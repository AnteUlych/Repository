<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet" />
<html>
<title>Address Book</title>
</head>

<body>
	<h2>Address Book</h2>

<a href="/spammer/message">send message</a>
<br />
<br>
	<form:form method="POST" commandName="email">
	<c:forEach items="${addressBook}" var="information">
	<input type="hidden" name="notUseful" value="${information}" />
${information} <input type="submit" class="btn btn-link" name="delete" value="delete">

<br>
</c:forEach>
<br />
<br>
		<table>
			<tr>
				<td colspan="20">Mail:</td>	
				<td><form:input path="address" /></td>
				<td colspan="20"><form:errors path="address" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
			
				<td><input type="submit" name="submit" value="Add"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>