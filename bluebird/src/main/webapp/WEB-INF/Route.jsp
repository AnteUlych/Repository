<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    
<title>Route</title>

</head>

<body>

<h1>${cargo.description}</h1>

<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>

  <form method="post">
	
longitude: <input name="longitude"  value="">
latitude: <input name="latitude"  value="">
status: <input name="status"  value="">	
<input type="submit" name="add" value="add">	

</form>

<c:forEach items="${route}" var="information">

${information.longitude}
${information.latitude}
${information.status}
<a href="/bluebird/editRoute/${information.id}">edit</a>

<br>

</c:forEach>




</body>

</html>