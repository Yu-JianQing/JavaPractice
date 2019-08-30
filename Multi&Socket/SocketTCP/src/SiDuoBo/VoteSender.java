package SiDuoBo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgCoder;
import SanShuJu_3.VoteMsgTextCoder;

public class VoteSender {
	public static final int CanditateId=475;
	
	public static void main(String[] args) throws IOException {
		InetAddress destAddress=InetAddress.getByName("224.0.0.0");
		if(!destAddress.isMulticastAddress())
			throw new IllegalArgumentException("not a multicast address");
		
		int destPort=9996;
		
		int TTL=5;
		
		MulticastSocket socket=new MulticastSocket();
		socket.setTimeToLive(TTL);
		
		VoteMsgCoder coder=new VoteMsgTextCoder();
		
		VoteMsg vote=new VoteMsg(true, true, CanditateId, 1000001L);
		
		byte[] msg=coder.toWire(vote);
		
		DatagramPacket packet=new DatagramPacket(msg, msg.length, destAddress, destPort);
		
		System.out.println("send a packet :"+vote);
		socket.send(packet);
		
		socket.close();
	}
}
