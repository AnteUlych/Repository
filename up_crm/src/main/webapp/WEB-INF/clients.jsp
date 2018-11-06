<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>

	<h2>${code}</h2><br>
	<h2>${privateCode}</h2><br>
	<h2>${manager}</h2>

<c:forEach items="${clients}" var="client">
<a href="/crm/client/${privateCode}${client.id}">${client.company}</a>, ${client.nextcall}<br>
</c:forEach>

<br>
<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>