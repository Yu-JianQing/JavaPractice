package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.lang.String;

import jdk.internal.dynalink.beans.StaticClass;

import com.student.Student;

public class Test {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int i=0;
	
	Connection conn=null;
//	Statement state=null;
	PreparedStatement state=null;
	ResultSet rs=null;
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="user1";
	String pwd="user1";
	
	System.out.println("1.添加学生");
	System.out.println("2.删除学生");
	System.out.println("3.查找学生");
	System.out.println("4.修改学生");
	System.out.println("5.显示所有学生");
	System.out.println("6.退出系统");
	
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,pwd);
		
//		String sql="create table student1 (sno varchar2(20) primary key,sname varchar2(20),sage varchar2(10),sex varchar2(10))";
//		state.execute(sql);
		
		while(true){
			System.out.println("请输入您的选择");
			i=sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("添加信息（学号 姓名 年龄 性别)");
				String sql0="insert into student1 values(?,?,?,?)";
				state=conn.prepareStatement(sql0);
				state.setString(1, sc.next());
				state.setString(2, sc.next());
				state.setString(3, sc.next());
				state.setString(4, sc.next());
				state.execute();
				break;
			case 2:
				System.out.println("输入要删除学生的学号：");
				String sno=sc.next();
				String sql1="delete from student1 where sno="+sno;
				state=conn.prepareStatement(sql1);
				state.execute();
				break;
			case 3:
				System.out.println("输入要查找的学生的学号：");
				String sno1=sc.next();
				String sql2="select from student1 where sno="+sno1;
				state=conn.prepareStatement(sql2);
				rs=state.executeQuery();
				System.out.println(rs.getInt(0));
				break;
			case 4:
				System.out.println("输入要修改的学生的学号：");
				String sno2=sc.next();
				System.out.println("输入要修改信息（姓名，年龄，性别）：");
				String sql3="update student1 set sname=?,sage=?,sex=? "
						+ "where sno="+sno2;
				state=conn.prepareStatement(sql3);
				state.setString(1, sc.next());
				state.setString(2, sc.next());
				state.setString(3, sc.next());
				state.execute();
				break;
			case 5:
				String sql4="select * from student1";
				state=conn.prepareStatement(sql4);
				rs=state.executeQuery();
				while(rs.next()){
					String sno3=rs.getString("sno");
					String sname=rs.getString("sname");
					String sage=rs.getString("sage");
					String sex=rs.getString("sex");
					System.out.println(sno3+"  "+sname+"  "+sage+"  "+sex);
				}
				break;
			case 6:
				return;
			default:
				System.out.println("选择不存在，重新输入");
				break;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
