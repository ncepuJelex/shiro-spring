<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试td元素的onclick事件</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript">

	window.onload = function() {
		var td1 = document.getElementById("1");
		console.log(td1);
		td1.onclick = function() {
			console.log(this);
			console.log(this.innerText);
			document.getElementById("11").value = this.innerText;
		}
		
		
	}
	
</script>

</head>
<body>
<div style="width: 300px;height: 200px; background-color: skyblue;">
	<input type="text" id="11"></input>
	
	<table>
		<tr><td id="1">123</td></tr>
		<tr><td id="2">456</td></tr>
	</table>

</div>
</body>
</html>