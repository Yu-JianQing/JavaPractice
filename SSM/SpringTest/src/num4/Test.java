package num4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {//混合配置（在Java配置文件中引入Java配置及xml配置）装配bean
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		Tom tom=(Tom) context.getBean("tom");
		System.out.println(tom);
		Jerry jerry=(Jerry) context.getBean("jerry");
		System.out.println(jerry);
		Jerry jerry2=(Jerry) context.getBean("jerry2");
		System.out.println(jerry2);
		
	}
}
