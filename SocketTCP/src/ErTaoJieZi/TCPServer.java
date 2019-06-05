package ErTaoJieZi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPServer {
	private static final int bufSize=32;
	
	public static void main(String[] args) throws IOException{
		int servport=9997;
		ServerSocket servSocket=new ServerSocket(servport);
		
		int RecMsgSize;
		byte [] recbuffer=new byte[bufSize];
		
		while(true){
			Socket server=servSocket.accept();
			SocketAddress clientAddress=server.getRemoteSocketAddress();
			System.out.println("client address is :"+clientAddress);
			
			InputStream in=server.getInputStream();
			OutputStream out=server.getOutputStream();
			
			while((RecMsgSize=in.read(recbuffer))!=-1){
				out.write(recbuffer, 0, RecMsgSize);
			}
			
			server.close();
		}
	}
}
