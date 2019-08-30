package ch4;


public class Button implements Action{
	ClickListener listener;
	
	public void setOnClickListener(ClickListener listener){
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
