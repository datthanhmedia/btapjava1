<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book list</title>
</head>
<body>
<h1>Data in here</h1>

<table border="1" style="text-align: left" width = "100%">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Author</th>
		<th>Publisher</th>
		<th>Price</th>
		
	</tr>
	<c:forEach items="${bookList}" var = "book">
		<tr>
		<th>${book.id}</th>
		<th>${book.name}</th>
		<th>${book.author}</th>
		<th>${book.publisher}</th>
		<th>${book.price}</th>
		<td><a href="updateBook?id=${book.id}">Update</a></td>
			<td><a href="deleteBook?id=${book.id}">Delete</a></td>
		
	</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/home">Home</a>
</body>
</html>