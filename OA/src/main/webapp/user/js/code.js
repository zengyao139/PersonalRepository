 var InterValObj; //timer变量，控制时间
    var count = 59; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    $.ajaxSetup({
    	  async: false
    	  });
    
    function sendMessage() {
    	 phone=$("#phone").val();
    	if(mobile.attr("validateStatus") != "true"){
		  	 alert("请正确输入手机号！");
		}else{
	    	curCount = count;
	  	  // 设置button效果，开始计时
		    document.getElementById("btnSendCode").setAttribute("disabled","true" );//设置按钮为禁用状态
		    document.getElementById("btnSendCode").value= curCount + "秒后再次获取";//更改按钮文字
		    InterValObj = window.setInterval("SetRemainTime()", 1000); // 启动计时器timer处理函数，1秒执行一次
		    // 向后台发送处理数据
	    $.ajax({
		    type: "get", // 用POST方式传输
		    dataType: "json", // 数据格式:JSON
		    async: false,
		    url: "user!code.action", // 目标地址
		    data: "phone="+phone,
		    success: function (data){ 
		    if(data == "1"){
			    $("#jbPhoneTip").html("<font color='#339933'>      短信验证码已发到您的手机,请查收</font>");
			                    }else if(data == "0"){
			    $("#jbPhoneTip").html("<font color='red'>   短信验证码发送失败，请重新发送</font>");
			    }
		    }
	    });
    }//if else 
  }
    
    
    function SetRemainTime() {
		if (curCount == 0) {                
			window.clearInterval(InterValObj);// 停止计时器
			document.getElementById("btnSendCode").removeAttribute("disabled");//移除禁用状态改为可用
			document.getElementById("btnSendCode").value="重新发送";
		}else {
			curCount--;
			document.getElementById("btnSendCode").value=curCount + "秒后再次获取";
			}
	}
    

  //验证短信验证码
    function doCompare(){
    	var x=0;
	   var codelast = document.getElementById("code").value;//获取输入的验证码
	   if(codelast == null || codelast == ''){
		  	 alert("验证码不能为空！");
		   }else{
		   $.ajax({
		   type: "get", // 用POST方式传输
		   anysc: false,
		   dataType: "json", // 数据格式:JSON
		   url: "user!compare.action", // 目标地址
		   data: "code="+codelast,
		   success: function (data){ 
			   /*alert(data);*/
			   if(data == 1){
				   $("#jbPhoneTip").html("<font color='#339933'>短信验证码验证成功</font>");
				  /* alert("1----");*/
				   		x=1;
			        }else if(data == 0){
			   			$("#jbPhoneTip").html("<font color='red'>×短信验证码不正确请重新输入</font>");
			   			/*alert("00-----")*/
			   			x=0;
			   		}else if(data ==2){
			   			$("#jbPhoneTip").html("<font color='red'>×验证码已失效请重新获取验证码</font>");
			   			/*alert("2----");*/
			   			//$("#jdPhoneTip").prev().attr("validateStatus",false);
			   			x=2;
			   		}
			   }
	   	});
        }
	   return x;
   }
    
    
