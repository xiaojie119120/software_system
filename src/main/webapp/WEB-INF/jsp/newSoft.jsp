<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>最新分享</title>
	<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/index0.css" />
	<link rel="shortcut icon"  href="${pageContext.request.contextPath}/images/js_logo.png" />
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe wrappe-upload">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
		<ul>
			<li><a href="${pageContext.request.contextPath}/">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
			<li class="header-li1"><a href="${pageContext.request.contextPath}/soft/new/all/1">最新分享</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
			<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
			
		</ul>
		</div>
		<div class="update">
			<div class="update_top">
				<c:if test="${pageType == 0 }">
					<span>
						<a href="#" class="abg">全部更新</a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/today/1">今日更新</a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/yestoday/1">昨日更新</a>
					</span>
				</c:if>
				<c:if test="${pageType == 1 }">
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/all/1">全部更新</a>
					</span>
					<span>
						<a href="#" class="abg">今日更新</a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/yestoday/1">昨日更新</a>
					</span>
				</c:if>
				<c:if test="${pageType == 2 }">
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/all/1">全部更新</a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/soft/new/today/1">今日更新</a>
					</span>
					<span>
						<a href="#" class="abg">昨日更新</a>
					</span>
				</c:if>
			</div>
			<div class="update_head">
					<span class="title">软件名称</span>
					<span class="size">软件大小</span>
					<span class="lan">操作系统</span>
					<span class="dro">软件授权</span>
					<span class="Sort">下载量</span>
					<span class="time">更新时间</span>
				</div>
				<c:if test="${newSofts==null }">
					<a style="font-size:14px;color:red;height:650px;width:978px;text-align:center;line-height:300px">没有找到匹配的记录!</a>
				</c:if>
				<c:if test="${newSofts!=null }">
					<div class="rankct" style="height:650px;">
						<ul>	
							<c:forEach var="soft" items="${newSofts }">
								<li>
									<a href="#" class="aimg">
										<img src="${pageContext.request.contextPath}/soft/icon/${soft.software.softIconLink }" width="30px" height="30px" />
									</a>
									<a href="${pageContext.request.contextPath}/soft/details/${soft.software.softId }" class="aruan"><p style="width:250px;">${soft.software.softName }</p></a>
									<span class="adax">${soft.softwareExpand.softSizeStr }</span>
									<span class="slan">${soft.software.softOs }</span>
									<span class="adro">共享软件</span>
									<span class="awen">${soft.software.softDownloadVolume }</span>
									<span class="atime">${soft.softwareExpand.softDateStr }</span>
								</li>
							</c:forEach>		
						</ul>
					</div>
					<div class="page">
						<a href="1">首页</a>
						<c:if test="${nowPage<=1 }">
							<a>上一页</a>
						</c:if>
						<c:if test="${nowPage>1 }">
							<a href="${nowPage-1 }">上一页</a>
						</c:if>
						
						<c:if test="${maxPage>10 }">
							<c:forEach var="i" begin="${nowPage }" end="${nowPage+9 }">
								<c:if test="${i==nowPage }">
									<a href="${i }" class="now">${i }</a>
								</c:if>
								<c:if test="${i!=nowPage }">
									<a href="${i }">${i }</a>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${maxPage<=10 }">
							<c:forEach var="i" begin="1" end="${maxPage }">
								<c:if test="${i==nowPage }">
									<a href="${i }" class="now">${i }</a>
								</c:if>
								<c:if test="${i!=nowPage }">
									<a href="${i }">${i }</a>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${nowPage>=maxPage }">
							<a>下一页</a>
						</c:if>
						<c:if test="${nowPage<maxPage }">
							<a href="${nowPage+1 }">下一页</a>
						</c:if>
						<a href="${maxPage }">首页</a>
						<span>共${maxPage }页</span>
					</div>
				</c:if>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
<script  src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
javascript:void(0);
	var oDiv=$(".page a").length;
	var i=1;
	var len1=212;
	var len2=oDiv*5;
	var len3=(oDiv-4)*24;
	var oLength=len2+len1+len3;
	$(".page").width(oLength);
	$(".update .update_top span a").hover(function(){
		$(this).css("text-decoration","underline");
	},function(){
		$(this).css("text-decoration","none");
	});
	$(".update .update_top span").click(function(){
		$(this).find("a").addClass("abg");
		$(this).siblings().find("a").removeClass("abg");	
});	
$(".header ul li ").click(function(){
			$(this).find("a").css("background","#006abf");
			$(this).siblings().find("a").css("background","#0e97e6");		
		})
</script>
</html>