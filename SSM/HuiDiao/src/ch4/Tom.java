package ch4;

public class Tom implements ClickListener{

	@Override
	public void click(Action action) {
		System.out.println("user click");
		action.print();
	}

}
