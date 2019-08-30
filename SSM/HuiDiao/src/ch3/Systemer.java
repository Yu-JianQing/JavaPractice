package ch3;

public class Systemer implements Action{
	PersonClick listener;
	
	public void setOnClickListener(PersonClick listener){
		this.listener=listener;
	}
	
	public void generateClick(){
		listener.click(this);
	}
	
	@Override
	public void print() {
		System.out.println("action...");
	}

}
