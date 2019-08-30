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

EL算术运算：5+6=${5+6}<br>
5%6=${5%6}
<br>
EL关系运算：
5==6?${5==6}<br>
8>=8?${8>=8}
<br>
EL逻辑运算：
5==6&&7>6||5>6?${5==6&&7>6||5>6}<br>
<br>
ELempty运算：
user is null? ${empty user}
<br>
EL条件运算：
5>6?5+6:5-6=${5>6?5+6:5-6}

<br><br><br><br><br>
范围<br>

<a href="<c:out value="ELinput"/>">show.jsp</a>

<br><br><br><br><br>

参数隐含:<br>
<form action="${pageContext.request.contextPath }/ch9/ELinput">
	name:<input name="name" type="text"><br>
	hobby:<input name="hobby" type="checkbox" value="a">a
	<input name="hobby" type="checkbox" value="b">b
	<input name="hobby" type="checkbox" value="c">c
	<input name="hobby" type="checkbox" value="d">d<br>
	<input type="submit" value="commit">
</form>

</body>
</html>