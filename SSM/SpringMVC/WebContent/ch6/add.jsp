<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form action="${pageContext.request.contextPath}/ch6/add" method="post" modelAttribute="user">
	<fieldset>
		<legend>add a user</legend><br>
		<label>user name :</label><sf:input path="name"/><br>
		<label>hobby:</label><sf:checkboxes items="${hobbys}" path="hobby"/><br>
		<label>friends</label>
		<sf:checkbox path="friends" value="tom1"/>tom1
		<sf:checkbox path="friends" value="tom2"/>tom2
		<sf:checkbox path="friends" value="tom3"/>tom3
		<sf:checkbox path="friends" value="tom4"/>tom4
		<br>
		<label>carrer:</label>
		<sf:select path="carrer">
			<option/>select carrer
			<sf:options items="${carrers}"/>
		</sf:select><br>
		<label>tel:</label><sf:textarea path="tel" rows="2"/><br>
		
		<input id="reset" type="reset">
		<input id="submit" type="submit" value="add">
	</fieldset>
</sf:form>
</body>
</html>