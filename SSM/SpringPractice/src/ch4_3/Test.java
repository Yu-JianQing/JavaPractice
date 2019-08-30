package ch4_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_3.xml");
		Add add=(Add) context.getBean("add");
		add.add(5, 6);
	}
}
