var year = null;
var plan=null;
var addBtn = null;
var backBtn = null;


$(function(){
	year = $("#year");
	plan=$("#plan");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	//name.next().html("*");
	plan.next().html("*");
	year.next().html("*");

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
	//计划安排
	plan.bind("focus",function(){
		validateTip(plan.next(),{"color":"#666666"},"* 请输入计划安排",false);
	}).bind("blur",function(){
		if(plan.val()!=""){
			validateTip(plan.next(),{"color":"green"},imgYes,true);
		}
	});
	
	//年份验证
	year.bind("focus",function(){
		validateTip(year.next(),{"color":"#666666"},"* 请输入具体日程",false);
	}).bind("blur",function(){
		if(year.val()!=""){
			validateTip(year.next(),{"color":"green"},imgYes,true);
		}
	});
	
	
	
	
	addBtn.bind("click",function(){
		if(plan.attr("validateStatus") != "true"){
			plan.blur();
		}else if(year.attr("validateStatus") != "true"){
			year.blur();
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