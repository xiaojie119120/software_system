function getStyle(obj,name)
{
	if(obj.currentStyle)
	{
		return obj.currentStyle[name]
	}
	else
	{
		return getComputedStyle(obj,false)[name]
	}
}
function getByClass(oParent,nClass)
{
	var eLe = oParent.getElementsByTagName('*');
	var aRrent  = [];
	for(var i=0; i<eLe.length; i++)
	{
		if(eLe[i].className == nClass)
		{
			aRrent.push(eLe[i]);
		}
	}
	return aRrent;
}

function startMove(obj,att,add)
{
	clearInterval(obj.timer)
	obj.timer = setInterval(function(){
	   var cutt = 0 ;
	   if(att=='opacity')
	   {
		   cutt = Math.round(parseFloat(getStyle(obj,att)));
	   }
	   else
	   {
		   cutt = Math.round(parseInt(getStyle(obj,att)));
	   }
	   var speed = (add-cutt)/4;
	   speed = speed>0?Math.ceil(speed):Math.floor(speed);
	   if(cutt==add)
	   {
		   clearInterval(obj.timer)
	   }
	   else
	   {
		   if(att=='opacity')
		   {
			   obj.style.opacity = (cutt+speed)/100;
			   obj.style.filter = 'alpha(opacity:'+(cutt+speed)+')';
		   }
		   else
		   {
			   obj.style[att] = cutt+speed+'px';
		   }
	   }
	   
	},30)
}

  window.onload = function()
  {
	  var oDiv = document.getElementById('playBox');
	  var oPre = getByClass(oDiv,'pre')[0];
	  var oNext = getByClass(oDiv,'next')[0];
	  var oUlBig = getByClass(oDiv,'oUlplay')[0];
	  var aBigLi = oUlBig.getElementsByTagName('li');
	  var oDivSmall = getByClass(oDiv,'smalltitle')[0]
	  var aLiSmall = oDivSmall.getElementsByTagName('li');
	  
	  function tab()
	  {
	     for(var i=0; i<aLiSmall.length; i++)
	     {
		    aLiSmall[i].className = '';
	     }
	     aLiSmall[now].className = 'thistitle'
	     startMove(oUlBig,'left',-(now*aBigLi[0].offsetWidth))
	  }
	  var now = 0;
	  for(var i=0; i<aLiSmall.length; i++)
	  {
		  aLiSmall[i].index = i;
		  aLiSmall[i].onclick = function()
		  {
			  now = this.index;
			  tab();
		  }
	 }
	  oPre.onclick = function()
	  {
		  now--
		  if(now ==-1)
		  {
			  now = aBigLi.length;
		  }
		   tab();
	  }
	   oNext.onclick = function()
	  {
		   now++
		  if(now ==aBigLi.length)
		  {
			  now = 0;
		  }
		  tab();
	  }
	  var timer = setInterval(oNext.onclick,3000) 
	  oDiv.onmouseover = function()
	  {
		  clearInterval(timer)
	  }
	   oDiv.onmouseout = function()
	  {
		  timer = setInterval(oNext.onclick,3000) 
	  }
  };
$(document).ready(function(e) {
        $(".tab li").click(function(){
			$(".tab li").eq($(this).index()).addClass("visit").siblings().removeClass("visit");
			$(".tabCon div ").hide().eq($(this).index()).show();
		})
    });
$(function(){
	$("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
	$("input[type=file]").each(function(){
	if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("No file selected...");}
	});
});
//Created by lx on 2016/11/15.
var oCHCK = function () {
    var chxm = false;
    var chQQ = false;
    var chphone = false;
    var chMail = false;
    var oCheck = document.getElementById('ocheck');    //父级IDIdName  oChxm
    function getByClass(o, s)//获取Class;
    {
        var aEle = document.getElementsByTagName('*');
        var arr = [];
        for (var i = 0; i < aEle.length; i++) {
            if (aEle[i].className == s) {
                arr.push(aEle[i])
            }
        }
        return arr;
    }
//邮箱校验
    function oChmail() {
        var oChmail = getByClass(oCheck, 'oChmail')[0];
        var reMail = /^\w+@[a-z0-9]+\.[a-z]+$/i;
        oChmail.onkeyup = function () {
            if (this.value.length >= 30) {
                this.value = this.value.substr(0, 30)
            }
            if (reMail.test(this.value)) {
                this.nextSibling.innerHTML = '输入正确';
                this.nextSibling.className = '';
                this.nextSibling.className = 'ingreen';
                chMail = true;
                return;
            } else {
                this.nextSibling.innerHTML = '请输入正确的邮箱';
                this.nextSibling.className = '';
                this.nextSibling.className = 'inred';
                chMail = false;
                return;
            }

        }
    }

    oChmail();
    var oCheckSbumit = getByClass(window, 'oCheckSbumit')[0];
    oCheckSbumit.onclick = function () {
        oCheckSbumit1();
    };
    function oCheckSbumit1() {
        var chckevalue = false; 
        if (chMail == true) {
            chckevalue = true;
        } else {
            alert('请输入邮箱');
            return false;
        }
        if (chckevalue == true) {
            alert('提交成功');
            window.location.href='http://www.baidu.com';
        } else {
            alert('失败');
            return chckevalue;
        }
    }

    window.onkeyup = function () {
        console.log('检查是否通过验证:\n'+ '邮箱' + chMail)
    }
};
oCHCK();
  function fileChange(e) {
     var fileSize = 0;   
     var  isIE;     
     if (isIE && !e.files) {     
       var filePath = e.value;     
       var fileSystem = new ActiveXObject("Scripting.FileSystemObject");        
       var file = fileSystem.GetFile (filePath);     
       fileSize = file.Size;    
     } else {    
      fileSize = e.files[0].size;     
      }   
      var size = fileSize / 1024;    
      if(size>2000){  
       alert("附件不能大于2M");
       e.value="";
       return
      }
      var name=e.value;
      var fileName = name.substring(name.lastIndexOf(".")+1).toLowerCase();
      if(fileName !="zip" && fileName !="rar"){
          alert("请选择zip或者rar格式文件上传！");
          e.value="";
          return
      }
    } ;

     function changeCss(obj){ 
var alist = document.getElementsByTagName("a"); 
for(var i =0;i < alist.Length;i++){ 
alist[i].style.color = "#000"; //给所有a标签赋原色 
alist[i].style.backgroundColor =Red;
} 
{obj.style.color = "red";
alist[i].style.backgroundColor =Red;
}
 //令当前标签高亮 
} ;