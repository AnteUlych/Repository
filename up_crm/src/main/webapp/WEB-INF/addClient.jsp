<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>

     <br>
     
     <br>
     <form method="post">
     Company: <input type="text" name="company"><br>
     Company code: <input type="text" name="cod"><br>
      Mail: <input type="text" name="mail" ><br>
      Person: <input type="text" name="person" ><br>
      Phone: <input type="text" name="phone" ><br>
     Category:<br>
				 <c:forEach items="${categories}" var="cat" varStatus="step">
                       <input type="radio" name="cat" value ="${cat}"> <label>${cat}</label><br>
		             </c:forEach>
   Enter funnel step:<br>
				 <c:forEach items="${funnels}" var="fun" varStatus="step">
                       <input type="radio" name="fun" value ="${fun}"> <label>${fun}</label><br>
		             </c:forEach>
		             <br>
	 Next Call: <input type="date" name="nextcall"><br> 
	 Comment: <input type="text" name="comment"><br>
	  <br>
	 <input type="submit"  name="add" value="add">
         
    </form>


<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>