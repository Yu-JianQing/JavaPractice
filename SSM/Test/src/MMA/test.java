//package MMA;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import Test.Detail;
//import Test.Order;
//import Test.Product;
//
//public class test {
//	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("Mapper/ApplicationConfig.xml");
//		ProductDao productDao=(ProductDao) context.getBean("productMapper");
//		Product product=productDao.selectProductByPno(1);
//		System.out.println("1号产品："+product);
//		
//		System.out.println("-------------------");
//		
//		DetailDao detailDao=(DetailDao) context.getBean("detailMapper");
//		Detail detail=detailDao.selectDetailByDno(1);
//		System.out.println("1号详细订单："+detail);
//		System.out.println("对应的产品："+detail.getProduct());
//		
//		System.out.println("-------------------");
//		
//		List<Detail> details=detailDao.selecAllDetails();
//		for(Detail d:details){
//			System.out.println(d.getDno()+"号详细订单："+detail);
//			System.out.println("对应的产品："+d.getProduct());
//		}
//		
//		System.out.println("-------------------");
//		
//		Date date=detailDao.selectTime();
//		System.out.println("test util.date:"+date);
//		System.out.println("util.date-->sql.date:"+new java.sql.Date(date.getTime()));
//		
//		java.sql.Date date2=detailDao.selectSQLTime();
//		System.out.println("test sql.date:"+date2);
//		System.out.println("sql.date-->util.date:"+new Date(date2.getTime()));
//		
//		System.out.println("++++++++++++++++++++");
//		
//		OrderDao orderDao=(OrderDao) context.getBean("orderMapper");
//		Order order=orderDao.seleOrderByRno(1);
//		System.out.println("1号订单："+order);
//		System.out.println("对应的订单详情：");
//		for(Detail detail2:order.getDetails())
//			System.out.println(detail2);
//		
//		List<Order> orders=orderDao.selectAllOrders();
//		System.out.println("所有订单：");
//		for(Order order2:orders)
//			System.out.println(order2);
//		
//		System.out.println("++++++++++++++++++++");
//		
//		System.out.println("1号订单对应状态：");
//		for(Detail detail2:order.getDetails())
//			System.out.println("rno="+order.getRno()+
//							",pname="+detail.getProduct().getPname()+
//							",count="+detail.getCount()+
//							",time="+detail.getTime());
//		
//		
//	}
//}
