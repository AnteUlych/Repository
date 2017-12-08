<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet" />
<head>
  <title>Comments</title>
</head>
<body>
<div class="w3-bar w3-light-grey">
<div class="w3-bar-item">

	</div>
  <a href="/bluebird/top" class="w3-button w3-right">back</a>


</div>

<div class="w3-row">

 <div class="w3-col w3-container" style="width:20%"><p></p></div>
  <div class="w3-col w3-container" style="width:60%"><p>
  
  <h3>Comments:</h3>
 <br> 
 
 <br> 
<c:forEach items="${comments}" var="comment">
  
 ${comment.client} (${comment.cargo}) [${comment.time}]:<br>
 <div class="w3-panel w3-border w3-round-xxlarge">
<p>${comment.comment} </p>
</div>

 <br>
 <br>
</c:forEach>
</p></div>
  <div class="w3-col  w3-container" style="width:20%"><p></p></div>
  
 
</div>

</body>
</html>