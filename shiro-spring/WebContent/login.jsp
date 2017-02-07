<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Login!</title>
</head>
<body>
	
	<h1>Login Page</h1>
	<hr>
	<form action="shiro/login.do" method="POST">
	
		UserName:<input type="text" name="username" id="username">
		<br>
		Password:<input type="password" name="password" id="password">
		<br>
		<input type="submit">
	</form>

</body>
</html>