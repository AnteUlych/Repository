<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<link href="resources/css/w3.css" rel="stylesheet" />
<head>
<title>Add new Client</title>
<style>
div.sign {
    position: relative;
    left: 70 ;
}
div.signbut {
    position: relative;
    left: 300 ;
}
</style>
</head>

<body>

<div class="w3-bar w3-light-grey">
<div class="w3-bar-item">

			
			
			
	
	</div>



</div>

<div class="w3-row">
<div class="w3-col" style="width:35%"><p></p>
</div>

<div class="w3-col" style="width:60%">
<div class="sign">
	<h2>Fill client form!</h2>
</div>
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
		</table>
		</br>
		<div class="signbut">
		<input class="w3-button w3-white w3-border w3-circle" type="submit" name="submit" value="+" >
			</div>
	</form:form>
</div>
<div class="w3-col" style="width:20%">
</div>
</body>
</html>