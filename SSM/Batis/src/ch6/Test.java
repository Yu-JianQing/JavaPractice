package ch6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch6/applicationContext.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
		OrdersMap ordersMapper=(OrdersMap) context.getBean("ordersMapper");
		
		User user=userMapper.selectUserOrderByUId1(1);
		System.out.println(user);
		System.out.println("********************");
		
		User user2=userMapper.selectUserOrderByUId2(1);
		System.out.println(user2);
		System.out.println("********************");
		
		List<RS> users=userMapper.selectUserOrderByUId3(1);
		for(RS user3 : users)
			System.out.println(user3);
		System.out.println("********************");
		
		List<Orders> orders=ordersMapper.selectOrdersByUId(1);
		for(Orders order:orders)
			System.out.println(order);
		
	}
}
