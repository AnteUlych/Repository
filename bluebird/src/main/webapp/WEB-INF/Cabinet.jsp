<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Cabinet</title>
</head>
<body>
 <h1>Cargoes</h1>

 <br> 
<c:forEach items="${cargoes}" var="cargo">
${cargo.description}
 <br>
</c:forEach>

<c:forEach items="${waybill}" var="way">
${way.longitude}
 <br>
 
</c:forEach>

<form method="POST">
	<c:forEach items="${cargoes}" var="cargo" varStatus="step">
	<input type="hidden" name="cargoid${step.index}" value="${cargo.id}" />
${cargo.id} <input type="submit" class="btn btn-link" name="find${step.index}" value="${cargo.description}">
<br>
</c:forEach>
	</form>

</body>
</html>