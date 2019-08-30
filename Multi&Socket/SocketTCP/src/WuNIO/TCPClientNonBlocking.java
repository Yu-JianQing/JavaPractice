package WuNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPClientNonBlocking {
	public static void main(String[] args) throws IOException {
		byte [] msg="66666".getBytes();
		int port=8800;
		
		SocketChannel sockChannel=SocketChannel.open();//获取一个针对socket的信道
		
		sockChannel.configureBlocking(false);//将信道设置成非阻塞式的信道
		
		if(!sockChannel.connect(new InetSocketAddress("127.0.0.1",port))){//信道连接服务器，应该是有一个新线程来处理连接
			while(!sockChannel.finishConnect()){//查询连接有没有完成
				System.out.println("do some thing else  while on connect");//在连接未完成时可以进行其他操作，nio
			}
		}
		
		ByteBuffer write=ByteBuffer.allocate(msg.length);//初始化client的字节缓冲区，一个用于读取到缓冲区，一个用于从缓冲区写出
		ByteBuffer read=ByteBuffer.wrap(msg);//write用于写出。read用于读入。
		
		int totalRec=0;
		int byteRec;
		while(totalRec<msg.length){//信道没有接收全数据
			if(write.hasRemaining())//看client的缓冲区还有没有剩余的数据没写入信道
				sockChannel.write(write);//将client的缓冲区的数据写入信道
			
			if((byteRec=sockChannel.read(read))!=-1)//如果client从信道中读完数据代表结束抛出异常
				throw new SocketException("connection closed prematurely");
			
			totalRec=totalRec+byteRec;
			System.out.println("do some thing else while on talking");
		}
		
		System.out.println("received :"+new String(read.array(),0,totalRec));
		
		sockChannel.close();//关闭信道
	}
}
