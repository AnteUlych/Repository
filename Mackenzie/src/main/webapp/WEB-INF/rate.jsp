<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

box {
	border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	-webkit-border-radius: 10px 10px 10px 10px;
	border: 0px solid #000000;
	-webkit-box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
	-moz-box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
	box-shadow: 10px 10px 41px -1px rgba(0, 0, 0, 0.75);
	position: relative;
	left: 310px;
	top: 40px;
	padding-right: 670px;
	padding-bottom: 370px;;
	background-color: white;
}

position {
	position: relative;
	top: 40px;
	left: 350px;
}

img {
	position: relative;
	right: 190px;
}
</style>
</head>

<body>

	<box></box>
	<img src="<c:url value="/resources/images/fsm.jpg" />" alt="fsm">
	<position> <br />

	<form:form method="POST" commandName="rate">
		<table>
			<tr>
				<td>Weight, t:</td>
				<td><form:select path="tonns">
						<form:option value="" label="...." />
						<form:options items="${weight}" />
					</form:select></td>
				<td><form:errors path="tonns" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Volume, m3:</td>
				<td><form:select path="m3">
						<form:option value="" label="...." />
						<form:options items="${volume}" />
					</form:select></td>
				<td><form:errors path="m3" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>FOB</td>
				<td><form:select path="pol">
						<form:option value="" label="...." />
						<form:options items="${port}" />
					</form:select></td>
				<td><form:errors path="pol" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td>Destination:</td>
				<td><form:select path="destination">
						<form:option value="" label="...." />
						<form:options items="${city}" />
					</form:select></td>
				<td><form:errors path="destination" cssStyle="color: #ff0000;" /></td>
			</tr>

			<tr>
		</table>

		<br />
		<input type="submit" name="submit" value="Calculate">
	</form:form> </bord> <br />
	<table class="tables">
		<tr class="borders">
			<th class="borders">Delivery option</th>
			<th class="borders" align="center">Rate, USD</th>
			<th class="borders">Details</th>
		</tr>
		<tr class="borders">
			<td class="borders">LCL + Groupage truck</td>
			<td class="borders" align="center">${consolidateRate}</td>
			<td class="borders">all in up to cnee's Customs terminal</td>
		</tr>
		<tr class="borders">
			<td class="borders">LCL + Separate truck</td>
			<td class="borders" align="center">${separateRate}</td>
			<td class="borders">all in, excl. Customs clearance </td>
		</tr>
		<tr class="borders">
			<td class="borders">LCL to the warehouse in Odessa</td>
			<td class="borders" align="center">${odessaRate}</td>
			<td class="borders">all in (ready for bonded delivery to the
				cnee)</td>
		</tr>
	</table>
	Transit time, days: 34 <br />
	The rate is valid 2 weeks <br />
	<a href="http://lcl-ukraine.com/?id=13">Terms and Conditions</a> </position>

</body>
</html>