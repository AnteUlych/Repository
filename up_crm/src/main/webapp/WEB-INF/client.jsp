<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>

${answer}, 
${category},
 ${company},
  ${funnel},
   ${mail}, 
   ${nextcall},
    ${person},
     ${phone}, 
     ${answer}
     <br>
     
     <br>
     <form method="post">
     Enter funnel step:<br>
				 <c:forEach items="${funnels}" var="fun" varStatus="step">
                       <input type="radio" name="fun" value ="${fun}"> <label>${fun}</label><br>
		             </c:forEach>
		             <br>
	 Next Call: <input type="date" name="nextcall"><br> 
	 Comment: <input type="text" name="comment"><br>  
	  <br>
	 <input type="submit"  name="add" value="add">
	 <br>
	 <input type="submit"  name="back" value="back">           
    </form>

<c:forEach items="${requests}" var="request">
<a href="/crm/request/${today}_${managerId}_${request.id}">${request.route}</a>, ${request.creating},
${request.result}, ${request.readiness}, ${request.type},

<br>
</c:forEach>
<br>
<c:forEach items="${statuses}" var="status">
${status.funnel}, ${status.answer}, ${status.lasttime},
<br>
</c:forEach>
<br>

<c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}">${service}</a><br>
</c:forEach>
<a href="/crm/editClient/${nextPage}">edit</a><br>
</body>
</html>