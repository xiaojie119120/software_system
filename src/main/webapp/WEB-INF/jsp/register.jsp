<%@page import="cn.jiesunshine.software_system.enums.UserStateEnum"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>注册</title>
	<link rel="short icon" href="${pageContext.request.contextPath}/images/js_logo.png">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index0.css">
</head>
<body>
	<div class="register">
		<div class="bg">
			<div class="box">
				<div class="logo">
					<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/logo.png" ></a>
				</div>
				<form class="box_cen" method="post"
					action="${pageContext.request.contextPath}/register"
					onsubmit="return register()">
					<p class='p1'>用户注册</p>
					<ul>
						<li style="margin-top:45px">
							<p>用户名:</p> <input type="text" id='username' name="name"
							value="${user.name}">
						</li>
						<li>
							<p>密码:</p> <input type="password" id='pwd' name="password"
							value="${user.password}"> <br>
						<li>
							<p>确认密码:</p> <input type="password" id='repwd' name="repwd">
							<br>
						<li>
							<p>电子邮箱:</p> <input type="text" id='address' name="email"
							value="${user.email}"> <br>
						<li><a href="${pageContext.request.contextPath}/login">已经注册？点这里>></a><input type="submit"
							value="注册" class="sub"></li>
						<div align="center">
							<c:set var="SUCCESS" value="<%=UserStateEnum.SUCCESS%>" />
							<c:if test="${state != null }">
								<c:if test="${state != SUCCESS.state }">
									<div id='zy' style="text-align:center;color:red;">注册失败：${stateInfo}</div>
								</c:if>
								<c:if test="${state == SUCCESS.state }">
									<div id='zy' style="text-align:center;color:blue;">注册成功：<a href="${pageContext.request.contextPath}/login" style="display:inline;">前往登录</a></div>
								</c:if>
							</c:if>
						</div>
					</ul>
				</form>
				
			</div>
		</div>
	</div>
</body>
<script src="js/jquery.js"></script>
<script type="text/javascript">
	function register(){
		var userName=document.getElementById('username').value;
		 var pwd=document.getElementById("pwd").value;  
      	var repwd=document.getElementById("repwd").value;  
      	var address=document.getElementById("address").value;  
      	var matchResult=true;
      	if(userName==""||pwd==""||repwd==""||address=="")
      	{  
            alert("请确认是否有空缺项！");  
            matchResult=false;
        }
        else if(userName.length<2||userName.length>14)
        {  
            alert("用户名长度在2~14个字符之间！");  
            matchResult=false; 
        } 
        else if(pwd.length<6||pwd.length>20||repwd.length<6||repwd.length>20)
        {  
            alert("密码或确认密码长度应在6到20个字符之间！");  
            matchResult=false;  
      	}
        else if(pwd!=repwd)
        {  
            alert("密码和确认密码不同，请重新输入！");  
            matchResult=false; 
        }
        if(matchResult==true)
        {
        	var mailreg=/^\w+@\w+(\.\w+)+$/;
        	if(!address.match(mailreg)){
        		alert('邮箱格式不正确！');
        		matchResult=false;
        	}
        }
        if(matchResult==true)
        {
        	if(userName.charAt(0)>=0&&userName.chatAt(0)<=9)
        	{
        		alert('用户名不能以数字字符开始！');
        		matchResult=false;
        	}
        }
        return matchResult;
	} 
</script>
</html>