<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa Tên Miền</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>SỬA TÊN MIỀN</h1>
<form method="POST" action="${pageContext.request.contextPath}/SuaTenMien">
	ID: <br>
	<input type="text" name="id" value="${tenMien.id}" readonly/><br>
	Tên miền: <br>
	<input type="text" name = "tenmien" value="${tenMien.tenMien}" /><br>
	Ngày đăng ký: <br>
	<input type="date" name = "ngaydangky" value="${tenMien.ngayDangKy}"/><br>
	Thông tin hosting: <br>
	<textarea rows="3" cols="3" name = "hosting" >${tenMien.hosting}</textarea><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>