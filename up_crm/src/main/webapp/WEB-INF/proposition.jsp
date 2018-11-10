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
rate: <input name="rate" placeholder="rate" value=""><br>
delivery: <input name="delivery" placeholder="delivery" value=""><br>
description: <input name="description" placeholder="description" value=""><br>
<br>
<input type="submit"  name="propose" value="propose">
</form>
<br>
<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>