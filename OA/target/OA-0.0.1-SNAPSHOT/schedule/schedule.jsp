<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>日程安排界面</title>
 	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/public.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../schedule/js/schedulelist.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="background: #A8A8A8">
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>日程安排</span>
            </div>
            <div class="search">
           	<form method="post" action="schedule!search.action"> 
	        		<span>月份：</span>
					 <select name="month" id="month" >
					 <option value="0">请选择</option>
						<c:if test="${monthList != null }">
						   <c:forEach var="name" items="${monthList}" begin="0" end="${monthList.size() }" step="1">
						   		<option value="${name }">${name }</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 <span>日期：</span>
					 <select name="day" id="day" >
					 <option value="0">请选择</option>
						<c:if test="${dayList != null }">
						   <c:forEach var="name" items="${dayList}" begin="0" end="${dayList.size() }" step="1">
						   		<option value="${name }">${name }</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 <input type="submit"  value="查找" style="background: #626367; width: 70px;font-size: 16px; height: 30px;"/>
					 <a href="schedule!add.action?username=${username }" style="background: #626367;">新增日程</a>
					 </form>
					
						 
						
						
						 
					
				
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0" >
                <tr class="firstTr">
                    <th width="16%">年份</th>
                    <th width="16%">月份</th>
                    <th width="16%">日期</th>
                    <th width="26%">安排内容</th>
                    <th width="26%">执行操作</th>
                </tr>
                   <c:forEach var="schedule" items="${scheduleList }" varStatus="status" >
					<tr>
						<td>
						<span>${schedule.year }</span>
						</td>
						<td>
						<span>${schedule.month }</span>
						</td>
						<td>
							<span>
								${schedule.day }
							</span>
						</td>
						<td>
						<span>${schedule.plan}</span>
						</td>
						<td>
							<%-- <span><a class="viewUser" href="javascript:;" userid=${address.ID } username=${address.username }><img src="${path }/index/images/read.png" alt="查看" title="查看"/></a></span> --%>
							<span><a class="modifyUser" href="schedule!getModifyJsp.action?ID=${schedule.ID }" userid=${schedule.ID } username=${schedule.username }><img src="${path}/index/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${schedule.ID } username=${schedule.username }><img src="${path}/index/images/schu.png" alt="删除" title="删除"/></a></span>
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