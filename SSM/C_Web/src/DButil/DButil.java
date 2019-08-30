package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DButil {
	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="user1";
	private static String pwd="user1";
	
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public static void close(ResultSet rs,Statement statement,Connection conn){
		if(rs!=null){
			try {rs.close();} catch (Exception e2) {}
		if(statement!=null)
			try {statement.close();} catch (Exception e2) {}
		if(conn!=null)
			try {conn.close();} catch (Exception e2) {}
		}
	}
}
