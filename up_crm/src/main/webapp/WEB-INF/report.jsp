<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<title>UPLG CRM</title>
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
<div class="w3-bar w3-top w3-black" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right">
   <form method="post"> 
 from:<input type="date" required name="start">
to:<input type="date" required name="end">
 <button type="submit" class="w3-button w3-black" name="filter" value="filter">Filter</button>
</form>
  </span>
</div>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">

    <h5><b>Manager`s request report:</b></h5>
  </header>


  <div class="w3-container">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	 <tr>
      <th>#</th>
      <th>Manager</th>
      <th>Auto all</th>
      <th>SAR all</th>
      <th>Auto not calculated</th>
      <th>SAR not calculated</th>
      <th>Auto refused</th>
      <th>SAR refused</th>
      <th>Auto bookings</th>
      <th>SAR bookings</th>
      <th>Given propositions</th>
      <th>Booked propositions</th>
    </tr>
	<c:forEach items="${managersReport}" var="manager" varStatus="theCount">
<tr>
<td>${theCount.index+1}</td>	
<td>${manager.name}</td>
<td>${manager.allAuto}</td>
<td>${manager.allSar}</td>
<td>${manager.notCalcAuto}</td>
<td>${manager.notCalcSar}</td> 
<td>${manager.refuseAuto}</td>
<td>${manager.refuseSar}</td>
<td>${manager.bookedAuto}</td>
<td>${manager.bookedSar}</td>
<td>${manager.propositions}</td>
<td>${manager.booked}</td>
</tr>
</c:forEach>   
    </table><br>
  </div>
  <hr>
<br>

 <!-- Header -->
  <header class="w3-container" style="padding-top:5px">

    <h5><b>Client`s situation report:</b></h5>
  </header>


  <div class="w3-container">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	 <tr>
      <th>#</th>
      <th>Company</th>
      <th>Category</th>
      <th>Manager</th>
      <th>Requests</th>
      <th>Bookings</th>
    </tr>
	<c:forEach items="${clientsReport}" var="client" varStatus="theCount">
<tr>
<td>${theCount.index+1}</td>	
<td>${client.company}</td>
<td>${client.category}</td>
<td>${client.manager}</td>
<td>${client.requests}</td>
<td>${client.bookings}</td>

</tr>
</c:forEach>   
    </table><br>
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

