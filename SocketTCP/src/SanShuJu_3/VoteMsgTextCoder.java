package SanShuJu_3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VoteMsgTextCoder implements VoteMsgCoder{		//以文本方式对信息进行编码
	public static final String Magic="Voting";//信息开头必须有此字符串，否则视为噪音
	public static final String Vote="v";//如果是投票用“v”表示
	public static final String InQuery="i";//如果是查询用“i”表示
	public static final String Response="R";//如果是服务器回复用“R”表示
	
	public static final String CharSetFromat="ASC-II";//用于编码的字典
	public static final String Delimsir="  ";//用于信息分隔的符号：两个空字符
	public static final int MaxLenth=2000;//信息的最大长度
	
	public byte [] toWire(VoteMsg msg) throws IOException{//编码
		String msgCode=Magic+Delimsir+//开头加Magic，分隔符隔开下一个部分信息
				(msg.isQuerry()?InQuery:Vote)+Delimsir+
				(msg.isResponse()?Response:"")+Delimsir+
				Integer.toString(msg.getCandidateID())+Delimsir+
				Long.toString(msg.getVoteCount());
		byte data[]=msgCode.getBytes(CharSetFromat);//编码成字节
		return data;
	}
	
	public VoteMsg fromWire(byte[] msg)throws IOException{//解码
		ByteArrayInputStream msgStream=new ByteArrayInputStream(msg);
		Scanner sca=new Scanner(new InputStreamReader(msgStream,CharSetFromat));//将字节数组转化为字符串并是用空格分隔的字符串
		
		boolean isQuerry;//VoteMsg的属性
		boolean isResponse;
		int candidateID;
		long voteCount;
		
		String str;
		str=sca.next();//读取第一个字符串
		if(!str.equals(Magic))
			throw new IOException("信息的第一个字符串不是"+Magic);
		
		str=sca.next();
		if(!str.equals(Vote)){
			isQuerry=false;
		}else if(!str.equals(InQuery)){
			throw new IOException("信息的第而个字符串不是"+InQuery);
		}else {
			isQuerry=true;
		}
		
		str=sca.next();
		if(str.equals(Response)){
			isResponse=true;
		}else {
			isResponse=false;
		}
		
		str=sca.next();
		candidateID=Integer.parseInt(str);
		
		if(isResponse){
			str=sca.next();
			voteCount=Long.parseLong(str);
		}else {
			voteCount=0;
		}
		//所有字符串读取完毕，并且VoteMsg属性赋值完毕
		return new VoteMsg(isQuerry, isResponse, candidateID, voteCount);
	}
}
