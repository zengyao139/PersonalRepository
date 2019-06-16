<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	    <link type="text/css" rel="stylesheet" href="css/public.css" />
	    <link type="text/css" rel="stylesheet" href="css/phone.css" />
<title>主页</title>
</head>

<frameset cols="*" rows="136, *" id="frame_main"  border="0">
    <frame src="../index/index!header.action" noresize="noresize" name="header">
    
    <frameset cols="240, *">
    	<frame src="../index/index!menu.action" name="menu" />
    	<frame src="../index/user!person.action" name="main">
    </frameset>
</frameset>

<noframes><body>
</body>
</noframes></html>