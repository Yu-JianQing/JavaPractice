package ch4_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_4.xml");
		
		Print print=(Print) context.getBean("numPrint");
		
		print.print();
		
	}
}
