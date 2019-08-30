package ch3_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch3_3.xml");
		
		User tom=(User) context.getBean("tom");
		System.out.println(tom);
		
		User jerry=(User) context.getBean("jerry");
		System.out.println(jerry);
	}
}
