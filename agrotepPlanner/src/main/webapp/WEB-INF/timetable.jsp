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
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-heartbeat"></i>&nbsp; Графік</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck w3-text-blue"></i>&nbsp; Автомобілі</a>
    <a href="/planner/clients" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-child w3-text-green"></i>&nbsp; Клієнти</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group w3-text-brown"></i>&nbsp; Логісти</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-line-chart w3-text-pink"></i>&nbsp; Статистика</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; Історія</a>
    <a href="/planner/variants" class="w3-bar-item w3-button w3-padding"><i class="fa fa-arrows w3-text-indigo"></i>&nbsp; Планування</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<form method="POST">
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-heartbeat  w3-text-red"></i> Графік</b></h5>
  </header>

  <br>

<div class="w3-container">
  <input onChange="this.form.submit()" value="turnOn" type="checkbox" id="checkMy" name="checkMy" ${htmlFilterMy}>
  <label for="checkMy">Мої</label>
  
  &nbsp;
  
  
  <input onChange="this.form.submit()" value="turnOn" type="checkbox" id="checkUrgent" name="checkUrgent" ${htmlFilterUrgent}>
  <label for="checkUrgent">Термінові</label>
  
   &nbsp;
  
  <input onChange="this.form.submit()" value="turnOn" type="checkbox" id="checkNotClosed" name="checkNotClosed" ${htmlFilterNotClosed}>
  <label for="checkNotClosed">Незакриті</label>
  
</div>
<br>
  <div class="w3-container">

    <table class="w3-table w3-bordered">
    <tr>
      <th>№</th>
      <th >!</th>
	  <th>Логіст</th>
	  <th>[грн/км]</th>
	  <th>[км]</th>
	  <th>Авто</th>
	  <th>Тип</th>
	  <th>Область</th>
	  <th>Завдання</th>
	  <th class="${weekendStringHeadFirstDay}">${firstTableHeadDay}</th>
	  <th class="${weekendStringHeadSecondDay}">${secondTableHeadDay}</th>
	  <th class="${weekendStringHeadThirdDay}">${thirdTableHeadDay}</th>
	  <th class="${weekendStringHeadFourthDay}">${fourthTableHeadDay}</th>
	  <th class="${weekendStringHeadFifthDay}">${fifthTableHeadDay}</th>
    </tr>
    
    <c:forEach items="${htmlTrucks}" var="trucksh" varStatus="theCount">
    <tr  class="${trucksh.columnUrgentColorClass}">
    <td>${theCount.index+1}</td>
    <td><input onChange="this.form.submit()" name="checkUrgentBox${trucksh.id}" type="checkbox" ${trucksh.columnUrgentClass}></td>
    <td>${trucksh.managerName}</td>
    <td>${trucksh.mounthUAHforKm}</td>
    <td>${trucksh.mounthKm}</td>
    <td>
    <div class="tooltip">
    <b>${trucksh.tracktor}</b>
    <span class="tooltiptext">
    ${trucksh.tracktor}/${trucksh.trailer}<br>
    ${trucksh.driver}<br>
    ${trucksh.phone}
    </span>
    </div>
    </td>
    <td>${trucksh.type}</td>
    <td><div style="${trucksh.fromOblastStatusStyle}">${trucksh.fromLastOblast}</div></td>
    
    <td onclick="document.getElementById('subscribe${trucksh.id}').style.display='block'">${trucksh.comment} &nbsp;</td>
    <td class="${weekendStringHeadFirstDay}" onclick="window.location.href='${trucksh.day1Link}'">${trucksh.day1}</td>
    <td class="${weekendStringHeadSecondDay}" onclick="window.location.href='${trucksh.day2Link}'">${trucksh.day2}</td>
    <td class="${weekendStringHeadThirdDay}" onclick="window.location.href='${trucksh.day3Link}'">${trucksh.day3}</td>
    <td class="${weekendStringHeadFourthDay}" onclick="window.location.href='${trucksh.day4Link}'">${trucksh.day4}</td>
    <td class="${weekendStringHeadFifthDay}" onclick="window.location.href='${trucksh.day5Link}'">${trucksh.day5}</td>
    
    </tr>
    </c:forEach>
  </table><br>
  <a href="/planner/timetablepast">Попередні відвантаження</a>
   <br>
  </div>
  <hr>


<!-- Subscribe Modal -->
<c:forEach items="${htmlTrucks}" var="trucksh" varStatus="theCount">
<div id="subscribe${trucksh.id}" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
    <i onclick="document.getElementById('subscribe${trucksh.id}').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>Коментар для ${trucksh.tracktor}/${trucksh.trailer}</b></p>
		
		 <p><input onkeypress="return event.keyCode != 13;" pattern="[^\\/`\/\x22]+" name="newComment${trucksh.id}" class="w3-input w3-border" type="text" placeholder="Коментар" value="${trucksh.comment}" maxlength="70"></p>
		
		  <br>
		  <p><button  name="button${trucksh.id}" type="submit" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('subscribe${trucksh.id}').style.display='none'">Коментувати</button></p>
		 
        

    </div>
  </div>
</div>
 </c:forEach>
   
  <!-- End page content -->
</div>
</form>


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