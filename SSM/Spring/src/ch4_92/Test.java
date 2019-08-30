package ch4_92;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4_92.xml");
		NumPrint numPrint=(NumPrint) context.getBean("numPrintImp");
		
		numPrint.print(5);
		
	}
}
