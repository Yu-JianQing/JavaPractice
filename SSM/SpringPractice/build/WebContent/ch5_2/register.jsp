<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ch5_2/register" method="post" name="registForm">
	<table border="1" bgcolor="lightblue" align="center">
		<tr>
			<td>name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>pass:</td>
			<td><input type="text" name="pass" maxlength="20"></td>
		</tr>
		<tr>
			<td>repass:</td>
			<td><input type="text" name="repass" maxlength="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="regist" onclick="allIsNull()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>