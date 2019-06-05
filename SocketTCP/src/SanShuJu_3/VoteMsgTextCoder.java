package SanShuJu_3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VoteMsgTextCoder implements VoteMsgCoder{		//���ı���ʽ����Ϣ���б���
	public static final String Magic="Voting";//��Ϣ��ͷ�����д��ַ�����������Ϊ����
	public static final String Vote="v";//�����ͶƱ�á�v����ʾ
	public static final String InQuery="i";//����ǲ�ѯ�á�i����ʾ
	public static final String Response="R";//����Ƿ������ظ��á�R����ʾ
	
	public static final String CharSetFromat="ASC-II";//���ڱ�����ֵ�
	public static final String Delimsir="  ";//������Ϣ�ָ��ķ��ţ��������ַ�
	public static final int MaxLenth=2000;//��Ϣ����󳤶�
	
	public byte [] toWire(VoteMsg msg) throws IOException{//����
		String msgCode=Magic+Delimsir+//��ͷ��Magic���ָ���������һ��������Ϣ
				(msg.isQuerry()?InQuery:Vote)+Delimsir+
				(msg.isResponse()?Response:"")+Delimsir+
				Integer.toString(msg.getCandidateID())+Delimsir+
				Long.toString(msg.getVoteCount());
		byte data[]=msgCode.getBytes(CharSetFromat);//������ֽ�
		return data;
	}
	
	public VoteMsg fromWire(byte[] msg)throws IOException{//����
		ByteArrayInputStream msgStream=new ByteArrayInputStream(msg);
		Scanner sca=new Scanner(new InputStreamReader(msgStream,CharSetFromat));//���ֽ�����ת��Ϊ�ַ��������ÿո�ָ����ַ���
		
		boolean isQuerry;//VoteMsg������
		boolean isResponse;
		int candidateID;
		long voteCount;
		
		String str;
		str=sca.next();//��ȡ��һ���ַ���
		if(!str.equals(Magic))
			throw new IOException("��Ϣ�ĵ�һ���ַ�������"+Magic);
		
		str=sca.next();
		if(!str.equals(Vote)){
			isQuerry=false;
		}else if(!str.equals(InQuery)){
			throw new IOException("��Ϣ�ĵڶ����ַ�������"+InQuery);
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
		//�����ַ�����ȡ��ϣ�����VoteMsg���Ը�ֵ���
		return new VoteMsg(isQuerry, isResponse, candidateID, voteCount);
	}
}