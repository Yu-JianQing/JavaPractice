<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>结果界面</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
		if("s".equals(name)){
	%>
	<font color="red" size="7">用户名为s</font>
	<%} else { %>
	<font>
		操作成功：<%=new Date() %><br/>
	</font>
	<%}%>
</body>
</html>