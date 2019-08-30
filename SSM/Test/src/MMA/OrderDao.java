package MMA;

import java.util.List;

import Test.Order;

public interface OrderDao {
	
	public Order seleOrderByRno(int rno);
	public List<Order> selectAllOrders();
	
}
