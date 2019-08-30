package numx1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("numx1.xml");
		
		Person person=(Person) context.getBean("tom");
		
		List<String> list=person.Hobbits("x", "y");
		
		for(String s:list){
			System.out.println(s);
		}
		
		
	}
}
