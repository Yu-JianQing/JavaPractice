<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/ch6/input">
name:<input name="name" type="text"><br>
pwd:<input name="name" type="pwd"><br>
age:<input name="name" type="age"><br>
<input type="submit" value="commit"><br>
</form>
</body>
</html>