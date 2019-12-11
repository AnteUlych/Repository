 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<html>
<title>Агротеп</title>
<meta http-equiv="refresh" content="30"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">-->
<link rel="stylesheet" href="<c:url value="/resources/w3.css" />">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

.tooltip {
  position: relative;
  display: inline-block;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
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

</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"> <a href="/tender/login" ><i class="fa fa-sign-out fa-fw"></i></a></span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    
    <div class="w3-col s8 w3-bar">
      <span><strong>${name}</strong></span><br>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Меню</h5>
  </div>
  <div class="w3-bar-block">
    <a href="/tender/auction" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/tender/auction" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-legal fa-fw"></i>&nbsp; Тендер автомобілів</a>
    <a href="/tender/sold" class="w3-bar-item w3-button w3-padding"><i class="fa fa-lock fa-fw"></i> ${alertSold} &nbsp; Заброньовані автомобілі </a>
    <a href="/tender/clientspropositions" class="w3-bar-item w3-button w3-padding"><i class="fa fa-volume-control-phone fa-fw"></i>&nbsp; Пропозиції клієнтів</a>
    <a href="/tender/deals/all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck fa-fw"></i>&nbsp; План відвантажень</a>
    <a href="/tender/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-id-card-o fa-fw"></i>&nbsp; Кадрова інформація</a>
    <a href="/tender/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart fa-fw"></i>&nbsp; Місячна звітність</a>
    <a href="/tender/addauction" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-balance-scale fa-fw"></i>&nbsp; Додати Тендер</a><br><br>

  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-legal"></i> Тендер</b></h5>
  </header>

  <div class="w3-row-padding w3-hoverable w3-margin-bottom">
    <div class="w3-half">
     <h5>Export</h5>
        <table class="w3-table w3-striped w3-white">
		
		<c:forEach items="${exportAuctions}" var="exportInfo" varStatus="theCount">
<tr class="${exportColors[theCount.index]}">	
<td><div class="tooltip"><i class="${exportIcons[theCount.index]}"></i><span class="tooltiptext">${exportInfo.date}</span></div></td>
<td><a href="/tender/bets/${exportInfo.id}">${exportInfo.route}</a></td>
<td>${exportInfo.truck}</td>
<td>${exportInfo.trucksclosed}/${exportInfo.trucks}</td>
<td>${exportInfo.readiness}</td>
<td>${exportInfo.rate} ${exportInfo.currency}</td>
<td>${exportInfo.betcount}</td>

</tr>
</c:forEach>  
        </table>
    </div>
	
        <div class="w3-half">
     <h5>Import</h5>
        <table class="w3-table w3-striped w3-white">
		
		<c:forEach items="${importAuctions}" var="importInfo" varStatus="theCount">
<tr class="${importColors[theCount.index]}">	
<td><div class="tooltip"><i class="${importIcons[theCount.index]}"></i><span class="tooltiptext">${importInfo.date}</span></div></td>
<td><a href="/tender/bets/${importInfo.id}">${importInfo.route}</a></td>
<td>${importInfo.truck}</td>
<td>${importInfo.trucksclosed}/${importInfo.trucks}</td>
<td>${importInfo.readiness}</td>
<td>${importInfo.rate} ${importInfo.currency}</td>
<td>${importInfo.betcount}</td>

</tr>
</c:forEach>  
        </table>
        <br><br><br>
    </div>
  </div>

  <!-- End page content -->
</div>
<script>
${messagealert}

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