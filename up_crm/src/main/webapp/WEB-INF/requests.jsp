<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>
	<h2>${id}</h2>

	<c:forEach items="${requests}" var="request">
${request.id}, ${request.creating}, ${request.readiness}, ${request.manager}, ${request.company},
<a href="/crm/request/${today}_${id}_${request.id}">${request.route}</a> , 
${request.size}, ${request.weight}, ${request.result}
<br>
</c:forEach>
<br>
<br>
<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>
<br>
<br>
<a href="/crm/createRequest/${today}_${id}_0">add request</a>
</body>
</html>