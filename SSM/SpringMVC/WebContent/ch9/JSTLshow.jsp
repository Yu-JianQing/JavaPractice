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

<c:out value="${tom1.name }" default="tom"/><br>

<c:set value="15" target="${tom1 }" property="age"/><c:out value="${tom1.age }"/><br><!-- target中必须用el表达式 -->

检验session中的值：<c:out value="${sessionScope.x}"/><br>

删除session中的值：<c:remove var="x" scope="session"/>

<!--  -->
控制流程：<br>
if:
<c:if test="${tom1.age>=18 }">
	tom1.age>=18	
</c:if><br>

ifelse---switch-case:
<c:choose>
	<c:when test="${tom1.age<=15 }">
		tom1.age smaller than 15 
	</c:when>
	<c:otherwise>
		tom1.age bigger than 15
	</c:otherwise>
</c:choose><br>

for:
<c:forEach items="${paramValues.hobby}" var="hobby" begin="0" end="3" step="1" varStatus="status">
	${hobby} + 迭代时隐含的变量：count:${status.count},index:${status.index},first:${status.first},last:${status.last}<br>
</c:forEach><br>

forTokens:
<c:forTokens items="one,two" var="y" delims=",">
	${y}
</c:forTokens><br>

join函数：<br>
${fn:join(paramValues.hobby,",") }<!-- 在el函数中直接写el表达式不需要加${} -->



</body>
</html>