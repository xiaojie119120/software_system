<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>用户列表</title>
</head>


<body>
	<c:import var="head" url="top.jsp"/>
	${head }
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${userList}" var="user">

				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/edit/${user.id}">编辑</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a>
					</td>
				</tr>

			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/user/list/${nowPage-1}">上一页</a>
		<a href="${pageContext.request.contextPath}/user/list/${nowPage+1}">下一页</a><br>
		当前在第${nowPage}页
	</div>
</body>
</html>
