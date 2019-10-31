package Strategy模式;

import java.util.Random;

public class ProbStrategy implements Strategy{
	private int history[][]={{1,1},{1,1},{1,1}};
	//history[i][0]代表出石头|剪刀|布的次数，history[i][1]代表出石头|剪刀|布赢的次数
	private Random random=new Random();
	private Hand preHand;
	
	public ProbStrategy(Hand preHand){
		this.preHand=preHand;
	}
	
	@Override
	public Hand nextHand() {
		int winCount=0;
		
		for(int i=0;i<3;i++)
			winCount=winCount+history[i][1];
		
		int r=random.nextInt(winCount);
		int r1=history[0][1];
		int r2=r1+history[1][1];
		
		if(r>=0&&r<=r1)
			preHand=Hand.ShiTou;
		else if(r>r1&&r<=r2)
			preHand=Hand.JianDao;
		else
			preHand=Hand.Bu;
		return preHand;
	}

	@Override
	public void study(boolean win) {
		for(Hand hand:Hand.values()){
			if(hand==preHand){
				history[preHand.getValue()][0]+=1;
				if(win)
					history[preHand.getValue()][1]+=1;
			}
		}
	}

}
