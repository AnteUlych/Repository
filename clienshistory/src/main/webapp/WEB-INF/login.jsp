
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>

<head>
<title>Агротеп</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="resources/css/style.css" />" rel='stylesheet' type='text/css' media="all">
<link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<style>

.loader {
  border: 2px solid #FFFFFF;
  border-radius: 50%;
  border-top: 2px solid DodgerBlue;
  border-bottom: 2px solid DodgerBlue;
  width: 20px;
  height: 20px;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>

<body>
	<div class="padding-all">
		<div class="header">
			<h1>Customer Relationship Management</h1>
		</div>
<br><br><br>
		<div class="design-w3l">
			<div class="mail-form-agile">
				<form method="POST"  id="frm">
					<input type="password"  name="code" placeholder="Код" required maxlength="7" class="padding"/>
					<p id="demo">
					<input type="submit" name="send" id="send" value="Вхід">
					</p>
				</form>
			</div>
		  <div class="clear"> </div>
		</div>
		
		<div class="footer">
		<p>© 2023</p>
		</div>
	</div>
	<script>
	$('#frm').bind('submit', function (e) {
	    var button = $('#send');

	    // Disable the submit button while evaluating if the form should be submitted
	    button.prop('disabled', true);
	    document.getElementById("demo").innerHTML = "<center><div class=\"loader\"></div></center>";
	    var valid = true;    

	    // Do stuff (validations, etc) here and set
	    // "valid" to false if the validation fails

	    if (!valid) { 
	        // Prevent form from submitting if validation failed
	        e.preventDefault();
	        document.getElementById("demo").innerHTML = "<input type=\"submit\" name=\"send\" id=\"send\" value=\"Вхід\" title=\"test\">";
	        // Reactivate the button if the form was not submitted
	        button.prop('disabled', false);
	    }
	});
</script>
</body>
</html>