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


<!--  
<form method="Post">
<c:forEach items="${cargoes}" var="cargo" varStatus="step">
	<input name="message${step.index}" type="hidden" value="${cargo.id}"/>
	<input type="submit" name="submit${step.index}" value="${cargo.description}"/>
  </c:forEach>
</form>
	-->


</body>
</html>