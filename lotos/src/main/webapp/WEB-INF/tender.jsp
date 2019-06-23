<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>TenderServlet</h2>
 
 ${isOwnTender}<br>
 ${logo}<br>
 
 <br>
  ${tenderCompany}<br>
  ${tenderFrom} - ${tenderTo}, ${tenderWeight} t, ${tendeVolume}<br>

 <br>
 propositions:
 <br>
    <form method="POST">
        <table>
        <c:forEach items="${propositions}" var="proposition" varStatus="step">
             <tr>
                <td>${proposition.company}</td>
                <td>${proposition.price}</td>
                <td>${proposition.currency}</td>
                <td><button type="submit" name="delete${proposition.id}" value="delete${proposition.id}">delete</td>
                <td><button type="submit" name="confirm${proposition.id}" value="confirm${proposition.id}">confirm</td>
            </tr> 
        </c:forEach>
        </table>
    </form>
 
  <br> 

	<a href="/lotos/addProposition/${tenderId}" >add proposition</a><br>
<a href="/lotos/tenders" >tenders</a><br>
<a href="/lotos/company/${id}">own page</a><br>
	
</body>
</html>