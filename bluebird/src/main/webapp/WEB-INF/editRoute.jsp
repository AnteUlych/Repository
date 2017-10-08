<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    
<title>Route</title>

</head>

<body>

<form method="post">
	
longitude: <input name="longitude" placeholder="${cargo.longitude}"  value="${cargo.longitude}">
<br>
latitude: <input name="latitude" placeholder="${cargo.latitude}"  value="${cargo.latitude}">
<br>
status: <input name="status" placeholder="${cargo.status}"  value="${cargo.status}">	
<br>
	
<input type="submit" name="edit" value="edit">	
	

</form>




</center>
</body>

</html>