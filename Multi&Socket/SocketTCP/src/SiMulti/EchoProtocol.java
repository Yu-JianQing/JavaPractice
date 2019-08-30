package SiMulti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class EchoProtocol implements Runnable{//�൱�ڴ���ͻ���������߳�
	private static final int BufSize=32;
	private Socket clntSocket;
	private Logger logger;
	
	public EchoProtocol(Socket clntSocket,Logger logger){
		this.clntSocket=clntSocket;
		this.logger=logger;
	}
	
	public static void handleEchoClient(Socket clntSocket,Logger logger){
		try {
			InputStream in=clntSocket.getInputStream();
			OutputStream out=clntSocket.getOutputStream();
			
			byte [] echoBuffer=new byte[BufSize];
			
			int recMsgSize;
			int totalBytes=0;
			while((recMsgSize=in.read(echoBuffer))!=-1){//���յ������ݷ���������
				out.write(echoBuffer, 0, recMsgSize);//�������е�����д������
				totalBytes=totalBytes+recMsgSize;
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
