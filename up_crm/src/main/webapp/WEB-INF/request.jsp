<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>
${company},${creating},${manager},${other},${readiness},
${result},${route},${size},${weight}
<br>
<br>	
<form method="post">
	<c:forEach items="${propositions}" var="proposition">
${proposition.id}, ${proposition.answer}, ${proposition.rate}, ${proposition.delivery}, 
${proposition.description}, ${proposition.manager}, ${proposition.result} 

<a href="/crm/editRequest/${today}_${managerId}_${request.id}">edit request</a>
<input type="submit"  name="delete${proposition.id}" value="cancel${proposition.id}">
<input type="submit"  name="confirm${proposition.id}" value="confirm">
<br>
</c:forEach>
<input type="submit"  name="cancel" value="cancel">
</form>
<br>
<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

<br>
<a href="/crm/proposition/${today}_${managerId}_${requestId}">add proposition</a>
</body>
</html>