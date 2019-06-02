<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>AddTendersServlet</h2>
 
 ${id}<br>
 
    <form method="POST">
        <table>
         <tr>
                <td>Weight:</td>
                <td><input type="number" name="weight" min="0" max="100000"/></td>
            </tr>
            <tr>
                <td>Size:</td>
                <td><input type="text" name="size" ></td>
            </tr>
             <tr>
                <td>Ready to pick up:</td>
                <td><input type="text" name="readytopickup" ></td>
            </tr>
             <tr>
                <td>Delivery:</td>
                <td><input type="text" name="appdelivery" ></td>
            </tr>
              <tr>
                <td>Time End tender:</td>
                <td><input type="date" name="timetoendtender" ></td>
            </tr>    
            <tr>
                <td>Country From:</td>
                <td><select name="countryfrom">
                  <option value="-">-</option>
                      <c:forEach items="${countries}" var="countrie" varStatus="step">
	<option value="${countrie}">${countrie}</option>
	</c:forEach>
                       </select>
                                </td>
        
            </tr>
            
             <tr>
                <td>Country to:</td>
                <td><select name="countryto">
                  <option value="-">-</option>
                      <c:forEach items="${countries}" var="countrie" varStatus="step">
	<option value="${countrie}">${countrie}</option>
	</c:forEach>
                       </select>
                                </td>
        
            </tr>
            
             <tr>
                <td>Transport:</td>
                  <td> <c:forEach items="${transports}" var="transp" varStatus="step">
                       <input type="radio" name="transport" required data-validation-required-message="Please select transport" value ="${transp}"> <label>${transp}</label><br>
		             </c:forEach>
                                </td>
            </tr>
            
            
             <tr>
                <td>Payments:</td>
                  <td> <c:forEach items="${payments}" var="paym" varStatus="step">
                       <input type="radio" name="payment" required data-validation-required-message="Please select transport" value ="${paym}"> <label>${paym}</label><br>
		             </c:forEach>
                                </td>
            </tr>
            
              <tr>
                <td>Payment Days:</td>
                <td><input type="number" name="dayspay" min="0" max="360"/></td>
            </tr>
            
                <tr>
                <td>Information:</td>
                <td><input type="text" name="freightinformationandconditions" ></td>
            </tr>
            
                <tr>
                <td>Visiability:</td>
                  <td> <c:forEach items="${visiabilities}" var="visi" varStatus="step">
                       <input type="radio" name="visiability" required data-validation-required-message="Please select visiability" value ="${visi}"> <label>${visi}</label><br>
		             </c:forEach>
                                </td>
            </tr>
            
             <tr>
                <td>Address to Pick up:</td>
                <td><input type="text" name="addresstopickup" ></td>
            </tr>
            
             <tr>
                <td>Address to Delivery:</td>
                <td><input type="text" name="addresstodelivery" ></td>
            </tr>
            
                    <tr>
                <td>Incoterms:</td>
                  <td> <c:forEach items="${incoterm}" var="inco" varStatus="step">
                       <input type="radio" name="incoterms" required data-validation-required-message="Please select visiability" value ="${inco}"> <label>${inco}</label><br>
		             </c:forEach>
                                </td>
            </tr>
           
              
            <tr>
                <td><button type="submit" name="add" value="add">add</td>
                
            </tr>
           
            
            
        </table>
    </form>
 

	
</body>
</html>