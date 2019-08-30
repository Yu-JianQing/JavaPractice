package com.Web_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DButil.DButil;

import com.sun.org.apache.regexp.internal.recompile;

public class FJDBC {
public static void main(String[] args) {
	Connection conn=null;
	Statement statement=null;
	ResultSet rs=null;
	int i=0;
	
	try {
//		Class.forName("oracle.jdbc.OracleDriver");//加载驱动
//		String url="jdbc:oracle:thin:@localhost:1521:xe";//thin是协议，1521是监听端口，xe是服务id
//		conn=DriverManager.getConnection(url,"user1","user1");//获取连接,oracle连接的角色是user1，密码是user1
		conn=DButil.getConnection();
		
		statement=conn.createStatement();//statement用于与数据库数据交互
		String sql="select * from student";
		String sql1="insert into student values('赵柳','555','男','football','anhui','xxx')";
		int count=statement.executeUpdate(sql1);
		System.out.println(count);
		rs=statement.executeQuery(sql);//一个set就是已经查询的有一张表
		while(rs.next()){
			String name=rs.getString("name");
			String pwd=rs.getString("pwd");
			String sex=rs.getString("sex");
			String hobbies=rs.getString("hobbies");
			String prov=rs.getString("province");
			String info=rs.getString("info");
			System.out.println(name+'\t'+pwd+'\t'+sex+'\t'+hobbies+'\t'+prov+'\t'+info);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
//		if(rs!=null){
//			try {rs.close();} catch (Exception e2) {}
//		if(statement!=null)
//			try {statement.close();} catch (Exception e2) {}
//		if(conn!=null)
//			try {conn.close();} catch (Exception e2) {}
//		}
		DButil.close(rs, statement, conn);
	}
}
}
