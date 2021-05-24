
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>

<head>
<title>Агротеп</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="resources/css/style.css" />" rel='stylesheet' type='text/css' media="all">
<link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
	<div class="padding-all">
		<div class="header">
			<h1>UA Planner</h1>
		</div>
<br><br><br>
	<br><br>
		
		<div class="footer">
			<div class="design-w3l">
			<div class="mail-form-agile">
				<form method="POST">
					<input type="password"  name="pass" placeholder="Код" required maxlength="9" class="padding" pattern="[^\\/`\/\x22]+"/>
					<input type="submit" value="Вхід">
				</form>
			</div>
		  <div class="clear"> </div>
		</div>
		</div>
	</div>
</body>
</html>