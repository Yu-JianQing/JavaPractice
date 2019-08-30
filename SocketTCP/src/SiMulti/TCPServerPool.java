package SiMulti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServerPool {
	public static void main(String[] args) throws IOException {
		int serPort=9995;
		int threadPoolSize=5;
		
		final ServerSocket servSocket=new ServerSocket(serPort);
		
		final Logger logger=Logger.getLogger("practical");
		
		for (int i = 0; i < threadPoolSize; i++) {
			Thread thread=new Thread(){
				public void run(){
					while(true){
						try {
							Socket clntSocket=servSocket.accept();
							EchoProtocol.handleEchoClient(clntSocket, logger);
						} catch (IOException e) {
							logger.log(Level.WARNING,"client accept failed ",e);
						}
					}
				}
			};
			
			thread.start();
			logger.info("create and start thread  "+thread.getName());
		}
	}
}
