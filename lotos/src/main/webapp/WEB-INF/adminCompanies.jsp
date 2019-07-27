<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>AdminCompaniesServlet</h2>

<br>
     <a href="/lotos/adminRequests" >Requests</a>
 <br>    
  <br> Companies:<br> 
  
  <table>
  
  <tr>
    <th>Company</th>
    <th>Registration</th> 
    <th>Code</th>
    <th>Manager</th>
    <th>Mail</th>
    <th>Phone</th>
    <th>Mobile</th>
    <th>Good Comments</th>
    <th>Bad Comments</th>
    <th>Proposition Deals</th>
    <th>Tender Deals</th>
    
  </tr>
  
  <c:forEach items="${statistic}" var="client" varStatus="step">
            <tr>
                <td>${client.company}</td>
                <td>${client.registration}</td>
                <td><a href="/lotos/adminCompanie/${client.code}" >${client.code}</a></td>
                <td>${client.manager}</td>
                <td>${client.mail}</td>
                <td>${client.phone}</td>
                <td>${client.mobile}</td>
                <td>${client.numberOfGoodComments}</td>
                <td>${client.numberOfBadComments}</td>
                <td>${client.numberOfPropositionDeals}</td>
                <td>${client.numberOfTenderDeals}</td>

            </tr>
  </c:forEach>
  </table>
     
        	
</body>
</html>