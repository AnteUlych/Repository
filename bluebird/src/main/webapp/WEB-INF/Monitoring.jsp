<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="resources/css/w3.css" rel="stylesheet" />
<head>
<title>Monitoring</title>
</head>

<body>

<div class="w3-bar w3-light-grey">
<div class="w3-bar-item">
<form method="post">
		Enter key:
				<input type="password" name="key" maxlength="10"  />			
				<input type="submit" name="submit" value="Send Monitoring" class="w3-button">
			
	</form>
	</div>
  
</div>

<div class="w3-row">
<div class="w3-col" style="width:20%"><p></p>
</div>

<div class="w3-col" style="width:60%">
<h2>Active Cargoes</h2>
  <table class="w3-table-all w3-hoverable w3-centered" >
    <thead>
      <tr class="w3-light-grey">
        <th>Number</th>
        <th>Client</th>
        <th>Description</th>
        <th>ETD</th>
        <th>Update</th>
      </tr>
    </thead>
        <c:set var="update" value="${updates}" />
		<c:forEach items="${active}" var="cargo" varStatus="theCount">

                  <tr>
      <td>${theCount.count}</td>
      <td> ${cargo.client}</td>
      <td>${cargo.description}</td>
      <td>${cargo.delivery}</td>
      <td> ${update[theCount.index]}</td>
    </tr> 
		</c:forEach>
		</table>
</div>
<div class="w3-col" style="width:20%">
</div>
</div>


</body>
</html>