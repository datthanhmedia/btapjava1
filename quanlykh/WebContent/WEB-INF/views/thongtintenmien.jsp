<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin tên miền</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1 class="thong-tin">THÔNG TIN TÊN MIỀN</h1>
<form style="text-align: center;" method="POST" action="${pageContext.request.contextPath}/ThongTinTenMien">
	<input name="tukhoa" placeholder="Tìm kiếm" />
	<input type="submit" value="Submit"/>
</form>
<div class="khach-hang">
	<table class="thong-tin-khach-hang" style="border-color: #b1b1b1; border-collapse: collapse; width: 100%; text-align: left" border="1">
			<tr class="menu-thong-tin-khach-hang">
				<th>ID</th>
				<th>Tên miền</th>
				<th>Trạng thái</th>
				<th>Ngày đăng ký</th>
				<th>Ngày hết hạn</th>
				<th>Hosting</th>
				<th colspan="3">Chức Năng</th>
			</tr>
		<c:forEach items="${listTenMien}" var = "listTenMien">
			<tr class="listKhachHang">
				<td>${listTenMien.id}</td>
				<td class="listtenmien">${listTenMien.tenMien}</td>
				<td>${listTenMien.trangThai}</td>
				<td class="listngay">${listTenMien.ngayDangKy}</td>
				<td class="listngay">${listTenMien.ngayHetHan}</td>
				<td class="listhosting">${listTenMien.hosting}</td>
				<td><a href="GiaHanTenMien?id=${listTenMien.id}">Gia Hạn</a></td>
				<td><a href="SuaTenMien?id=${listTenMien.id}">Sửa</a></td>
				<td><a href="XoaTenMien?id=${listTenMien.id}">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>