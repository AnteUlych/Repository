 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>

<!DOCTYPE html>
<html>
<title>�������</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 180px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
  position: absolute;
  z-index: 1;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}

.container{ width:100%; }    
.align-left{ float: left;width:50%; }
.align-right{ float: right;width:50%; }

</style>
<body class="w3-white">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"> <a href="/planner/login" ><i class="fa fa-sign-out fa-fw"></i></a></span>

</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-card" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s8 w3-bar">
      <span>${name}</span><br>
    </div>
  </div>
  <hr>
  <div class="w3-bar-block">
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-heartbeat"></i>&nbsp; ������</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck w3-text-blue"></i>&nbsp; ��������</a>
    <a href="/planner/clients" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-child w3-text-green"></i>&nbsp; ��볺���</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group w3-text-brown"></i>&nbsp; ������</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-line-chart w3-text-pink"></i>&nbsp; ����������</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; ������</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-truck w3-text-green"></i> ���������� ���� ${truckHtml} �� ${dateStart}</b></h5>
  </header>
 <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-third">
        <h5>������� �����: ${lastAddress}</h5>
        
        <form method="post">
        
		<button type="submit" class="w3-button w3-round-xxlarge w3-blue-grey" name="wait" formnovalidate>���������</button>
		
		<div id="locationField">
        <p><input id="autocomplete" name="googleAddress" class="w3-input w3-border" type="text" placeholder="�������� ������������" required>   </p>
        </div>
		<p><input class="w3-input w3-border" name="priceFromClient" type="number" placeholder="���" value="${valuePrice}" required>  </p>
		<p><input class="w3-input w3-border" name="infoClient" type="text" placeholder="��������" value="${valueInfo}" required pattern="[^\\/`\/\x22]+">  </p>
		<br>
        <p>${calculateTo}</p>
		<p>${priceForKm}</p>
		<br>
		<div class='container'>

          <p id="demo0"></p>
             <p id="demo1"></p>
	<p id="demo2"></p>
	
		
			
			<input type="hidden" class="field" name ="street_number" id="street_number" disabled="true">
			
			<input type="hidden" class="field" name ="route" id="route" disabled="true">
		
			<input type="hidden" class="field" name ="locality" id="locality" disabled="true"></input>
		<input type="hidden" class="field" name ="administrative_area_level_1" id="administrative_area_level_1" disabled="true">
		<input type="hidden" class="field" name ="postal_code" id="postal_code" disabled="true">
		<input type="hidden" class="field" name ="country" id="country" disabled="true">

	</form>
	
</div>
		<br>
		
      </div>
      <div class="w3-twothird">
        <h5>�볺��� ${lastOblast}</h5>
        <table class="w3-table w3-striped w3-white">
         <c:forEach items="${clients}" var="client" varStatus="theCount">
          <tr class = "${client.blacklist}" >
            <td><a href="/planner/client/${client.id}" target="_blank">${client.company}</a></td>
            <td>${client.typetruck}</td>
            <td>${client.cargo}</td>
			<td>${client.posibilityToGo}</td>
          </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
 
  
</div>
<br>
  <div class="w3-container">

    

  </div>

  <hr>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDvzr8p07fENAftZAumRG2tdfOE8VJQDwE&libraries=places&callback=initAutocomplete&language=uk" async defer></script>


<script>

var placeSearch, autocomplete;
var componentForm = {
	street_number: 'short_name',
	route: 'long_name',
	locality: 'long_name',
	administrative_area_level_1: 'short_name',
	country: 'long_name',
	postal_code: 'short_name'
};

function initAutocomplete() {
	autocomplete = new google.maps.places.Autocomplete(
		(document.getElementById('autocomplete')), {
			types: ['geocode'],			
componentRestrictions: {country: "UA"}
		});
	autocomplete.addListener('place_changed', fillInAddress);
}

function fillInAddress() {

	var place = autocomplete.getPlace();
	
	for (var component in componentForm) {
		document.getElementById(component).value = '';
		document.getElementById(component).disabled = false;
	}
	for (var i = 0; i < place.address_components.length; i++) {
		var addressType = place.address_components[i].types[0];
		if (componentForm[addressType]) {
			var val = place.address_components[i][componentForm[addressType]];
			document.getElementById(addressType).value = val;
		}
	}
	
	console.log(place.geometry.location.lng());
	console.log(place.geometry.location.lat());
	var longitude= place.geometry.location.lng();
	var latitude= place.geometry.location.lat();
	document.getElementById('demo1').innerHTML = '<input type="hidden" name="lng"  id="demo1" value="'+longitude+'"></input>';
	document.getElementById('demo2').innerHTML = '<input type="hidden" name="lat" id="demo2" value="'+latitude+'"></input>';
	document.getElementById('demo0').innerHTML = '<div class="align-left"><button type="submit" class="w3-button w3-round-xxlarge w3-blue" name="calculate">�����������</button></div><div class="align-right"><button class="w3-button w3-round-xxlarge w3-green" name="book">���������</button></div>';
}



// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>