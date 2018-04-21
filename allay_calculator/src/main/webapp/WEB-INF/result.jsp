<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<title>test_result</title>
</head>

<body>
<form method="post">
	${waybill}<br>
	${seaRate}<br>
	${seaTime}<br>
	<input type="submit"  name="booking" value="sea">
	<div ng-show="${rail}">
    ${railRate}<br>
	${railTime}<br>
	<input type="submit"  name="booking" value="rail">
</div>
	<br>
</form>	
	
</body>
</html>