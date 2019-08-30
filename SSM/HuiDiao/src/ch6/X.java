package ch6;

public class X implements ClickListener{

	public void init(){
		Button button=new Button();
		button.setOnClickListener(this);
		button.generateClick();
		button.print();
	}
	
	@Override
	public void click(Action action) {
		action.print();
	}
	
}
