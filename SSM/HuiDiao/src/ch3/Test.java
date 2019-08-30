package ch3;

public class Test {
	public static void main(String[] args) {
		PersonClick personClick=new Person();
		Systemer systemer=new Systemer();
		systemer.setOnClickListener(personClick);
		systemer.generateClick();
	}
}
