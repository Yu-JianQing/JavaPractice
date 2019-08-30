package ch4;

public class MyPerson implements Person{

	@Override
	public void eat() {
		System.out.println("eating");
	}

	@Override
	public void sleep() {
		System.out.println("sleeping");
	}

}
