package Strategyģʽ;

import java.util.Random;

public class RandomStrategy implements Strategy{
	private Random random=new Random();

	@Override
	public Hand nextHand() {
		int r=random.nextInt(3);
		for(Hand hand:Hand.values()){
			if(hand.getValue()==r){
				return hand;
			}
		}
		return null;
	}

	@Override
	public void study(boolean win) {}

}
