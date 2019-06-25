<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>RecomendationServlet</h2>
 
 ${logo}<br>
 ${id}<br>
 
 <br>
  ${company.manager}<br>


 <br>
 recommendations:
 <br>
   
        <table>
        <c:forEach items="${recommendations}" var="recommendation" varStatus="step">
             <tr>
             <br>
                <td><a href="/lotos/company/${company.id}" >${recommendation.companytender}</a></td>
                <td>${recommendation.rate}</td>
                <td>${recommendation.whyinfo}</td>

            </tr> 
        </c:forEach>
        </table>
    
 
  <br> 

<a href="/lotos/tenders" >tenders</a><br>
<a href="/lotos/company/${id}">own page</a><br>
	
</body>
</html>