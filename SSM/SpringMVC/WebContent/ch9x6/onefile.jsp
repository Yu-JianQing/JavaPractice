<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/ch9x6/onefile" method="post" enctype="multipart/form-data">
select file:<input type="file" name="myFile"><br>
the file des:<input type="text" name="des"><br>
<input type="submit" value="commit">
</form>


</body>
</html>