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
		
		VoteMsg msg=new VoteMsg(false, false, candidate, 0);	//ͶƱ��Ϣ
		
		VoteMsgCoder coder=new VoteMsgTextCoder();
		
		byte[] encodeMsg=coder.toWire(msg);
		System.out.println("�Ѿ������ͶƱ������Ϣ�����ǣ�"+encodeMsg.length);
		System.out.println("ͶƱ��Ϣ�ǣ�"+msg.toString());
		
		DatagramPacket packet=new DatagramPacket(encodeMsg, encodeMsg.length);
		socket.send(packet);//����ͶƱ��Ϣ
		
		byte[] recMsg=new byte[VoteMsgTextCoder.MaxLenth];
		packet=new DatagramPacket(recMsg, recMsg.length);//���ջظ�����
		
		socket.receive(packet);
		
		encodeMsg=Arrays.copyOf(packet.getData(), packet.getLength());
		System.out.println("���յ����������صĻظ���Ϣ�����ǣ�"+encodeMsg.length);
		
		msg=coder.fromWire(recMsg);//����
		System.out.println("���յ����������صĻظ���Ϣ�ǣ�"+msg.toString());
	}
}
