package num1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {//自动化装配bean
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Tom tom=(Tom) context.getBean("tom");
		
		System.out.println(tom.getBook());
		
		context=new ClassPathXmlApplicationContext("num1.xml");
		
		Tom tom2=(Tom) context.getBean("tom");
		
		System.out.println(tom2.getBook());
		
	}
}
