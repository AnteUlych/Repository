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
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right">UP Logistics Group</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s8 w3-bar">
      <span>${company}, ${manager}</span><br>
    </div>
  </div>
  <hr>

  <div class="w3-bar-block">
  
  <c:forEach items="${services}" var="service">
<a href="/crm/service/${privateCode}${service}" class="w3-bar-item w3-button w3-padding">&nbsp; ${service}</a><br>
</c:forEach>
<br>
<a href="/crm/proposition/${today}_${managerId}_${requestId}" class="w3-bar-item w3-button w3-padding">add proposition</a>
<br>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
   <div class="w3-container" id="contact">
    <h2>${route}</h2>
    <i class="fa fa-map-marker" style="width:30px"></i>Parameters: ${size}, ${weight}<br>
    <i class="fa fa-clock-o" style="width:30px"></i>Pick Up: ${readiness}<br>
    <i class="fa fa-thermometer" style="width:30px"> </i>Other: ${other}<br>
    
  </div>
  </header>


  <div class="w3-container">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
	<form method="post">
	<c:forEach items="${propositions}" var="proposition" varStatus="theCount">

<tr>
<td>${proposition.answer}</td>
<td>${proposition.rate}</td>
<td>${proposition.delivery}</td>
<td>${proposition.description}</td>
<td>${proposition.manager}</td>
<td>${proposition.result}</td>


<td><button type="submit" class="w3-button w3-red" name="delete${proposition.id}" value="cancel${proposition.id}" ${taboo[theCount.index]}>delete</td>
<td><button type="submit" class="w3-button w3-green " name="confirm${proposition.id}" value="confirm" ${mayIClick}>confirm</td>

</tr>
<br>
</c:forEach>

</table>
<br>

<input class="w3-input w3-border w3-third" type="text" placeholder="not intersting" value="not intersting" maxlength="50" name="whynot">
<button type="submit"class="w3-button w3-red w3-third" type="submit"  name="cancel" value="cancel" ${mayIClick}>Cancel</button>

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

