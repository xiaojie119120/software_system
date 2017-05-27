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
					<div class="record">
						<a href="${pageContext.request.contextPath }/my/soft/1">
							<img src="${pageContext.request.contextPath}/images/record.png" align="center">
							<span>软件管理</span>
						</a>
					</div>
					<div class="record" style="border-bottom:2px solid #fe8282">
						<img src="${pageContext.request.contextPath}/images/users.png" align="center">
						<span style="color:#fe8282;">用户管理</span>
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
							<li>
								<p>当前注册用户总数:<span>${userCount }</span></p>
							</li>
							<c:forEach var="uss" items="${shows }">
								<li class="share_li">
									<a href="javascript:void()" onclick="edit('${uss.user.id}');">[${uss.userExpand.userTypeStr }]${uss.user.name }</a>
									<div class="share_eidt">
										<a>
											<input type="submit" name="" value="编辑" class="edit_1" onclick="edit('${uss.user.id}');">
										</a>
										<form action="${pageContext.request.contextPath }/user/delete" method="post">
											<input type="hidden" name="id" value="${uss.user.id }">
											<input type="hidden" name="page" value="${nowPage }">
											<input type="button" name="" value="删除" class="edit_2" onclick="del(this);">
										</form>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<c:if test="${shows!=null }">
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
	/*编辑按钮*/
	function edit(id){
	  layer.open({
		  type: 2,
		  shadeClose: true,//点击遮罩关闭层
  		  shade: 0.8,
  		  move: false,
		  title: '编辑',
		  area: ['400px', '600px'], //宽高
		  content: ['${pageContext.request.contextPath}/user/edit/'+id,'no'],
		  resize: false
		});	
	}
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