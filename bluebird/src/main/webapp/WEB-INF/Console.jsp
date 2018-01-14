<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="resources/css/w3.css" rel="stylesheet" />
<head>
<title>CS</title>
</head>

<body>

<div class="w3-bar w3-light-grey">
<div class="w3-bar-item">
<form:form method="POST" commandName="freight">
		Enter description:
				<form:input path="description" />
				<form:errors path="description" cssStyle="color: #ff0000;"/>
			
				Please select client:
				<form:select path="client">
					  <form:option value="" label="...." />
					  <form:options items="${clients}" />
				       </form:select>
               <form:errors path="client" cssStyle="color: #ff0000;" />
			
				<input type="submit" name="submit" value="Add" class="w3-button">
			
	</form:form>
	</div>
  <a href="addClient" class="w3-button w3-right">add new client</a>


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
      </tr>
    </thead>
		<c:forEach items="${active}" var="cargo" varStatus="theCount">

                  <tr>
      <td>${theCount.count}</td>
      <td> ${cargo.client}</td>
      <td><a href="route/${cargo.id}">${cargo.description}</a></td>
    </tr> 
		</c:forEach>
		</table>
</div>
<div class="w3-col" style="width:20%">
</div>
</div>


<!--		<br>
	<h2>add cargo</h2>
	<form:form method="POST" commandName="freight">
		Enter description:
				<form:input path="description" />
				<form:errors path="description" cssStyle="color: #ff0000;"/>
			
				Please select client:
				<form:select path="client">
					  <form:option value="" label="...." />
					  <form:options items="${clients}" />
				       </form:select>
               <form:errors path="client" cssStyle="color: #ff0000;" />
			
				<input type="submit" name="submit" value="Submit">
			
	</form:form>
	-->
</body>
</html>