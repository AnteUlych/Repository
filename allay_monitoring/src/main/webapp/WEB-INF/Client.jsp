<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Tracing</title>
</head>

<body>

	${booking.route}
	${booking.longitude}
	${booking.latitude}
	${booking.status}
	${booking.delivery}
	${booking.update}
	
	<br>
	<br>

<c:forEach items="${bookings}" var="transportation">
${transportation.route} : ${transportation.key}	<br>
</c:forEach>
	


</body>
</html>