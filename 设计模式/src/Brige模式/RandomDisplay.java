package Brigeģʽ;

public class RandomDisplay extends CountDisplay{

	public RandomDisplay(AbstractDisplay display) {
		super(display);
	}
	
	public void randomDisplay(int times){
		multiDisplay((int) (Math.random()*times));
	}

}
