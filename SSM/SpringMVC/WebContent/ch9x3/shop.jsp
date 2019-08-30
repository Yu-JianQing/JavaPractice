<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<sf:form action="${pageContext.request.contextPath}/ch9x3/shop" method="post" modelAttribute="product">
	name:<sf:input path="name"/><br>
	des:<sf:input path="des"/><br>
	price:<sf:input path="price"/><br>
	date:<sf:input path="date"/><br>
	<input type="reset" value="reset">  <input type="submit" value="commit">
	
	<sf:errors path="*"/>
</sf:form>

</body>
</html>