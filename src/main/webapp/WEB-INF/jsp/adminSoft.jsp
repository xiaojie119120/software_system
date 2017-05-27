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
						<c:if test="${user.picLink==null }">
							<img src="${pageContext.request.contextPath }/images/head.png">
						</c:if>
						<c:if test="${user.picLink!=null }">
							<img src="${pageContext.request.contextPath }/user/head/${user.picLink }">
						</c:if>
						<div class="zhe">
						<span>更换头像</span>
					</div>
					</div>
					<p>${user.name }</p>
					
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
					<div class="action">
						<a href="${pageContext.request.contextPath }/my/dynamic/1">
							<img src="${pageContext.request.contextPath }/images/action.png" align="center">
							<span>动态</span>
						</a>
					</div>
					<div class="record" style="border-bottom:2px solid #fe8282">
						<img src="${pageContext.request.contextPath}/images/record.png" align="center">
						<span style="color:#fe8282;">软件管理</span>
					</div>
					<div class="record">
						<a href="${pageContext.request.contextPath}/user/list/1">
							<img src="${pageContext.request.contextPath}/images/users.png" align="center">
							<span>用户管理</span>
						</a>
					</div>
					<div class="add">
						<a href="${pageContext.request.contextPath}/soft/upload">
							<img src="${pageContext.request.contextPath}/images/add.png" align="center">
							<span>添加分享</span>
						</a>
					</div>
				</div>
				<div class="cen2_contain">
					<div class="share">
						<ul class="share_ul" style="height: 600px">
							<c:if test="${softCount==null }">
								<li>
									<p>网站貌似才刚刚搭建，一个软件都没有，快去分享吧！</p>
								</li>
							</c:if>
							<c:if test="${softCount!=null }">
								<li>
									<p>您是尊敬的管理员，可以操作所有软件----软件总数:<span>${softCount }</span></p>
								</li>
							</c:if>
							<c:forEach var="soft" items="${softs }">
								<li class="share_li">
									<c:if test="${user.id == soft.softUserId }">
										<a href="${pageContext.request.contextPath }/soft/details/${soft.softId }">【${soft.softName }】</a>
									</c:if>
									<c:if test="${user.id != soft.softUserId }">
										<a href="${pageContext.request.contextPath }/soft/details/${soft.softId }">${soft.softName }</a>
									</c:if>
									<div class="share_eidt">
										<a href="${pageContext.request.contextPath }/soft/edit/${soft.softId }">
											<input type="submit" name="" value="编辑" class="edit_1">
										</a>
										<form action="${pageContext.request.contextPath }/soft/delete/${soft.softId }" method="post">
											<input type="hidden" name=page value="${nowPage }">
											<input type="button" name="" value="删除" class="edit_2" onclick="del(this);">
										</form>
									</div>
								</li>
							</c:forEach>
						</ul>
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
			</div>
			<div style="clear:both;">
			</div>
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
	/*删除按钮*/
	function del(obj){
		var fm = obj.parentElement;
		layer.confirm('用户删除后无法恢复！你确定要删除吗？', {
			btn: ['删除','取消'], //按钮
			shadeClose: true}, function(){
					fm.submit();
				}, function(){
			});
	}
	var oDiv=$(".page a").length;
	var i=1;
	var len1=212;
	var len2=oDiv*5;
	var len3=(oDiv-4)*24;
	var oLength=len2+len1+len3;
	$(".page").width(oLength); 
	function showDelInfo(){
		if ("${delState}"==1){
			showTips("${delInfo}", 50, 3);
		}
	}
	$(document).ready(showDelInfo());
</script>
</html>