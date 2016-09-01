<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form:form method="get" action="createReport.html" modelAttribute="attReport">
		<table>
			<tr>
				<th>Key</th>
				<th>Value</th>
			</tr>
			<c:forEach items="${attReport.mapAtt}" var="mapAtt" varStatus="status">
				<tr>
					<td>${mapAtt.key}</td>
					<td><input name="mapAtt['${mapAtt.key}']"
						value="${mapAtt.value}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />

		<input type="submit" value="Save" />

	</form:form>
</body>
</html>