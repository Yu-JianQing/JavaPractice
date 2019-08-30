<%@page import="org.springframework.ui.Model"%>
<%@page import="ch1.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
test<br>

<c:forEach items="${users}" var="user">
	<li>
		<c:out value="${user.name }"/><br>
		<c:out value="${user.pass }"/><br>
		<c:out value="${user.repass }"/><br>
	</li>
</c:forEach>


</body>
</html>