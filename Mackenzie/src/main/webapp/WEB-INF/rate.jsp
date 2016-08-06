<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>LCL FSMAC</title>
<head>
<style>

.tables {
    border-collapse: collapse;
    border: 1px solid black;
}

.borders {
    border: 1px solid black;
}

</style>
</head>

<body>
	<img src="<c:url value="/resources/images/fsm.jpg" />" alt="fsm">
<br />

	<form:form method="POST" commandName="rate">
		<table>
			<tr>
				<td>Weight, t:</td>
				<td><form:select path="tonns">
					  <form:option value="" label="...." />
					  <form:options items="${weight}" />
				       </form:select>
                                </td>
				<td><form:errors path="tonns" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Volume, m3:</td>
				<td><form:select path="m3">
					  <form:option value="" label="...." />
					  <form:options items="${volume}" />
				       </form:select>
                                </td>
				<td><form:errors path="m3" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>FOB </td>
				<td><form:select path="pol">
					  <form:option value="" label="...." />
					  <form:options items="${port}" />
				       </form:select>
                                </td>
				<td><form:errors path="pol" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><form:select path="destination">
					  <form:option value="" label="...." />
					  <form:options items="${city}" />
				       </form:select>
                                </td>
				<td><form:errors path="destination" cssStyle="color: #ff0000;" /></td>
			</tr>
	
			<tr>
		</table>
		<br />
		<input type="submit" name="submit" value="Calculate">
	</form:form>
	
	<br />
	<table class="tables">
  <tr class="borders">
    <th class="borders">Delivery option</th>
    <th class="borders">Rate, USD</th>
    <th class="borders">Details</th>
  </tr>
  <tr class="borders">
    <td class="borders">LCL + Groupage truck</td>
    <td class="borders"  align="center">${consolidateRate}</td>
    <td class="borders">all in up to cnee's Customs terminal</td>
  </tr>
  <tr class="borders">
    <td class="borders">LCL + Separate truck</td>
    <td class="borders" align="center">${separateRate}</td>
    <td class="borders">all in, excl. Customs clearance </td>
  </tr>
  <tr class="borders">
    <td class="borders">LCL to the warehouse in Odessa</td>
    <td class="borders"  align="center">${odessaRate}</td>
    <td class="borders">all in (ready for bonded delivery to the cnee)</td>
  </tr>
</table>
Transit time, days: 34
<br />
The rate is valid 2 weeks
<br />
<a href="http://lcl-ukraine.com/?id=13">Terms and Conditions</a>


</body>
</html>