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
		<th>Tên Khách Hàng</th>
		<th>SĐT</th>
		<th>Thông Tin Khách Hàng</th>
		<th>Hạn Chót</th>
		<th>NV Bán Hàng</th>
		<th>Developer</th>
		<th>Trạng Thái</th>
		<th>Thông tin web</th>
		
	</tr>
	<c:forEach items="${listOrder}" var = "order">
		<tr id="order-${order.id}">
		<th>${order.id}</th>
		<th>${order.customerName}</th>
		<th>${order.phone}</th>
		<th>${order.info}</th>
		<th>${order.deadline}</th>
		<th>${order.salerName}</th>
		<th>${order.devName}</th>
		<th>${order.orderStatus}</th>
		<th>${order.webInfo}</th>
		
		
	</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>