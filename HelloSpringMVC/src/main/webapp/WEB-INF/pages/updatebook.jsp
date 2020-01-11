<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create book</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2 style="text-align:center; color:blue;">CREATE BOOK MODEL</h2>
	
	<form:form method="POST" action="${pageContext.request.contextPath}/book/update" modelAttribute="book">
         <table border="0">
         	<tr>
               <td>id</td>
               <td><form:input type="number" path="id" readonly="true"/></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><form:input type="text" path="name"/></td>
            </tr>
            <tr>
               <td>Author</td>
               <td><form:input type="text" path="author"/></td>
            </tr>
            <tr>
               <td>Publisher</td>
               <td><form:input type="text" path="publisher"/></td>
            </tr>
             <tr>
               <td>Price</td>
               <td><form:input type="number" path="price"/></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
               </td>
            </tr>
         </table>
      </form:form>
</body>
</html>