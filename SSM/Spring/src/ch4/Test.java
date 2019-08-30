package ch4;

public class Test {
	public static void main(String[] args) {
		Person person=new MyPersonProxy(new MyPerson());
		person.eat();
		person.sleep();
	}
}
