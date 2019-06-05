package SanShuJu_4;

import java.io.OutputStream;
import java.net.Socket;

import SanShuJu_2.Framer;
import SanShuJu_2.LengthFramer;
import SanShuJu_3.VoteMsg;
import SanShuJu_3.VoteMsgBinCoder;
import SanShuJu_3.VoteMsgCoder;

public class VoteClientTCp {
	public static final int CandidateID=888;
	
	public static void main(String[] args) throws Exception{
		String destAddr="127.0.0.1";
		int destPort=9999;
		
		Socket socket=new Socket(destAddr, destPort);
		OutputStream out=socket.getOutputStream();
		
		VoteMsg voteMsg=new VoteMsg(true, false, CandidateID, 0);//这个消息是查询消息
		VoteMsgCoder coder=new VoteMsgBinCoder();
		Framer framer=new LengthFramer(socket.getInputStream());
		
		byte[] encodeMsg=coder.toWire(voteMsg);
		
		System.out.println("client 发送消息的长度bytes："+encodeMsg.length);
		System.out.println("client 发送消息是："+voteMsg);
		framer.frameMsg(encodeMsg, out);//成帧
		
		voteMsg.setQuerry(false);//现在变成投票消息
		coder.toWire(voteMsg);
		
		System.out.println("client 发送消息的长度bytes："+encodeMsg.length);
		System.out.println("client 发送消息是："+voteMsg);
		framer.frameMsg(encodeMsg, out);//成帧
		
		encodeMsg=framer.nextMsg(); //收到请求回复
		voteMsg=coder.fromWire(encodeMsg);
		
		System.out.println("client 收到请求回复消息的长度是："+encodeMsg.length);
		System.out.println("client 收到请求回复消息是："+voteMsg);
		
		voteMsg=coder.fromWire(framer.nextMsg());//收到投票回复
		
		System.out.println("client 收到投票回复消息的长度是："+encodeMsg.length);
		System.out.println("client 收到投票回复消息是："+voteMsg);
		
		socket.close();
	}
	
}
