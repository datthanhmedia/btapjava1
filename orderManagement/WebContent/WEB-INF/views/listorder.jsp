<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/updateorder.js" ></script>
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
		<tr id="order-${order.id}" class="order">
		<th id="order-id-${order.id}" class="order-id">${order.id}</th>
		<th id="order-customername-${order.id}" class="order-customername">${order.customerName}</th>
		<th id="order-phone-${order.id}" class="order-phone">${order.phone}</th>
		<th id="order-info-${order.id}" class="order-info">${order.info}</th>
		<th id="order-deadline-${order.id}" class="order-deadline">${order.deadline}</th>
		<th id="order-salername-${order.id}" class="order-salername">${order.salerName}</th>
		<th id="order-devname-${order.id}" class="order-devname">${order.devName}</th>
		<th id="order-orderstatus-${order.id}" class="order-orderstatus">${order.orderStatus}</th>
		<th id="order-webinfo-${order.id}" class="order-webinfo">${order.webInfo}</th>
		<td id="update-${order.id}" class="update"><a href="" onclick="updateorder(${order.id})">Update</a></td>
			<td><a href="DeleteOrder?id=${order.id}">Delete</a></td>
		
	</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>