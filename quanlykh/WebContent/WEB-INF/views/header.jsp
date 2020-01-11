<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resource/css/header.css" />' rel='stylesheet'>
</head>
<body>
	<div style="background-color: #d0d0d0; heigh:100px;"> 
		<h5>Hello, ${sessionScope.user}</h5>
		<img width = "30px" alt="logo" src="<c:url value="/resource/image/logo.jpg" />">
		<ul class="menu-chinh">
				<li><a href="${pageContext.request.contextPath}/ThongTinKhachHang">Khách hàng</a></li>
				<li><a href="${pageContext.request.contextPath}/ThemKhachHang">Thêm khách hàng</a></li>
				<li><a href="${pageContext.request.contextPath}/ThongTinTenMien">Tên miền</a></li>
				<li><a href="${pageContext.request.contextPath}/ThemTenMien">Thêm tên miền</a></li>
				<li><a href="${pageContext.request.contextPath}/DangXuat">Đăng xuất</a></li>
		</ul>
	</div>
</body>
</html>