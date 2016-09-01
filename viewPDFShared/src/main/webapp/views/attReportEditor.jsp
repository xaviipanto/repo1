<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>CKEditor</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
	<script src="../ckeditor/ckeditor.js"></script>
	
	<script type="text/javascript">
		$( init );
		function init() {
			$('#makeMeDraggable').draggable();
		}
	</script>
</head>
<body>
	<form:form method="get" action="createReportEditor.html" modelAttribute="attReport">
		<table>
			<tr>
				<th>Key</th>
				<th>Value</th>
			</tr>
			<c:forEach items="${attReport.mapAtt}" var="mapAtt" varStatus="status">
				<tr>
					<td>${mapAtt.key}</td>
					<td>
						<input name="mapAtt['${mapAtt.key}']"
								value="${mapAtt.value}"
								style="width: 600px"/>
					</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<td>
					<div style="width: 800px; height: 600px;">
						<textarea id="editor1" name="editor1"></textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="content" style="height: 400px;">
						<div id="makeMeDraggable"></div>
					</div>
				</td>
			</tr>
		</table>
		<script>
			CKEDITOR.replace( 'editor1' );
		</script>
		<br/>

		<input type="submit" value="Save" />

	</form:form>
</body>
</html>
