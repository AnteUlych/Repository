<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>TendersServlet</h2>
 
 ${company}<br>
 
    <form method="POST">
        <table>
            <tr>
                <td>Country From:</td>
                <td><select name="countryFrom">
                      <option value="${htmlFrom}">${htmlFrom}</option>
                      <c:forEach items="${countriesF}" var="countrie" varStatus="step">
	<option value="${countrie}">${countrie}</option>
	</c:forEach>
                       </select>
                                </td>
        
            <tr>
                <td>Country To:</td>
                <td><select name="countryTo">
                     <option value="${htmlTo}">${htmlTo}</option>
                      <c:forEach items="${countriesT}" var="countrie" varStatus="step">
	<option value="${countrie}">${countrie}</option>
	</c:forEach>
                       </select>
                                </td>
            </tr>
             <tr>
                <td>Weight From:</td>
                <td><input type="number" name="weightMore" placeholder="${htmlMore}" value="${htmlMore}" min="0" max="100000"/></td>
            </tr>
             <tr>
                <td>Weight To:</td>
                <td><input type="number" name="weightLess" placeholder="${htmlLess}" value="${htmlLess}" min="0" max="100000"/></td>
            </tr>
             <tr>
                <td>Transport:</td>
                  <td><select name="transport">
                 <option value="${htmlTransport}">${htmlTransport}</option>
                      <c:forEach items="${transports}" var="transport" varStatus="step">
	<option value="${transport}">${transport}</option>
	</c:forEach>
                       </select>
                                </td>
            </tr>
            <tr>
                <td><button type="submit" name="filtr" value="filtr">Filtr</td>
                
            </tr>
           
            
        </table>
    </form>
 
  <br> tenders:<br> 
	<c:forEach items="${tenders}" var="tender" varStatus="step">
	<a href="/lotos/tender/${tender.id}" >${tender.id}</a><br>
	</c:forEach>
	
</body>
</html>