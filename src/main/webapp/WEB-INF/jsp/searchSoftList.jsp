<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>搜索</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index0.css">
	<link rel="shortcut icon"  href="${pageContext.request.contextPath }/images/js_logo.png">
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe wrappe-upload">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
		<ul>
			<li><a href="${pageContext.request.contextPath}/">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/new/all/1">最新分享</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
			<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
		</ul>
		</div>
		<div class="search_r">
			<div class="jg">
				<strong class="jg_top">软件搜索结果：${searchName }</strong>
				<c:if test="${softs!=null }">
					<ul>	
						<li class="list_button">
							<a href="">按人气排</a>
							<a href="">按时间排</a>
							<a href="">按好评率排</a>
							<a href="">按字母声母</a>
						</li>
						<c:forEach var="soft" items="${softs }">
							<li class="li_name">
								<strong>${soft.software.softName }</strong>
								<div class="free">
									<p class="free_2" style="margin-top:15px">
										${soft.software.softAbstract }
										<a href="${pageContext.request.contextPath}/soft/details/${soft.software.softId }">[详细简介]</a>
									</p>
								</div>
							</li>
						</c:forEach>
						
					</ul>
				</c:if>
				<c:if test="${softs==null }">
		
						<a style="font-size:14px;color:red;height:300px;width:978px;text-align:center;line-height:300px">没有找到匹配的记录!</a>
					
				</c:if>
			</div>
			<c:if test="${softs!=null }">
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
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<script  src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	var oDiv=$(".page a").length;
	var i=1;
	var len1=212;
	var len2=oDiv*5;
	var len3=(oDiv-4)*24;
	var oLength=len2+len1+len3;
	$(".page").width(oLength);
</script>
</html>