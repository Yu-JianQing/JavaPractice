package SanShuJu_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgCoder;
import SanShuJu_3.VoteMsgTextCoder;

public class VoteClientUDP {
	public static void main(String[] args) throws IOException {
		InetAddress address=InetAddress.getByName("127.0.0.1");
		int detPort=10000;
		
		int candidate=50;
		
		DatagramSocket socket=new DatagramSocket();
		socket.connect(address, detPort);
		
		VoteMsg msg=new VoteMsg(false, false, candidate, 0);	//投票信息
		
		VoteMsgCoder coder=new VoteMsgTextCoder();
		
		byte[] encodeMsg=coder.toWire(msg);
		System.out.println("已经编码的投票请求信息长度是："+encodeMsg.length);
		System.out.println("投票信息是："+msg.toString());
		
		DatagramPacket packet=new DatagramPacket(encodeMsg, encodeMsg.length);
		socket.send(packet);//发送投票信息
		
		byte[] recMsg=new byte[VoteMsgTextCoder.MaxLenth];
		packet=new DatagramPacket(recMsg, recMsg.length);//接收回复信心
		
		socket.receive(packet);
		
		encodeMsg=Arrays.copyOf(packet.getData(), packet.getLength());
		System.out.println("接收到服务器返回的回复信息长度是："+encodeMsg.length);
		
		msg=coder.fromWire(recMsg);//解码
		System.out.println("接收到服务器返回的回复信息是："+msg.toString());
	}
}
