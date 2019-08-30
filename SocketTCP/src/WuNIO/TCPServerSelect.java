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
		
		Selector selector=Selector.open();//��ʼ���������˵�ѡ����
		
		for (int i : ports) {//һ���˿ڿ��Զ�Ӧ���socketchannel����ֻ�ܶ�Ӧһ��serversocketchannel
			ServerSocketChannel listenChannel=ServerSocketChannel.open();//��ʼ��ÿ���˿ڵ�serversocketchannel
			
			listenChannel.socket().bind(new InetSocketAddress(i));//ÿ��serversocket��һ���˿�
			
			listenChannel.configureBlocking(false);//����serversocketchannelΪ��������
			
			listenChannel.register(selector, SelectionKey.OP_ACCEPT);//��serversocketchannelע�ᵽ��������ѡ������ȥ��ע���¼���accept���ȴ�������
		}
		
		TCPProtocol protocol=new SelectorProtocol(BufSize);
		
		while(true){//��������Ҫһֱ����
			if(selector.select(TimeOut)==0){//ѡ��������ѡ�񣬿���Щ�ŵ�׼������
				System.out.print("*");
				continue ;//���û��׼�����������ѯ
			}
			
			Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();//selectedKeys��ʾ����Щ׼���õ��ŵ���key���뵽ѡ���У�ÿ���ŵ����ø��Ե�key
																														//selector.selectedKeys()����һ��set���ϣ�������ѡ�����е�key
			
			while(keyIterator.hasNext()){//���α���ѡ���е�key��Ҳ���൱�����α����Ѿ�׼���õ��ŵ�����ѯ��
				SelectionKey key=keyIterator.next();//ȡ��һ��key
				
				if(key.isAcceptable())//�����key�������ŵ��ǲ��Ƿ���accept�¼�
					protocol.handleAccept(key);//ִ��accept����
				
				if(key.isReadable())//�����key�������ŵ��ǲ��Ƿ���read�¼�
					protocol.handleRead(key);//ִ��read����
				
				if(key.isValid()&&key.isWritable())//�����key�������ŵ��ǲ��Ƿ���write�¼�
					protocol.handleWrite(key);//ִ��write����
				
				keyIterator.remove();//������������key��ѡ����ɾ��
			}
		}
		
		
	}
}
