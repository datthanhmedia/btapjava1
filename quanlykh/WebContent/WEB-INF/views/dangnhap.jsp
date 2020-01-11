<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
<h1>ĐĂNG NHẬP</h1>
<form method="POST" action="${pageContext.request.contextPath}/DangNhap">
	Tài khoản: <br>
	<input type="text" name = "user" /><br>
	Mật khẩu: <br>
	<input type="password" name = "password" /><br>
	<input type="submit" value="Đăng Nhập"/>
</form>
</body>
</html>