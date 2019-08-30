package ch2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Tom implements Person{
	public void eat(String name){
		System.out.println("eating "+name);
	}

	@Override
	public void walk() {
		System.out.println("walking");
	}

	@Override
	public List<?> hobbies(String h1, String h2) {
		List<String> hobbies=new ArrayList<String>();
		hobbies.add(h1);
		hobbies.add(h2);
		return hobbies;
	}
}
