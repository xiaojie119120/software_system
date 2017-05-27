<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="top_bk">
		<div class="top0">
			<div class="con_top">
				<a href="${pageContext.request.contextPath }/"><img src="${pageContext.request.contextPath }/images/logo.png" class="img_logo"></a>
			</div>
			<div class="search">
				<form action="${pageContext.request.contextPath}/soft/search/1" id="findForm" method="post">
					<div class="button">
						<input type="text" name="sname" class="text" placeholder="请输入相关的软件名" />
					</div>
					<a href="javascript:void(0);" class="find" onclick="findSubmit();">搜索</a>
				</form>
			</div>
			<c:if test="${sessionScope.user != null }">
				<div class="cen_xl">
					<a class="xl_tou" href="${pageContext.request.contextPath}/my/home">
						<c:if test="${sessionScope.user.picLink!=null }">
							<img src="${pageContext.request.contextPath }/user/head/${sessionScope.user.picLink }" class="xl_head">
						</c:if>
						<c:if test="${sessionScope.user.picLink==null }">
							<img src="${pageContext.request.contextPath }/images/head.png" class="xl_head">
						</c:if>
					</a>
					<img src="${pageContext.request.contextPath }/images/xl.png" class="xl_tu">
					<div class="xl_k">
						<dl>
							<dd>
								<a href="${pageContext.request.contextPath }/my/home">
									<img src="${pageContext.request.contextPath }/images/p_top1.png" align="center">
									<span>个人主页</span>
								</a>
							</dd>
							<dd>
								<a href="${pageContext.request.contextPath }/my/edit">
									<img src="${pageContext.request.contextPath }/images/p_top2.png" align="center">
									<span>修改资料</span>
								</a>
							</dd>
							<dd>
								<a href="${pageContext.request.contextPath}/logout">
									<img src="${pageContext.request.contextPath }/images/exit.png" align="center">
									<span>退出</span>
								</a>
							</dd>
						</dl>
					</div>
				</div>
			</c:if>		
			<c:if test="${sessionScope.user == null }">
				<div class="login_reg">
					<a href="${pageContext.request.contextPath}/register" style="color: #666;margin-top: 13px;">注册</a>
					<a style="color: #666;margin-top: 13px;position: relative;">|</a>
					<a href="${pageContext.request.contextPath}/login" style="color: #666;margin-top: 13px;position: relative;">登录</a>
				</div>
			</c:if>
		</div>
	</div>
<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>	
<script type="text/javascript">
    $(".cen_xl").hover(function(){
		$(".xl_k").show();
	},function(){
		$(".xl_k").hide();
	})
	function findSubmit()//第二种提交方式，用普通button按钮结合JavaScript提交
    {
        var form1=document.getElementById("findForm");          //设置提交路径
        form1.submit();                            //提交
    }
</script>	

</body>
</html>
