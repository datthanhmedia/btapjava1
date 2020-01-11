<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Data in here</h1>

<table border="1" style="text-align: left" width = "100%">
	<tr>
		<th>ID</th>
		<th>Tên Nhân Viên</th>
		<th>Thông tin nhân viên</th>
		<th>Tài Khoản</th>
		<th>Chức vụ</th>
		
	</tr>
	<c:forEach items="${listUser}" var = "user">
		<tr>
		<th>${user.iduser}</th>
		<th>${user.userName}</th>
		<th>${user.userInfo}</th>
		<th>${user.userAcc}</th>
		<th>${user.role}</th>
		<td><a href="updateUser?id=${user.iduser}">Update</a></td>
			<td><a href="DeleteUser?id=${user.iduser}">Delete</a></td>
		
	</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>