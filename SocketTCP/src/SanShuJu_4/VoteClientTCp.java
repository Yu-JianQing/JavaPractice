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
		
		VoteMsg voteMsg=new VoteMsg(true, false, CandidateID, 0);//�����Ϣ�ǲ�ѯ��Ϣ
		VoteMsgCoder coder=new VoteMsgBinCoder();
		Framer framer=new LengthFramer(socket.getInputStream());
		
		byte[] encodeMsg=coder.toWire(voteMsg);
		
		System.out.println("client ������Ϣ�ĳ���bytes��"+encodeMsg.length);
		System.out.println("client ������Ϣ�ǣ�"+voteMsg);
		framer.frameMsg(encodeMsg, out);//��֡
		
		voteMsg.setQuerry(false);//���ڱ��ͶƱ��Ϣ
		coder.toWire(voteMsg);
		
		System.out.println("client ������Ϣ�ĳ���bytes��"+encodeMsg.length);
		System.out.println("client ������Ϣ�ǣ�"+voteMsg);
		framer.frameMsg(encodeMsg, out);//��֡
		
		encodeMsg=framer.nextMsg(); //�յ�����ظ�
		voteMsg=coder.fromWire(encodeMsg);
		
		System.out.println("client �յ�����ظ���Ϣ�ĳ����ǣ�"+encodeMsg.length);
		System.out.println("client �յ�����ظ���Ϣ�ǣ�"+voteMsg);
		
		voteMsg=coder.fromWire(framer.nextMsg());//�յ�ͶƱ�ظ�
		
		System.out.println("client �յ�ͶƱ�ظ���Ϣ�ĳ����ǣ�"+encodeMsg.length);
		System.out.println("client �յ�ͶƱ�ظ���Ϣ�ǣ�"+voteMsg);
		
		socket.close();
	}
	
}
