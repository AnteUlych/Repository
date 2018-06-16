<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>UPLG</title>
</head>

<body>

	<table>
		<thead>
			<tr>
				<th>Number</th>
				<th>Client</th>
				<th>Route</th>
				<th>Status</th>
				<th>Delivery</th>
				<th>Update</th>
			</tr>
		</thead>

		<c:forEach items="${bookings}" var="booking" varStatus="theCount">

			<tr>
				<td>${theCount.count}</td>
				<td>${booking.company}</td>
				<!-- <td><a href="route/${cargo.id}">${cargo.description}</a></td>-->
				<td>${booking.route}</td>
				<td>${booking.status}</td>
				<td>${booking.delivery}</td>
				<td>${booking.update}</td>
			</tr>
		</c:forEach>
	</table>
	------------------------------------------


	<c:forEach items="${bookings}" var="booking" varStatus="theCount">

		<form:form method="POST" commandName="booking">
             ${booking.longitude} - ${booking.status} <br>
             <form:input path="longitude" placeholder="${booking.longitude}" value="${booking.longitude}"  />
			 <form:input path="status" placeholder="${booking.status}" value="${booking.status}" />
			<br>

			<input type="submit" name="submit" value="Submit ${booking.id}">

		</form:form>

	</c:forEach>

</body>
</html>