package ch3_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch3_4.xml");
		
		User user=(User) context.getBean("user");
		System.out.println(user.getName());
	}
}
