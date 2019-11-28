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
    <h5>����</h5>
  </div>
  <div class="w3-bar-block">
    <a href="/tender/auction" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Close Menu</a>
    <a href="/tender/auction" class="w3-bar-item w3-button w3-padding"><i class="fa fa-legal fa-fw"></i>&nbsp; ������ ���������</a>
    <a href="/tender/sold" class="w3-bar-item w3-button w3-padding"><i class="fa fa-lock fa-fw"></i> ${alertSold} &nbsp; ����������� �������� </a>
    <a href="/tender/clientspropositions" class="w3-bar-item w3-button w3-padding  w3-blue"><i class="fa fa-volume-control-phone fa-fw"></i>&nbsp; ���������� �볺���</a>
    <a href="/tender/deals/all" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck fa-fw"></i>&nbsp; ���� �����������</a>
    <a href="/tender/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-id-card-o fa-fw"></i>&nbsp; ������� ����������</a>
    <a href="/tender/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bar-chart fa-fw"></i>&nbsp; ̳����� �������</a>
    <a href="/tender/addauction" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-balance-scale fa-fw"></i>&nbsp; ������ ������</a><br><br>

  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-volume-control-phone"></i>&nbsp; ���������� ������</b>
    <button class="w3-button" onclick="document.getElementById('subscribe').style.display='block'"><i class="fa fa-comment-o fa-fw"></i></button>
    </h5>
  </header>
<form method = "post">
  <div class="w3-row-padding w3-hoverable w3-margin-bottom">
    <div class="w3-half">
     <h5>Export (������)</h5>
        <table class="w3-table w3-striped w3-white">
		
		<c:forEach items="${exportPropositions}" var="exportInfo" varStatus="theCount">
<tr class="${exportColor[theCount.index]}">		
<td>${exportDate[theCount.index]}</td>
<td>${exportInfo.route}</td>
<td>${exportInfo.truck}</td>
<td>${exportInfo.information}</td>
<td>${exportInfo.rate} ${exportInfo.currency}</td>
<td>${exportInfo.manager}</td>
<td>${exportButtonDelete[theCount.index]}</td>
<td>${exportButtonConfirm[theCount.index]}</td>

</tr>
</c:forEach>  
        </table>
    </div>
	
        <div class="w3-half">
     <h5>Import (������)</h5>
        <table class="w3-table w3-striped w3-white">
		
		<c:forEach items="${importPropositions}" var="importInfo" varStatus="theCount">
<tr class="${importColor[theCount.index]}">	
<td>${importDate[theCount.index]}</td>
<td>${importInfo.route}</td>
<td>${importInfo.truck}</td>
<td>${importInfo.information}</td>
<td>${importInfo.rate} ${importInfo.currency}</td>
<td>${importInfomanager}</td>
<td>${importButtonDelete[theCount.index]}</td>
<td>${importButtonConfirm[theCount.index]}</td>

</tr>
</c:forEach>  
        </table>
        
        <!-- Subscribe Modal -->
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <h2 class="w3-wide"><i class="fa fa-comment-o" style="width:30px"></i> </h2>
	   
	      <p>    ��������:            
          <input required type="radio" name="direction" value ="export"> <label>������� (������)</label>
		  <input required type="radio" name="direction" value ="import"> <label>������ (������)</label>
      </p>
	   
	   <p>���� ������������:<input class="w3-input w3-border" required type="date"  placeholder="���� ������������" name="readydate"></p>
	  <p><input class="w3-input w3-border" type="text" required placeholder="�������, ������, ������������� �����" name="route" maxlength="150"></p>
      <p><input class="w3-input w3-border" type="text" required placeholder="�볺��" name="client" maxlength="70"></p>
	  
	  <p><input class="w3-input w3-border" type="number" required min="0" max="1000000" placeholder="ֳ��" name="rate" autocomplete="off"></p>
	  
	     <p>    ������:            
          <input required type="radio" name="currency" value ="EUR"> <label>����</label>
		  <input required type="radio" name="currency" value ="UAH"> <label>�����</label>
          <input required type="radio" name="currency" value ="USD"> <label>�������</label>	
      </p>
	  
	   <p>    ���������:            
		               <input  type="radio" required name="truck" value ="����"> <label>����</label>
                       <input  type="radio" required name="truck" value ="���������������"> <label>���������������</label>
                       <input  type="radio" required name="truck" value ="������������"> <label>������������</label>
                       <input required type="radio" name="truck" value ="����������"> <label>����������</label>
                       <input  type="radio" required name="truck" value ="2-��������"> <label>2-��������</label>	
      </p>
      
	  <button type="submit" name="addproposition" value="addproposition" class="w3-button w3-padding-large w3-green w3-margin-bottom" >������ ���������� �볺���</button>
    </div>
  </div>
</div>

        <br><br><br>
    </div>
  </div>
</form>
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