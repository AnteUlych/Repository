 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<title>Агротеп</title>
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
<body class="w3-white">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"> <a href="#" ><i class="fa fa-sign-out fa-fw"></i></a></span>

</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left w3-card" style="z-index:3;width:300px;" id="mySidebar"><br>
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
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-heartbeat  w3-text-red"></i> Графік</b></h5>
  </header>

  <br>

<div class="w3-container">
  <input type="checkbox" id="checkMy" name="checkMy" ${htmlFilterMy}>
  <label for="checkMy">Мої</label>
  
  &nbsp;
  
  <input type="checkbox" id="checkRemont" name="checkRemont" ${htmlFilterRemont}>
  <label for="checkRemont">На ремонті</label>
  
   &nbsp;
  
  <input type="checkbox" id="checkUrgent" name="checkUrgent" ${htmlFilterUrgent}>
  <label for="checkUrgent">Термінові</label>
  
   &nbsp;
  
  <input type="checkbox" id="checkNotClosed" name="checkNotClosed" ${htmlFilterNotClosed}>
  <label for="checkNotClosed">Незакриті</label>
  
</div>
<br>
  <div class="w3-container">

    <table class="w3-table w3-bordered">
    <tr>
      <th>№</th>
      <th >!</th>
	  <th>Логіст</th>
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
    <tr>
      <td>1</td>
      <td><input type="checkbox"></td>
	  <td>Саша</td>
	  <td>
	  <div class="tooltip">
	  <b>АА1056ОР</b>
	  <span class="tooltiptext">
	  Cергій Василенко <br>
	  +380506475151
	  </span>	
	  </td>
	  <td>тент</td>
	  <td><div style="color:green">Полтавська</div></td>
	  <td  onclick="document.getElementById('subscribe2').style.display='block'">на Київ чи Одесу</td>
	  <td><center>
	  <div class="tooltip">
	  <i class="fa fa-truck" style="color:green">
	  <span class="tooltiptext">
	  Львов-Киев, Оптима, <br>
	  15 грн/км
	  </span>
	  </i></center>
	  </td>
	  <td><center>
	  <div class="tooltip">
	  <i class="fa fa-truck" style="color:green">
	  <span class="tooltiptext">
	  Киев-Одесса, Сокара, <br>
	  20 грн/км
	  </span>
	  </i></center>
	  </td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
    </tr>
     <tr>
      <td>2</td>
      <td><input type="checkbox"></td>
	  <td>Саша</td>
	  <td>
	   <div class="tooltip">
	  <b>АА4825ОР</b>
	  <span class="tooltiptext">
	  Олександр Жук <br>
	  +380504587878
	  </span>
	  </td>
	  <td>реф</td>
	  <td><div style="color:red">Одеська</div></td>
	  <td onclick="document.getElementById('subscribe2').style.display='block'">домой</td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'">
	  <center>
	  <div class="tooltip">
	  <i class="fa fa-truck" style="color:green">
	  <span class="tooltiptext">
	  Киев-Харьков, Аджилити<br>
	  19 грн/км
	  </span>
	  </i></center>
	  </td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
    </tr>
    <tr>
      <td>3</td>
      <td><input type="checkbox"></td>
	  <td>Леша</td>
	  <td>
	   <div class="tooltip">
	  <b>АА8888ОР</b>
	  <span class="tooltiptext">
	  Юрій Цех<br>
	  +380507898874
	  </span>
	  </td>
	  <td>реф</td>
	  <td>парк</td>
	  <td onclick="document.getElementById('subscribe2').style.display='block'">план 15.04</td>
	  <td onclick="window.location.href='page2'">
	    <center>
	  <div class="tooltip">
	  <i class="fa fa-wrench" style="color:red">
	  <span class="tooltiptext">
	  Заміна деталі
	  </span>
	  </i></center>
	  </td>
	  <td onclick="window.location.href='page2'">
	  <center>
	  <div class="tooltip">
	  <i class="fa fa-wrench" style="color:red">
	  <span class="tooltiptext">
	  Заміна деталі
	  </span>
	  </i></center>
	  </td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
	  <td onclick="window.location.href='page2'"></td>
    </tr>
	    <tr>
      <td class="w3-lime">4</td>
      <td  class="w3-lime"><input type="checkbox" checked></td>
	  <td  class="w3-lime">Леша</td>
	  <td  class="w3-lime">
	   <div class="tooltip">
	  <b>АА2222ОР</b>
	  <span class="tooltiptext">
	  Володимир Фес <br>
	  +380509632587
	  </span>
	  </td>
	  <td  class="w3-lime">реф</td>
	  <td  class="w3-lime"><div style="color:red">Одеська</div></td>
	  <td class="w3-lime" onclick="document.getElementById('subscribe2').style.display='block'">как угодно</td>
	  <td class="w3-lime" onclick="window.location.href='page2'"></td>
	  <td class="w3-lime" onclick="window.location.href='page2'"></td>
	  <td class="w3-lime" onclick="window.location.href='page2'"></td>
	  <td class="w3-lime" onclick="window.location.href='page2'"></td>
	  <td class="w3-lime" onclick="window.location.href='page2'"></td>
    </tr>
  </table><br>

  </div>
  <hr>


<!-- Subscribe Modal -->
<div id="subscribe2" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe2').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>Коментар для АА1604ОТ</b></p>
		
		 <p><input class="w3-input w3-border" type="text" placeholder="Коментар"></p>
		
		  
		  <p><button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('subscribe').style.display='none'">Коментувати</button></p>
		 <br>
        

    </div>
  </div>
</div>

  
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