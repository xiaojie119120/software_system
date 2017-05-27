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
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
<body>
	<div class="head_edit_box">
		<div class="head_edit_show">
			<c:if test="${user.picLink==null }">
				<img src="${pageContext.request.contextPath }/images/head.png" id="pic">
			</c:if>
			<c:if test="${user.picLink!=null }">
				<img src="${pageContext.request.contextPath }/user/head/${user.picLink }" id="pic">
			</c:if>
			<div class="zhe" id="zhe">
				<span>更换头像</span>
			</div>
		</div>
		<form enctype="multipart/form-data" id="head_form">
			<div class="head_edit_select">
				<input type="file" id="upload" accept="image/*" name="head_pic">
			</div>
			<div class="btns">
				<input type="button" value="保存" class="submit" id="OK">
				<input type="button" value="取消" id="Cancel">
			</div>
		</form>
	</div>

</body>
<script type="text/javascript">
	var isUp=false;
	var src = $("#pic").attr("src");
	$("#zhe").click(function () {
		$("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
 	});
 	$("#upload").on("change",function(){
 		var pattern=/(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
		var Imgk=this.value;
		if(Imgk!=null&&Imgk.trim()!=""&&pattern.test(Imgk.toLowerCase())){
			var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
			if (objUrl!=null) {
				$("#pic").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
				isUp=true;
			}
		}else{
			$("#pic").attr("src", src);
			this.value = null;
		}
	});
	$("#Cancel").click(function () {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index);
 	});
 	$("#OK").click(function () {
 		if (isUp){
	 		layer.load(1);
			$.ajax({
			    url: 'editHeadExecution',
			    type: 'POST',
			    cache: false,
			    data: new FormData($('#head_form')[0]),
			    processData: false,
			    contentType: false
			}).done(function(res) {
				layer.closeAll('loading');
				if (res.state!=1){
					layer.msg(res.stateInfo, {time: 2000, icon:2});
				}else{
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index);
					parent.location.reload();
				}
			}).fail(function(res) {
				layer.closeAll('loading');
				layer.msg("保存失败", {time: 2000, icon:2});
			}); 
		}else{
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index);
		}
 	});
 	function getObjectURL(file) {
		var url = null ;
 		if (window.createObjectURL!=undefined) { // basic
	 		url = window.createObjectURL(file) ;
	 	} else if (window.URL!=undefined) { // mozilla(firefox)
	 		url = window.URL.createObjectURL(file) ;
		} else if (window.webkitURL!=undefined) { // webkit or chrome
	 		url = window.webkitURL.createObjectURL(file) ;
	 	}
	 	return url ;
	 }
	function init(){
		layer.tips('点击你的头像更换', '#pic', {
		  tips: 3
		});
	}
	$(document).ready(init());
</script>
</html>
