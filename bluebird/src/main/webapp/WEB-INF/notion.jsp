<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="resources/css/w3.css" rel="stylesheet" />
<head>
<title>UPLG</title>
 <style type="text/css">
 
 body {
    background-image: url("<c:url value="/resources/images/tracing.jpg" />");
background-size: cover;
}
 
 /*Andrii*/
.container {
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
	width: 1000px;
}

header {
	height: 100px;
	width: 100%;
}
header logo {
	position: absolute;
	left: 50%;
	top: 0;
	-webkit-transform: translateX(-50%);
    -ms-transform: translateX(-50%);
    transform: translateX(-50%);
}
/*Andrii*/

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

position: relative;
	width: 100%;
	height: 470px;
	/*top correction*/
	top:150;
 }
 
 


.mark {
  position: absolute;
  top:80;	
         left: 520;
  transform: translate(-50%,-50%);
}
input[type="checkbox"],
input[type="radio"] {
  position: absolute;
  opacity: 0;
  z-index: -1;
}
label {
  position: relative;
  display: inline-block;
  margin-right: 10px;
  margin-bottom: 10px;
  padding-left: 30px;
  padding-right: 10px;
  line-height: 36px;
  cursor: pointer;
}
label::before {
  content: " ";
  position: absolute;
  top: 6px;
  left: 0;
  display: block;
  width: 24px;
  height: 24px;
  border: 2px solid #3385ff;
  border-radius: 4px;
  z-index: -1;
}
input[type="radio"] + label::before {
  border-radius: 18px;
}
/* Checked */
input[type="checkbox"]:checked + label,
input[type="radio"]:checked + label {
  padding-left: 10px;
  color: #fff;
}
input[type="checkbox"]:checked + label::before,
input[type="radio"]:checked + label::before {
  top: 0;
  width: 100%;
  height: 100%;
  background: #3385ff;
}
/* Transition */
label,
label::before {
  -webkit-transition: .25s all ease;
  -o-transition: .25s all ease;
  transition: .25s all ease;
}
textblock{
	 position: absolute;
  top:120;	
         left: 70;
}
.resizedTextbox {width: 370px; height: 100px }

buttonblock{
	 position: absolute;
  top:350;	
         left: 400;

.upbutton {
  display: inline-block;
  padding: 10px 25px;
  font-size: 15px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #0066cc;
  border: none;
  border-radius: 20px;
  
}

.upbutton:hover {background-color: #c2d6d6}

.upbutton:active {
  background-color: #c2d6d6;
 
} 
	<!--!-->
   </style>

</head>

<body>

<!-- for TomCat -->

<!--  Andrii-->
<section id=cabinet">
	<div class="container">
	<!-- / Andrii-->
<!-- fot TomCat -->
<!--!-->
<div class="generalblock">

<!--!-->
<br>
<center>${route}</center>
	<form:form method="POST">
				
				
				<!--<form>-->
				
				<div class="mark">
  
                 <input type="radio" name="rate" id="rb2" value="2" />
                 <label for="rb2">bad</label>
                 <input type="radio" name="rate" id="rb3" value="3" />
                 <label for="rb3">so-so</label>
				 <input type="radio" name="rate" id="rb4" value="4" />
                 <label for="rb4">good</label>
				 <input type="radio" name="rate" id="rb5" value="5" />
                 <label for="rb5">excellent</label>
  
                 </div>
				 <!--
				  <input type="radio" name="rate" value="1"> 1<br>
				  <input type="radio" name="rate" value="2"> 2<br>
				  <input type="radio" name="rate" value="3"> 3<br>
				  <input type="radio" name="rate" value="4"> 4<br>
				  <input type="radio" name="rate" value="5"> 5<br>
				 -->
				   <!-- </form>-->
			<textblock>
			<textarea name="opinion" cols="80" rows="10" maxlength="190"></textarea>
			</textblock>
                <!--<textblock><input name="opinion" placeholder="text" value="" class="resizedTextbox"></textblock>-->
          <!-- <input type="submit" class="upbutton" name="submit" value="send">-->
		   
	<buttonblock>	   
<div class="w3-container">
  <p><button class="w3-button w3-blue w3-round-xxlarge" type="submit">send information</button></p>
</div>
	</buttonblock>	
	</form:form>
</div>
<!--  Andrii-->
	</div>
</section>
<!-- / Andrii-->
</body>
</html>