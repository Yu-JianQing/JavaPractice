package ch4;

public class MyPersonProxy implements Person{
	private MyPerson myperson;
	
	public MyPersonProxy(MyPerson myPerson){
		this.myperson=myPerson;
	}
	
	@Override
	public void eat() {
		System.out.println("before eat");
		myperson.eat();
		System.out.println("after eat");
	}

	@Override
	public void sleep() {
		System.out.println("before sleep");
		myperson.sleep();
		System.out.println("after sleep");
	}

}