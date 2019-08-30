<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/ch7/shop" method="post">
<table align="center" cellpadding="1" cellspacing="1">
	<tr>
		<td>product name:</td>
		<td><input type="text" name="name" size="20"></td>
	</tr>
	<tr>
		<td>product price:</td>
		<td><input type="text" name="price" size="20"></td>
	</tr>
	<tr>
		<td>product count:</td>
		<td><input type="text" name="count" size="20"></td>
	</tr>
	<tr>
		<td><input type="submit" value="commit"></td>
	</tr>
</table>
</form>

</body>
</html>