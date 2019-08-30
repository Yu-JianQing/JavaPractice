package ch5;

public class Test {
	public static void main(String[] args) {
		Button button=new Button();
		button.setOnClickListener(new ClickListener() {
			@Override
			public void click(Action action) {
				action.print();
			}
		});
		button.generateClick();
	}
}
