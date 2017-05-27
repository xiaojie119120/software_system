<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>登录</title>
	<link rel="shortcut icon"  href="${pageContext.request.contextPath}/images/js_logo.png">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index0.css">

</head>
<body>
<div class="login">
	<div class="bg">
		<div class="box">
			<div class="logo">
                <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/logo.png" ></a>
            </div>
			<form  name="loginname" class="box_cen" method="post" action="${pageContext.request.contextPath}/login" onsubmit="return login()">
				<p class='p1'>用户登录</p>
				<ul>
					<li style="margin-top:45px">
						<p>用户名：</p>
						<input type="text" id='username' name="name">
					</li>
					<li>
						<p>密码：</p>
						<input type="password" id='pwd' name="pwd">
						<br>
					<li>
						<a href="${pageContext.request.contextPath}/register">还未注册？点这里>></a><input type="submit" value="登录"
						class="sub">
					</li>
					<div align="center">
						<c:if test="${state != null }">
							<c:if test="${state != UserStateEnum.SUCCESS.state }">
								<div id='zy' style="text-align:center;color:red;">登录失败：${stateInfo }</div>
							</c:if>
						</c:if>
					</div>
				</ul>
			</form>
		</div>
	</div>
</div>
</body>
<script src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	function login(){
		var userName=document.getElementById("username").value;
		var pwd=document.getElementById('pwd').value;
		var matchResult=true;
		if(userName==""||pwd=="")
		{
			alert('请确认是否有空项');
			matchResult=false;
		}
		else if(userName.length<2||userName>14)
		{
			alert('用户名长度在2~14个字符之间！');
			matchResult=false;
		}
		else if(pwd.length<6||pwd.length>20)
		{
			alert('密码长度在6~20个字符之间！');
			matchResult=false;
		}
		return matchResult;
	}
</script>
</html>