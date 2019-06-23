<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>AddPropositionServlet</h2>
 
 ${logo}<br>
 <br>
  ${tender.company}: ${tender.countryfrom} - ${tender.countryto},${tender.weight},
  ${tender.size}<br>
 <br>
 <br>
    <form method="POST">
        <table>
     
            <tr>
                <td>Pick Up:</td>
                <td><input type="text" name="pickup" ></td>
            </tr>
             <tr>
                <td>Delivery Date:</td>
                <td><input type="text" name="deliverydate" ></td>
            </tr>
             <tr>
                <td>Other information:</td>
                <td><input type="text" name="otherinformation" ></td>
            </tr>
               <tr>
                <td>Price:</td>
                <td><input type="number" name="price" > 
                <c:forEach items="${currencies}" var="cure" varStatus="step">
                       <input type="radio" name="currency" required data-validation-required-message="Please select visiability" value ="${cure}"> <label>${cure}</label>
		             </c:forEach></td>
            </tr>   
            
                 <tr>
                <td>Transport:</td>
                  <td> <c:forEach items="${transports}" var="tran" varStatus="step">
                       <input type="radio" name="transport" required data-validation-required-message="Please select visiability" value ="${tran}"> <label>${tran}</label><br>
		             </c:forEach>
                                </td>
            </tr>
           
              
            <tr>
                <td><button type="submit" name="add" value="add">add</td>
                
            </tr>
           
            
            
        </table>
    </form>
 
<a href="/lotos/tender/${tender.id}" >back</a><br>
<a href="/lotos/tenders" >tenders</a><br>
<a href="/lotos/company/${id}">own page</a><br>
	
</body>
</html>