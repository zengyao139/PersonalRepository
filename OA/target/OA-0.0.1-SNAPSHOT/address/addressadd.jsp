<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	    <link type="text/css" rel="stylesheet" href="css/public.css" />
	    <link type="text/css" rel="stylesheet" href="css/phone.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>通讯管理</title>
</head>
<body style="background: #A8A8A8">
  <div class="right" >
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>通讯管理 >> 联系人添加</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="index!addOk.action">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="address.username" value="${username }"/>
                <div>
                    <label for="name">好友名称：</label>
                    <input type="text" name="address.name" id="name" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="mobile">电话号码：</label>
                    <input type="text" name="address.mobile" id="mobile" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="email">电子邮箱</label>
                    <input type="text" name="address.email" id="email" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="qq">QQ号码</label>
                    <input type="text" name="address.qq" id="qq" value=""> 
					<font color="red"></font>
                </div>
                
                <div>
                    <label for="company">所在公司</label>
                    <input type="text" name="address.company" id="company" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">所居地址：</label>
                    <input type="text" name="address.address" id="address" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="postcode">邮政编码</label>
                   <input name="address.postcode" id="postcode"  value="">
                </div>
                <div>
                    <label for="sex" >好友属性：</label>
					<select name="address.sex" id="sex">
					    <option value="男" selected="selected">男性</option>
					    <option value="女">女性</option>
					 </select>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" style="background: #626367" >
					<input type="button" id="back" name="back" value="返回" style="background: #626367">
                </div>
            </form>
              <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
        </div>
</div>
<script type="text/javascript" src="../address/js/addressadd.js"></script>
<script type="text/javascript" src="../address/js/common.js"></script>

</body>
</html>