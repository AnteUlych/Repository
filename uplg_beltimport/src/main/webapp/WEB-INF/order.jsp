<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Spring MVC form submission</title>
</head>

<body>
${request.client}, 
<br>
${request.pickup}
<br>

	<c:forEach var="document" items="${request.documentation}">  
			<c:out value="${document}"/><br>
	</c:forEach>
<br>

</body>
</html>