package ch2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext  context=new AnnotationConfigApplicationContext(Config.class);
		Person tom=(Person) context.getBean("tom");
		tom.eat("apple");
		System.out.println("================");
		tom.walk();
		System.out.println("===============");
		List<String> list=(List<String>) tom.hobbies("AA", "BB");
		for(String s:list)
			System.out.println(s);
	}
}
