<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
list:<br>
<table>
	<tr>
		<th>name</th><th>hobby</th><th>friends</th><th>carrer</th><th>tel</th>
	</tr>
	<c:forEach items="${users}" var="user" >
		<tr>
			<td>${user.name}</td>
			<td>
				<c:forEach items="${user.hobby}" var="hobby">${hobby} </c:forEach>
			</td>
			<td>
				<c:forEach items="${user.friends}" var="friend">${friend} </c:forEach>
			</td>
			<td>${user.carrer }</td>
			<td>${user.tel }</td>
		</tr>
	</c:forEach>
</table>


<a href="<c:url value="/ch6/input"/>">add</a><!-- 必须这么写 -->
</body>
</html>