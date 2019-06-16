var mobile = null;
var email = null;
var qq = null;
var name1=null;
var addBtn = null;
var backBtn = null;
var code1=null;
$.ajaxSetup({
	  async: false
	  });

$(function(){
	mobile = $("#phone");
	name1= $("#name");
	email = $("#email");
	qq = $("#password");
	code1=$("#jbPhoneTip");
	addBtn = $("#add");
	backBtn = $("#back");
	
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	//name.next().html("*");
	mobile.next().html("*");
	email.next().html("*");
	name1.next().html("*");
	qq.next().html("*");

	//电话号码验证
	mobile.bind("focus",function(){
		validateTip(mobile.next(),{"color":"#666666"},"* 请输入联系方式",false);
	}).bind("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(mobile.val().match(patrn)){
			validateTip(mobile.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(mobile.next(),{"color":"red"},imgNo + " 格式不正确",false);
		}
	});
	//邮箱验证
	email.bind("focus",function(){
		validateTip(email.next(),{"color":"#666666"},"* 请输入邮箱",false);
	}).bind("blur",function(){
		var patrn=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
		if(email.val().match(patrn)){
			validateTip(email.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(email.next(),{"color":"red"},imgNo + " 邮箱格式不正确",false);
		}
	});
	
	//qq验证
	qq.bind("focus",function(){
		validateTip(qq.next(),{"color":"#666666"},"* 请输入密码",false);
	}).bind("blur",function(){
		var patrn=/^[a-zA-Z0-9_-]{6,14}$/;//字母。数字，下划线
		if(qq.val().match(patrn)){
			validateTip(qq.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(qq.next(),{"color":"red"},imgNo + "密码长度为6-14位",false);
		}
	});
	//用户名
	name1.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		//user.do?method=ucexist&userCode=**
		var code = name1.val();
		if(code == '' || code == null){
			validateTip(name1.next(),{"color":"red"},imgNo+ " 不能为空",false);
			return;
		}
		$.ajax({
			type:"GET",//请求类型
			url:"user!checkName.action",//请求的url
			data:{uname:code},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data == "1"){//账号已存在，错误提示
					validateTip(name1.next(),{"color":"red"},imgNo+ " 账号存在",false);
				}else{//账号可用，正确提示
					validateTip(name1.next(),{"color":"green"},imgYes,true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(name1.next(),{"color":"red"},imgNo+"error",false);
			}
		});
	}).bind("focus",function(){
		//显示友情提示
		validateTip(name1.next(),{"color":"#666666"},"*",false);
	}).focus();
	
	
	
	
	
	
	
	
	addBtn.bind("click",function(){
		var com=doCompare();
		/*alert(com);*/
		if(mobile.attr("validateStatus") != "true"){
			mobile.blur();
		}else if(qq.attr("validateStatus") != "true"){
			qq.blur();
		}else if(email.attr("validateStatus") != "true"){
			email.blur();
		}else if(name1.attr("validateStatus") != "true"){
			name1.blur();
		}else if(com!=1){
			if(com==2){
				$("#jbPhoneTip").html("<font color='red'>验证码失效，重新获取</font>");
			}else {
				$("#jbPhoneTip").html("<font color='red'>验证码错误</font>");
			}
		}else{
			if(confirm("是否确认提交数据")){
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.bind("click",function(){
		/*if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}*/
		history.back(-1);
	});
});