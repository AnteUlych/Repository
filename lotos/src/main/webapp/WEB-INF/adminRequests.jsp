<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>DealsServlet</h2>

<br>
     <a href="/lotos/adminCompanies" >companies</a>
 <br>    
  <br> Requests:<br> 
  
  <table>
  <c:forEach items="${requests}" var="request" varStatus="step">
            <tr>
                <td>${request.registration}</td>
                <td>${request.company}</td>
                <td><a href="/lotos/adminRequest/${request.id}" >${request.code}</a></td>

            </tr>
  </c:forEach>
  </table>
     
        	
</body>
</html>