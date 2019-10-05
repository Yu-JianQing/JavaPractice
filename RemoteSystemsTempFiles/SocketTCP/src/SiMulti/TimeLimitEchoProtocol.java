package SiMulti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class TimeLimitEchoProtocol implements Runnable{//�൱�ڴ���ͻ���������߳�,���Ƹ�ÿ���ͻ��˷������ʱ��
	private static final int BufSize=32;
	private static final int TimeLimit=10000;
	private Socket clntSocket;
	private Logger logger;
	
	public TimeLimitEchoProtocol(Socket clntSocket,Logger logger){
		this.clntSocket=clntSocket;
		this.logger=logger;
	}
	
	public static void handleEchoClient(Socket clntSocket,Logger logger){
		try {
			InputStream in=clntSocket.getInputStream();
			OutputStream out=clntSocket.getOutputStream();
			
			byte [] echoBuffer=new byte[BufSize];
			
			long endTime=System.currentTimeMillis()+TimeLimit;
			int remTtime=TimeLimit;//ʣ��ʱ��
			
			clntSocket.setSoTimeout(TimeLimit);
			
			int recMsgSize;
			int totalBytes=0;
			while((remTtime>0)&&(recMsgSize=in.read(echoBuffer))!=-1){//���յ������ݷ���������
				out.write(echoBuffer, 0, recMsgSize);//�������е�����д������
				totalBytes=totalBytes+recMsgSize;
				
				remTtime=(int) (endTime-System.currentTimeMillis());
				clntSocket.setSoTimeout(remTtime);//˵����ÿ�����ӵ��ܷ���ʱ�䲢����ÿ�ζ�д��ʱ��
			}
			
			logger.info("client send msg to "+clntSocket.getRemoteSocketAddress()+"  echo total "+totalBytes+"  bytes");
			
		} catch (IOException e) {
			try {
				clntSocket.close();
			} catch (IOException e1) {}
		}
	}
	
	public void run() {
		handleEchoClient(clntSocket, logger);
	}

}
