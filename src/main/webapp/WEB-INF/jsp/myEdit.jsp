<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>个人信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index0.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/js_logo.png">
	<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/public.js"></script>
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="personal">
		<div class="person_top">
		</div>
		<div class="person_cen">
			<div class="cen_left">
				<ul class="left_data">
					<li class="ys_one" style="background:#f5f7fa">
						<img src="${pageContext.request.contextPath }/images/p_icon1.png" class="p_icon" align="center">
						<span>个人资料</span>	
					</li>
					<li class="ys_two">
						<img src="${pageContext.request.contextPath }/images/p_icon2.png" class="p_icon" align="center">
						<span>修改账户</span>		
					</li>
				</ul>
			</div>
			<div class="cen_right0">
			<form class="cen_right00" action="editExecution" method="post">
				<dl>
					<dt>用户名</dt>
					<input type="text" name="name" value="${sessionScope.user.name }">
					<dt>E-mall</dt>
					<input type="text" name="email" value="${sessionScope.user.email }">
					<dt>用户类型</dt>
					<input type="text" name="" value="${userTypeStr }" disabled="disabled" >
					<dt>上次登录时间</dt>
					<input type="text" name="" value="${sessionScope.user.preLoginTime }" disabled="disabled" >
					<dt>上次登录ip</dt>
					<input type="text" name="" value="${sessionScope.user.preLoginIp }" disabled="disabled" >
					<!-- <dt class="jies">自我介绍</dt>
					<textarea></textarea> -->
					<input type="submit" name="" value="更新" class="submit">
					<dt class="zhan">
						<!-- 更多内容
						<span id="deploy">展开</span>
						<hr style="width:590px;margin-left:100px;color:#dce3e8"> -->
					</dt>
					<div class="z_contain">
						<div class="na_name1" style="width:306px;float:left">
							<p>真实姓名</p>
							<input type="text" name="" class="zenj">
						</div>
						<div class="na_name2" style="width:306px;float:left;margin-left:76px">
							<p>手机号码</p>
							<input type="text" name="" class="zenj">
						</div>
						<div class="na_name3" style="width:306px;float:left;">
							<p>省份</p>
							<input type="text" name="" class="zenj">
						</div>
						<div class="na_name4" style="width:306px;float:left;margin-left:76px">
							<p>城市</p>
							<input type="text" name="" class="zenj">
						</div>
						<div class="na_name4" style="float:left;">
							<p>备注</p>
							<textarea></textarea>
						</div>
						<input type="submit" name="" class="submit_2" value="更新">
					</div>	
				</dl>
			</form>
			<form class="cen_right01" action="${pageContext.request.contextPath }/my/editPwdExecution" method="post" onsubmit="return pass()">
				<dl>
					<dt class="p_bold">修改密码<hr></dt>
					<dt>当前密码</dt>
					<input type="password" name="nowPass" id="pass_one">
					<dt>新密码</dt>
					<input type="password" name="password" id="pass_two">
					<dt>确认密码</dt>
					<input type="password" name="rePass" id="pass_three">
					<br>
					<input type="submit" value="更新" class="submit_3">
				</dl>

			</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#deploy").click(function(){
		//if($(this).)
		if($(this).html()=="展开")
		{
			$(this).html("收起");
			$(".z_contain").show();
		}
		else if($(this).html()=="收起")
		{
			$(this).html("展开");
			$(".z_contain").hide();
		}
	});
	$(".person_cen .cen_left .left_data li").click(function(){
		$(this).css("background","#f5f7fa").siblings().css("background","#fff");
	})
	$(".ys_one").click(function(){
		$(".cen_right00").show();
		$(".cen_right01").hide();
	})
	$(".ys_two").click(function(){
		$(".cen_right01").show();
		$(".cen_right00").hide();
	})
	//if($("pass_one").value()==$("pass_two").value())
	//{
	//	alert("新密码不能与当前密码相同");
	//}
	function pass(){
		var oPass1=document.getElementById("pass_one").value;
		var oPass2=document.getElementById("pass_two").value;
		var oPass3=document.getElementById("pass_three").value;
		if(oPass1==""||oPass2==""||oPass3=="")
		{
			alert("请确认是否有空项");
			return false;
		}
		else if(oPass1==oPass2)
		{
			alert("新密码不能与当前密码相同");
			return false;
		}
		else if(oPass2!=oPass3)
		{
			alert("密码和确认密码不同，请重新输入！");
			return false;
		}
		return true;
	}
	function showInfo(){
		if ("${updateInfo}"!=""){
			showTips("${updateInfo}", 50, 3);
		}
	}
	$(document).ready(showInfo());
</script>
</html>