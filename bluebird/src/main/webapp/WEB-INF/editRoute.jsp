<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet" />
<head>
    
<title>Route</title>
<style>
div.sign {
    position: relative;
    top: 100 ;
}

div.deletebut {
    position: relative;
    left: 90 ;
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
<form method="post">
	
<table>
		
			<tr>
				<td>longitude:</td> 
<td><input name="longitude" placeholder="${cargo.longitude}"  value="${cargo.longitude}"></td> 
</tr>
<td>latitude: </td>
<td><input name="latitude" placeholder="${cargo.latitude}"  value="${cargo.latitude}"></td>
</tr>
<td>status: </td>
<td><input name="status" placeholder="${cargo.status}"  value="${cargo.status}"></td>	
</tr>
</table>
	<br>
	<div class="deletebut">
	<input type="submit" class="w3-button w3-white w3-border w3-circle" name="edit" value="delete">
	&nbsp
	&nbsp
	&nbsp
	&nbsp
	&nbsp
	<input type="submit" class="w3-button w3-white w3-border w3-circle" name="edit" value="edit">	
	</div>
	
</form>

</div>
<div class="w3-col" style="width:20%">
</div>



</body>

</html>