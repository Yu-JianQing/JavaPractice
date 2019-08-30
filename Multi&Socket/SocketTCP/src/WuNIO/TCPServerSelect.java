package WuNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class TCPServerSelect {
	private static final int BufSize=256;
	private static final int TimeOut=3000;
	
	public static void main(String[] args) throws IOException {
		int ports[]={8800,8801,8802};
		
		Selector selector=Selector.open();//初始化服务器端的选择器
		
		for (int i : ports) {//一个端口可以对应多个socketchannel，但只能对应一个serversocketchannel
			ServerSocketChannel listenChannel=ServerSocketChannel.open();//初始化每个端口的serversocketchannel
			
			listenChannel.socket().bind(new InetSocketAddress(i));//每个serversocket绑定一个端口
			
			listenChannel.configureBlocking(false);//设置serversocketchannel为非阻塞的
			
			listenChannel.register(selector, SelectionKey.OP_ACCEPT);//将serversocketchannel注册到服务器的选择器上去，注册事件是accept，等待被调用
		}
		
		TCPProtocol protocol=new SelectorProtocol(BufSize);
		
		while(true){//服务器端要一直运行
			if(selector.select(TimeOut)==0){//选择器进行选择，看哪些信道准备好了
				System.out.print("*");
				continue ;//如果没人准备好则继续轮询
			}
			
			Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();//selectedKeys表示将那些准备好的信道的key加入到选择集中，每个信道对用各自的key
																														//selector.selectedKeys()返回一个set集合，里面是选择集所有的key
			
			while(keyIterator.hasNext()){//依次遍历选择集中的key，也就相当于依次遍历已经准备好的信道（轮询）
				SelectionKey key=keyIterator.next();//取出一个key
				
				if(key.isAcceptable())//看这个key所属的信道是不是发生accept事件
					protocol.handleAccept(key);//执行accept操作
				
				if(key.isReadable())//看这个key所属的信道是不是发生read事件
					protocol.handleRead(key);//执行read操作
				
				if(key.isValid()&&key.isWritable())//看这个key所属的信道是不是发生write事件
					protocol.handleWrite(key);//执行write操作
				
				keyIterator.remove();//将处理完的这个key从选择集中删除
			}
		}
		
		
	}
}
