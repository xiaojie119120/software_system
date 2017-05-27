	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
		<meta name="referrer" content="always" />
		<meta name="renderer" content="webkit" />
		<title>分享软件</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index0.css">
		<link href="${pageContext.request.contextPath }/images/js_logo.png" rel="shortcut icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor/kindeditor.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor/plugins/code/prettify.js"></script>
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
				<li class="header-li1"><a href="${pageContext.request.contextPath}/soft/upload">分享软件</a></li>
				<li><a href="${pageContext.request.contextPath}/info/achieve">软件资讯</a></li>
				<li><a href="${pageContext.request.contextPath}/about">关于我们</a></li>
				
			</ul>
			</div>
			<div class="content content-upload">
				<p class="fabu">欢迎您分享一个好用的软件</p>
				<form action="uploadExecution" method="post" enctype="multipart/form-data" name="con-upload" id="ocheck" onsubmit="return fs()">
				<ul>
				<li>
					<div class="name">
						软件名:<input type="text"  id="softName" name="softName"></div>
					<div class="window">
						操作系统:
						<select name="softOs">
							<option value="Windows">Windows</option>
							<option value="Unix">Unix</option>
							<option value="Linux">Linux</option>
							<option value="Mac">Mac</option>
						</select>
					</div>	
						<div class="details" style="height:580px">
						软件详细:
						<textarea class="softmg1" id="softmg1" name="softDetails"></textarea>
						
					</div>
					<div class="import">
						软件摘要:
						<textarea id="softmg2" name="softAbstract"></textarea>
					</div>
					<div class="size_ts">
						上传:
						<div class="baidu_upload">
							<input type="text" class="baidu_link" id="baidu_link" name="baiduLink" placeholder="请输入百度网盘地址" disabled="disabled">
						</div>
						<div class="baidu_select">
		        			<p>使用百度网盘<input type="checkbox" value="百度网盘" class="select" id="baidu_select"></p>
		        		</div>
		       	 	</div>
					</li></ul>
					<div class="rar">
						<input type="file" name="icon" onchange="PreviewImage(this)" id="fileInput2" accept="image/*"/>
						<p class="ti">图标</p>
						<div class='lx'>
							<select name="softGroupId" id="softGroup">
								<option value="-1">未分类</option>
								<c:forEach var="group" items="${groups }">
									<option value="${group.groupId }">${group.groupName }</option>
								</c:forEach>
							</select>
							<p class="ti">选择软件类型</p>
						</div>
						<div style="font-size:12px;color:#0e97e6;margin-left:150px">
			            	<input type="file" name="file" style="outline:none;border:none;" id="fileInput1"/>
							<p>选择上传的软件</p>
			        	</div> 
			        	<div class="edit_ts"><p>暂不支持上传超过100M的软件</p></div>
		        </div>
		        
				<input type="submit" class="sub">
				</form>
				
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</body>
		<script  src="${pageContext.request.contextPath }/js/jquery-3.1.0.min.js"></script>
		<script type="text/javascript">
		var isSel = false;
		$('#baidu_select').click(function(){
			var link = document.getElementById('baidu_link');
			var fi1 = document.getElementById('fileInput1');
			var isBaidu = document.getElementById('baidu_select').checked;
			if (isSel){
				link.disabled = true;
			}else{
				link.disabled = false;		
			}
			fi1.disabled = isBaidu;
			isSel = isBaidu;	
		});
		//上传图片js判断	
		function PreviewImage(imgFile){
			var pattern=/(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
			var Imgk=imgFile.value;
			if(Imgk!=null&&Imgk.trim()!=""&&!pattern.test(Imgk.toLowerCase())){
				alert("系统只支持jpg/jpeg/png/gif/bmp格式的照片！");
				imgFile.value=null;
				Imgk=0;
				return false;
			}
		}
		KindEditor.ready(function(K) {
				var editor1 = K.create('textarea[name="softDetails"]', {
					cssPath : '${pageContext.request.contextPath }/js/kindeditor/plugins/code/prettify.css',
					uploadJson : '${pageContext.request.contextPath }/soft/upload_json',height:"565px",width:"650px",
					fileManagerJson : '',
					allowFileManager : true,
					afterCreate : function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
							document.forms['example'].submit();
						});
					}			
				});
				prettyPrint();
			});
		//表单提交判断
		function fs(){
			var oName=document.getElementById('softName').value;
			var oSoft1=document.getElementById('softmg1').value;
			var oSoft2=document.getElementById('softmg2').value;
			var oInput1=document.getElementById('fileInput1').value;
			var oInput2=document.getElementById('fileInput2').value;
			var softGroup=document.getElementById('softGroup').value;
			var baiduLink = document.getElementById('baidu_link').value;
			var isBaidu = document.getElementById('baidu_select').checked;
			var ss=true;
			if(oName.trim()=="")
			{
				alert("软件名不能留空！");
				ss=false; 
				return ss;
			}
			else if(oName.trim().length>50)
			{
				alert('软件名长度不能超过50个字符！');
				ss=false;
				return ss;
			}
			else if(oName.trim().length<4)
			{
				alert('软件名长度不能少于4个字符！');
				ss=false;
				return ss;
			}
			else if(softGroup==-1)
			{
				alert("软件分类不能留空！");
				ss=false; 
				return ss;
			}
			else if(!isBaidu && oInput1=="")
			{
				alert("你还没有选择要上传的软件");
				ss=false;
				return ss;
			}else if(isBaidu && baiduLink=="")
			{
				alert("你还没有输入百度网盘地址");
				ss=false;
				return ss;
			}
			else if(oInput2=="")
			{
				alert("你还没有选择要上传的图标");
				ss=false;
				return ss;
			}
				return ss;
		}
		function init(){
			var select = document.getElementById('baidu_select');
			select.checked=false;
		}
		$(".header ul li ").click(function(){
				$(this).find("a").css("background","#006abf");
				$(this).siblings().find("a").css("background","#0e97e6");		
			})
		$(document).ready(init());
	</script>
	</html>