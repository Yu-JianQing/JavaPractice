<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- shift+ctrl+c注释HTML代码 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生</title>
<% String message=(String)request.getAttribute("message");
	if(message!=null){
		if(!"".equals(message.trim())){%>
			<script type="text/javascript">
				alert("${requestScope.message}")
			</script>
		<%}
	}
%>
</head>
<body>
	<center>
	<form action="addStu.do" method="post">
		<table>
			<caption><h3>添加学生信息</h3></caption>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="name">
					<span style="color:red;">${requestScope.message}</span>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" value="F">女
					<input type="radio" name="sex" value="N">男
				</td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobbies" value="football">football
					<input type="checkbox" name="hobbies" value="basketball">basketball
					<input type="checkbox" name="hobbies" value="pingpang">pingpang
				</td>
			</tr>
			<tr>
				<td>省份</td>
				<td>
					<select name="province">
						<option value="jiangsu">江苏</option>
						<option value="anhui">安徽</option>
						<option value="gansu">甘肃</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>个人简介</td>
				<td>
					<%-- <%String info=request.getParameter("info"); %><!-- 此处空白不会被忽略 --> --%>
					<textarea name="info" rows="10" cols="20">
					<%-- <%=info==null?"":info %> --%>
					${param.info}</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>