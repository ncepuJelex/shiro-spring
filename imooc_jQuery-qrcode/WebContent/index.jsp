<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery 生成二维码</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.qrcode.min.js"></script>

<script type="text/javascript">

	function _generateCode() {
		jQuery('#qrcode').qrcode("this plugin is great,but I don't wanna be single...");
	};
	/* 
	$(function() {
		
		jQuery('#qrcode').qrcode("this plugin is great,but I don't wanna be single...");
		
		// You can set the height and width of the generated qrcode:
		//	jQuery('#qrcode').qrcode({width: 64,height: 64,text: "size doesn't matter"});
		
	}); */
</script>

</head>
<body>
	<a href="javascript:_generateCode()">点我生成二维码</a>
	<br><br>
	<div id="qrcode"></div>
</body>
</html>