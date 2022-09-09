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

.noselect {
  -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none; /* Safari */
     -khtml-user-select: none; /* Konqueror HTML */
       -moz-user-select: none; /* Old versions of Firefox */
        -ms-user-select: none; /* Internet Explorer/Edge */
            user-select: none; /* Non-prefixed version, currently
                                  supported by Chrome, Edge, Opera and Firefox */
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right"> <a href="/clientshisory/login" ><i class="fa fa-sign-out fa-fw"></i></a></span>
${menuForHead}
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    
    <div class="w3-col s8 w3-bar">
      <span><strong>${name}</strong></span><br>
    </div>
  </div>
  <hr>

  <div class="w3-bar-block">
    <a href="/clientshisory/plan" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/clientshisory/plan" class="w3-bar-item w3-button w3-padding "><i class="fa fa-calendar w3-text-blue"></i>&nbsp; Графік дзвінків</a>
    <a href="/clientshisory/calculates" class="w3-bar-item w3-button w3-padding "><i class="fa fa-book w3-text-pink"></i>&nbsp; Запити</a>
    <a href="/clientshisory/archive" class="w3-bar-item w3-button w3-padding "><i class="fa fa-archive w3-text-orange"></i>&nbsp; Архів запитів</a>
     <a href="/clientshisory/addclient" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user-plus w3-text-green"></i>&nbsp; Додати клієнта</a>
    <a href="/clientshisory/find" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search w3-text-red"></i>&nbsp; Пошук компаній</a>

    <a href="/clientshisory/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart w3-text-gray"></i>&nbsp; Звіт</a>
  </div>

  <hr>
    <div class="w3-bar-block">
    
    <c:forEach items="${products}" var="prod" varStatus="theCount">
    <a href="/clientshisory/planproduct/${prod.id}" class="w3-bar-item w3-button w3-padding "><i class="fa fa-minus"></i>&nbsp; ${prod.product}</a>
    </c:forEach>
<hr>
  </div>
  
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container noselect" style="padding-top:22px">
    <h5>
    <b><i class="${funelIcon}"></i>&nbsp; ${company} &nbsp;  
    ${editClient} 
    
    </b>   
    </h5>

     <i class="fa fa-university" style="width:30px"></i> Код підприємства ${edrpo}<br>
     <i class="fa fa-clock-o" style="width:30px"></i> Дата внесення в систему ${creationAsString}<br>
     <i class="fa fa-truck" style="width:30px"> </i> ${productsOfClient}<br>
     <i class="fa fa-cube" style="width:30px"> </i>  ${freight}<br>
     <i class="fa fa-user-o" style="width:30px"> </i> ${manager}<br>
     <br>
     <i class="fa fa-male" style="width:30px"> </i> ${lpr}<br>
     <i class="fa fa-phone" style="width:30px"> </i> ${phone}<br>
     <i class="fa fa-mobile" style="width:30px"> </i> ${mobile}<br>
     <i class="fa fa-envelope" style="width:30px"> </i> ${mail}<br>
     <i class="fa fa-sticky-note-o" style="width:30px"> </i> ${othercontact}<br>
     
     
    
  </header>

<br>

<div class="w3-container">
<h5>
${addRecord}<br> 
</h5>
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
		<c:forEach items="${records}" var="rec" varStatus="theCount">
<tr class="">

<td>${rec.date}</td>
<td><i class="${icons[theCount.index]}"></i></td>
<td>${rec.manager}</td>
<td>${rec.record}</td>

</tr>


</c:forEach>
</table>

<br><br><br>
  
  </div>

  </div>

<div id="add" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('add').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide"><i class="${funelIcon}" style="width:30px"></i>&nbsp; ${company}</h2>
	  
	  <form method="post" >
	  <p><input class="w3-input w3-border" required type="text"  placeholder="Коментар" name="planrecord" maxlength="199" required></p>
	  <p><input class="w3-input w3-border" required type="date"  placeholder="Наступний дзвінок" name="callfornexttime"></p>
    
	   <p>                      
					   <input  type="radio" required name="radiofunel" ${check0} value ="0"> <label><i class="fa fa-snowflake-o w3-text-blue"></i> &nbsp;</label>
		               <input  type="radio" required name="radiofunel" ${check1} value ="1"> <label><i class="fa fa-user-secret"></i> &nbsp;</label>
                       <input  type="radio" required name="radiofunel" ${check2} value ="2"> <label><i class="fa fa-flag-checkered"></i> &nbsp;</label>
                       <input  type="radio" required name="radiofunel" ${check3} value ="3"> <label><i class="fa fa-check w3-text-green"></i> &nbsp;</label>
                       <input  type="radio" required name="radiofunel" ${check4} value ="4"> <label><i class="fa fa fa-ban w3-text-red"></i> &nbsp;</label>	
	</p>
	  <br>
	  <button type="submit" name="addrecord" value="addrecord" class="w3-button w3-padding-large w3-green w3-margin-bottom" >Додати запис</button>
	  </form>	
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