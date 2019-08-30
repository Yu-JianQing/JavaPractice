package ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch2/ApplicationContext.xml");
		
//		StudentMap mapper=(StudentMap) context.getBean("singleMapper");
		StudentMap mapper=(StudentMap) context.getBean("studentMap");
		Student student=mapper.selectStudentBySno(2016305004);
		System.out.println(student);
	}
}
