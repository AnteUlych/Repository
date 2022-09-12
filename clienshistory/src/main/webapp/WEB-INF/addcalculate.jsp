 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" contentType="text/html; charset=cp1251"%>
 <%@ page pageEncoding="cp1251"%>
 
<!DOCTYPE html>
<html>
<title>�������</title>
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
    <a href="/clientshisory/plan" class="w3-bar-item w3-button w3-padding "><i class="fa fa-calendar w3-text-blue"></i>&nbsp; ������ ������</a>
    <a href="/clientshisory/calculates" class="w3-bar-item w3-button w3-padding "><i class="fa fa-book w3-text-pink"></i>&nbsp; ������</a>
    <a href="/clientshisory/archive" class="w3-bar-item w3-button w3-padding "><i class="fa fa-archive w3-text-orange"></i>&nbsp; ����� ������</a>
     <a href="/clientshisory/addclient" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user-plus w3-text-green"></i>&nbsp; ������ �볺���</a>
    <a href="/clientshisory/find" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search w3-text-red"></i>&nbsp; ����� �������</a>

    <a href="/clientshisory/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart w3-text-gray"></i>&nbsp; ���</a>
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
    <b><i class="fa fa-book"></i> ����� ����� </b>
     
    
    </h5>
  </header>
  
<br>
<div class="w3-modal-content  w3-padding-large">
<div class="w3-container w3-white w3-center">

 <form method="POST">
 
<p><b>${client}</b></p>
		 	     <p>
	
	     <input pattern="[^\\/`\/\x22]+" name="cityfrom" class="w3-input w3-quarter" type="text" placeholder="̲��� ²�������"  maxlength="40" required>
	     <input style="text-transform:uppercase" pattern="[^\\/`\/\x22]+" name="countryfrom" class="w3-input w3-quarter" type="text"  placeholder="����� ��������" minlength="2" maxlength="2" required>
	  
	     <input pattern="[^\\/`\/\x22]+" name="cityto" class="w3-input w3-quarter" type="text" placeholder="̲��� ��������"  maxlength="40" required>
	     <input style="text-transform:uppercase" pattern="[^\\/`\/\x22]+" name="countryto" class="w3-input w3-quarter" type="text"  placeholder="����� ��������" minlength="2" maxlength="2" required>
	     </p>
		 <p>	 
	     <input pattern="[^\\/`\/\x22]+" name="freight" class="w3-input w3-third" type="text" placeholder="������"  maxlength="40" required>
	     <input pattern="[^\\/`\/\x22]+" name="weight" class="w3-input w3-third" type="number" placeholder="����, �"   min="1" max="24" required>
         <input pattern="[^\\/`\/\x22]+" name="temperature" class="w3-input w3-third" type="text" placeholder="������������� �����"  maxlength="40">
	     </p>
	  

	     
	     

	     <p>	 
	     <input pattern="[^\\/`\/\x22]+" name="budget" class="w3-input w3-half" type="text" placeholder="������ ����"  maxlength="40">
         <input pattern="[^\\/`\/\x22]+" name="rate" class="w3-input w3-half" type="text" placeholder="������ �볺���"  maxlength="40">
	     </p>
	     <br>
	     <br>
	     <p><input pattern="[^\\/`\/\x22]+" name="calculateonadate" class="w3-input w3-border" type="text" placeholder="��������� �������"  maxlength="40" required></p>
	     <p><input pattern="[^\\/`\/\x22]+" name="comments" class="w3-input w3-border" type="text" placeholder="���� ����������"  maxlength="450" ></p>
	   <br>
	    
	     ��� ��:&nbsp;
	     <input type="radio" id="tilt" name="typetruck" value="����"  required>
         <label for="tilt">����</label>
         <input type="radio" id="ref" name="typetruck" value="���" >
         <label for="ref">���</label>
         <input type="radio" id="total" name="typetruck" value="���� ����" >
         <label for="total">���� ����</label>&nbsp; &nbsp;
         <input type="checkbox" id="adr" name="adr" value="adr" >
         <label for="adr"> ����������� ������</label>
         <br>
	     <br>
		  <p><button name="add" type="submit" class="w3-button w3-padding-large w3-green w3-margin-bottom">������</button></p>

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