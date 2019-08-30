package WuNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SelectorProtocol implements TCPProtocol{
	private int bufSize;
	
	public SelectorProtocol(int bufSize){
		this.bufSize=bufSize;
	}
	
	public void handleAccept(SelectionKey key) throws IOException {//当信道上发生的事件是accept时，调用此方法处理
		ServerSocketChannel serverSocketChannel=(ServerSocketChannel) key.channel();//由发生accept事件的信道上的key获取到ServerSocketChannel
		SocketChannel socketChannel=serverSocketChannel.accept();//由serversocketchannel建立连接返回服务器端的socketchannel
		//SocketChannel socketChannel=((ServerSocketChannel)key.channel()).accept();	
		
		socketChannel.configureBlocking(false);//设置信道为非阻塞信道
		
		socketChannel.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocate(bufSize));//将此信道注册到选择器上。此方法会返回注册的建
	}

	public void handleRead(SelectionKey key) throws IOException {//当信道上发生的事件是read时，调用此方法处理
		SocketChannel socketChannel=(SocketChannel)key.channel();//由发生事件的信道上的key获取到socketchannel
		
		ByteBuffer buffer=(ByteBuffer)key.attachment();//获取到key（信道）的附件（在服务器端）
		//附件应该是存储了信道会发生什么事件
		
		long byteRead=socketChannel.read(buffer);//服务器端从信道中读入数据到缓冲区中（信道的附件）
		
		if(byteRead==-1){//如果没读到数据
			socketChannel.close();//关闭socket
		}else if(byteRead>0){//服务器读到了数据
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);//指示应该监听信道上的读或者写操作
		}
	}

	public void handleWrite(SelectionKey key) throws IOException {//当信道上发生的事件是write时，调用此方法处理
		ByteBuffer buffer=(ByteBuffer)key.attachment();//获取到信道上的附件（缓冲区）
		
		buffer.flip();//将缓冲区准备为数据传出状态
		
		SocketChannel socketChannel=(SocketChannel)key.channel();////由发生事件的信道上的key获取到socketchannel
		
		socketChannel.write(buffer);//将缓冲区的数据写入到channel中
		
		if(!buffer.hasRemaining())//如果缓冲区数据已经写出完毕
			key.interestOps(SelectionKey.OP_READ);//指示应该监听信道上的读操作
		
		buffer.compact();
	}

}
