<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/resource/css/header.css" />' rel='stylesheet'>
<link href='<c:url value="/resource/css/thongtinkhachhang.css" />' rel='stylesheet'>
<link href='<c:url value="/resource/css/thongtintenmien.css" />' rel='stylesheet'>
<link href='<c:url value="/resource/css/themkhachhang.css" />' rel='stylesheet'>

</head>
<body>
	<div class="menu-tren">
		<div class="logo">
			<img alt="logo" src="<c:url value="/resource/image/logo.png" />">
				<h5>Hello, ${sessionScope.user}</h5>
		</div>
		<div class="menu">
			<ul class="menu-chinh">
				<li>
					<a href="${pageContext.request.contextPath}/ThongTinKhachHang">Khách hàng</a>
					<ul class="menu-con">
						<li><a href="${pageContext.request.contextPath}/ThongTinKhachHang">- Tất Cả Khách hàng</a></li>
						<li><a href="${pageContext.request.contextPath}/ThemKhachHang">- Thêm khách hàng</a></li>
					</ul>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/ThongTinTenMien">Tên Miền</a>
					<ul class="menu-con">
						<li><a href="${pageContext.request.contextPath}/ThongTinTenMien">- Tất Cả Tên miền</a></li>
						<li><a href="${pageContext.request.contextPath}/ThemTenMien">- Thêm tên miền</a></li>
						<li><a href="${pageContext.request.contextPath}/TenMienSapHetHan">- Sắp hết hạn</a></li>
						<li><a href="${pageContext.request.contextPath}/TenMienHetHan">- Hết Hạn</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/DangXuat">Đăng xuất</a></li>
			</ul>
		</div>
	</div>
</body>
</html>