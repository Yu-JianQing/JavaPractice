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
		
		SocketChannel sockChannel=SocketChannel.open();//��ȡһ�����socket���ŵ�
		
		sockChannel.configureBlocking(false);//���ŵ����óɷ�����ʽ���ŵ�
		
		if(!sockChannel.connect(new InetSocketAddress("127.0.0.1",port))){//�ŵ����ӷ�������Ӧ������һ�����߳�����������
			while(!sockChannel.finishConnect()){//��ѯ������û�����
				System.out.println("do some thing else  while on connect");//������δ���ʱ���Խ�������������nio
			}
		}
		
		ByteBuffer write=ByteBuffer.allocate(msg.length);//��ʼ��client���ֽڻ�������һ�����ڶ�ȡ����������һ�����ڴӻ�����д��
		ByteBuffer read=ByteBuffer.wrap(msg);//write����д����read���ڶ��롣
		
		int totalRec=0;
		int byteRec;
		while(totalRec<msg.length){//�ŵ�û�н���ȫ����
			if(write.hasRemaining())//��client�Ļ���������û��ʣ�������ûд���ŵ�
				sockChannel.write(write);//��client�Ļ�����������д���ŵ�
			
			if((byteRec=sockChannel.read(read))!=-1)//���client���ŵ��ж������ݴ�������׳��쳣
				throw new SocketException("connection closed prematurely");
			
			totalRec=totalRec+byteRec;
			System.out.println("do some thing else while on talking");
		}
		
		System.out.println("received :"+new String(read.array(),0,totalRec));
		
		sockChannel.close();//�ر��ŵ�
	}
}
