<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="https://www.w3schools.com/w3css/4/w3.css" rel="stylesheet" />
<head>
    
<title>UPLG</title>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYtYZUPx_nyCWCUjmVN6RxSeD7fAA4dzo&callback=myMap"> 
          type="text/javascript"></script>
 <style>


div.signbut {
    position: relative;
    left: 170 ;
}
</style>
</head>

<body>
<div class="w3-bar w3-light-grey">
<div class="w3-bar-item">

	</div>
</div>

<div class="w3-row">
  <div class="w3-half w3-container">
  <br>
   ${cargo.description} 


<br>
<br>
  <form method="post">
	
<input name="longitude"  value="" placeholder="longitude"><br>
<input name="latitude"  value="" placeholder="latitude"><br>
<input name="status"  value="" placeholder="status"><br>	

<br>
<input type = "checkbox" name = "finish" /> finish route  <input type="submit" class="w3-button w3-white w3-border w3-circle"  name="add" value="+">	      

</form>

     <div id="map" style="width: 490px; height: 290px;"></div>

 <script type="text/javascript">
  <!--??-->
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
  
  </script>
  </div>
  <div class="w3-half w3-table w3-bordered w3-hoverable w3-striped">
   <table>
    <thead>
      <tr class="w3-light-grey">
        <th>Longitude</th>
        <th>Latitude</th>
        <th>Status</th>
		<th>Edit</th>
      </tr>
    </thead>
<c:forEach items="${route}" var="information">
<tr>
<td>${information.longitude}</td>
<td>${information.latitude}</td>
<td>${information.status}</td>
<td><a href="/tracing/editRoute/${information.id}">edit</a><t/d>
</tr>
<br>

</c:forEach>
</table>
  </div>
</div>

</body>

</html>