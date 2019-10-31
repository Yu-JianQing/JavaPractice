package Brigeģʽ;

public class Display {
	private AbstractDisplay display;
	
	public Display(AbstractDisplay display){
		this.display=display;
	}
	
	public void before(){
		display.beforeDisplay();
	}
	
	public void going(){
		display.goingDisplay();
	}
	
	public void after(){
		display.afterDisplay();
	}
	
	public final void display(){
		before();
		going();
		after();
	}

}
