<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza JSP View</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>NAME</td>
			<td>Flavor</td>
			<td>Categories</td>
		</tr>
		<tr>
			<td>${pdf.name}</td>
			<td>${pdf.flavor}</td>
			<td>
				<c:forEach var="item" items="${pdf.categories}">
					<c:out value="${item}" />&nbsp; 
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>