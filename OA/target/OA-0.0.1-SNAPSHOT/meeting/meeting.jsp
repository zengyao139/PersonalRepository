<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会议管理</title>
 	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/public.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../meeting/js/meetinglist.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="background: #A8A8A8">
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>会议管理</span>
            </div>
            <div class="search">
					 <a href="meeting!add.action?username=${username }" style="background: #626367;">新增公告</a>
            </div>
            <table class="providerTable" cellpadding="0" cellspacing="0" >
                <tr class="firstTr">
                    <th width="13%">会议填写人</th>
                    <th width="13%">会议开始时间</th>
                    <th width="13%">会议结束时间</th>
                    <th width="13%">会议地点</th>
                    <th width="13%">会议标题</th>
                    <th width="20%">会议内容</th>
                    <th width="15%">相应操作</th>
                </tr>
                   <c:forEach var="meeting" items="${meetingList }" varStatus="status" >
					<tr>
						<td>
						<span>${meeting.sender }</span>
						</td>
						<td>
						<span>${meeting.starttime }</span>
						</td>
						<td>
						<span>${meeting.endtime }</span>
						</td>
						<td>
							<span>
								${meeting.address }
							</span>
						</td>
						<td>
							<span>${meeting.title }</span>
						</td>
						<td>
							<span>${meeting.content}</span>
						</td>
						<td>
							<%-- <span><a class="viewUser" href="javascript:;" userid=${address.ID } username=${address.username }><img src="${path }/index/images/read.png" alt="查看" title="查看"/></a></span> --%>
							<span><a class="modifyUser" href="meeting!getModifyJsp.action?ID=${meeting.ID }" userid=${meeting.ID } username=${meeting.sender }><img src="${path}/index/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${meeting.ID }  username=${meeting.sender }><img src="${path}/index/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%-- <input type="hidden" id="totalPageCount" value="${totalPage}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPage}"/>
	          	<c:param name="totalPageCount" value="${totalPage}"/>
          	</c:import> --%>
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