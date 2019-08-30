package num2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num2/applicationContext.xml");
		
		StuMap stuMap=(StuMap) context.getBean("stuMapper");
		
		Student student=stuMap.selectBySno(2016305005);
		System.out.println(student);
		
		Student student2=new Student();
		student2.setSno(123456);student2.setSname("tom4");
		student2.setSex("男");student2.setSage(15);student2.setSdept("PH");
		int x=stuMap.addStudent(student2);
		System.out.println(x);
		
	}
}
