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
	   <script type="text/javascript" src="../notice/js/jquery-1.8.3.min.js"></script>
<title>通讯管理</title>
</head>
<body style="background: #A8A8A8">
  <div class="right" >
        <div style="margin-left: 20%;margin-top: 5%;">
            <strong>你现在所在的位置是:</strong>
            <span>用户注册</span>
        </div>
        <div class="providerAdd" style="width: 60%;height: 60% ; margin: 0 auto; margin-top: 10px;">
        
            <form id="userForm" name="userForm" method="post" action="user!addOk.action">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <%-- <input type="hidden" name="address.username" value="${username }"/> --%>
                <div>
                    <label for="username">用户名称:</label>
                    <input type="text" name="user.username" id="name" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div> 
                <div>
                    <label for="password">用户密码:</label>
                    <input type="password" name="user.password" id="password" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="email">电子邮箱:</label>
                    <input type="text" name="user.email" id="email" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">电话号码:</label>
                    <input type="text"  name="user.phone" id="phone" value=""> 
					
					<font color="red"></font>
                </div>
                 	
                	
                
                <div>
                    <label for="code">验证码:</label>
                    <input type="text" style="width: 140px;" name="code" id="code" value=""> 
					<input type="button" style="width: 120px;" name="btnSendCode" id="btnSendCode"  onclick="sendMessage();" value="获取验证码"></input>
					<span></span>
						<br/><br/>	&nbsp &nbsp &nbsp;<strong style="margin-left:24%; text-align: center;" ><span id="jbPhoneTip" ></span></strong>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" style="background: #626367" >
					<input type="button" id="back" name="back" value="返回" style="background: #626367">
                </div>
            </form>
              <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
        </div>
</div>
 <script type="text/javascript" src="../user/js/register.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="../user/js/code.js"></script>
<!-- <script type="text/javascript" src="../address/js/common.js"></script>
 -->
</body>
</html>