<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div style="background-color: #d0d0d0; heigh:100px;"> 
		<h5>Hello, ${sessionScope.useracc}</h5>
		
		<a href="${pageContext.request.contextPath}/home">Home</a>
		
		<a href="${pageContext.request.contextPath}/OrderList">Danh sách khách hàng</a>
		
		<a href="${pageContext.request.contextPath}/CreatOrder">Thêm khách hàng</a>
		
		<a href="${pageContext.request.contextPath}/LogOut">Đăng xuất</a>
	</div>
</body>
</html>