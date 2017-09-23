<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>racoon CRM</title>
</head>

<body>
	<h2>Input your password</h2>

	<form:form method="POST" commandName="password">
		<table>
			<tr>
				<td>Enter your login:</td>
				<td><form:password path="login"  showPassword="true"/></td>
				<td><form:errors path="login" cssStyle="color: #ff0000;"/></td>
			<tr>
				<td>Enter your password:</td>
				<td><form:password path="password" showPassword="true"/></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>