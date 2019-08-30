package ch4_93;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_93.xml");
		
		Performance actor=(Performance) context.getBean("actor");
		actor.perform();

		Encoreable actor2=(Encoreable) context.getBean("actor");
		actor2.Encore();
		
	}
}
