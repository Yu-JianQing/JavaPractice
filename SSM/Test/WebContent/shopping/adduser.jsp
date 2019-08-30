<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<sf:form action="${pageContext.request.contextPath}/shopping/adduser" method="post" modelAttribute="user">
	name:<sf:input path="uname"/><sf:errors path="uname"/><br>
	pwd:<sf:input path="pwd"/><sf:errors path="pwd"/><br>
	tel:<sf:input path="tel"/><sf:errors path="tel"/><br>
	address:<sf:input path="address"/><sf:errors path="address"/><br>
	<input type="reset" value="reset"> <input type="submit" value="commit">
</sf:form>
</center>


</body>
</html>