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
     Company: <input type="text" name="company" placeholder="${company}" value="${company}"><br>
      Mail: <input type="text" name="mail" placeholder="${mail}" value="${mail}"><br>
      Person: <input type="text" name="person" placeholder="${person}" value="${person}"><br>
      Phone: <input type="text" name="phone" placeholder="${phone}" value="${phone}"><br>
     Enter funnel step:<br>
				 <c:forEach items="${categories}" var="cat" varStatus="step">
                       <input type="radio" name="cat" value ="${cat}"> <label>${cat}</label><br>
		             </c:forEach>
 
	  <br>
	 <input type="submit"  name="add" value="add">
         
    </form>


<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>

</body>
</html>