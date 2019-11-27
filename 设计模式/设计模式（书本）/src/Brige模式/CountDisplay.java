package Brigeģʽ;

public class CountDisplay extends Display{

	public CountDisplay(AbstractDisplay display) {
		super(display);
	}
	
	public void multiDisplay(int times){
		before();
		for(int i=1;i<=times;i++)
			going();
		after();
	}
	
}
