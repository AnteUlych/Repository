 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>

<!DOCTYPE html>
<html>
<title>Агротеп</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">-->
<link rel="stylesheet" href="<c:url value="/resources/w3.css" />">
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
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding "><i class="fa fa-truck w3-text-blue"></i>&nbsp; Автомобілі</a>
    <a href="/planner/clientslist" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-child w3-text-green"></i>&nbsp; Клієнти</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group"></i>&nbsp; Логісти</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-line-chart w3-text-pink"></i>&nbsp; Статистика</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; Історія</a>
    <a href="/planner/variants" class="w3-bar-item w3-button w3-padding"><i class="fa fa-arrows w3-text-indigo"></i>&nbsp; Планування</a>
    <a href="/planner/trucksmap" class="w3-bar-item w3-button w3-padding"><i class="fa fa-compass w3-text-orange"></i>&nbsp; Мапа</a>
    <a href="/planner/documents" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope-open w3-text-purple"></i>&nbsp; Документи</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->

<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-gavel w3-text-brown"></i> Гаранти</b> <button  onclick="document.getElementById('subscribe').style.display='block'" class="w3-button w3-xlarge w3-circle w3-white">+</button></h5>
    <a href="/planner/garantcalendar">Графік по гарантам</a>
  </header>

  <br>


  <div class="w3-container">
<form method="POST">
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
    <tr>
      <th>#</th>
      <th>Клієнт</th>
      <th>Гарант</th>
	  <th>Ціна</th>
	  <th>День</th>
	  <th>Затерти</th>
    </tr>
    
    <c:forEach items="${garants}" var="gar" varStatus="theCount">
    <tr>
    <td>${theCount.index+1}</td>
    <td>${gar.client}</td>
    <td>${gar.route}</td>
    <td>${gar.price}</td>
    <td>${daysweek[theCount.index]}</td>
    <td><button name="delete${gar.id}" type="submit" class="w3-button   w3-margin-bottom w3-circle" formnovalidate><i class="fa fa-eraser"></i></button></td>
    

    </tr>
    </c:forEach>
      
  </table><br>
</form>
  </div>
  <hr>

<form method="POST">
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>Новий Гарант</b></p>
		
		 <p><input name="client" class="w3-input w3-border" type="text" placeholder="Клієнт" maxlength="99" required></p>
	     <p><input name="route" class="w3-input w3-border" type="text" placeholder="Відвантаження" maxlength="199" required></p>
	     <p><input name="price" class="w3-input w3-border" type="number" placeholder="Ціна" min="0" max="1000000" required></p>
	     <p><input name="numberoftrucks" class="w3-input w3-border" type="number" placeholder="Кількість" value="1" min="1" max="10" required></p>
	   <br>
	     <p>
         <input type="radio" id="total2" name="dayofweek" value="2" required>
         <label for="total2">понеділок &nbsp;</label>
         <input type="radio" id="total3" name="dayofweek" value="3" required>
         <label for="total3">вівторок &nbsp;</label>
         <input type="radio" id="total4" name="dayofweek" value="4" required>
         <label for="total4">середа &nbsp;</label>
         <input type="radio" id="total5" name="dayofweek" value="5" required>
         <label for="total5">четвер &nbsp;</label>
         <input type="radio" id="total6" name="dayofweek" value="6" required>
         <label for="total6">п'ятниця &nbsp;</label>
         <input type="radio" id="total7" name="dayofweek" value="7" required>
         <label for="total7">субота &nbsp;</label>
         <input type="radio" id="total1" name="dayofweek" value="1" required>
         <label for="total1">неділя &nbsp;</label>
        
	     </p>

		  <br>
		  <p><button name="add" type="submit" class="w3-button w3-padding-large w3-green w3-margin-bottom">Додати</button></p>
		 
        

    </div>
  </div>
</div>
</form>
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