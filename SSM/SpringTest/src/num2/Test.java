package num2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {//Java配置文件装配bean
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Tom tom=(Tom) context.getBean("tom");
		System.out.println("tom:"+tom);
		System.out.println(tom.getBook());
		
		Tom tom1=(Tom) context.getBean("tom1");
		System.out.println("tom1:"+tom1);
		System.out.println(tom1.getBook());
		
		Tom tom2=(Tom) context.getBean("tom2");
		System.out.println("tom2:"+tom2);
		System.out.println(tom2.getBook());
		
		
	}
}
