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
    <a href="/tender/auction" class="w3-bar-item w3-button w3-padding"><i class="fa fa-legal fa-fw"></i>&nbsp; Тендер автомобілів</a>
    <a href="/tender/sold" class="w3-bar-item w3-button w3-padding"><i class="fa fa-lock fa-fw"></i> ${alertSold} &nbsp; Заброньовані автомобілі </a>
    <a href="/tender/clientspropositions" class="w3-bar-item w3-button w3-padding  w3-blue"><i class="fa fa-volume-control-phone fa-fw"></i>&nbsp; Контракти</a>
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
    <h5><b><i class="fa fa-volume-control-phone"></i>&nbsp; Контракти 
    <button class="w3-button" onclick="document.getElementById('subscribe').style.display='block'"><i class="fa fa fa-plus"></i></button>
    </b>
    </h5>
  </header>
  <br>
    <div class="w3-container" id="contact">
  
  	

	 <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
		<c:forEach items="${contracts}" var="con" varStatus="theCount">

         <tr class ="${colors[theCount.index]}">
	
	            <td>${theCount.index+1}</td>
			    <td><a href="/tender/contract/${con.id}">${con.company}</a></td>
			    <td>${con.manager}</td>
			    <td>${lastdates[theCount.index]}</td>
				<td>${editButtons[theCount.index]}</td>
			
         </tr>


</c:forEach>
</table>
<br><br><br>
<!-- Subscribe Modal -->

<c:forEach items="${contracts}" var="con" varStatus="theCount">
<div id="subscribe${con.id}" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe${con.id}').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide"><i class="fa fa-cog" style="width:30px"></i> </h2>
	  
 
	  
	  <form method="post" >
	  <br>
	  <p><input class="w3-input w3-border"  type="text"  value="${con.company}" name="comp${con.id}" maxlength="40"></p>
	  <br>
	  <p>    Термін роботи з клієнтом:</p>
	  <p><input class="w3-input w3-border"  type="date"  value="${lastdates[theCount.index]}" name="lastdate${con.id}"></p>
	  <br>
      <p>    Менеджер: <input  type="radio"  name="manager${con.id}" value ="${con.managerid}" checked> <label>${con.manager} </label></p>
	   <p>
	   
					   <c:forEach items="${managers}" var="mana" varStatus="theCount">
					   <input  type="radio"  name="manager${con.id}" value ="${mana.id}"> <label>${mana.name}</label>					   
					   </c:forEach>

	</p>
	<br>
	<p>Статус: <input  type="radio"  name="status${con.id}" value ="${con.status}" checked> <label>${con.status} </label></p>
<p>
  
					   <input  type="radio"  name="status${con.id}" value ="on" > <label>on </label>
					   <input  type="radio"  name="status${con.id}" value ="off" > <label>off </label>

	</p>
	  <br><br>
	  <button type="submit" name="edit${con.id}" value="edit${con.id}" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Редагувати</button>
	  </form>	
    </div>
  </div>
</div>	
</c:forEach>	

<!-- Subscribe Modal -->


<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide"><i class="fa fa-plus" style="width:30px"></i>Новий контракт</h2>
	  
 
	  
	  <form method="post" >
	  <br>
	  <p><input class="w3-input w3-border"  type="text" required placeholder="Назва клієнта" name="newclient" maxlength="40"></p>
	  <br>

	  <br><br>
	  <button type="submit" name="add" value="add" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Додати Контракт</button>
	  </form>	
    </div>
  </div>
</div>

 
  </div>

</div>
  <!-- End page content -->
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