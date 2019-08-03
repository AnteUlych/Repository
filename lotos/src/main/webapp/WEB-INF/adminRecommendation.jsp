<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>adminRecommendationServlet</h2>
 
    <form method="POST">
     
                ${recomendationdate} ${rate}<br>  
                Tender: ${companytender}<br>         
                Proposition: ${companyproposition}<br>
                ${transport}, ${incoterms} ${countryfrom} - ${countryto}, ${weight} kg <br>
                <br>
                ${whyinfo}<br>  
                <br>
                <button type="submit" name="hide" value="hide">Hide</button><br><br>
                <button type="submit" name="delete" value="delete">Delete</button><br>
                        
    </form>
  <br>
  <br> 

<a href="/lotos/adminCompanies" >companies</a> <br>
<a href="/lotos/adminRequests" >Requests</a><br>
	

</body>
</html>