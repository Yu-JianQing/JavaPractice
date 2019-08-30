package ch3_2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {
	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ch3_2.xml");
	
		LifeBean bean=(LifeBean) context.getBean("life");
		
		context.close();
	}
	
}
