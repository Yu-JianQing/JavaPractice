package SanShuJu_3;

public class VoteMsg {
	private boolean isQuerry;	//true表示是查询，false表示是投票
	private boolean isResponse;	//true表示是服务器端，false表示是客户端
	private int candidateID;
	private long voteCount;
	
	public VoteMsg(boolean isQuerry,boolean isResponse,int candidateID,long voteCount){
		if(candidateID<0||candidateID>10000)
			throw new IllegalArgumentException("candidate id is broken");
		if(voteCount<0)
			throw new IllegalArgumentException("vote count is bad");
		
		this.isQuerry=isQuerry;
		this.isResponse=isResponse;
		this.candidateID=candidateID;
		this.voteCount=voteCount;
	}

	public boolean isQuerry() {
		return isQuerry;
	}

	public void setQuerry(boolean isQuerry) {
		this.isQuerry = isQuerry;
	}

	public boolean isResponse() {
		return isResponse;
	}

	public void setResponse(boolean isResponse) {
		this.isResponse = isResponse;
	}

	public int getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(int candidateID) {
		if(candidateID<0||candidateID>10000)
			throw new IllegalArgumentException("candidate id is broken");
		this.candidateID = candidateID;
	}

	public long getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(long voteCount) {
		if(voteCount<0)
			throw new IllegalArgumentException("vote count is bad");
		this.voteCount = voteCount;
	}
	
	public String toString(){
		String s=(isQuerry?"查询  ":"投票  ")+"候选人 id： "+candidateID;
		if(isResponse)
			s="服务器回复：候选人id ："+candidateID+"已经获得"+voteCount+"票";
		return s;
	}
	
}
