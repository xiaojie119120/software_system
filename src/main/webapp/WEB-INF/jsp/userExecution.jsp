<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>执行结果</title>
</head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index0.css">

<body>
	<div class="result" align="center">
		<p>${stateInfo}</p>
		<a href="${pageContext.request.contextPath }/user/edit/${uid }"><input type="button" value="返回" class="btn"></a>
	</div>
</body>
</html>
