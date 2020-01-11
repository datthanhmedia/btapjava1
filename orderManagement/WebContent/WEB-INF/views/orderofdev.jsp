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
		<th>Trạng Thái</th>
		<th>Thông tin web</th>
		
	</tr>
	<c:forEach items="${listOrder}" var = "order">
		<tr class="order">
		<th  class="order-id">${order.id}</th>
		<th  class="order-customername">${order.customerName}</th>
		<th  class="order-phone">${order.phone}</th>
		<th  class="order-info">${order.info}</th>
		<th  class="order-deadline">${order.deadline}</th>
		<th  class="order-salername">${order.salerName}</th>
		<th  class="order-orderstatus">${order.orderStatus}</th>
		<th  class="order-webinfo">${order.webInfo}</th>
		<td  class="update"><a href="UpdateStatus?id=${order.id}">Sửa</a></td>
		
	</tr>
	</c:forEach>
</table>
</body>
</html>