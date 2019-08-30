package ch4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch4/applicationContext.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
		
		List<User> list=userMapper.selectAll();
		
		for(User user:list)
			System.out.println(user);
		
	}
}
