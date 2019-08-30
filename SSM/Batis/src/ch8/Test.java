package ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch8/applicationContext.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
	
		User user=new User();
		user.setUname("to");
		user.setUsex("女");
		
		List<User> users=userMapper.selectUserByIf(user);
		for(User user2:users)
			System.out.println(user2);
		System.out.println("*************");
		
		List<User> users2=userMapper.selectUserByChoose(user);
		for(User user2:users2)
			System.out.println(user2);
		System.out.println("*************");
		
		List<User> users3=userMapper.selectUserByTrim(user);
		for(User user2:users3)
			System.out.println(user2);
		System.out.println("*************");
		
		List<User> users4=userMapper.selectUserByWhere(user);
		for(User user2:users4)
			System.out.println(user2);
		System.out.println("*************");
		
		User user3=new User();
		user3.setUid(5);
		user3.setUsex("女");
		int x=userMapper.updateUserBySet(user3);
		System.out.println("*************"+x);
		
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
			ids.add(i);
		List<User> users5=userMapper.selectUserByForEach(ids);
		System.out.println(users5);
		System.out.println("*************");
		
		User user5=new User();
		user5.setUname("to");
		
		List<User> users6=userMapper.selectUserByBind(user5);
		for(User user2:users6)
			System.out.println(user2);
		System.out.println("*************");
		
	}
}
