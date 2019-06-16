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
<title>会议管理</title>
</head>
<body style="background: #A8A8A8">
  <div class="right" >
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>会议管理>> 新增会议记录 </span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="meeting!addOk.action">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
             <%--    <input type="hidden" name="worklog.username" value="${username }"/> --%>
                 <%-- <input type="hidden" name="address.ID" value="${address.ID }"/> --%>
               <div>
                    <label for="sender">会议填写人:</label>
                   <input type="text" id="sender" name="meeting.sender"  value=""></input>
                   <font color="red"></font>
                </div>
                <div>
                    <label for="title">开始时间:</label>
                    <input type="text" name="meeting.starttime"  onclick="WdatePicker();" id="starttime" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="content">结束时间:</label>
                    <input type="text" name="meeting.endtime" id="endtime"  onclick="WdatePicker();" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="title">会议地点:</label>
                    <input type="text" name="meeting.address" id="address" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="title">会议标题:</label>
                    <input type="text" name="meeting.title" id="title" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="content">会议内容:</label>
                    <input type="text" name="meeting.content" id="content" value=""> 
					<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" style="background: #626367" >
					<input type="button" id="back" name="back" value="返回" style="background: #626367">
                </div>
            </form>
              <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
        </div>
</div>
<script type="text/javascript" src="../meeting/js/meetingadd.js"></script>
<script type="text/javascript" src="../meeting/js/WdatePicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</body>
</html>