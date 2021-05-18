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

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.accordion {
  background-color: #fff ;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #ccc; 
}

.panel {
  padding: 0 18px;
  display: none;
  background-color: white;
  overflow: hidden;
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
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding"><i class="fa fa-heartbeat w3-text-red"></i>&nbsp; Графік</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck w3-text-blue"></i>&nbsp; Автомобілі</a>
    <a href="/planner/clients" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-child"></i>&nbsp; Клієнти</a>
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
    <h5><b><i class="fa fa-child  w3-text-green"></i> Клієнти</b> &nbsp; <button onclick="document.getElementById('subscribe').style.display='block'" class="w3-button w3-xlarge w3-circle w3-white">+</button></h5>
  </header>
  <br>
<div class="w3-container">
<button class="accordion">Одеська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsODESA}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Дніпропетровська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsDNIPRO}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Чернігівська область</button>
<div class="panel">
<table>
  <c:forEach items="${clientsCHERNIGIV}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Харківська область</button>
<div class="panel">
<table>
  <c:forEach items="${clientsKHARKIV}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Житомирська область</button>
<div class="panel">
 <table>
  <c:forEach items="${clientsZHYTOMYR}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Полтавська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsPOLTAVA}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Херсонська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsKHERSON}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Київ / Київська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsKYIV}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Запорізька область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsZAPORIZZA}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Луганська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsLUGANSK}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Донецька область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsDONETSK}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Вінницька область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsVINNITSA}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Крим</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsKRYM}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Миколаївська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsMYKOLAIV}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Кіровоградська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsKIROVOGRAD}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Сумська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsSUMY}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Львівська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsLVIV}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Черкаська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsCHERKASY}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Хмельницька область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsKHMELNYTSK}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Волинська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsVOLYN}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Рівненська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsRIVNE}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Івано-Франківська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsFRANKIVSK}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Тернопільська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsTERNOPIL}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Закарпатська область</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsZAKARPATTIA}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

<button class="accordion">Чернівецька</button>
<div class="panel">
  <table>
  <c:forEach items="${clientsCHERNIVTSI}" var="client1" varStatus="theCount">
    <tr>
    <td><a href="/planner/client/${client1.id}">${client1.company}</a></td>
    <td>${client1.cargo}</td>
    <td>${client1.typetruck}</td>
    <td>${client1.transportVolume}</td>
    <td>${client1.season}</td>
  </tr>
  </c:forEach>
</table>
</div>

</div>

  <hr>
<form method="POST">
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>Новий клієнт</b></p>
		
		 <p><input name="company" class="w3-input w3-border" type="text" placeholder="Назва клієнта" maxlength="40" required></p>
		 <p><input name="code" class="w3-input w3-border" type="number" placeholder="ЄДРПОУ" maxlength="11" required></p>
		 <p><input name="contactPerson" class="w3-input w3-border" type="text" placeholder="Контактна особа" maxlength="40" required></p>
		 <p><input name="phone" class="w3-input w3-border" type="text" placeholder="Телефон" maxlength="40" required></p>
		 <p><input name="email" class="w3-input w3-border" type="email" placeholder="Пошта" maxlength="40" required></p>
		 <p><input name="payment" class="w3-input w3-border" type="text" placeholder="Оплати" maxlength="99" required></p>
		 <p><input name="transportVolume" class="w3-input w3-border" type="text" placeholder="Об'єм" maxlength="99" required></p>
		 <p><input name="season" class="w3-input w3-border" type="text" placeholder="Сезонність" maxlength="40" required></p>
		 <p><input name="cargo" class="w3-input w3-border" type="text" placeholder="Вантаж" maxlength="40" required></p>
		 <p><input name="otherInfo" class="w3-input w3-border" type="text" placeholder="Додаткова інформація" maxlength="149" required></p>
		    <p>
  <input type="radio" id="tilt" name="typetruck" value="тент" required>
  <label for="tilt">тент</label>
  <input type="radio" id="ref" name="typetruck" value="реф">
  <label for="ref">реф</label>
  <input type="radio" id="any" name="typetruck" value="тент або реф">
  <label for="any">тент або реф</label>
</p>
<p><textarea name="warning" class="w3-input w3-border" rows="5" placeholder="Застереження" maxlength="999" required></textarea></p>

		  <br>
		  <p><button name="button" type="submit" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Створити</button></p>
		 
        

    </div>
  </div>
</div>
</form>
   
  <!-- End page content -->
</div>



<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
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