<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>消息管理</title>
 	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/public.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../sms/js/smslist.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="background: #A8A8A8">
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>消息管理</span>
            </div>
            <div class="search">
					 <a href="sms!add.action?username=${sms.username }" style="background: #626367;">发送消息</a>
            </div>
            <table class="providerTable" cellpadding="0" cellspacing="0" >
                <tr class="firstTr">
                    <th width="12%">接收者</th>
                    <th width="12%">发送者</th>
                    <th width="28%">消息内容</th>
                    <th width="18%">发送时间</th>
                    <th width="12%">是否已读</th>
                    <th width="18%">相应操作</th>
                </tr>
                   <c:forEach var="sms" items="${smsList }" varStatus="status" >
					<tr>
						<td>
							<span>${sms.username }</span>
						</td>
						
						<td>
							<span>${sms.sender }</span>
						</td>
						
						<td>
							<span>${sms.message }</span>
						</td>
						
						<td>
							<span>${sms.sendtime }</span>
						</td>
						
						<td id="read">
						<c:if test="${sms.isRead=='1' }"><span  id="read">已读</span></c:if>
							<c:if test="${sms.isRead=='0' }"><span  id="read">未读</span></c:if>
						</td>
						<td>
						<!-- 设为已读 -->
							<span><a class="modifyUser" href="javascript:;" userid=${sms.ID } username=${sms.isRead }><img src="${path}/index/images/xiugai.png" alt="设为已读" title="设为已读"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${sms.ID }  username=${sms.sender }><img src="${path}/index/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
        </div>
        <div class="zhezhao"></div>
<div class="remove" id="removeUse" style="background: 	#A9A9A9">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>
        
        
        
</body>

</html>