package aboutSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class aboutUDPClient {
	class ReadThread extends Thread{
		private final DatagramSocket socket;
		ReadThread(String name,DatagramSocket socket){
			super(name);
			this.socket=socket;
		}
		
		public void run(){
			byte [] b=new byte[5];
			DatagramPacket recpacket = new DatagramPacket(b, b.length);
			
			while(true){
				try {
					socket.receive(recpacket);
					System.out.printf("%25s\n",Thread.currentThread().getName()+" recevice the msg :"+new String(b));
				} catch (IOException e) {}
			}
			
		}
	}
	
	public static void main(String[] args) throws SocketException, IOException {
		DatagramPacket packet;
		DatagramSocket socket=new DatagramSocket(9994);
		
		InetAddress address=InetAddress.getByName("127.0.0.1");
		
		new aboutUDPClient().new ReadThread("read", socket).start();
		
		Scanner scanner=new Scanner(System.in);
		while(true){
			try {
				System.out.print("input a msg to send Jerry: ");
				String msg=scanner.nextLine();
				byte [] buf=msg.getBytes();
				
				packet=new DatagramPacket(buf, buf.length, address,9993);
				
				socket.send(packet);
			} catch (Exception e) {}
		}
		
	}
}
