<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="referrer" content="always" />
	<meta name="renderer" content="webkit" />
	<title>${soft.software.softName }</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index0.css">
	<link href="${pageContext.request.contextPath }/images/js_logo.png" rel="shortcut icon" />	
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
		<div class="content content-upload_1">
		<div class="content-details0">
			<div class="xtop">
				<img src="${pageContext.request.contextPath }/soft/icon/${soft.software.softIconLink }" width="55" height="55" />
				<span>${soft.software.softName }</span>
				<c:if test="${sessionScope.user.type>=2 }">
					<a href="${pageContext.request.contextPath }/soft/edit/${soft.software.softId }" style="display: inline;color: #00a5ec;float:right;margin-right: 20px;">编辑</a>
				</c:if>				
			</div>
			<div class="ftop">    
				<ul class="ul_left">
					<li>软件类型：${soft.software.groupName }</li>
					<li>更新时间：${soft.softwareExpand.softDateStr }</li>
					<li >下载量：${soft.software.softDownloadVolume }</li>
							
				</ul>
				<ul class="ul_center">
					<li>软件大小：${soft.softwareExpand.softSizeStr }</li>
					<li>操作系统：：${soft.software.softOs }</li>
					<li>分享者：${soft.software.userName }</li>	
				</ul>
				<ul class="ul_right">
					<li class="topic">
						相关软件
					</li>
					<li>暂无</li>
				</ul>
			</div>
		</div>
		<div class="content-details1">
	            <ul class="tab">
	           		<li style="border-top:2px solid #0e97e6;font-weight:bold;" id="one"><a href="###">软件介绍</a></li>
	            	<li><a href="###" id="two">软件截图</a></li>
	            	<li><a href="###" id="three">下载地址</a></li>
	        	</ul>
	            <div class="tabCon">
	                <div class="li_one">
	                	<div class="litop">
	                		<p class="litop_p">基本简介</p>
	                		<div class="xian"></div>
	                	</div>
	                	<div class="cen">
	                		<div class="duan">
	                			${soft.software.softDetails }
	                		</div>
	                	</div>
	                </div>
	            </div>
	            <div class="tab_two">
	            	<div class="li_two">
	            		<div class="litop">
	                		<p>软件截图</p>
	                	</div>
	                	<div class="jimg">
	                		<div class="btn_left">
	                			<img src="${pageContext.request.contextPath }/images/btn_left.png">
	                		</div>
	                		<ul class="btn_center">
	                			<c:forEach var="pic" items="${pics }">
	                				<li><img src="${pageContext.request.contextPath }/soft/image/${pic.picLink }"></li>
	                			</c:forEach>
	                		</ul>
	                		<div class="btn_right">
	                			<img src="${pageContext.request.contextPath }/images/btn_right.png">
	                		</div>
	                	</div>
	            	</div>
	            </div>
	            <div class="tab_three">
	            	<div class="tab_th">
	            		<div class="teng">
	            			<span>下载地址</span>
	            		</div>
	            		<ul>
	            			<li>本地下载地址</li>
	            			<li class="nobg">
	            				<c:if test="${soft.software.softFileLink=='' }">
	            					<a class="aleft">暂无</a>
	            				</c:if>
	            				<c:if test="${soft.software.softFileLink!='' }">
	            					<div class="li_icon">
		            					<a href="${pageContext.request.contextPath}/soft/download/${soft.software.softId }">
		            						<div class="tu">
		            							<img src="${pageContext.request.contextPath }/images/icon1.png">
		            						</div>
		            						<div class="wen" >本地下载</div>
		            					</a>
		            				</div>
	            				</c:if>
	            			</li>
	            			<li>网盘下载地址</li>
	            			<li class="nobg">
	            				<c:if test="${baiduLink.bdLink==null }">
	            					<a class="aleft">暂无</a>
	            				</c:if>
	            				<c:if test="${baiduLink.bdLink!=null }">
		            				<div class="li_icon">
		            					<a href="http://${baiduLink.bdLink }">
		            						<div class="tu">
		            							<img src="${pageContext.request.contextPath }/images/icon1.png">
		            						</div>
		            						<div class="wen" >百度网盘</div>
		            					</a>
		            				</div>
	            				</c:if>
	            			</li>
	            		</ul>
	            	</div>
	            </div>
	            <jsp:include page="footer.jsp" ></jsp:include>
	        </div>	
	        
		</div>
		<!--回到顶部按钮-->
		<div id="btn1">
			<div id="wp" >回到顶部</div>
			<img src="${pageContext.request.contextPath }/images/h1_03.png" id="Img" />	
		</div>	
	</div>
