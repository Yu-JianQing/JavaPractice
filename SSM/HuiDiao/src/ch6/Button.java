package ch6;


public class Button implements Action{
	ClickListener listener;
	
	public void setOnClickListener(ClickListener listener){
		this.listener=listener;
	}
	
	public void generateClick(){
		System.out.println("gengenerateClick");
		listener.click(this);
	}
	
	@Override
	public void print() {
		System.out.println("action...");
	}
	
}
