package SiDuoBo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;

import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgCoder;
import SanShuJu_3.VoteMsgTextCoder;

public class VoteReceiver {
	public static void main(String[] args) throws IOException {
		InetAddress address=InetAddress.getByName("224.0.0.0");
		if(!address.isMulticastAddress())
			throw new IllegalArgumentException("not a multicast address");
		
		int port=9996;
		
		MulticastSocket socket=new MulticastSocket(port);
		socket.joinGroup(address);
		
		VoteMsgCoder coder=new VoteMsgTextCoder();
		
		DatagramPacket packet=new DatagramPacket(new byte[VoteMsgTextCoder.MaxLenth], VoteMsgTextCoder.MaxLenth);
		socket.receive(packet);
		
		VoteMsg msg=coder.fromWire(Arrays.copyOfRange(packet.getData(), 0, packet.getLength()));
		
		System.out.println("receive msg : "+msg);
		
		socket.close();
	}
}