</body>
<script src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	window.onload=function()
	{
		var oBtn=document.getElementById('btn1');
		var oWp=document.getElementById('wp');
		var oImg=document.getElementById("Img");	
		var timer=null;
		var bSys=true;
		var isRuning = false;
		window.onscroll=function()
		{
			if(!bSys)
			{
				clearInterval(timer);
			}
			bSys=false;
		}
		oBtn.onclick=function()
		{	
			if (!isRuning){
				isRuning = true;
				timer=setInterval(function(){
					var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
					var iSpeed=Math.floor(-scrollTop/8);//取整
					if(scrollTop==0)
					{
						clearInterval(timer);
						isRuning=false;
					}
					bSys=true;
					document.documentElement.scrollTop=document.body.scrollTop=scrollTop+iSpeed;
					oImg.src="${pageContext.request.contextPath }/images/h4_03.png";	
				},2);	
			}				
		}
		oBtn.onmouseover=function()
		{
			oImg.src="${pageContext.request.contextPath }/images/h2_03.png";
		}
		oBtn.onmouseout=function()
		{
			oImg.src="${pageContext.request.contextPath }/images/h1_03.png";
		}
	}
	$(function(){
		$('.tab li').mouseover(function(){
			$(this).css('border-top','2px solid #0e97e6').siblings().css('border-top','0px');
			$(this).css('font-weight','bold').siblings().css('font-weight','normal');
		});
		$('#one').click(function(){
			$('.tabCon').show();
			$('.tab_two').show();
			$('.tab_three').show();
		});
		$('#two').click(function(){
			$('.tabCon').hide();
			$('.tab_two').show();
			$('.tab_three').show();
		});
		$('#three').click(function(){
			$('.tabCon').hide();
			$('.tab_two').hide();
			$('.tab_three').show();
		});		
	});
	/*轮播按钮*/
	var i=0;
	var len=$('.btn_center li').length-1;
	$('.jimg').hover(function(){
		$(".btn_left").css('display','block');
		$(".btn_right").css('display','block');
	},function(){
		$(".btn_left").css('display','none');
		$(".btn_right").css('display','none');
	});
	$('.btn_left').click(function(){
		i--;
		if(i<0) 
		{
			i=len;
		}
		/*图片淡入淡出*/
		$('.btn_center li').eq(i).fadeIn(300).siblings().fadeOut(300);
	});
	$('.btn_right').click(function(){
		i++;
		if(i>len)
		{
			i=0;
		} 	
		/*图片淡入淡出*/
		$('.btn_center li').eq(i).fadeIn(300).siblings().fadeOut(300);	
	})
	function auto(){
		i++;
		if(i>len)
		{
			i=0;
		} 	
		/*图片淡入淡出*/
		$('.btn_center li').eq(i).fadeIn(300).siblings().fadeOut(300);
	}
	setInterval("auto()","3000");//自动播放
	var imgL=($(".btn_center li img").height()/2);
	var imgsum=207-imgL;
	$(".btn_center li img").css({"margin-top":imgsum+"px"});
	/*回到顶部按钮*/
	$(window).scroll(function(){
		if($(window).scrollTop>300)
		{
			$("#btn1").fade
		}
	})
</script>
</html>