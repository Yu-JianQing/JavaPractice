package SiMulti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import SiCompress.CompressProtocol;

public class TCPServerExecutor {
	public static void main(String[] args) throws IOException {
		int servPort=9995;
		
		ServerSocket servSocket=new ServerSocket(servPort);
		
		Logger logger=Logger.getLogger("practical");
		
		Executor service=Executors.newCachedThreadPool();
		
		while(true){
			Socket clntSocket=servSocket.accept();
//			service.execute(new EchoProtocol(clntSocket, logger));
			service.execute(new CompressProtocol(clntSocket, logger));
		}
	}
}
