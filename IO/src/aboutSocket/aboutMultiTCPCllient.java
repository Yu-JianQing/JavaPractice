package aboutSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class aboutMultiTCPCllient {
	class ReadThread extends Thread{
		private final DataInputStream in;	
		
		public ReadThread(String name,DataInputStream in){
			super(name);
			this.in=in;
		}
		
		public void run(){
			try {
				while(true){
					double x=in.readDouble();
					System.out.println(Thread.currentThread().getName()+"read the circle area is "+x);
				}
			} catch (Exception e) {
				System.out.println("server is broken!");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		try {
			Scanner scanner=new Scanner(System.in);
			
			System.out.println("please input server ip:");
			String ip=scanner.nextLine();
			System.out.println("please input server port:");
			int port=scanner.nextInt();
			
			InetAddress address=InetAddress.getByName(ip);
			
			Socket socket=new Socket(address, port);
			
			InputStream in=socket.getInputStream();
			DataInputStream dataIn=new DataInputStream(in);
			
			OutputStream out=socket.getOutputStream();
			DataOutputStream dataOut=new DataOutputStream(out);
			
			new aboutMultiTCPCllient().new ReadThread("client Read", dataIn).start();
			
			while(true){
				try {
					System.out.println("input the circle radius (inpur any english word to stop):");
					double r=scanner.nextDouble();
					dataOut.writeDouble(r);
					Thread.sleep(10);
				} catch (Exception e) {
					System.exit(0);
					System.out.println("end !");
				}
			}
					
		} catch (Exception e) {
			System.out.println("server is broken!");
		}
	}
	
	
}
