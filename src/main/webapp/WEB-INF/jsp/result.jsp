<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>提示</title>
	<link href="${pageContext.request.contextPath}/images/js_logo.png" rel="shortcut icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index0.css">
</head>


<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/new/all/1">最新分享</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
				<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>

			</ul>
		</div>
		<div class="search_r">
			<div class="jg">
				<strong class="jg_top">提示</strong>
				<a style="font-size:14px;color:blue;height:300px;width:978px;text-align:center;line-height:300px">${resultInfo }</a>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
