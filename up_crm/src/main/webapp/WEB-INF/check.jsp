<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>


     <br>
     <form method="post">
 
	 Search client by code: <input type="text" name="cod">
	  <input type="submit"  name="search" value="search">
	 <br>
	 <input type="submit"  name="back" value="back">           
    </form>

		<a href="/crm/client/${privateCode}${clientId}">${company}, ${worker}</a>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>