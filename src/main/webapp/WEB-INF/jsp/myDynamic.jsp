<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>个人主页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index0.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/js_logo.png">
	<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/public.js"></script>
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="personal_2">
		<div class="person2_top">
		</div>
		<div class="person2_cen">
			<div class="cen2_left">
				<div class="top2_png">
					<div class="png2_head" onclick="showSetHead();">
						<c:if test="${sessionScope.user.picLink==null }">
							<img src="${pageContext.request.contextPath }/images/head.png">
						</c:if>
						<c:if test="${sessionScope.user.picLink!=null }">
							<img src="${pageContext.request.contextPath }/user/head/${sessionScope.user.picLink }">
						</c:if>
						<div class="zhe">
						<span>更换头像</span>
					</div>
					</div>
					<p>${sessionScope.user.name }</p>
					
					<a href="${pageContext.request.contextPath }/my/edit">
					<img src="${pageContext.request.contextPath }/images/edit.png" class="edit">
					</a>
					<div class="tishi">
						<i></i>
						<span>修改资料</span>
					</div>
				</div>
			</div>	
			<div class="cen2_right">
				<div class="cen2_topic">
					<div class="action" style="border-bottom:2px solid #fe8282">
						<img src="${pageContext.request.contextPath }/images/action.png" align="center">
						<span style="color:#fe8282;">动态</span>
					</div>
					<c:if test="${sessionScope.user.type >= 1 }">
						<div class="record">
							<a href="${pageContext.request.contextPath }/my/soft/1">
								<img src="${pageContext.request.contextPath}/images/record.png" align="center">
								<span>软件管理</span>
							</a>
						</div>
					</c:if>
					<c:if test="${sessionScope.user.type >= 2 }">
						<div class="record">
							<a href="${pageContext.request.contextPath}/user/list/1">
								<img src="${pageContext.request.contextPath}/images/users.png" align="center">
								<span>用户管理</span>
							</a>
						</div>
					</c:if>
					<c:if test="${sessionScope.user.type >= 1 }">
						<div class="add">
							<a href="${pageContext.request.contextPath}/soft/upload">
								<img src="${pageContext.request.contextPath}/images/add.png" align="center">
								<span>添加分享</span>
							</a>
						</div>
					</c:if>
				</div>
				<div class="cen2_contain">
					<ul class="cen2_action">
						<li>
							<span>没有动态</span>
							<div class="who">
								<div class="who_tu">
									<img src="${pageContext.request.contextPath }/images/head.png">
								</div>
								<p>${user.name }</p>
							</div>
							<p class="shuom">动态功能正在开发中，敬请期待！</p>
							<p class="p_time">2017-3-18</p>
						</li>
					</ul>
					<div class="page">
							<a>首页</a>
							<a>上一页</a>
							<a href="">1</a>
							<a href="">2</a>
							<a href="">3</a>
							<a href="">4</a>
							<a href="">5</a>
							<a href="">6</a>
							<a href="">7</a>
							<a href="">8</a>
							<a href="">下一页</a>
							<a href="">页尾</a>
							<span>共***页</span>
					</div>
				</div>	
			</div>
			<div style="clear:both;"></div>
		</div>	
	</div>
</body>
<script type="text/javascript">
	$('.edit').hover(function(){
		$(".tishi").show();
	},function(){
		$(".tishi").hide();
	})
	$(".png2_head").hover(function(){
		$(".zhe").show()
	},function(){
		$(".zhe").hide()
	})
	var oDiv=$(".page a").length;
	var i=1;
	var len1=212;
	var len2=oDiv*5;
	var len3=(oDiv-4)*24;
	var oLength=len2+len1+len3;
	$(".page").width(oLength);
</script>
</html>