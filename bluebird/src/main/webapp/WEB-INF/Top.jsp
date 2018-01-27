<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>UPLG</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
td {
  text-align: center;
  vertical-align: middle;
}
</style>
</head>
<body>
 Total transportations - ${allActiveCargoes}
	<br><br>
<table>
  <tr>
 <th>Marks</th><th>Clients</th>
 </tr>
 <tr>
	<td>never again</td><td>${mark1}</td>
	 </tr>
 <tr>
	 <td>bad servise</td><td>${mark2}</td>
	 </tr>
 <tr>
	 <td>so-so</td><td>${mark3}</td>
	 </tr>
 <tr>
	 <td>good service</td><td>${mark4}</td>
	 </tr>
 <tr>
	 <td>excellent service</td><td>${mark5}</td>
	 </tr>
</table>
	<br>
	<br>
	<a href="/tracing/top/allReviews">reviews</a><br>
	<a href="/tracing/top/allVisitors">visitors</a>
	<br><br>
	<c:forEach items="${active}" var="cargo">
		${cargo.client} - ${cargo.description};
		<br>
	</c:forEach>
	<br>

</body>
</html>