package ch4_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Calculat calculat=(Calculat) context.getBean("calculator");
		
		calculat.add(5, 6);
	}
}
