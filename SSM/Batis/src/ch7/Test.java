package ch7;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch7/applicationContext.xml");
		
		OrdersMap ordersMapper=(OrdersMap) context.getBean("ordersMapper");
		
		List<Orders> orders=ordersMapper.selectAllOrdersAndProducts();
		for(Orders order:orders)
			System.out.println(order);
		
	}
}
