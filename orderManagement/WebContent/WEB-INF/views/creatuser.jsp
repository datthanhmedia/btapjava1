<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<h1>CREAT User</h1>
	<form method="POST" action="${pageContext.request.contextPath}/CreatUser">
	<table border="0" width="400px">
		<tr>
			<td>Tên Nhân Viên:</td>
			<td><input type="text" name = "username" /></td>
		</tr>
		<tr>
			<td>Thông tin nhân viên:</td>
			<td><textarea rows="4" cols="50" name = "userinfo" ></textarea></td>
		</tr>
		<tr>
			<td>Tài khoản:</td>
			<td><input type="text" name = "useracc" /></td>
		</tr>
		<tr>
			<td>Mật khẩu:</td>
			<td><input type="password" name = "password" /></td>
		</tr>
		<tr>
			<td>Chức vụ:</td>
			<td><select name="role" required>
				  <option value="">Chọn chức vụ</option>
				  <option value="admin">admin</option>
				  <option value="saler">Nhân viên bán hàng</option>
				  <option value="dev">Nhân viên kỹ thuật</option>
				</select></td>
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