package ch2;

import org.springframework.stereotype.Component;

@Component("cat")
public class Cat implements Animal{
	private String name="cat";
	
	public void speak() {
		System.out.println(name);
	}

}
