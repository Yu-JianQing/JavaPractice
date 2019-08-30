package ch4_9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Performance actor=(Performance) context.getBean("actor");
		actor.perform();

		Encoreable actor2=(Encoreable) context.getBean("actor");
		actor2.Encore();
		
	}
}
