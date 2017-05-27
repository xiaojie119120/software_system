<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
<title>JS软件分享</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index0.css">
<link href="${pageContext.request.contextPath}/images/js_logo.png" rel="shortcut icon" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
			<ul>
				<li class="header-li1"><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/new/all/1">最新分享</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
				<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
				<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>			

			</ul>
		</div>
		<div class="content">
			<div class="content-left">
				<div class="content-left-0">
					<p>软件分类</p>
					<ul>
						<c:forEach  items="${groups}" var="group" end="17" >
							<li><a href="${pageContext.request.contextPath}/soft/group/${group.groupId }/1">${group.groupName }</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="content-left-1">
					<p>友情链接</p>
					<ul>
						<li><a href="https://home.zcyoung.cn">科技小屋</a></li>
						<li><a href="http://www.hhtcyounger.cn">诛仙younger</a></li>
						<li><a href="http://blog.csdn.net/xiaojie119120">JS的csdn博客</a></li>
					</ul>
					<div style="clear:both"></div>
				</div>

			</div>
			<div class="content-right">
				<div class="content-right-1">
					<p class="con-right-1-1">最新分享</p>

					<c:forEach items="${newSofts }" var="soft">
						<div class="content-new">
							<div class="con-new-left">
								<img src="${pageContext.request.contextPath}/soft/icon/${soft.software.softIconLink }" width="55px" height="55px"><%-- /soft/icon/${soft.software.softIconLink } --%>
							</div>
							<div class="con-new-mid">
								<a href="${pageContext.request.contextPath}/soft/details/${soft.software.softId }">
								<p class="con-mid-1-1" style="width:250px">${soft.software.softName }</p>
								<p class="con-mid-1-2" style="width:530px">${soft.software.softAbstract }</p>
								<p class="con-mid-1-2-1">大小：${soft.softwareExpand.softSizeStr }
									更新日期：${soft.softwareExpand.softDateStr }</p>
								</a>
							</div>
							<div class="con-new-right">
								<a href="${pageContext.request.contextPath}/soft/download/${soft.software.softId }">安全下载</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script  src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">
	javascript:void(0);
		var i;
		if($(".content-new").length>10)
		{
			for(i=10;i<=$(".content-new").length;i++)
			{
				$(".content-new").eq(i).hide();
			}
		}
		$(".header ul li ").click(function(){
			$(this).find("a").css("background","#006abf");
			$(this).siblings().find("a").css("background","#0e97e6");		
		})
	</script>
</body>
</html>