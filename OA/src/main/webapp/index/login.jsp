<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人通讯管理系统</title>
<style type="text/css">
#all {margin-left:auto; margin-right:auto; text-align: center;width: 540px;}
body {text-align:center;}
#main {background:url(images/login_mid.gif); height:240px; text-align:center;}
#title {height:66px;margin-top: 120px;}
#login { margin-top: 32px; width: 420px; margin-left: auto; margin-right:auto;}
#btm_left {background:url(images/login_btm_left.gif) no-repeat; width:21px; float:left;}
#btm_mid {background:url(images/login_btm_mid.gif); width:498px; float:left;}
#btm_right {background:url(images/login_btm_right.gif) no-repeat; width:21px; float:left;}
</style>
<script type="text/javascript" >
function reset_form()
{
	document.getElementById('username').value = '';
	document.getElementById('password').value = '';
	return false;
}
					 
</script>
</head>

<body >
<div id="all">
    <div id="title"><img src="images/login_title.gif" /></div>
    <div id="main" >
    	<form action="user!login.action" method="post" id="login_form">
        <table id="login" style="margin-top: 2px;">
        	<tr>
            	<td>用户名:  </td>
                <td><input type="text" name="user.username" id="username" size="32" style="background:url(images/username_bg.gif) left no-repeat #FFF; border:1px #ccc solid;height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
          <tr><td></td><td></td></tr> 
            <tr><td></td><td></td></tr>
            <tr>
            	<td>密 码：</td>
                <td><input type="password" name="user.password" id="password" size="32" style="background:url(images/password_bg.gif) left no-repeat #FFF; border: 1px #ccc solid; height: 20px; font-family:Arial, Helvetica, sans-serif; font-size:14px; font-weight: 800; margin:0; padding-left: 24px;" /></td>
            </tr>
            <tr>
            	<td></td>
            	<br></br>
            	<td style="text-align: left; padding-top: 32px;">
                	<input type="image" style="border-radius: 5px; margin-left: 17px;" src="images/login.gif" name="submit" onclick="javascript:document.getElementById('login_form').submit();" />&nbsp;&nbsp;&nbsp;
                    <input type="image" style="border-radius: 5px;" src="images/cancel.gif" name="cancel" onclick="reset_form();" />
                   	<a href="../index/user!register.action" style="float:right;margin:8px;color:	#696969;">没有账户? 点击注册</a><br/>
                   	<a href="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2019053065366819&scope=auth_user&redirect_uri=http://114.115.130.90:8080/OA/index/index!frame.action">支付宝登录</a>
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div id="btm">
        <div id="btm_left"></div>
        <div id="btm_mid"></div>
        <div id="btm_right"></div>
    </div>
</div>
</body>
</html>