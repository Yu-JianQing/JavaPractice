package num3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {//xml配置文件装配bean
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num3.xml");
		
		Tom tom=(Tom) context.getBean("tom");
		System.out.println("tom:"+tom);
		System.out.println(tom.getBook());
		
		Tom tom1=(Tom) context.getBean("tom1");
		System.out.println("tom1:"+tom1);
		System.out.println(tom1.getBook());
		
		Jerry jerry=(Jerry) context.getBean("jerry");
		System.out.println(jerry.getName());
		System.out.println(jerry.getHobbies());
		
		Jerry jerry1=(Jerry) context.getBean("jerry1");
		System.out.println(jerry1.getName());
		System.out.println(jerry1.getHobbies());
		
	}
}
