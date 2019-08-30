package num5;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num5/applicationConfig.xml");
		
		UserMap userMapper=(UserMap) context.getBean("userMapper");
		OrdersMap ordersMapper=(OrdersMap) context.getBean("ordersMapper");
		
		
		List<Orders> orders=ordersMapper.selectOrdersByUId(1);
		for(Orders order:orders)
			System.out.println(order);
		
		List<User> users=userMapper.selectAllUsers1();
		for(User user:users)
			System.out.println(user);
		
	}
}
