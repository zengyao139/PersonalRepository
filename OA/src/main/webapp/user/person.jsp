<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script type="text/javascript" src="../user/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

$(function(){
	var window1=$(window).height();
	$("#div_x").css("top",parseInt(window1)*0.58+"px");
})
</script>
<title>个人空间</title>
</head>
<body style="background: #A8A8A8">
 <div class="location">
                <strong style="margin-left: 2%;margin-top: 10px;">你现在所在的位置是: <span style="margin-left: 5px;margin-top: 10px;">站点首页</span></strong>
              <br></br>	
            </div>
			<div style="width: 60%;height: 63%; margin-left: 20px; margin: 0 auto; ">
				<div id="addiv" style="width:60%; height:63%;border:1px solid black;  position:absolute;overflow:hidden;border-radius: 7px;">
						<img class="adpic" src="../user/image/15.jpg" width="100%" height="100%" style="position:absolute;left:0px; top:0px;"/>
						<img class="adpic" src="../user/image/12.jpg" width="100%" height="100%" style="position:absolute;left:0px; top:0px;"/>
						<img class="adpic" src="../user/image/16.jpg" width="100%" height="100%" style="position:absolute;left:0px; top:0px;"/>
						<img class="adpic" src="../user/image/14.jpg" width="100%" height="100%" style="position:absolute;left:0px; top:0px;"/>
				</div>
				 <div id="div_x" style="   position:relative; top:350px;left:44%;    font-size: 14px;">
					<c:forEach begin="1" end="4" var="step">
						<img class="imgindex" alt="" src="/OA/user/image/dot1.png" >
					</c:forEach>
				</div>  
			</div>

</body>
<script type="text/javascript" src="../user/js/picture.js"></script>
</html>