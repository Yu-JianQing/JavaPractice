package SiCompress;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

public class CompressProtocol implements Runnable{
	private static final int BufSize=1024;
	private Socket clntSocket;
	private Logger logger;
	
	public CompressProtocol(Socket clntSocket,Logger logger){
		this.clntSocket=clntSocket;
		this.logger=logger;
	}
	
	public static void handleCompress(Socket clntSocket,Logger logger){
		try {
			InputStream in=clntSocket.getInputStream();
			GZIPOutputStream out=new GZIPOutputStream(clntSocket.getOutputStream());
			
			byte [] buf=new byte[BufSize];
			int bytesRead;
			while((bytesRead=in.read(buf))!=-1)
				out.write(buf,0,bytesRead);
			
			out.finish();
			
			logger.info("client  "+clntSocket.getRemoteSocketAddress() +" finished");
		} catch (IOException e) {
			logger.log(Level.WARNING,"exception in  echo protocol ",e);
		}
		
		try {
			clntSocket.close();
		} catch (IOException e) {
			logger.info("exception = "+e);
		}
	}
	
	public void run() {
		handleCompress(clntSocket, logger);
	}

}
