<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<title>AGROTEP</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"><a href="/probe/calculator" >Calculator</a></span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>

  <hr>

  <div class="w3-bar-block">
  
<a href="/probe/transports/export" class="w3-bar-item w3-button w3-padding">&nbsp; Export</a><br>
<a href="/probe/transports/import" class="w3-bar-item w3-button w3-padding">&nbsp; Import</a><br>
<a href="/probe/transports/europe" class="w3-bar-item w3-button w3-padding">&nbsp; Europe</a><br>
<a href="/probe/transports/ukraine" class="w3-bar-item w3-button w3-padding">&nbsp; Ukraine</a><br>
<br>
<a href="/probe/addtransport/" class="w3-bar-item w3-button w3-padding">add transport</a>
<br>

  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b>Add Transport:</b></h5>
  </header>


  <div class="w3-container">
    <p></p>
    <form method="post">
      <p><input class="w3-input w3-border" type="text" placeholder="Readiness" maxlength="100" required name="readiness"></p>
	  <p><input class="w3-input w3-border" type="text" placeholder="Route" maxlength="140" required name="route"></p>
	  <p><input class="w3-input w3-border" type="text" placeholder="Information" maxlength="500" required name="information"></p>
	  <p><input class="w3-input w3-border" type="text" placeholder="Truck and Driver" maxlength="215" required name="truckdriver"></p>
	  <br>
	   Direction:<br>
				<select required name="direct">
					  <c:forEach items="${directions}" var="di" varStatus="step">
					   <option value="${di}">${di}</option>
					  </c:forEach>
				       </select>
					   <br>
					   <br>
    
<br>
	 
    <button type="submit" class="w3-button w3-green w3-third" name="add" value="add">Add Transport</button>
    </form>
  </div>
  <hr>

  <!-- End page content -->
</div>

<script>
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

