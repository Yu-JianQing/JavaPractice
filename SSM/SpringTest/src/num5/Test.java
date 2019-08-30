package num5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Test {//xml配置文件装配bean
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Tom tom=(Tom) context.getBean("tom");
		System.out.println(tom);
		System.out.println(tom.getBook());
		
		Jerry jerry=(Jerry) context.getBean("jerry");
		System.out.println(jerry);
		
//		Lisa lisa=(Lisa) context.getBean("lisa");
//		System.out.println(lisa);
	}
}
