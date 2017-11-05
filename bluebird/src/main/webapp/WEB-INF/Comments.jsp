<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Comments</title>
</head>
<body>
 <h1>Comments</h1><br> 

<br> 
 <br> 
<c:forEach items="${comments}" var="comment">
${comment.client} 
${comment.cargo} 
${comment.time}
${comment.comment}
${comment.rate}
 <br>
</c:forEach>
<br>
	<a href="/bluebird/top">back</a>
	<br>


</body>
</html>