<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.sql.DataSource" import="java.sql.Connection" 
	import="java.sql.ResultSet"  import="java.sql.Statement" 
	import="org.springframework.context.ApplicationContext"
	import="org.springframework.context.annotation.AnnotationConfigApplicationContext"
	import="ch1.Config"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
DataSource dataSource=(DataSource) context.getBean("dataSource");

Connection con=dataSource.getConnection();
String sql="select * from user";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql);

while(rs.next())
	System.out.println(rs.getString(1));
%>

</body>
</html>