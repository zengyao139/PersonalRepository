<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>日志管理</title>
 	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/public.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../worklog/js/workloglist.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="background: #A8A8A8">
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>日志管理</span>
            </div>
            <div class="search">
           <%-- 	<form method="post" action="search.action"> 
					 <span>好友名称：</span>
					 <input name="name" class="input-text"	type="text" id="name" >
					 
					 <span>好友地址：</span>
					 <select name="address2" id="address2" >
					 <option value="0">请选择</option>
						<c:if test="${addressNameList != null }">
						   <c:forEach var="name" items="${addressNameList}" begin="0" end="${addressNameList.size() }" step="1">
						   		<option value="${name }">${name }</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 
					 <input type="submit"  value="查找" style="background: #626367; width: 70px;font-size: 16px; height: 30px;"/> --%>
					 <a href="worklog!add.action?username=${username }" style="background: #626367;">新增日志</a>
					<!--  </form> -->
				
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0" >
                <tr class="firstTr">
                    <th width="10%">日志年份</th>
                    <th width="10%">日志月份</th>
                    <th width="10%">日志日期</th>
                    <th width="15%">日志标题</th>
                    <th width="23%">日志内容</th>
                    <th width="12%">记录时间</th>
                    <th width="20%">相应操作</th>
                </tr>
                   <c:forEach var="worklog" items="${worklogList }" varStatus="status" >
					<tr>
						<td>
						<span>${worklog.year }</span>
						</td>
						<td>
							<span>
								${worklog.month }
							</span>
						</td>
						<td>
							<span>${worklog.day }</span>
						</td>
						<td>
							<span>${worklog.title}</span>
						</td>
						<td>
							<span>${worklog.description}</span>
						</td>
						<td>
							<span>${worklog.logtime}</span>
						</td>
						<td>
							<%-- <span><a class="viewUser" href="javascript:;" userid=${address.ID } username=${address.username }><img src="${path }/index/images/read.png" alt="查看" title="查看"/></a></span> --%>
							<span><a class="modifyUser" href="worklog!getModifyJsp1.action?ID=${worklog.ID }" userid=${worklog.ID } username=${worklog.username }><img src="${path}/index/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${worklog.ID } username=${worklog.username }><img src="${path}/index/images/schu.png" alt="删除" title="删除"/></a></span>
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