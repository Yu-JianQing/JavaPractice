package ch1;

import net.sf.ehcache.management.Cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		Person person=(Person) context.getBean("person");
		
		person.eat("apple");
		person.age(5);
		person.sex();
		person.name();
		person.walk();
//		person.retire(5);
		
		
	}
}
