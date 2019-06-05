package SanShuJu_4;

import java.util.HashMap;
import java.util.Map;

import SanShuJu_3.VoteMsg;

public class VoteService {//������������Ϣʹ��
	private Map<Integer, Long> result=new HashMap<Integer, Long>();//���id �� ��õ�ͶƱ��
	
	public VoteMsg handleRequest(VoteMsg msg){
		if(msg.isResponse())//�����Ϣ��Ҫ���ص���Ϣ�����ٲ���
			return msg;
		
		msg.setResponse(true);//���Ǿ����ó���
		
		int candidate=msg.getCandidateID();//����Ϣ�л�ȡ��id
		Long count=result.get(candidate);//��map���õ���Ӧid��Ӧ��ͶƱ��count
		
		if(count==null)//�����idû��ͶƱ������Ϊ0��
			count=0L;
		
		if(!msg.isQuerry())//����Է�������������ͶƱ
			result.put(candidate, ++count);//��Ѵ��˵�id��Ʊ��+1����map��
		
		msg.setVoteCount(count);//��������ͶƱ��
		
		return msg;
	}
}
