package ch4_91;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_91.xml");
//		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_91_2.xml");
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_91_3.xml");
		
		Performance actor=(Performance) context.getBean("actor");
		actor.perform();

		
	}
}
