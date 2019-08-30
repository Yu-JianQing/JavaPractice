package ch3_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("ch3_2.xml");
		
		Bean bean1=(Bean) context.getBean("bean1");
		System.out.println(bean1);
		Bean bean2=(Bean) context.getBean("bean1");
		System.out.println(bean2);
		
		Bean bean3=(Bean) context.getBean("bean2");
		System.out.println(bean3);
		Bean bean4=(Bean) context.getBean("bean2");
		System.out.println(bean4);
		
	}
}
