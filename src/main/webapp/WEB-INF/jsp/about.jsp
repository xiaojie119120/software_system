<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>关于我们</title>
	<link href="${pageContext.request.contextPath}/images/js_logo.png" rel="shortcut icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index0.css">
	<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
</head>


<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/new/all/1">最新更新</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
				<li class="header-li1"><a href="${pageContext.request.contextPath}/about">关于我们</a></li>

			</ul>
		</div>
		<div class="about_we">
			<div class="about_logo">
				<div class="t" id="t1"></div>
				<img alt="" src="${pageContext.request.contextPath }/images/logo.png" id="logo">
				<div class="t" id="t2"></div>
			</div>
			
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	var isRun=false;
	function init(){
		isRun=true;
		setTimeout(function(){
			layer.tips('JS软件分享是一个提供大学生分享和下载学习软件的平台。本网站的所有软件都由用户分享上传，仅限用于学习，不得用于商业用途。如果存在侵犯了您版权的软件，请联系我们，我们会根据实情删除该软件。', '#t1', {
				tips: [2, '#899DC0'],
				tipsMore: true,
				time: -1,
				isOutAnim: false
			});
		},300);
		setTimeout(function(){
			layer.tips('访问JS软件分享网站的用户必须明白，本网站对所提供下载的软件和程序代码不拥有任何权利，其版权归该软件和程序代码的合法拥有者所有，请用户在下载使用前必须详细阅读并遵守软件作者的“使用许可协议”。', '#t2', {
				tips: [2, '#1E9FFF'],
				tipsMore: true,
				time: -1,
				isOutAnim: false
			});	
		},600);
		setTimeout(function(){
			layer.tips('JS软件分享网站保证站内提供的所有可下载资源（软件等等）都是按“原样”提供，本站未做过任何改动，虽然我们会审核软件，但我们并不能保证本站提供的下载资源的准确性、安全性和完整性，同时JS软件分享网站不承担用户因使用这些下载资源对自己和他人造成任何形式的损失或伤害。', '#logo', {
				tips: [4, '#5ED7AE'],
				tipsMore: true,
				time: -1,
				isOutAnim: false
			});
		},900);
		setTimeout(function(){
			layer.tips('联系我们<br>E-mail：<a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=HGR1fXN2dXktLSUtLixcbW0yf3Nx" style="color:#fff;display:initial;">xiaojie119120@qq.com<a/>QQ：584719514', '#logo', {
				tips: [1, '#FF5722'],
				tipsMore: true,
				time: -1,
				isOutAnim: false
			});	
		},1200);
		setTimeout(function(){
			isRun=false;
		},1500);
	}
	$("#logo").click(function(){
		if (!isRun){
			layer.closeAll('tips');
			init();
		}
	})
	
	$(document).ready(init());
</script>
</html>
