<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="x" value="1" scope="session"/>

<form action="${pageContext.request.contextPath }/ch9/JSTLinput">
	hobby:<input name="hobby" type="checkbox" value="a">a
	<input name="hobby" type="checkbox" value="b">b
	<input name="hobby" type="checkbox" value="c">c
	<input name="hobby" type="checkbox" value="d">d<br>
	<input type="submit" value="commit">
</form>
<br>
函数：<br>
contains:${fn:contains("I am a person","am") }<br>
containsIgnoreCase:${fn:containsIgnoreCase("I am a person","i") }<br>
endsWith:${fn:endsWith("I am a person","on") }<br>
indexOf:${fn:indexOf("I am a person","o") }<br>
join -->show<br>
length:${fn:length("aaa") }<br>
replace:${fn:replace("I am a person","person","cat") }<br>
split:${fn:split("I am a person"," ") }<br>









</body>
</html>