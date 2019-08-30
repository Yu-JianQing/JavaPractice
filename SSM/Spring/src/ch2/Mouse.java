package ch2;

import org.springframework.stereotype.Component;

@Component("mouse")
public class Mouse implements Animal{

	public void speak() {
		System.out.println("mouse");
	}

}
