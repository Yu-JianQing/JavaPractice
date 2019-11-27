package Strategyģʽ;

import java.util.Random;

public class WinningStrategy implements Strategy{
	private Hand preHand;
	private Random random=new Random();
	private boolean isWin;
	
	public WinningStrategy(Hand preHand){
		this.preHand=preHand;
	}


	@Override
	public Hand nextHand() {
		if(!isWin){
			int r=random.nextInt(3);
			for(Hand hand:Hand.values()){
				if(hand.getValue()==r){
					preHand=hand;
				}
			}
		}
		return preHand;
	}

	@Override
	public void study(boolean win) {
		this.isWin=win;
	}

}
