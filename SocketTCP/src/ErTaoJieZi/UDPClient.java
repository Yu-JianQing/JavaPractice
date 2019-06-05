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
					throw new IOException("�յ��İ������Ǽĸ��ҵ�");
				recvResponse=true;
			} catch (InterruptedIOException e) {
				tries+=1;
				System.out.println("��ʱ�����ǵ�"+tries+"���ط���Ϣ");
			}
		} while (!recvResponse&&tries<MaxTries);
		
		if(recvResponse){
			System.out.println("�յ�������"+new String(recvPacket.getData()));
		}else {
			System.out.println("û�յ�����---give up");
		}
		
		socket.close();
	}
}
