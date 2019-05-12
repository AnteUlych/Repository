<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>

<body>
	CompanyServlet ${companyId}
	<br> ${id}
	<br> company - ${company.company}
	<br> isOwnCompany : ${isOwnCompany}
	<br> numberOfTenders = ${numberOfTenders}
	<br> numberOfGoodRecomendations = 
	<a href="/lotos/recomendations/${company.id}" >${numberOfGoodRecomendations}</a><br>
	<br> numberOfBadRecomendations = 
	<a href="/lotos/recomendations/${company.id}" >${numberOfBadRecomendations}</a><br>
	<br> numberOfClosingTenders = ${numberOfClosingTenders}
	<br> numberOfWinningPropositions = ${numberOfWinningPropositions}
	<br>
	<br> 
	
    <br> tenders:<br> 
	<c:forEach items="${companyTenders}" var="tender" varStatus="step">
	<a href="/lotos/tender/${tender.id}" >${tender.id}</a><br>
	</c:forEach>
	
	 <br> propositions:<br> 
	<c:forEach items="${companyProposition}" var="proposition" varStatus="step">
	<a href="/lotos/tender/${proposition.tenderid}" >${proposition.tenderid}</a><br>
	</c:forEach>
	
	 <br> deals:<br> 
	<c:forEach items="${companyDeal}" var="deal" varStatus="step">
	<a href="/lotos/deal/${deal.id}" >${deal.id}</a><br>
	</c:forEach>
	
		<br> tender propositions<br> 		
		<c:forEach items="${propositions}" var="tenderPropositions" varStatus="step">
			propos - ${tenderPropositions.id}<br>	
		</c:forEach>
			

</body>
</html>