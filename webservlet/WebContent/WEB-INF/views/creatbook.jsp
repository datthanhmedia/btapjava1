<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creat Book</title>
</head>
<body>
	<h1>CREAT BOOK</h1>
	<form method="POST" action="${pageContext.request.contextPath}/creatBook">
	<table border="0" width="400px">
		<tr>
			<td>Name:</td>
			<td><input type="text" name = "name" /></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name = "author" /></td>
		</tr>
		<tr>
			<td>Publisher:</td>
			<td><input type="text" name = "publisher" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name = "price" /></td>
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