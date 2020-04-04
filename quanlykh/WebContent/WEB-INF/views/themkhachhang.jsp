<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Khách Hàng</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>THÔNG TIN KHÁCH HÀNG</h1>
<form method="POST" action="${pageContext.request.contextPath}/ThemKhachHang">
	<p class="nhap"> Khách hàng:</p> <br>
	<input type="text" name = "tenkh" /><br>
	<p class="nhap">Thông tin khách hàng:</p> <br>
	<textarea rows="5" cols="21" name = "thongtin" ></textarea><br>
	<p class="nhap">Trạng Thái:</p> <br>
	<input checked="checked" name="trangthai" type="radio" value="0" />Chưa Làm
	<input name="trangthai" type="radio" value="1" />Đã Làm
<br>
	<p class="nhap">Điện thoại:</p> <br>
	<input type="text" name = "sdt" /><br>
	<p class="nhap">Tên miền:</p> <br>
	<input type="text" name = "tenmien" /><br>
	<p class="nhap">Ngày:</p> <br>
	<input type="date" name = "ngay" /><br>
	<p class="nhap">Nhân viên:</p> <br>
	<input type="text" name = "sale" /><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>