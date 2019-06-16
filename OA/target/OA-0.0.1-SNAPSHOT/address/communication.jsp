<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>通讯管理</title>
 	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/public.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/friendlist.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body style="background: #A8A8A8">
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>通讯管理</span>
            </div>
            <div class="search">
           	<form method="post" action="search.action"> 
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
					 
					 <input type="submit"  value="查找" style="background: #626367; width: 70px;font-size: 16px; height: 30px;"/>
					 <a href="add.action?username=${username }" style="background: #626367;">添加联系人</a>
					 </form>
					
						 
						
						
						 
					
				
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0" >
                <tr class="firstTr">
                    <th width="10%">用户名称</th>
                    <th width="10%">好友名称</th>
                    <th width="6%">好友属性</th>
                    <th width="7%">联系电话</th>
                    <th width="10%">电子邮箱</th>
                    <th width="10%">QQ号码</th>
                    <th width="10%">所在公司</th>
                    <th width="10%">现居地址</th>
                    <th width="7%">邮政编码</th>
                    <th width="20%">操作</th>
                </tr>
                   <c:forEach var="address" items="${addressList }" varStatus="status" >
					<tr>
						<td>
						<span>${address.username }</span>
						</td>
						<td>
						<span>${address.name }</span>
						</td>
						<td>
							<span>
								${address.sex }
							</span>
						</td>
						<td>
						<span>${address.mobile}</span>
						</td>
						<td>
						<span>${address.email}</span>
						</td>
						<td>
							<span>${address.qq}</span>
						</td>
						<td>
							<span>${address.company}</span>
						</td>
						
						<td>
							<span>${address.address}</span>
						</td>
						<td>
							<span>${address.postcode}</span>
						</td>
						<td>
							<%-- <span><a class="viewUser" href="javascript:;" userid=${address.ID } username=${address.username }><img src="${path }/index/images/read.png" alt="查看" title="查看"/></a></span> --%>
							<span><a class="modifyUser" href="index!getModifyJsp.action?ID=${address.ID }" userid=${address.ID } username=${address.name }><img src="${path}/index/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${address.ID } username=${address.name }><img src="${path}/index/images/schu.png" alt="删除" title="删除"/></a></span>
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