<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>UPDATE BOOK</h1>
	<form method="POST" action="${pageContext.request.contextPath}/updateBook">
	<table border="0" width="400px">
	
		<tr>
			<td>ID:</td>
			<td><input type="text" name = "id" value="${book.id}" readonly /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name = "name" value="${book.name}" /></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name = "author" value="${book.author}" /></td>
		</tr>
		<tr>
			<td>Publisher:</td>
			<td><input type="text" name = "publisher" value="${book.publisher}" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name = "price" value="${book.price}" /></td>
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