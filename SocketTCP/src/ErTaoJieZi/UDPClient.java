package ErTaoJieZi;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	private static final int TimeOut=3000;
	private static final int MaxTries=5;
	
	public static void main(String[] args) throws IOException{
		InetAddress servAddress=InetAddress.getByName("localhost");
		byte [] sendMsg="666".getBytes();
		
		int servPort=7;
		
		DatagramSocket socket=new DatagramSocket();
		socket.setSoTimeout(TimeOut);
		
		DatagramPacket sendPacket=new DatagramPacket(sendMsg, sendMsg.length, servAddress,servPort);
		DatagramPacket recvPacket=new DatagramPacket(new byte[sendMsg.length], sendMsg.length);
		
		int tries=0;
		boolean recvResponse=false;
		
		do {
			socket.send(sendPacket);
			try {
				socket.receive(recvPacket);
				if(!recvPacket.getAddress().equals(servAddress))
					throw new IOException("收到的包裹不是寄给我的");
				recvResponse=true;
			} catch (InterruptedIOException e) {
				tries+=1;
				System.out.println("超时，这是第"+tries+"次重发信息");
			}
		} while (!recvResponse&&tries<MaxTries);
		
		if(recvResponse){
			System.out.println("收到包裹："+new String(recvPacket.getData()));
		}else {
			System.out.println("没收到包裹---give up");
		}
		
		socket.close();
	}
}
