package ch3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch3/applicationContext.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
		User user=userMapper.selectById(1);
		System.out.println(user);
		System.out.println("**********************");
		
		List<User> users=userMapper.selectAll();
		for(User user2:users)
			System.out.println(user2);
		System.out.println("**********************");
		
		Map<String, Object> map=new HashMap();
		map.put("u_name", "t");
		map.put("usex", "男");
		List<User> users2=userMapper.selectApart(map);
		for(User user3:users2)
			System.out.println(user3);
		System.out.println("**********************");
		
//		User user2=new User();//普通插入，属性值全部写全
//		user2.setUid(6);user2.setUname("tom6");user2.setUsex("男");
//		int x1=userMapper.insertUser2(user2);
//		System.out.println(x1);
//		System.out.println("**********************");
		
//		User user3=new User();//自动主键回填插入，除主键wait其余属性全部写全。
//						//主键的值由数据库自动按照主键递增的顺序填写，并且将填写的主键注入到原先要插入到数据库中的对象
//		user3.setUname("tom7");user3.setUsex("男");
//		int x2=userMapper.insertUser2(user3);
//		System.out.println(x2+"   "+user3.getUid());
//		System.out.println("**********************");
		
		
//		User user4=new User();//手动主键回填插入，除主键wait其余属性全部写全。
//		//主键的值由自定义的sql语句生产，并且将填写的主键注入到原先要插入到数据库中的对象
//		user4.setUname("tom8");user4.setUsex("男");
//		int x3=userMapper.insertUser2(user4);
//		System.out.println(x3+"   "+user4.getUid());
//		System.out.println("**********************");
		
		User user5=userMapper.selectById(1);
		System.out.println(user5);
		System.out.println("**********************");
		
		List<Map<String, Object>> users3=userMapper.selectAll2();
		for(Map<String, Object> map2:users3)
			System.out.println(map2);
		System.out.println("**********************");
		
	}
}
