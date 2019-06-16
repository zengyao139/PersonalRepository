var mobile = null;
var email = null;
var qq = null;
var addBtn = null;
var backBtn = null;


$(function(){
	mobile = $("#mobile");
	email = $("#email");
	qq = $("#qq");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	//name.next().html("*");
	mobile.next().html("*");
	email.next().html("*");
	qq.next().html("*");

	/*$.ajax({
		type:"GET",//请求类型
		url:path+"/sys/getrolelist",//请求的url
		//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data != null){
				userRole.html("");
				var options = "<option value=\"0\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].roleName);
					options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
				}
				userRole.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip(userRole.next(),{"color":"red"},imgNo+" 获取用户角色列表error",false);
		}
	});*/
		

	//电话号码验证
	mobile.bind("focus",function(){
		validateTip(mobile.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).bind("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(mobile.val().match(patrn)){
			validateTip(mobile.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(mobile.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
		}
	});
	//邮箱验证
	email.bind("focus",function(){
		validateTip(email.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).bind("blur",function(){
		var patrn=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		if(email.val().match(patrn)){
			validateTip(email.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(email.next(),{"color":"red"},imgNo + " 您输入的邮箱格式不正确",false);
		}
	});
	
	//qq验证
	qq.bind("focus",function(){
		validateTip(qq.next(),{"color":"#666666"},"* 请输入qq号码",false);
	}).bind("blur",function(){
		var patrn=/^[1-9][0-9]{4,13}$/;
		if(qq.val().match(patrn)){
			validateTip(qq.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(qq.next(),{"color":"red"},imgNo + " 您输入的qq号格式不正确",false);
		}
	});
	
	
	addBtn.bind("click",function(){
		if(mobile.attr("validateStatus") != "true"){
			mobile.blur();
		}else if(qq.attr("validateStatus") != "true"){
			qq.blur();
		}else if(email.attr("validateStatus") != "true"){
			email.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.bind("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});