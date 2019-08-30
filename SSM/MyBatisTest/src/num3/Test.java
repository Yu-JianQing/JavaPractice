package num3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num3/applicationConfig.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
		
//		User user1=userMapper.selectUserByUid1(1);
//		System.out.println(user1);
//		
//		Map<Object, Object> map=new HashMap<Object, Object>();
//		map.put("uid", 1);
//		User user2=userMapper.selectUserByUid2(map);
//		System.out.println(user2);
		
//		List<User> users1=userMapper.selectAllUsers1();
//		for(User user:users1)
//			System.out.println(user);
		
//		List<Map<String, Object>> users2=userMapper.selectAllUsers2();
//		for(Map<String, Object> map : users2)
//			System.out.println(map);
		
		
//		User user2=new User();
//		user2.setUid(0);user2.setUname("jerry");user2.setUsex("女");
//		int x1=userMapper.updateAUser(user2);
//		System.out.println(x1);
		
		
//		User user3=new User();
//		user3.setUid(8);
//		int x2=userMapper.deleteAUser(user3);
//		System.out.println(x2);
		
		
//		User user4=new User();
//		user4.setUid(8);user4.setUname("tom8");user4.setUsex("男");
//		int x3=userMapper.insertAUser1(user4);
//		System.out.println(x3);
		
//		User user5=new User();
//		user5.setUname("tom9");user5.setUsex("男");
//		int x4=userMapper.insertAUser2(user5);
//		System.out.println(user5.getUid());
		
		User user5=new User();
		user5.setUname("tom9");user5.setUsex("男");
		int x4=userMapper.insertAUser3(user5);
		System.out.println(user5.getUid());
		
		
	}
}
