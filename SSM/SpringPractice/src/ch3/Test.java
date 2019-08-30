package ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch3.xml");
		
		Bean bean1=(Bean) context.getBean("bean1");
		System.out.println(bean1+bean1.msg);
		
		
		Bean bean2=(Bean) context.getBean("bean2");
		System.out.println(bean2+bean2.msg);
		
		
		Bean bean3=(Bean) context.getBean("bean3");
		System.out.println(bean3+bean3.msg);
		
	}
}
