<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!--<link href="resources/css/w3.css" rel="stylesheet" />-->
<link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet" />
<head>
  <title>UPLG</title>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYtYZUPx_nyCWCUjmVN6RxSeD7fAA4dzo&callback=myMap"> 
          type="text/javascript"></script>
  <style type="text/css">

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
}

generalsector{
   position: absolute;
   top:370;	
   left: 40;  
}
 
 mapsector{
   position: absolute;
   top:30;
   left: 40;   
}
 
commentsector{
   position: absolute;
   top:370;	
   left: 750;   
}
 
   cargosector{
   position: absolute;
   top:30;	
   left: 750;   
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

<!--  for host
<img src="/resources/images/up.jpg" alt="up" width="100%" >
<logo><img src="/resources/images/logo.jpg" alt="logo"  ></logo>
<bottomimage><img src="/resources/images/down.jpg" alt="down" width="98.8%"></bottomimage>

for TomCat
-->
<header>
	<logo><img class="displayed" src="<c:url value="/resources/images/logo.jpg" />" alt="logo"></logo>
</header>
<!--  Andrii-->
<section id=cabinet">
	<div class="container">
	<!-- / Andrii-->

		<!--  fot TomCat -->
		<div class="generalblock">

		<generalsector>
		${client} <br> 
		Last update: ${lastUpdate} <br> 
		Total cargoes: ${totalCargoes} 
		</generalsector>

		<mapsector>
		${generalInformation}
		<br><br>

		 <div id="map" style="width: 690px; height: 290px;"></div>

		 <script type="text/javascript">
		 //   var locations = [
		  //    ['<center>10:00 24/10/2017</center><center>XX 1111 XX</center>', 51.508742,-0.120850,],
		  //    ['<center>10:00 25/10/2017</center><center>XX 1111 XX</center>', 52.395715,4.888916,],
		  //    ['<center>10:00 26/10/2017</center><center>XX 1111 XX</center>', 52.340748, 20.478142,],
		  //  ];  <!---->
		var locations = ${way};
			var map = new google.maps.Map(document.getElementById('map'), {
			  zoom: 4,
			  center: new google.maps.LatLng(50.423648, 30.380058),  <!---->
			  mapTypeId: google.maps.MapTypeId.ROADMAP
			});

			var infowindow = new google.maps.InfoWindow();

			var marker, i;

			for (i = 0; i < locations.length; i++) {  
			  marker = new google.maps.Marker({
				position: new google.maps.LatLng(locations[i][1], locations[i][2]),
				map: map
			  });

			  google.maps.event.addListener(marker, 'click', (function(marker, i) {
				return function() {
				  infowindow.setContent(locations[i][0]);
				  infowindow.open(map, marker);
				}
			  })(marker, i));
			
			}
		//	   var infowindow = new google.maps.InfoWindow({
		//    content: ${lastInfo}  <!---->
		//  });
		//  infowindow.open(map,marker);
			  
		  </script>
		<!--<div id="map" style="width:250%;height:290px"></div>

		<script>
		function myMap() {
		  var placeMap = new google.maps.LatLng(51.508742,-0.120850);
		  var mapCanvas = document.getElementById("map");
		  var mapOptions = {center: placeMap, zoom: 5};
		  var map = new google.maps.Map(mapCanvas, mapOptions);
		  var marker = new google.maps.Marker({position:placeMap});
		  marker.setMap(map);

		  var infowindow = new google.maps.InfoWindow({
			content: "<center>10:00 25/10/2017</center><center>XX 1111 XX</center>"
		  });
		  infowindow.open(map,marker);
		}
		</script>
		 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYtYZUPx_nyCWCUjmVN6RxSeD7fAA4dzo&callback=myMap"></script>
		 -->
		 </mapsector>


		<form method="POST">
		<cargosector>
		cargo in work: 
		<br>

		<br>
		<!--<input type="submit" class="btn btn-link" name="find1" value="FR-45 - Kyiv, 2 pl"> -->
		<c:forEach items="${cargoes}" var="cargo" varStatus="step">
			<input type="hidden" name="cargoid${step.index}" value="${cargo.id}" />
		 <input type="submit" class="upbutton" name="find${step.index}" value="${cargo.description}">
		<br>
		</c:forEach>
		<!--  
		<input type="submit" class="upbutton" name="find1" value="FR-45 - Kyiv, 2 pl">
		<br>
		<input type="submit" class="upbutton" name="find2" value="DE-60 - Kyiv, 1 pl">
		<br>
		<input type="submit" class="upbutton" name="find3" value="RO-5  - Kyiv, 15 pl">
		-->
		</cargosector>
		<commentsector>
				Help us make our service<br /> better. Leave Your mark: 
				
				<br />
				<input type="submit" class="upbutton" name="comment" value="opinion">
		<commentsector/>

			</form>
		</div>
<!--  Andrii-->
	</div>
</section>
<!-- / Andrii-->

<!-- old version !!!!!
 Cargo<br> 

 ${lastUpdate}<br> 
 ${totalCargoes}
${way}
<br> 
 <br> 
<c:forEach items="${cargoes}" var="cargo">
${cargo.description}
 <br>
</c:forEach>

<c:forEach items="${waybill}" var="way">
${way.longitude}
 <br>
 
</c:forEach>

<form method="POST">
	<c:forEach items="${cargoes}" var="cargo" varStatus="step">
	<input type="hidden" name="cargoid${step.index}" value="${cargo.id}" />
${cargo.id} <input type="submit" class="btn btn-link" name="find${step.index}" value="${cargo.description}">
<br>
</c:forEach>

<c:choose>
    <c:when test="${needComment}">
        Say as how could we make our service better 
        <br />
        <input type="submit" class="btn btn-link" name="comment" value="comment">
    </c:when>    
    <c:otherwise>
        You`ve already give a rate. 
        <br />
    </c:otherwise>
</c:choose>


	</form>
 -->
</body>
</html>