package ch4;

public class Test {
	public static void main(String[] args) {
		
		ClickListener listener=new Tom();
		Button button=new Button();
		button.setOnClickListener(listener);
		button.generateClick();
	}
}
