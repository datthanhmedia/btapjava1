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
<form method="POST" action="${pageContext.request.contextPath}/UpdateStatus">
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

		<tr class="order">
		<th  class="order-id">${listOrder.id}</th>
		<th  class="order-customername">${listOrder.customerName}</th>
		<th  class="order-phone">${listOrder.phone}</th>
		<th  class="order-info">${listOrder.info}</th>
		<th  class="order-deadline">${listOrder.deadline}</th>
		<th  class="order-salername">${listOrder.salerName}</th>
		<th  class="order-orderstatus"><select name="orderstatus" required>
				  <option value="">Trạng thái</option>
				  <option value="Đã Làm">Đã Làm</option>
				  <option value="Chưa Làm">Chưa Làm</option>
				</select></th>
		<th  class="order-webinfo"><textarea rows="4" cols="50" name = "webinfo" >${listOrder.webInfo}</textarea></th>
		<td  class="submit"><input type="submit" value="Submit"/>
			<a href="${pageContext.request.contextPath}/OrderOfDev">Cancle</a></td>
		
	</tr>
	
</table>
</body>
</html>