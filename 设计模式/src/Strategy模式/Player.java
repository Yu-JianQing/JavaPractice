package Strategyģʽ;

public class Player {
	private String name;
	private Strategy strategy;
	private int winCount;
	private int loseCount;
	private int gameCount;
	
	public Player(String name,Strategy strategy){
		this.name=name;
		this.strategy=strategy;
	}
	
	public Hand nextHand(){
		return strategy.nextHand();
	}
	
	public void win(){
		winCount++;
		gameCount++;
		strategy.study(true);
	}
	
	public void loose(){
		loseCount++;
		gameCount++;
		strategy.study(false);
	}
	
	public void draw(){
		gameCount++;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", winCount=" + winCount + 
				", loseCount=" + loseCount + ", gameCount=" + gameCount + "]";
	}
}
