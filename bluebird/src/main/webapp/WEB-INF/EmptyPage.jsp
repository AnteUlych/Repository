<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Cabinet</title>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYtYZUPx_nyCWCUjmVN6RxSeD7fAA4dzo&callback=myMap"> 
          type="text/javascript"></script>
  <style type="text/css">
  .generalblock{
background: rgba(255,255,255,1);
background: -moz-linear-gradient(left, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -webkit-gradient(left top, right top, color-stop(0%, rgba(255,255,255,1)), color-stop(47%, rgba(246,246,246,1)), color-stop(100%, rgba(237,237,237,1)));
background: -webkit-linear-gradient(left, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -o-linear-gradient(left, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: -ms-linear-gradient(left, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
background: linear-gradient(to right, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=1 );

border-radius: 17px 17px 17px 17px;
-moz-border-radius: 17px 17px 17px 17px;
-webkit-border-radius: 17px 17px 17px 17px;
border: 0px solid #000000;

-webkit-box-shadow: 2px 4px 5px -1px rgba(0,0,0,0.75);
-moz-box-shadow: 2px 4px 5px -1px rgba(0,0,0,0.75);
box-shadow: 2px 4px 5px -1px rgba(0,0,0,0.75);

font-weight:bold;
position: absolute;
left: 200;
top:60;
width: 1000px;
height: 470px;
 }
 

  commentsector{
   position: absolute;
   top:170;	
   left: 380;   
 }
 

 
 logo{
		position:absolute;
		 top:80;	
         left: 50; 
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
<!--  fot TomCat -->
<img class="displayed" src="<c:url value="/resources/images/up.jpg" />" alt="up" width="100%">
<logo><img class="displayed" src="<c:url value="/resources/images/logo.jpg" />" alt="logo"></logo>
<bottomimage><img class="displayed" src="<c:url value="/resources/images/down.jpg" />" alt="down" width="98.8%"></bottomimage>
<!--  fot TomCat -->

<div class="generalblock">
<commentsector>
       no active transportations
        <br />
		<br />
	   <form action="http://uplg.com.ua">
    <input type="submit" class="upbutton" value="visit site" />
</form>
<commentsector/>


</div>
</body>
</html>