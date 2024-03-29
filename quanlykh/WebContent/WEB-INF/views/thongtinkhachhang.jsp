<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin khách hàng</title>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="tongkhachhang">
	<h1 class="thong-tin">THÔNG TIN KHÁCH HÀNG</h1>
	<form style="text-align: center;" method="POST" action="${pageContext.request.contextPath}/ThongTinKhachHang">
		<input name="tukhoa" placeholder="Tìm kiếm" />
		<input type="submit" value="Tìm Kiếm"/>
	</form>
	<div class="khach-hang">
		<table class="thong-tin-khach-hang" style="border-color: #b1b1b1; border-collapse: collapse; width: 100%; text-align: left" border="1">
			<tr class="menu-thong-tin-khach-hang">
				<th>ID</th>
				<th>Tên Khách Hàng</th>
				<th>Thông Tin Khách Hàng</th>
				<th>Trạng Thái</th>
				<th>SĐT</th>
				<th>Tên miền</th>
				<th>Ngày</th>
				<th>Nhân viên</th>
				<th colspan="2">Chức Năng</th>
			</tr>
			<c:forEach items="${listKhachHang}" var = "listKhachHang">
				<tr id="listKhachHang-${listKhachHang.id}" class="listKhachHang">
					<td id="listKhachHang-id-${listKhachHang.id}" class="listKhachHang-id">${listKhachHang.id}</th>
					<td id="listKhachHang-tenKH-${listKhachHang.id}" class="listKhachHang-tenKH">${listKhachHang.tenKH}</th>
					<td id="listKhachHang-thongTin-${listKhachHang.id}" class="listKhachHang-thongTin">${listKhachHang.thongTin}</th>
					<td id="listKhachHang-trangThai-${listKhachHang.id}" class="listKhachHang-trangThai">${listKhachHang.trangThai}</th>
					<td id="listKhachHang-sdt-${listKhachHang.id}" class="listKhachHang-info">${listKhachHang.sdt}</th>
					<td id="listKhachHang-tenMien-${listKhachHang.id}" class="listKhachHang-tenMien">${listKhachHang.tenMien}</th>
					<td id="listKhachHang-ngay-${listKhachHang.id}" class="listKhachHang-ngay">${listKhachHang.ngay}</th>
					<td id="listKhachHang-sale-${listKhachHang.id}" class="listKhachHang-sale">${listKhachHang.sale}</th>
					<td id="update-${listKhachHang.id}" class="update"><a href="SuaKhachHang?id=${listKhachHang.id}">Sửa</a></td>
					<td id="delete${listKhachHang.id}" class="delete"><a href="XoaKhachHang?id=${listKhachHang.id}">Xóa</a></td>	
				</tr>
			</c:forEach>
		</table>
</div>
</div>
</body>
</html>