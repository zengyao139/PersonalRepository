var mobile = null;
var email = null;
var qq = null;
var addBtn = null;
var backBtn = null;


$(function(){
	mobile = $("#sender");
	email = $("#title");
	qq = $("#content");
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
		

	//年份验证
	qq.bind("focus",function(){
		validateTip(qq.next(),{"color":"#666666"},"* 请输入公告内容",false);
	}).bind("blur",function(){
		if(qq.val()!=""){
			validateTip(qq.next(),{"color":"green"},imgYes,true);
		}
	});

	mobile.bind("focus",function(){
		validateTip(mobile.next(),{"color":"#666666"},"* 请输入填写人",false);
	}).bind("blur",function(){
		if(mobile.val()!=""){
			validateTip(mobile.next(),{"color":"green"},imgYes,true);
		}
	});
	email.bind("focus",function(){
		validateTip(email.next(),{"color":"#666666"},"* 请输入公告标题",false);
	}).bind("blur",function(){
		if(email.val()!=""){
			validateTip(email.next(),{"color":"green"},imgYes,true);
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