<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>DealServlet</h2>
 
 ${logo}<br>
 <br>
  ${isRecommendationExist}<br>
  ${deal.companytender} - > ${deal.companyproposition}<br>

 <br>
 
 ${recommendation.rate}<br>
 ${recommendation.whyinfo}<br>
 
 propositions:
 <br>
    <form method="POST">
    
     Rate:
             
                <c:forEach items="${rates}" var="rat" varStatus="step">
                       <input type="radio" name="assessment" required data-validation-required-message="Please select visiability" value ="${rat}"> <label>${rat}</label> <br>
		             </c:forEach>
     
         Comment:<input type="text" name="comment" ><br>
            
       <button type="submit" name="add" value="add">add</button>
    </form>
 
  <br> 

<a href="/lotos/tenders" >tenders</a><br>
<a href="/lotos/company/${id}">own page</a><br>
	
</body>
</html>