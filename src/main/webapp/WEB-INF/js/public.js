//contetn为要显示的内容  
//height为离窗口顶部的距离  
//time为多少秒后关闭的时间，单位为秒  
function showTips( content, height, time ){  
    //窗口的宽度  
  var windowWidth  = $(window).width();  
  var tipsDiv = '<div class="tipsClass">' + content + '</div>';  
   
  $( 'body' ).append( tipsDiv );  
  $( 'div.tipsClass' ).css({  
      'top'       : height + 'px',  
      'left'      : ( windowWidth / 2 ) - 980/2 + 'px',  
      'position'  : 'fixed',  
      'padding'   : '3px 5px',  
      'background': '#0e97e6',  
      'font-size' : 12 + 'px',  
      'margin'    : '0 auto',  
      'text-align': 'center',  
      'width'     : '970px',  
      'height'    : 'auto',  
      'color'     : '#fff',  
      'opacity'   : '0.8', 
      'z-index'   : '999'
  }).show();  
  setTimeout( function(){$( 'div.tipsClass' ).fadeOut();}, ( time * 1000 ) );  
}  
function showSetHead(){
	layer.open({
	  type: 2,
	  shadeClose: true,//点击遮罩关闭层
	  shade: 0.8,
	  move: false,
	  title: '更换头像',
	  area: ['260px', '380px'], //宽高
	  content: ['/my/editHead','no'],
	  resize: false
	});	
}