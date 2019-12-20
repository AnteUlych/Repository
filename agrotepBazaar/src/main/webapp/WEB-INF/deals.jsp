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
    <a href="/tender/clientspropositions" class="w3-bar-item w3-button w3-padding"><i class="fa fa-volume-control-phone fa-fw"></i>&nbsp; Пропозиції клієнтів</a>
    <a href="/tender/deals/all" class="w3-bar-item w3-button w3-padding  w3-blue"><i class="fa fa-truck fa-fw"></i>&nbsp; План відвантажень</a>
    <a href="/tender/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-id-card-o fa-fw"></i>&nbsp; Кадрова інформація</a>
    <a href="/tender/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart fa-fw"></i>&nbsp; Місячна звітність</a>
    <a href="/tender/addauction" class="w3-bar-item w3-button w3-padding "><i class="	fa fa-balance-scale fa-fw"></i>&nbsp; Додати Тендер</a><br><br>

  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-truck"></i> План відвантажень (<a href="/tender/deals/export">Експорт</a>, <a href="/tender/deals/import">Імпорт</a> та <a href="/tender/dealsfiltr">архів</a>)</b></h5>
  </header>

  <div class="w3-container" id="contact">
  
      
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
             <th colspan="6">${lastMonday}</th>                
          </tr>
         <c:forEach items="${lastWeekMomday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekMomdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
             <th colspan="6">${lastTuesday}</th> 
         </tr>
         <c:forEach items="${lastWeekTuesday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekTuesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
             <th colspan="6">${lastWednesday}</th> 
         </tr>
         <c:forEach items="${lastWeekWednesday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekWednesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
	
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${lastThursday}</th> 
         </tr>
         <c:forEach items="${lastWeekThursday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekThursdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
		
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${lastFriday}</th> 
         </tr>
         <c:forEach items="${lastWeekFriday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekFridayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			 
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${lastSaturday}</th> 
         </tr>
         <c:forEach items="${lastWeekSaturday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekSaturdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
		
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
   <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${lastSunday}</th> 
         </tr>
         <c:forEach items="${lastWeekSunday}" var="dea" varStatus="theCount">
         <tr class="${lastWeekSundayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
  
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${presentMonday}</th> 
         </tr>
         <c:forEach items="${presentWeekMomday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekMomdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			 
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${presentTuesday}</th> 
         </tr>
         <c:forEach items="${presentWeekTuesday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekTuesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${presentWednesday}</th> 
         </tr>
         <c:forEach items="${presentWeekWednesday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekWednesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
             <th colspan="6">${presentThursday}</th> 
         </tr>
         <c:forEach items="${presentWeekThursday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekThursdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
             <th colspan="6">${presentFriday}</th> 
         </tr>
         <c:forEach items="${presentWeekFriday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekFridayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${presentSaturday}</th> 
         </tr>
         <c:forEach items="${presentWeekSaturday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekSaturdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
	
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${presentSunday}</th> 
         </tr>
         <c:forEach items="${presentWeekSunday}" var="dea" varStatus="theCount">
         <tr class="${presentWeekSundayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
		
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
      
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${nextMonday}</th> 
         </tr>
         <c:forEach items="${nextWeekMomday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekMomdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${nextTuesday}</th> 
         </tr>
         <c:forEach items="${nextWeekTuesday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekTuesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			 
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${nextWednesday}</th> 
         </tr>
         <c:forEach items="${nextWeekWednesday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekWednesdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${nextThursday}</th> 
         </tr>
         <c:forEach items="${nextWeekThursday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekThursdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
       <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
           <th colspan="6">${nextFriday}</th> 
         </tr>
         <c:forEach items="${nextWeekFriday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekFridayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
     <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
            <th colspan="6">${nextSaturday}</th> 
         </tr>
         <c:forEach items="${nextWeekSaturday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekSaturdayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			 
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
   <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">		 
          <tr style="background-color:#f08080">
           <th colspan="6">${nextSunday}</th> 
         </tr>
         <c:forEach items="${nextWeekSunday}" var="dea" varStatus="theCount">
         <tr class="${nextWeekSundayColors[theCount.index]}">
             <td>${theCount.index+1}</td>
			 <td>${dea.information}</td>
			 <td><a href="/tender/deal/${dea.id}">${dea.truck}</a></td>
		     <td>${dea.manager}</td>				
		     <td>${dea.truckdriver}</td>
			 <td>${dea.otherinformation}</td>
			 
		  </tr>
        </c:forEach>
     </table>
  <br><br>
  
  
  	<!--  

	 <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
		<c:forEach items="${deals}" var="dea" varStatus="theCount">
<tr class="${colors[theCount.index]}">
	
			    <td>${dates[theCount.index]}</td>
			    <td>${dea.information}</td>
			    <td>${dea.truck}</td>
				<td>${dea.manager}</td>				
				<td>${dea.truckdriver}</td>
				<td>${dea.otherinformation}</td>
				<td><a href="/tender/deal/${dea.id}"><i class="fa fa-thumb-tack"></i></a></td>
			
</tr>


</c:forEach>
</table>

-->


<br><br><br>
<!-- Subscribe Modal -->

	

 
  </div>



</div>

  <!-- End page content -->

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