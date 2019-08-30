package aboutSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class aboutMultiTCPServer {
	class ServerThread extends Thread{
		private final Socket socket;
		
		public ServerThread(String name,Socket socket) {
			super(name);
			this.socket=socket;
			InetAddress address=socket.getInetAddress();
			System.out.println("client address is :"+address);
		}
		
		public void run(){
			try {
				InputStream in=socket.getInputStream();
				DataInputStream dataIn=new DataInputStream(in);
				
				OutputStream out=socket.getOutputStream();
				DataOutputStream dataOut=new DataOutputStream(out);
				
				while(true){
					double x=dataIn.readDouble();
					System.out.println(Thread.currentThread().getName()+" get the circle's radius :"+x);
					
					dataOut.writeDouble(3.14*x*x);
				}
			} catch (Exception e) {
				System.out.println("client is broken!");
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(9992);
		Socket socket;
//		while(true){//当多个client时使用
			socket=server.accept();
			
			new aboutMultiTCPServer().new ServerThread("server", socket).start();
//		}
		
	}
}
