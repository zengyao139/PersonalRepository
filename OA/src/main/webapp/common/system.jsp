<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="background: #A8A8A8">
 <div class="location">
                <strong style="margin-left: 2%;margin-top: 40px;">你现在所在的位置是: <span style="margin-left: 5px;margin-top: 40px;">系统页面</span></strong>
              <br></br>	
            </div>
            <div style="width: 360px;border:1px solid black; height: 190px; text-align:center; margin-left: 20px;margin-top: 40px; margin: 0 auto; ">
				<br/>
				<p> <strong>负载均衡</strong></p>
				<p>请求地址真实IP : <%=request.getHeader("X-real-ip") %> <p> 
				<p>nginx服务器IP : <%=request.getRemoteAddr()%><p>
				</div>
</body>
</html>