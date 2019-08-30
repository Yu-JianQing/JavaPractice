package SiMulti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class TimeLimitEchoProtocol implements Runnable{//相当于处理客户端请求的线程,限制给每个客户端服务的总时间
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
			int remTtime=TimeLimit;//剩余时间
			
			clntSocket.setSoTimeout(TimeLimit);
			
			int recMsgSize;
			int totalBytes=0;
			while((remTtime>0)&&(recMsgSize=in.read(echoBuffer))!=-1){//将收到的数据放入数组中
				out.write(echoBuffer, 0, recMsgSize);//将数组中的数据写入流中
				totalBytes=totalBytes+recMsgSize;
				
				remTtime=(int) (endTime-System.currentTimeMillis());
				clntSocket.setSoTimeout(remTtime);//说的是每个连接的总服务时间并不是每次读写的时间
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
