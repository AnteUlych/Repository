<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>AdninCompanieServlet</h2>
 
    <form method="POST">
      <table>
      
            <tr>
                <td>Edit Company:</td>
                <td><input type="text"  name="newCompany" placeholder="${client.company}"  value="${client.company}"/></td>
            </tr>
            <tr>
                <td>Edit Code:</td>
                <td><input type="text"  name="codeCompany" placeholder="${client.code}"  value="${client.code}"/></td>
            </tr>
            <tr>
                <td>Edit mail:</td>
                <td><input type="text"  name="mail" placeholder="${client.mail}"  value="${client.mail}"/></td>
            </tr>
             <tr>
                <td>Edit manager:</td>
                <td><input type="text"  name="manager" placeholder="${client.manager}"  value="${client.manager}"/></td>
            </tr>
             <tr>
                <td>Edit phone:</td>
                <td><input type="text"  name="phone" placeholder="${client.phone}"  value="${client.phone}"/></td>
            </tr>
             <tr>
                <td>Edit mobile:</td>
                <td><input type="text"  name="mobile" placeholder="${client.mobile}"  value="${client.mobile}"/></td>
            </tr>
             <tr>
                <td>Edit webaddress:</td>
                <td><input type="text"  name="webaddress" placeholder="${client.webaddress}"  value="${client.webaddress}"/></td>
            </tr>
            <tr>
                <td>Edit password:</td>
                <td><input type="text" name="password" placeholder="${client.password}"  value="${client.password}"/></td>
            </tr>
             <tr>
                <td>Edit youcontrol:</td>
                <td><input type="text" name="youcontrol" placeholder="${client.youcontrol}"  value="${client.youcontrol}"/></td>
            </tr>
    
            <tr>
                <td><button type="submit" name="submit" value="submit">Edit</td>
                
            </tr>
  
        </table>
           
    </form>
 
  <br> 

<a href="/lotos/adminCompanies" >companies</a> <br>
<a href="/lotos/adminRequests" >Requests</a><br>
	
	<br> Recommendations:<br> 
  <br> 
  <table>
  
  <tr>
    <th>Company Tender</th>
    <th>Company Proposition</th> 
    <th>Deal Date</th>
    <th>Recommendation Date</th>
    <th>Incoterms</th>
    <th>Country From</th>
    <th>Country To</th>
    <th>Weight</th>
    <th>Transport</th>
    <th>Rate</th>   
  </tr>
  
  <c:forEach items="${comments}" var="comment" varStatus="step">
            <tr>
                <td>${comment.companytender}</td>
                <td>${comment.companyproposition}</td>
                <td>${comment.dealdate}</td>
                <td>${comment.recomendationdate}</td>
                <td>${comment.incoterms}</td>
                <td>${comment.countryfrom}</td>
                <td>${comment.countryto}</td>
                <td>${comment.weight}</td>
                <td>${comment.transport}</td>
                <td><a href="/lotos/adminRecommendation/${comment.id}" >${comment.rate}</a></td>
            </tr>
  </c:forEach>
  </table>
</body>
</html>