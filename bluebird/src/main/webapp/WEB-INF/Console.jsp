<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Spring MVC form submission</title>
</head>

<body>
<h2>active cargoes</h2>
		<c:forEach items="${active}" var="cargo">
<a href="route/${cargo.id}">${cargo.description}</a>
                     <br>
		</c:forEach>
		<br>
	<h2>add cargo</h2>

	<form:form method="POST" commandName="freight">
		<table>
		
			<tr>
				<td>Enter description:</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color: #ff0000;"/></td>
			</tr>
			
			<tr>
				<td>Please select client:</td>
				<td><form:select path="client">
					  <form:option value="" label="...." />
					  <form:options items="${clients}" />
				       </form:select>
                </td>
				<td><form:errors path="client" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>
	<h2>add client</h2>
<a href="addClient">add new client</a>
</body>
</html>