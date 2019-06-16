<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单页面</title>
<style type="text/css">
html, body {height:100%;overflow:hidden;} /*为兼容ie7,ff*/
body {font-family:Arial, Helvetica, sans-serif; font-size:12px; margin:0px; text-align:center; border-right:1px #ccc solid;}
a {color: #000; text-decoration: none;}
#menu img {_margin-top: 12px;}/*没办法,ie6对list-style-image支持不好*/
#all {width: 100%;height:100%;}
#menu {width: 96%;}
#menu ul {padding:0; margin: 0; list-style: none;}
#menu ul li {background-image:url(/OA/index/images/menu_bg.gif); background-repeat: repeat-x; background-position:center; height: 32px;;margin-top: 2px; margin-bottom: 2px; border:1px #ccc solid; line-height: 2.8;}
</style>
</head>
<body>
<div id="all">
    <div id="menu">
        <ul>
        
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/index!communication.action" target="main">通讯目录</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/schedule!schedule.action" target="main">日程安排</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/meeting!meeting.action" target="main">会议管理</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/notice!notice.action" target="main">公告管理</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/sms!sms.action" target="main">消息管理</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/worklog!worklog.action" target="main">工作日志</a></li>
            <li><img src="images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="../index/index!system.action" target="main">关于系统</a></li>
        </ul>
    </div>
</div>
</body>
</html>