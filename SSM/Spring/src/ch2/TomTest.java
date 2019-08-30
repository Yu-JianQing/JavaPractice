package ch2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class TomTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DogConfig.class);
		Tom tom=context.getBean(Tom.class);
		tom.speak();
		context.close();
	}
}
