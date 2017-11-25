<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="resources/css/w3.css" rel="stylesheet" />
<head>
<title>Cabinet</title>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYtYZUPx_nyCWCUjmVN6RxSeD7fAA4dzo&callback=myMap"> 
          type="text/javascript"></script>
<style type="text/css">

 logo{
		position: relative;		
         left: 60px; 
	}

.generalblock{

font-weight:bold;
position: absolute;
left: 550;
top:160;
width: 400px;
height: 270px;
 }
 
.upbutton {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #cccacc), color-stop(1, #dfdfdf));
	background:-moz-linear-gradient(top, #cccacc 5%, #dfdfdf 100%);
	background:-webkit-linear-gradient(top, #cccacc 5%, #dfdfdf 100%);
	background:-o-linear-gradient(top, #cccacc 5%, #dfdfdf 100%);
	background:-ms-linear-gradient(top, #cccacc 5%, #dfdfdf 100%);
	background:linear-gradient(to bottom, #cccacc 5%, #dfdfdf 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#cccacc', endColorstr='#dfdfdf',GradientType=0);
	background-color:#cccacc;
	-moz-border-radius:10px;
	-webkit-border-radius:10px;
	border-radius:10px;
	display:inline-block;
	cursor:pointer;
	color:#5c5c5c;
	font-family:Arial;
	font-size:12px;
	font-weight:bold;
	height:35px;
	line-height:38px;
width:169px;
	text-decoration:none;
	text-align:center;
	text-shadow:0px 1px 0px #ffffff;
}
.upbutton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #cccacc));
	background:-moz-linear-gradient(top, #dfdfdf 5%, #cccacc 100%);
	background:-webkit-linear-gradient(top, #dfdfdf 5%, #cccacc 100%);
	background:-o-linear-gradient(top, #dfdfdf 5%, #cccacc 100%);
	background:-ms-linear-gradient(top, #dfdfdf 5%, #cccacc 100%);
	background:linear-gradient(to bottom, #dfdfdf 5%, #cccacc 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#cccacc',GradientType=0);
	background-color:#dfdfdf;
}
.upbutton:active {
	position:relative;
	top:1px;
	
}

bottomimage{
		position:absolute;
		bottom: 0;
		width:99%;
	}
</style>
</head>

<body>

	<img class="displayed" src="<c:url value="/resources/images/up.jpg" />" alt="up" width="100%">

<bottomimage><img class="displayed" src="<c:url value="/resources/images/down.jpg" />" alt="down" width="98.8%"></bottomimage>
<div class="generalblock">
	<form:form method="POST" commandName="password">

		<table>
		<tr>
		<td><logo><img class="displayed" src="<c:url value="/resources/images/logo.jpg" />" alt="logo"></logo></td>
		</tr>
		
		<tr>
		<td>&nbsp;</td>
		</tr>
		
			<tr>
				<td><form:password path="login"  showPassword="true" placeholder="username"/></td>
				<!--<td><form:errors path="login" cssStyle="color: #ff0000;"/></td>-->
			<tr>
				<td><form:password path="password" showPassword="true" placeholder="password"/></td>
			<tr>
				 <td><center>&nbsp;<form:errors path="password" cssStyle="color: #ff0000;"/></center></td>
			</tr>
			<tr>
			<br>
				<td><center><input type="submit" class="upbutton" name="submit" value="tracking out"></center></td>
			</tr>
			<tr>
		</table>
	</form:form>
</div>
</body>
</html>		