package ch1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext xmlContext=new ClassPathXmlApplicationContext("Knights.xml");
		Knight knight=(Knight) xmlContext.getBean("knight");
//		Minstrel minstrel=(Minstrel) xmlContext.getBean("minstrel");
		knight.embarkQuest();
		xmlContext.close();
		
		//一个Java项目中只能有一个applicationcontext，一旦关闭便不会再打开，也不能打开其他的context
		
//		AnnotationConfigApplicationContext javaContext=new AnnotationConfigApplicationContext(KnightConfig.class);
//		Knight knight2=javaContext.getBean(Knight.class);
////		Knight knight2=(Knight) xmlContext.getBean("knight");
//		knight2.embarkQuest();
//		javaContext.close();
	}
}
