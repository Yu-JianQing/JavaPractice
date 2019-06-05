package SanShuJu_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VoteMsgBinCoder implements VoteMsgCoder{		//�Զ����Ʒ�ʽ����Ϣ���б���
	public static final int Min_Wire_Lenth=4;	//��Ϣ��С����
	public static final int Max_Wire_Lenth=16;	//��Ϣ��󳤶�
	public static final int Magic=0x5400;//���ڱ�������Ķ���������ʮ�����Ʊ�ʾ�ˣ�
	public static final int MagicMask=0xfc00;
	public static final int MagicShift=8;
	public static final int ResponseFlag=0x0200;
	public static final int InQuerryFlag=0x0100;

	public byte[] toWire(VoteMsg msg) throws IOException {//����
		ByteArrayOutputStream byteStream=new ByteArrayOutputStream();
		DataOutputStream out=new DataOutputStream(byteStream);
		
		short magicAndFlag=Magic;
		if(msg.isQuerry())
			magicAndFlag |=InQuerryFlag;
		
		if(msg.isResponse())
			magicAndFlag |=ResponseFlag;
		
		out.writeShort(magicAndFlag);//�ȶ�isQuerry����isResponse����
		out.writeShort((short)msg.getCandidateID());	//CandidateID���ñ���ֱ��д��
		
		if(msg.isResponse())
			out.writeLong(msg.getVoteCount());//VoteCount()���ñ���ֱ��д��
		
		out.flush();
		
		byte[] data=byteStream.toByteArray();
		
		return data;
	}

	public VoteMsg fromWire(byte[] msg) throws IOException {
		if(msg.length<Min_Wire_Lenth)
			throw new IOException("��Ϣ���̣���Ч");
		
		ByteArrayInputStream byteStream=new ByteArrayInputStream(msg);
		DataInputStream in=new DataInputStream(byteStream);
		
		int magic=in.readShort();//�����һ���ѱ�����ַ���isQuerry����isResponse
		if((magic&MagicMask)!=Magic)
			throw new IOException("��Ϣ��ͷһ���ַ���������magic");
		
		boolean resp=((magic&ResponseFlag)!=0);//����
		boolean inque=((magic&InQuerryFlag)!=0);
		int candidateID=in.readShort();
		
		if(candidateID<0||candidateID>10000)
			throw new IOException("candidate id ������Ҫ��"+candidateID);
		
		long count=0;
		if(resp){
			count=in.readLong();
			if(count<0)
				throw new IOException("vote count������Ҫ��"+count);
		}
		
		return new VoteMsg(inque, resp, candidateID, count);
	}
	
}