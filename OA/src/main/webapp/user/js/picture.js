/*$(function(){
	var index = 0 ;
	var imglength =4;
	var width1=$("#div").css("width");
	var window1=$(window).width()
	var width_n=parseInt(width1);
	var window_n=parseInt(window1);
	var width=(width_n*window_n)/100;
	alert("width1="+width1+",widown1="+window1+",width_n="+width_n+",window_n="+window_n+",width="+width);
	
	
	$(".imgindex").eq(index).css("background","green");
	$.each($(".adpic"),function(i,n){
		$(n).css("left",435*i+"px");
	})
	setInterval(function(){
		$.each($(".adpic"),function(i,n){
			$(n).animate({"left":parseInt($(n).css("left"))-435+"px"},1000,function(){
				//当动画执行完成后执行的功能
				if(i==0){
					var $newimg = $(n).clone();
					$(n).remove();
					$newimg.css("left",870);
					$("#addiv").append($newimg);
				}
			});
		})
		index++;
		if(index>imglength-1){
			index=0;
		}
		$(".imgindex").css("background","red");
		$(".imgindex").eq(index).css("background","green");
		//$(".imgindex").eq(index).css("background","green");
	},3000);
})
*/

















$(function(){
	var index = 0 ;
	var imglength =4;
	var width1=$("#addiv").css("width");
	var x=parseInt(width1);
	$(".imgindex").eq(index).attr('src','/OA/user/image/dot2.png');
	$.each($(".adpic"),function(i,n){
		$(n).css("left",x*i+"px");
	})
	setInterval(function(){
		$.each($(".adpic"),function(i,n){
			$(n).animate({"left":parseInt($(n).css("left"))-x+"px"},1000,function(){
				//当动画执行完成后执行的功能
				if(i==0){
					var $newimg = $(n).clone();
					$(n).remove();
					$newimg.css("left",(x*2)+"px");
					$("#addiv").append($newimg);
				}
			});
		})
		index++;
		if(index>imglength-1){
			index=0;
		}
		$(".imgindex").attr('src','/OA/user/image/dot1.png');
		$(".imgindex").eq(index).attr('src','/OA/user/image/dot2.png');
		//$(".imgindex").eq(index).css("background","green");
	},3000);
})















