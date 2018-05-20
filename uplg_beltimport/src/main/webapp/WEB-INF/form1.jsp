<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC form submission</title>
</head>

<body>
	<h2>Fill your form!</h2>

	<form:form method="POST" commandName="request">
		<table>
			<tr>
				<td>Contact person:</td>
				<td><form:select path="client">
					  <form:option value="" label="...." />
					  <form:options items="${clients}" />
				       </form:select>
                </td>
			</tr>
			<tr>
				<td>Ready at:</td>
				<td><form:input path="pickup" /></td>

			</tr>
			<tr>
				<td>Address:</td>
				<td><form:select path="address">
					  <form:option value="" label="...." />
					  <form:options items="${addresses}" />
				       </form:select>
                </td>

			</tr>
			<tr>
				<td>Pallets:</td>
					<td><form:select path="quantity">
					  <form:option value="" label="...." />
					  <form:options items="${pallets}" />
				       </form:select>
                </td>

			
			
			<tr>
				<td><input type="submit" name="submit" value="Calculate"></td>
				<td><input type="submit" name="submit" value="Order"></td>
			</tr>
			<tr>
		</table>
	</form:form>
Price: ${price}
Delivery: ${delivery}
</body>
</html>