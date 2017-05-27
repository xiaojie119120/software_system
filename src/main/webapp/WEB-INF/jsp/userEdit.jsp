<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>编辑</title>
</head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index0.css">
	<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
<body>
	<c:if test="${user != null }">
		<div class="edit_box">
			<form class="edit_form" action="${pageContext.request.contextPath}/user/editExecution" enctype="multipart/form-data"
				method="post">
				<dl>
					<dt>头像<input type="button" value="开启" class="user_head_btn" onclick="switchEdit();" id="user_head_btn_id"></dt>
						<input type="file" name="head_pic" class="user_head" id="user_head_id" disabled="disabled">
					<dt>用户ID</dt>
						<input class="no_edit" type="text" name="id" value="${user.id}" readonly="readonly">
					<dt>用户名</dt>
						<input type="text" name="name" value="${user.name}">
					<dt>密码</dt>
						<input type="text" name="password" value="${user.password}">
					<dt>邮箱</dt>
						<input type="text" name="email" value="${user.email}">
					<dt>用户类型</dt>
						<select name="type" class="select_edit" id="user_type">
							<option value="0">普通用户</option>
							<option value="1">软件分享者</option>
							<option value="2">管理员</option>
						</select>
					<c:if test="${user.picLink!=null }">
						<input type="hidden" name="picLink" value="${user.picLink}">
					</c:if>
				</dl>
				<input type="submit" value="提交" class="user_submit"/>
			</form>
		</div>
	</c:if>

</body>
<script type="text/javascript">
	var canEditFile=false;
	function switchEdit(){
		var oInput1=document.getElementById('user_head_id');
		if (canEditFile){
			oInput1.value=null;
			oInput1.disabled = true;
			canEditFile=false;
			document.getElementById('user_head_btn_id').value = "开启";			
		}else{
			oInput1.disabled = false;
			canEditFile=true;
			document.getElementById('user_head_btn_id').value = "关闭";
		}
	}
	function init(){
		var select = document.getElementById("user_type");
		for(var i=0;i<select.length;i++){
			if (select[i].value == "${user.type }"){
				select[i].selected = true;
				break;
			}
		}
	}
	$(document).ready(init());
</script>
</html>
