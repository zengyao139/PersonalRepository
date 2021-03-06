var userObj;



//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
	$.ajax({
		type:"GET",
		url:"sms!deleteAdd.action",
		data:{uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data == "1"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data == "2"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除对应消息失败");
			}else if(data == "0"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，对应消息不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除对应消息失败");
		}
	});
}
//设为已读
function modifyUser(obj){
	var read=$("#read");
	$.ajax({
		type:"GET",
		url:"sms!modify.action",
		data:{uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data == "1"){
				obj.parents("tr").find("#read").text("已读");
			}else if(data == "2"){
				alert("设置失败")
			}else if(data == "0"){
				alert("不存在该短信！")
			}
		},
		error:function(data){
			alert("error");
		}
	});
}


function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteUser(userObj);
	});

	$(".deleteUser").on("click",function(){
		userObj = $(this);
		changeDLGContent("你确定要删除对应消息吗？");
		openYesOrNoDLG();
	});
	
	$(".modifyUser").on("click",function(){
		userObj = $(this);
		if((userObj.attr("username")=="0"))
			modifyUser(userObj);
	});
	
});