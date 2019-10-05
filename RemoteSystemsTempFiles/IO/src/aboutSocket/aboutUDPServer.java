package aboutSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class aboutUDPServer {
	class SendThread extends Thread{
		private final DatagramSocket socket;
		SendThread(String name,DatagramSocket socket){
			super(name);
			this.socket=socket;
		}
		
		public void run(){
			try {
				InetAddress address=InetAddress.getByName("127.0.0.1");
				Scanner scanner=new Scanner(System.in);
				DatagramPacket packet=null;
				
				while(true){
					System.out.print("input a msg to send Tom: ");
					String msg=scanner.nextLine();
					byte [] buf=msg.getBytes();
					
					packet=new DatagramPacket(buf, buf.length, address,9994);
					
					socket.send(packet);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	public static void main(String[] args) throws SocketException, IOException {
		byte [] b=new byte[5];
		DatagramPacket recpacket = new DatagramPacket(b, b.length);
		DatagramSocket socket=new DatagramSocket(9993);
		
		while(true){
			try {
				socket.receive(recpacket);
				System.out.printf("%25s\n",Thread.currentThread().getName()+" recevice the msg :"+new String(b));
				
				new aboutUDPServer().new SendThread("read", socket).start();
			} catch (IOException e) {}
		}
		
	}
}
