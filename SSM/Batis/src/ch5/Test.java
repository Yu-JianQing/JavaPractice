package ch5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch5/applicationContext.xml");
		
		IdCardMap cardMapper=(IdCardMap) context.getBean("cardMapper");
		PersonMap personMapper=(PersonMap) context.getBean("personMapper");
		
		IdCard card=cardMapper.selectCodeById(1);
		System.out.println(card);
		
		Person person=personMapper.selectPersonById1(1);
		System.out.println(person);
		
		Person person2=personMapper.selectPersonById2(2);
		System.out.println(person2);
		
		RS person3=personMapper.selectPersonById3(3);
		System.out.println(person3);
		
	}
}
