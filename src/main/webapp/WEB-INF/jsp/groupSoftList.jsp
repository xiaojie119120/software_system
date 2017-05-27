<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>${groupName }</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index0.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/js_logo.png">
</head>
<body>
	<jsp:include page="top_info.jsp"></jsp:include>
	<div class="wrappe">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="header">
		<ul>
			<li><a href="${pageContext.request.contextPath}/">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">装机必备</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/new/all/1">最新分享</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/downVolume/1">下载排行</a></li>
			<li class="header-li1"><a href="${pageContext.request.contextPath}/soft/group">软件分类</a></li>
			<li><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
			<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
			<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>			
			
		</ul>
		</div>
		<div class="classify">
			<div class="class_a">
				<c:forEach var="group" items="${groups }">
					<c:if test="${group.groupId==gid }">
						<a style="background: #006abf;">${group.groupName }</a>
					</c:if>
					<c:if test="${group.groupId!=gid }">
						<a href="${pageContext.request.contextPath}/soft/group/${group.groupId }/1">${group.groupName }</a>
					</c:if>	
				</c:forEach>
			</div>
			<ul>
				<li class="list_button">
				</li>
				<c:if test="${softs==null }">
					<a style="font-size:14px;color:red;height:650px;width:978px;text-align:center;line-height:300px">该分类没有软件记录!</a>
				</c:if>
				<c:if test="${softs!=null }">
					<c:forEach var="soft" items="${softs }">
						<li>
							<a href="${pageContext.request.contextPath}/soft/details/${soft.software.softId }">
								<div class="class_img">
									<img src="${pageContext.request.contextPath}/soft/icon/${soft.software.softIconLink }">
								</div>
								<div class="class_word">
									<h3 style="margin-bottom:8px">${soft.software.softName }</h3>
									<p>
										${soft.software.softAbstract }
									</p>
								</div>	
								<div class="class_load">
									<a href="${pageContext.request.contextPath}/soft/download/${soft.software.softId }">
										安全下载
									</a>
								</div>	
							</a>
						</li>
					</c:forEach>
				</c:if>	
			</ul>
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
	var len1=212;
	var len2=oDiv*5;
	var len3=(oDiv-4)*24;
	var oLength=len2+len1+len3;
	$(".page").width(oLength);
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
</html>