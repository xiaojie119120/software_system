<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>软件列表</title>
</head>


<body>
	<c:import var="head" url="head.jsp"/>
	${head }
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${softs}" var="soft">

				<tr>
					<td>${soft.software.softId}</td>
					<td>${soft.software.softName}</td>
					<td><a href="${pageContext.request.contextPath}/my/soft/delete/${soft.software.softId}">删除</a></td>
				</tr>

			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/soft/user/${uid}/${nowPage-1}">上一页</a>
		<a href="${pageContext.request.contextPath}/soft/user/${uid}/${nowPage+1}">下一页</a><br>
		当前在第${nowPage}页<br>
		一共${maxPage }页
	</div>
</body>
</html>