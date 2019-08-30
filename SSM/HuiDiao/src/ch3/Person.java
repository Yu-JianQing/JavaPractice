package ch3;

public class Person implements PersonClick{

	@Override
	public void click(Action action) {
		System.out.println("user click");
		action.print();
	}

}
