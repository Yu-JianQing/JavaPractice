<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="jerry" class="ch9.Person" scope="page"/>
<jsp:setProperty property="name" name="jerry" value="jerry"/>

model:${tom1.name }<br>

page:${pageScope.jerry.name }<br>

request:${requestScope.tom2.name }<br>

session:${sessionScope.tom3.name }<br>

application:${applicationScope.tom4.name }<br>


<br><br><br><br><br>


text:${param.name }<br>
checkbox:${paramValues.hobby[0]},${paramValues.hobby[1]},${paramValues.hobby[2]},${paramValues.hobby[3]},


</body>
</html>