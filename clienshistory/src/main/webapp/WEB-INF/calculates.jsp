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

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />
</head>

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
 <a href="/clientshisory/weeklyreminderlist" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullhorn w3-text-purple"></i>&nbsp; Нагадування</a>
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
  <header class="w3-container" style="padding-top:22px">
    <h5>
   
    <b><i class="fa fa-book"></i> Запити за останній тиждень &nbsp;<button onclick="document.getElementById('subscribe').style.display='block'" class="w3-button w3-xlarge w3-circle"><i class="fa fa-plus w3-text-green"></i></button>
    </b>
     
    
    </h5>
  </header>
  
<br>
<div class="w3-container">

 
    <table class="w3-table w3-striped w3-bordered w3-border w3-white w3-hoverable">
<tr  style="background-color:pink">	
<th></th>
<th>${day0}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates0}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>

</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day1}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates1}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day2}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates2}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day3}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates3}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day4}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates4}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day5}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates5}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>
<tr  style="background-color:pink">	
<th></th>
<th>${day6}</th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>

<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>	
	
<c:forEach items="${listCalculates6}" var="calc" varStatus="theCount">		
<tr class="">
<td><a href="/clientshisory/editcalculates/${calc.id}"><i class="fa fa-pencil"></i></a></td>
<td><a href="/clientshisory/client/${calc.companyid}">${calc.company}</a></td>
<td>${calc.manager}</td>
<td>${calc.weight}</td>
<td>${calc.freight}</td>
<td>${calc.truck}</td>
<td>${calc.temperature}</td>
<td><b style="color:red">${calc.dangerous}</b></td>
<td>${calc.cityfrom}, ${calc.countryfrom}</td>

<td>${calc.cityto}, ${calc.countryto}</td>

<td>${calc.calculateonadate}</td>
<td>${calc.budget}</td>
<td>${calc.rate}</td>
<td>${calc.comments}</td>
</tr>
</c:forEach>










</table>
<br>
<br>



<br><br><br>
  
  </div>
<form method="POST">
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>Новий Запит</b></p>
		
		 <p>
		  
		   <select class="w3-input w3-border" name="idclient">
         <option value="0">Клієнт:</option>
         <c:forEach items="${clients}" var="cli" varStatus="theCount">	
         <option value="${cli.id}">${cli.company}</option>
         </c:forEach>
         </select>
      
         		 

 
         
		 </p>
		 	     <p>
	
	     <input pattern="[^\\/`\/\x22]+" name="cityfrom" class="w3-input w3-quarter" type="text" placeholder="МІСТО ВІДПРАВКИ" maxlength="40" required>
	      <input  name="countryfrom" class="w3-input w3-quarter" list="eu"  placeholder="Країна відправки" autocomplete="off"  required>
	    <datalist id="eu">
        <c:forEach items="${countries}" var="c" >	
        <option value="${c}">
        </c:forEach>
        </datalist>
	  
	     <input pattern="[^\\/`\/\x22]+" name="cityto" class="w3-input w3-quarter" type="text" placeholder="МІСТО ДОСТАВКИ" maxlength="40" required>
	     <input name="countryto" class="w3-input w3-quarter" list="eu"  placeholder="Країна доставки" autocomplete="off" required>
	     </p>
		 <p>	 
	     <input pattern="[^\\/`\/\x22]+" name="freight" class="w3-input w3-third" type="text" placeholder="Вантаж" maxlength="40" required>
	     <input pattern="[^\\/`\/\x22]+" name="weight" class="w3-input w3-third" type="number" placeholder="Вага, т" min="1" max="24" required>
         <input pattern="[^\\/`\/\x22]+" name="temperature" class="w3-input w3-third" type="text" placeholder="Температурний режим" maxlength="40">
	     </p>
	  

	     
	     

	     <p>	 
	     <input pattern="[^\\/`\/\x22]+" name="budget" class="w3-input w3-half" type="text" placeholder="Ставка наша" maxlength="40">
         <input pattern="[^\\/`\/\x22]+" name="rate" class="w3-input w3-half" type="text" placeholder="Ставка клієнта" maxlength="40">
	     </p>
	     <br>
	     <br>
	     <p><input pattern="[^\\/`\/\x22]+" name="calculateonadate" class="w3-input w3-border" type="text" placeholder="Готовність вантажу" maxlength="40" required></p>
	     <p><input pattern="[^\\/`\/\x22]+" name="comments" class="w3-input w3-border" type="text" placeholder="Інша інформація" maxlength="450" ></p>
	   <br>
	    
	     Тип РС:&nbsp;
	     <input type="radio" id="tilt" name="typetruck" value="тент" required>
         <label for="tilt">тент</label>
         <input type="radio" id="ref" name="typetruck" value="реф">
         <label for="ref">реф</label>
         <input type="radio" id="total" name="typetruck" value="будь який">
         <label for="total">будь який</label>&nbsp; &nbsp;
         <input type="checkbox" id="adr" name="adr" value="adr">
         <label for="adr"> Небезпечний вантаж</label>
         <br>
	     <br>
		  <p><button name="add" type="submit" class="w3-button w3-padding-large w3-green w3-margin-bottom">Додати</button></p>
		 
        

    </div>
  </div>
</div>
</form>
  </div>

<script>
 
$(document).ready(function () {
    $('select').selectize({
        sortField: 'text'
    });
});

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