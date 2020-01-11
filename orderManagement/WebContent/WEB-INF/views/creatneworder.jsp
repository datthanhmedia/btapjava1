<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<h1>CREAT ORDER</h1>
	<form method="POST" action="${pageContext.request.contextPath}/CreatOrder">
	<table border="0" width="400px">
		<tr>
			<td>Tên Khách Hàng:</td>
			<td><input type="text" name = "customername" /></td>
		</tr>
		<tr>
			<td>SĐT:</td>
			<td><input type="text" name = "phone" /></td>
		</tr>
		<tr>
			<td>Thông Tin Khách Hàng:</td>
			<td><textarea rows="4" cols="50" name = "info" ></textarea></td>
		</tr>
		<tr>
			<td>Hạn Chót:</td>
			<td><input type="date" name = "deadline" /></td>
		</tr>
		
		<tr>
			<td>Thông Tin Web:</td>
			<td><textarea rows="4" cols="50" name = "webinfo" ></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="Submit"/>
			<a href="${pageContext.request.contextPath}/home">Cancle</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>