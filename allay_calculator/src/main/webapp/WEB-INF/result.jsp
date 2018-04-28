<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<title>test_result</title>
</head>

<body>
<form method="post">
	${waybill}<br>
	LCL:
	lcl tariff - ${seaRate} USD;<br>
	Delivery date - ${seaTime} days;<br>
	<input type="submit"  name="booking" value="sea">
	<div ng-show="${rail}">
	Rail:
    Rail tariff - ${railRate} USD;<br>
	Delivery date - ${railTime} days;<br>
	<input type="submit"  name="booking" value="rail">
</div>
<br>
- the rate is calculated for a consolidated non-dangerous cargo;<br>
- payment is possible in UAH, USD and EUR;<br>
- delivery for warehouse of Client.
	<br>
</form>	
	
</body>
</html>