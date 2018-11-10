<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>

<form method="post">
route: <input name="route" placeholder="route"  value=""><br>
size: <input name="size" placeholder="size" value=""><br>
weight: <input name="weight" placeholder="weight" value=""><br>
other: <input name="other" placeholder="other" value=""><br>
readiness: <input name="readiness" placeholder="readiness" value=""><br>
Please select client:<br>
				<select name="client">
					  <c:forEach items="${companies}" var="companie" varStatus="step">
					   <option value="${companie}">${companie}</option>
					  </c:forEach>
				       </select>
<br>
Enter Service:<br>
				 <c:forEach items="${services}" var="service" varStatus="step">
                       <input type="radio" name="service" value ="${service}"> <label>${service}</label><br>
		             </c:forEach>
				
<input type="submit"  name="add" value="add">
</form>
<br>
<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>