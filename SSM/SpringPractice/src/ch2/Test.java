package ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch2.xml");
		
		TestDIService service=(TestDIService) context.getBean("testDIService");
		service.sayHello();
		
		TestDIService service2=(TestDIService) context.getBean("testDIService2");
		service2.sayHello();
	}
}
