package SanShuJu_4;

import java.util.HashMap;
import java.util.Map;

import SanShuJu_3.VoteMsg;

public class VoteService {//服务器返回信息使用
	private Map<Integer, Long> result=new HashMap<Integer, Long>();//存放id 和 获得的投票数
	
	public VoteMsg handleRequest(VoteMsg msg){
		if(msg.isResponse())//如果信息是要返回的信息则不用再操作
			return msg;
		
		msg.setResponse(true);//不是就设置成是
		
		int candidate=msg.getCandidateID();//从信息中获取到id
		Long count=result.get(candidate);//从map中拿到相应id对应的投票数count
		
		if(count==null)//如果此id没有投票数则设为0；
			count=0L;
		
		if(!msg.isQuerry())//如果对服务器的请求是投票
			result.put(candidate, ++count);//则把此人的id和票数+1放入map中
		
		msg.setVoteCount(count);//重新设置投票数
		
		return msg;
	}
}
