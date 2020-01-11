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
	Tên khách hàng: <br>
	<input type="text" name = "tenkh" /><br>
	Thông tin khách hàng: <br>
	<textarea rows="3" cols="3" name = "thongtin" ></textarea><br>
	Trạng Thái: <br>
	<input checked="checked" name="trangthai" type="radio" value="0" />Chưa Làm
	<input name="trangthai" type="radio" value="1" />Đã Làm
<br>
	Điện thoại: <br>
	<input type="text" name = "sdt" /><br>
	Tên miền: <br>
	<input type="text" name = "tenmien" /><br>
	Ngày: <br>
	<input type="date" name = "ngay" />
	Nhân viên: <br>
	<input type="text" name = "sale" /><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>