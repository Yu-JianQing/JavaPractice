package ch3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource=(DataSource) context.getBean("dataSource");

		Connection con=dataSource.getConnection();
		String sql="select * from user";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		while(rs.next())
			System.out.println(rs.getString(1));
	}
}
