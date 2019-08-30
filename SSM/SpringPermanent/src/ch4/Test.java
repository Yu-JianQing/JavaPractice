package ch4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

		UserDao userDao=(UserDao) context.getBean("userDaoImp");
		
		User user=new User(4,"tom4","123",123,"us");
//		userDao.insert(user);
		
//		userDao.removeByUno(3);
		
//		user.setUname("tom4x");
//		userDao.update(user);
		
//		User user2=userDao.selectUserByUno(1);
//		System.out.println(user2);
		
		List<User> users=userDao.selectAllUsers();
		for(User userx:users)
			System.out.println(userx);
		
	}
}
