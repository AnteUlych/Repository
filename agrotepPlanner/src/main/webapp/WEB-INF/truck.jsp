 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>

<!DOCTYPE html>
<html>
<title>Агротеп</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}


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
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding "><i class="fa fa-heartbeat w3-text-red"></i>&nbsp; Графік</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-truck "></i>&nbsp; Автомобілі</a>
    <a href="/planner/clients" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-child w3-text-green"></i>&nbsp; Клієнти</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group w3-text-brown"></i>&nbsp; Логісти</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-line-chart w3-text-pink"></i>&nbsp; Статистика</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; Історія</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->

<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-truck  w3-text-blue"></i> Редагувати екіпаж</b></h5>
  </header>

  <br>

<form method="POST">
  <div class="w3-container">
	     <p><input name="tracktor" class="w3-input w3-border" type="text" placeholder="Тягач" value="${truck.tracktor}" maxlength="19" required></p>
	     <p><input name="trailor" class="w3-input w3-border" type="text" placeholder="Причіп" value="${truck.trailer}" maxlength="19" required></p>
	     <p><input name="driver" class="w3-input w3-border" type="text" placeholder="Водій" value="${truck.driver}" maxlength="40" required></p>
	     <p><input name="phone" class="w3-input w3-border" type="text" placeholder="Телефон" value="${truck.phone}" maxlength="40" required></p>
	    <br>
	     <p>Тип:&nbsp;
	     <input type="radio" id="tilt" name="typetruck" value="тент" ${tilt}>
         <label for="tilt">тент</label>
         <input type="radio" id="ref" name="typetruck" value="реф" ${ref}>
         <label for="ref">реф</label>
         <input type="radio" id="total" name="typetruck" value="цільномет" ${total}>
         <label for="total">цільномет</label>
	     </p>
	     <br>
	       <p>Відповідальний:&nbsp; 
	       <c:forEach items="${managers}" var="manager" varStatus="theCount">       
	     <input type="radio" id="${manager.id}" name="manar" value="${manager.name}" ${responsibleManager[theCount.index]} required>
         <label for="${manager.id}">${manager.name}</label>
         </c:forEach>
	     </p>
	     <br>
	     <p class="w3-text-red"> Призупинити роботу &nbsp;<input type="checkbox" name="toblacklist" value="yesToBlackList" ${checkBlackList} ></p>
		  <br>
		  <p><button name="edit" type="submit" class="w3-button w3-padding-large w3-blue w3-margin-bottom">Редагувати</button></p>


 <br>

  </div>
  </form>
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