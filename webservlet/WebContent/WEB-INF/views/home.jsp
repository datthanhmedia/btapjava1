<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First web java</title>
</head>
<body>
	<h1>Hello world</h1>
	<a href="${pageContext.request.contextPath }/bookList">Book List</a>
	<a href="${pageContext.request.contextPath }/creatBook">Creat Book</a>
	<a href="${pageContext.request.contextPath }/logout">Log Out</a>
	<form method = "GET" action="${pageContext.request.contextPath}/SearchBook">
	<input type = "text" name = "bookname"/>
	<input type = "submit" value="Search by name"/>
	
</form>
</body>
</html>
