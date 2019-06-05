package ErTaoJieZi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	private static final int MaxDate=255;
	public static void main(String[] args) throws IOException{
		int servPort=9996;
		
		DatagramSocket socket=new DatagramSocket(servPort);
		DatagramPacket packet=new DatagramPacket(new byte[MaxDate], MaxDate);
		
		while(true){
			socket.receive(packet);
			System.out.println("收到包裹,客户端ip地址"+packet.getAddress().getHostAddress()+"  端口："+packet.getPort());
			
			socket.send(packet);
			packet.setLength(MaxDate);
		}
	}
}
