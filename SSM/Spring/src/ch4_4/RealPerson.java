package ch4_4;

public class RealPerson implements Person{

	@Override
	public void eat() {
		System.out.println("eating");
	}

	@Override
	public void sleep() {
		System.out.println("sleeping");
	}

}
