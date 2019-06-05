package SanShuJu_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class VoteMsgBinCoder implements VoteMsgCoder{		//以二进制方式对信息进行编码
	public static final int Min_Wire_Lenth=4;	//信息最小长度
	public static final int Max_Wire_Lenth=16;	//信息最大长度
	public static final int Magic=0x5400;//用于编码运算的二进制数（十六进制表示了）
	public static final int MagicMask=0xfc00;
	public static final int MagicShift=8;
	public static final int ResponseFlag=0x0200;
	public static final int InQuerryFlag=0x0100;

	public byte[] toWire(VoteMsg msg) throws IOException {//编码
		ByteArrayOutputStream byteStream=new ByteArrayOutputStream();
		DataOutputStream out=new DataOutputStream(byteStream);
		
		short magicAndFlag=Magic;
		if(msg.isQuerry())
			magicAndFlag |=InQuerryFlag;
		
		if(msg.isResponse())
			magicAndFlag |=ResponseFlag;
		
		out.writeShort(magicAndFlag);//先对isQuerry或者isResponse编码
		out.writeShort((short)msg.getCandidateID());	//CandidateID不用编码直接写入
		
		if(msg.isResponse())
			out.writeLong(msg.getVoteCount());//VoteCount()不用编码直接写入
		
		out.flush();
		
		byte[] data=byteStream.toByteArray();
		
		return data;
	}

	public VoteMsg fromWire(byte[] msg) throws IOException {
		if(msg.length<Min_Wire_Lenth)
			throw new IOException("信息过短，无效");
		
		ByteArrayInputStream byteStream=new ByteArrayInputStream(msg);
		DataInputStream in=new DataInputStream(byteStream);
		
		int magic=in.readShort();//读入第一个已编码的字符串isQuerry或者isResponse
		if((magic&MagicMask)!=Magic)
			throw new IOException("信息的头一个字符串不符合magic");
		
		boolean resp=((magic&ResponseFlag)!=0);//解码
		boolean inque=((magic&InQuerryFlag)!=0);
		int candidateID=in.readShort();
		
		if(candidateID<0||candidateID>10000)
			throw new IOException("candidate id 不符合要求"+candidateID);
		
		long count=0;
		if(resp){
			count=in.readLong();
			if(count<0)
				throw new IOException("vote count不符合要求"+count);
		}
		
		return new VoteMsg(inque, resp, candidateID, count);
	}
	
}
