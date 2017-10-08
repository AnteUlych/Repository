<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC form submission</title>
</head>

<body>
	<h2>Fill client form!</h2>

	<form:form method="POST" commandName="customer">
		<table>
			<tr>
				<td>Enter company:</td>
				<td><form:input path="company" /></td>
				<td><form:errors path="company" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td>Enter name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: #ff0000;" /></td>
			</tr>
				<tr>
				<td>Enter email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
			<tr>
				<td>Enter phone:</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssStyle="color: #ff0000;" /></td>
			</tr>
				<tr>
				<td>Enter login:</td>
				<td><form:input path="login" /></td>
				<td><form:errors path="login" cssStyle="color: #ff0000;" /></td>
			</tr>
				<tr>
				<td>Enter password:</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>