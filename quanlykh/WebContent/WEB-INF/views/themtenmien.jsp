<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Tên Miền</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>THÊM TÊN MIỀN</h1>
<form method="POST" action="${pageContext.request.contextPath}/ThemTenMien">
	Tên miền: <br>
	<input type="text" name = "tenmien" /><br>
	Ngày đăng ký: <br>
	<input type="date" name = "ngaydangky" /><br>
	Hosting: <br>
	<textarea rows="3" cols="3" name = "hosting" ></textarea><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>