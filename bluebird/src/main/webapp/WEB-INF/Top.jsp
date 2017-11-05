<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>bluebird</title>
</head>
<body>

	<c:forEach items="${active}" var="cargo">
		${cargo.client} - ${cargo.description};
		<br>
	</c:forEach>
	<br> Total transportations - ${allActiveCargoes}
	<br> Marks:
	<br> never again - ${mark1}
	<br> bad servise - ${mark2}
	<br> so-so - ${mark3}
	<br> good service - ${mark4}
	<br> excellent service - ${mark5}
	<br>
	<br>
	<a href="/bluebird/top/allReviews">reviews</a>
	<br>

</body>
</html>