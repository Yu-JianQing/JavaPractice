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
	
	public void handleAccept(SelectionKey key) throws IOException {//���ŵ��Ϸ������¼���acceptʱ�����ô˷�������
		ServerSocketChannel serverSocketChannel=(ServerSocketChannel) key.channel();//�ɷ���accept�¼����ŵ��ϵ�key��ȡ��ServerSocketChannel
		SocketChannel socketChannel=serverSocketChannel.accept();//��serversocketchannel�������ӷ��ط������˵�socketchannel
		//SocketChannel socketChannel=((ServerSocketChannel)key.channel()).accept();	
		
		socketChannel.configureBlocking(false);//�����ŵ�Ϊ�������ŵ�
		
		socketChannel.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocate(bufSize));//�����ŵ�ע�ᵽѡ�����ϡ��˷����᷵��ע��Ľ�
	}

	public void handleRead(SelectionKey key) throws IOException {//���ŵ��Ϸ������¼���readʱ�����ô˷�������
		SocketChannel socketChannel=(SocketChannel)key.channel();//�ɷ����¼����ŵ��ϵ�key��ȡ��socketchannel
		
		ByteBuffer buffer=(ByteBuffer)key.attachment();//��ȡ��key���ŵ����ĸ������ڷ������ˣ�
		//����Ӧ���Ǵ洢���ŵ��ᷢ��ʲô�¼�
		
		long byteRead=socketChannel.read(buffer);//�������˴��ŵ��ж������ݵ��������У��ŵ��ĸ�����
		
		if(byteRead==-1){//���û��������
			socketChannel.close();//�ر�socket
		}else if(byteRead>0){//����������������
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);//ָʾӦ�ü����ŵ��ϵĶ�����д����
		}
	}

	public void handleWrite(SelectionKey key) throws IOException {//���ŵ��Ϸ������¼���writeʱ�����ô˷�������
		ByteBuffer buffer=(ByteBuffer)key.attachment();//��ȡ���ŵ��ϵĸ�������������
		
		buffer.flip();//��������׼��Ϊ���ݴ���״̬
		
		SocketChannel socketChannel=(SocketChannel)key.channel();////�ɷ����¼����ŵ��ϵ�key��ȡ��socketchannel
		
		socketChannel.write(buffer);//��������������д�뵽channel��
		
		if(!buffer.hasRemaining())//��������������Ѿ�д�����
			key.interestOps(SelectionKey.OP_READ);//ָʾӦ�ü����ŵ��ϵĶ�����
		
		buffer.compact();
	}

}
