package num4;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num4/applicationConfig.xml");
		
		IdCardMap cardMapper=(IdCardMap) context.getBean("cardMapper");
		PersonMap personMapper=(PersonMap) context.getBean("personMapper");
		
		IdCard card=cardMapper.selectCardById(1);
		System.out.println(card);
		
		List<Person> persons1=personMapper.selectAllPersons1();
		for(Person person:persons1)
			System.out.println(person);
		
		List<Person> persons2=personMapper.selectAllPersons2();
		for(Person person:persons2)
			System.out.println(person);
		
	}
}
