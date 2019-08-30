package ch2;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog implements Animal{//component注释表示该类是个bean，让Spring容器自动创建此bean
	private String name="dog";
	
	public void speak() {
		System.out.println(name);
	}

}
