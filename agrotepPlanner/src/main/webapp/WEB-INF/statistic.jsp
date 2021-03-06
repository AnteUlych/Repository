 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>

<!DOCTYPE html>
<html>
<title>�������</title>
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
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding"><i class="fa fa-heartbeat w3-text-red"></i>&nbsp; ������</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck w3-text-blue"></i>&nbsp; ��������</a>
    <a href="/planner/clients" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-child w3-text-green"></i>&nbsp; ��볺���</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group w3-text-brown"></i>&nbsp; ������</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding   w3-blue"><i class="fa fa-line-chart"></i>&nbsp; ����������</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; ������</a>
    <a href="/planner/variants" class="w3-bar-item w3-button w3-padding"><i class="fa fa-arrows w3-text-indigo"></i>&nbsp; ����������</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->

<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
  <form method="post">
    <h5><b><i class="fa fa-line-chart w3-text-red"></i>  ���������� �� �����</b> &nbsp;<input type="date" name="start" value="${start}" required> &nbsp; - &nbsp; <input type="date" name="finish" value="${finish}" required> &nbsp; <button type="submit"  class="w3-button w3-xlarge w3-circle w3-white"><i class="fa fa-check" style="width:30px"></i></button></h5>
  </form>
  </header>
 <div class="w3-panel">
     <div class="w3-container">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
      <tr>
        <td><b>��������</b></td>
        <td><i class="fa fa-calculator w3-text-blue"></i></td>
        <td><i class="fa fa-check w3-text-green"></i></td>
        <td><i class="fa fa-handshake-o w3-text-lime"></i></td>
        <td><i class="fa fa-pied-piper-alt w3-text-orange"></i></td>
        <td><i class="fa fa-remove w3-text-red"></i></td>
  
      </tr>
      <c:forEach items="${statistics}" var="stat" varStatus="theCount">
      <tr>
        <td><a href="/planner/statisticbymanager/${stat.id}&_${start}&_${finish}" style="text-decoration: none" target="_blank">${stat.managerName}</a></a></td>
        <td>${stat.numberOfCalculating}</td>
        <td>${stat.numberOfbooking}</td>
        <td>${stat.numberOfHelp}</td>
        <td>${stat.numberOfNewClients}</td>
        <td>${stat.numberOfDeletes}</td>
      </tr>
      </c:forEach>
      <tr>

    </table><br><br>

  </div> 
   <div class="w3-container">
  <p>������� ���� �� ������� �� �����</p>
    <div class="w3-light-grey">
      <div class="w3-container w3-center w3-padding ${colorkm}" style="width:${avaragePricesForKmInPercent}%">${avaragePricesForKm} ���/��</div>
    </div>
  </div>
 </div>
 
  
</div>
<br>


  <hr>




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