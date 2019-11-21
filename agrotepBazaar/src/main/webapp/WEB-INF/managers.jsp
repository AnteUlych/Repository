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
  <span class="w3-bar-item w3-right"> <a href="/bazaar/login" ><i class="fa fa-sign-out fa-fw"></i></a></span>
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
    <a href="/bazaar/auction" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/bazaar/auction" class="w3-bar-item w3-button w3-padding"><i class="fa fa-legal fa-fw"></i>&nbsp; Тендер автомобілів</a>
    <a href="/bazaar/sold" class="w3-bar-item w3-button w3-padding"><i class="fa fa-lock fa-fw"></i> ${alertSold} &nbsp; Заброньовані автомобілі </a>
    <a href="/bazaar/clientspropositions" class="w3-bar-item w3-button w3-padding"><i class="fa fa-volume-control-phone fa-fw"></i>&nbsp; Пропозиції клієнтів</a>
    <a href="/bazaar/deals/all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck fa-fw"></i>&nbsp; План відвантажень</a>
    <a href="/bazaar/managers" class="w3-bar-item w3-button w3-padding  w3-blue"><i class="fa fa-id-card-o fa-fw"></i>&nbsp; Кадрова інформація</a>
    <a href="/bazaar/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart fa-fw"></i>&nbsp; Місячна звітність</a>
    <a href="/bazaar/addauction" class="w3-bar-item w3-button w3-padding "><i class="	fa fa-balance-scale fa-fw"></i>&nbsp; Додати Тендер</a><br><br>

  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5>
    <b><i class="fa fa-id-card-o"></i> Кадрова інформація</b>
      ${addManager}
    
    </h5>
  </header>
  
<br><br>
<div class="w3-container">

 
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
		<c:forEach items="${managers}" var="manag" varStatus="theCount">
<tr class="">

<td>${theCount.count}</td>
<td>${manag.name}</td>
<td>${manag.mail}</td>
<td>${manag.rank}</td>
<td>${manag.code}</td>
<td><button class="w3-button" onclick="document.getElementById('subscribe${manag.id}').style.display='block'"><i class="fa fa-user"></i></button></td>


</tr>


</c:forEach>
</table>

<br><br><br>
  
<!-- Subscribe Modal -->

<c:forEach items="${managers}" var="manag" varStatus="theCount">
<div id="subscribe${manag.id}" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe${manag.id}').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide"><i class="fa fa-user-secret" style="width:30px"></i> </h2>
	  
<form method = "post">
	  <p><input class="w3-input w3-border" type="text" required placeholder="${manag.name}" value="${manag.name}" name="name${manag.id}" maxlength="90"></p>
      <p><input class="w3-input w3-border" type="email" required placeholder="${manag.mail}" value="${manag.mail}" name="mail${manag.id}" maxlength="90"></p>
      <p><input class="w3-input w3-border" type="number" required placeholder="${manag.phone}" value="${manag.phone}" name="phone${manag.id}" min="10000000000" max="999999999999"></p>
      
	                   <input  type="radio" name="san${manag.id}" checked value ="${manag.rank}"> <label>${manag.rank}</label>
		               <input  type="radio" name="san${manag.id}" value ="top"> <label>top</label>
                       <input  type="radio" name="san${manag.id}" value ="coordinator"> <label>coordinator</label>
                       <input  type="radio" name="san${manag.id}" value ="manager"> <label>manager</label>
                       <input  type="radio" name="san${manag.id}" value ="chief"> <label>chief</label>
      <br> <br>
	  <button type="submit" formnovalidate name="fired${manag.id}" value="fired${manag.id}" class="w3-button w3-padding-large w3-red w3-margin-bottom" >Звільнити</button>
	  <button type="submit" name="edit${manag.id}" value="edit${manag.id}" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Редагувати</button>
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
      <h2 class="w3-wide"><i class="fa fa-user-secret" style="width:30px"></i> </h2>
	  
<form method = "post">
	  <p><input class="w3-input w3-border" type="text" required placeholder="Ім'я та прізвище"  name="name" maxlength="90" autocomplete="off"></p>
      <p><input class="w3-input w3-border" type="email" required placeholder="Електронна адреса" name="mail" maxlength="90" autocomplete="off"></p>
      <p><input class="w3-input w3-border" type="number" required placeholder="Мобільний телефон"  name="phone" min="10000000000" max="999999999999" autocomplete="off"></p>
      
	     
		               <input  type="radio" name="san" required value ="top"> <label>top</label>
                       <input  type="radio" name="san" required value ="coordinator"> <label>coordinator</label>
                       <input  type="radio" name="san" required value ="manager"> <label>manager</label>
                       <input  type="radio" name="san" required value ="chief"> <label>chief</label>
      <br> <br>
    
	  <button type="submit" name="add" value="add" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Додати співробітника</button>
</form>
    </div>
  </div>
</div>


  </div>

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