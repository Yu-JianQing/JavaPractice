package SanShuJu_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgCoder;
import SanShuJu_3.VoteMsgTextCoder;

public class VoteServerUDP {
	public static void main(String[] args) throws IOException {
		int port=10000;
		
		DatagramSocket socket=new DatagramSocket(port);
		
		byte[] inBuffer=new byte[VoteMsgTextCoder.MaxLenth];
		
		VoteMsgCoder coder=new VoteMsgTextCoder();
		VoteService service=new VoteService();
		
		while(true){
			DatagramPacket packet=new DatagramPacket(inBuffer, inBuffer.length);
			socket.receive(packet);
			
			byte[] encodeMsg=Arrays.copyOf(packet.getData(), packet.getLength());
			System.out.println("拿到客户端的请求，长度是："+encodeMsg.length);
			
			VoteMsg msg=coder.fromWire(encodeMsg);//解码
			msg=service.handleRequest(msg);//信息转换
			
			packet.setData(coder.toWire(msg));//重新编码
			
		}
	}
}
