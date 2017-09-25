<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Cabinet</title>
</head>
<body>
 <h1>Cargoes</h1><br> 
 ${lastUpdate}<br> 
 ${totalCargoes}

<br> 
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

<c:choose>
    <c:when test="${needComment}">
        Say as how could we make our service better 
        <br />
        <input type="submit" class="btn btn-link" name="comment" value="comment">
    </c:when>    
    <c:otherwise>
        You`ve already give a rate. 
        <br />
    </c:otherwise>
</c:choose>


	</form>

</body>
</html>