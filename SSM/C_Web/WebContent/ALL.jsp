<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入jstl标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1" cellspacing="0" cellpadding="10">
			<caption><h3>学生信息表</h3></caption>
			<thead>
				<tr>
					<th>姓名</th>
					<th>性别</th>
					<th>爱好</th>
					<th>地址</th>
					<th>简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stu" items="${sessionScope.stus}"><!-- 增强for循环标签 -->
					<tr>
						<td>${stu.name}</td>
						<td>${stu.sex=="F"?"男":"女"}</td>
						<td>
							<c:forEach var="s" items="${stu.hobbies}">
								${s}
							</c:forEach>
						</td>
						<td>${stu.province}</td>
						<td>${stu.info}</td>
						<td>
							<a href="modify.jsp?name=${stu.name}&info=${dtu.info}" method="post">修改</a>/<a href="deleteStu.do?name=${stu.name}" method="post">删除</a>
						</td>
					</tr>
				</c:forEach>
<%-- 			${requestScope.stus} --%>
<!-- 				<tr> -->
<%-- 					<td>学生：${sessionScope.stus}</td> --%>
<!-- 					<td>zhangsan</td> -->
<!-- 					<td>nan</td> -->
<!-- 					<td>football,basketball</td> -->
<!-- 					<td>张三</td> -->
<!-- 					<td>我是张三</td> -->
<!-- 				</tr> -->
			</tbody>
		</table>
	</center>
</body>
</html>