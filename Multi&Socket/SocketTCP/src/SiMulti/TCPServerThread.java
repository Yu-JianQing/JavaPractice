package SiMulti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPServerThread {//一客户端一线程
	public static void main(String[] args) throws IOException {
		int servPort=9995;
		
		ServerSocket servSocket=new ServerSocket(servPort);
		
		Logger logger=Logger.getLogger("practical");
		
		while(true){
			Socket clntSocket=servSocket.accept();
			
			Thread thread=new Thread(new EchoProtocol(clntSocket, logger));
			thread.start();
			
			logger.info("create and start thread  "+thread.getName());
		}
	}
}
