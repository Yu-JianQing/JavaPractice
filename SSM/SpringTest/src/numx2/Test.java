package numx2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Person person=(Person) context.getBean("tom");
		
		List<String> list=person.Hobbits("x", "y");
		
		for(String s:list){
			System.out.println(s);
		}
		
		Eat tomEat=(Eat) context.getBean("tom");
		
		tomEat.eat();
	}
}
