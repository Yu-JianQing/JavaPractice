<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<sf:form method="post" commandName="user">
input your name:<sf:input path="name"/><br>
input your email:<sf:input path="email"/><br>
input your passwd:<sf:input path="passwd"/><br>
<input type="submit" value="commit">
</sf:form>
</body>
</html>