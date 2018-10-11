<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询</title>
</head>
<body>
		${Msg }
		${updateMsg }
		<form action="${pageContext.request.contextPath }/findInfo" method="post">
	查询条件：
	<table width="100%" border=1>
	<tr>
	<td><input type="submit" value="查询"/></td>
	</tr>
	</table>
	人员出差信息列表：
	<table width="100%" border=1>
	<tr>
		<td>Name</td>
		<td>Start</td>
		<td>End</td>
		<td>Location</td>
		<td>PrintTime</td>
		<td>Room</td>
		<td>Folio</td>
		<td>Days</td>
		<td>operation</td>
	</tr>
	<c:forEach items="${Personlist }" var="item" varStatus="s">
	<tr>
		<td>${item.name }</td>
		<td>${item.start}</td>
		<td>${item.end}</td>
		<td>${item.location }</td>
		<td>${item.printTime }</td>
		<td>${item.room }</td>
		<td>${item.folio }</td>
		<td>${item.days }</td>
		<td>
			<a href="${pageContext.request.contextPath }/delInfo?id=${item.id}">删除</a>
			<a href="${pageContext.request.contextPath }/view/update.jsp?id=${item.id}">修改</a>
			<a href="${pageContext.request.contextPath }/pdf?id=${item.id}" onclick="alert('導出成功')">导出pdf</a>
		</td>
	
	</tr>
	</c:forEach>
	
	</table>
	</form>
	<a href="${pageContext.request.contextPath }/view/Login.jsp">返回主页</a>
</body>
</html>