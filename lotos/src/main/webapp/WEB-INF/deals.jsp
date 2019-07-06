<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>DealsServlet</h2>
 
 ${logo}<br>
 
 
  <br> deals:<br> 
	<c:forEach items="${deals}" var="deal" varStatus="step">
	<a href="/lotos/deal/${deal.id}" >${deal.countryfrom} - ${deal.countryto}</a><br>
	</c:forEach>
	
</body>
</html>