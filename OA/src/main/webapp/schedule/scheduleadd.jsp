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
<title>日程安排</title>
</head>
<body style="background: #A8A8A8">
  <div class="right" >
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>日程安排 >> 新增日程安排</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="schedule!addOk.action">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="username" value="${user }"/>
                <div>
                    <label for="year">日程年份：</label>
                   <input type="text" id="year" name="year"  onclick="WdatePicker();"></input>
                   <font color="red"></font>
                </div>
                 <div>
                    <label for="plan">安排内容：</label>
                    <input type="text" name="plan" id="plan" value=""> 
					<!-- 放置提示信息 -->
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
<script type="text/javascript" src="../schedule/js/scheduleadd.js"></script>
<script type="text/javascript" src="../schedule/js/WdatePicker.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</body>
</html>