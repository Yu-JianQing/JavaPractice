package num6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("num6/applicationConfig.xml");
		
		OrderMap orderMapper=(OrderMap) context.getBean("orderMapper");
		
		List<Order> orders=orderMapper.selectAllOrders();
		for(Order order:orders)
			System.out.println(order);
	}
}
