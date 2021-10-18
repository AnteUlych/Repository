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

.container{ width:100%; }    
.align-left{ float: left;width:50%; }
.align-right{ float: right;width:50%; }

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
    <a href="/planner/timetable" class="w3-bar-item w3-button w3-padding"><i class="fa fa-heartbeat w3-text-red"></i>&nbsp; ������</a>
    <a href="/planner/trucks" class="w3-bar-item w3-button w3-padding"><i class="fa fa-truck w3-text-blue"></i>&nbsp; ��������</a>
    <a href="/planner/clientslist" class="w3-bar-item w3-button w3-padding  w3-blue"><i class="	fa fa-child"></i>&nbsp; ��볺���</a>
    <a href="/planner/managers" class="w3-bar-item w3-button w3-padding"><i class="fa fa-group w3-text-brown"></i>&nbsp; ������</a>
    <a href="/planner/statistic" class="w3-bar-item w3-button w3-padding"><i class="	fa fa-line-chart w3-text-pink"></i>&nbsp; ����������</a>
    <a href="/planner/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-hourglass-3 w3-text-yellow"></i>&nbsp; ������</a>
    <a href="/planner/variants" class="w3-bar-item w3-button w3-padding"><i class="fa fa-arrows w3-text-indigo"></i>&nbsp; ����������</a>
    <a href="/planner/trucksmap" class="w3-bar-item w3-button w3-padding"><i class="fa fa-compass w3-text-orange"></i>&nbsp; ����</a>
    <a href="/planner/documents" class="w3-bar-item w3-button w3-padding"><i class="fa fa-envelope-open w3-text-purple"></i>&nbsp; ���������</a>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->

<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-child w3-text-green"></i>  ${clien.company}</b> &nbsp; <button onclick="document.getElementById('subscribe').style.display='block'" class="w3-button w3-xlarge w3-circle w3-white"><i class="fa fa-pencil" style="width:30px"></i></button></h5>
    ${blacklist}
  </header>
 <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div class="w3-half">
      
  <i class="fa fa-university" style="width:30px"></i> ${clien.code}<br>
   <i class="fa fa-user-o" style="width:30px"> </i> ${clien.contactPerson}<br>
   <i class="fa fa-phone" style="width:30px"> </i> ${clien.phone}<br>
   <i class="fa fa-envelope-o" style="width:30px"> </i> ${clien.email}<br>
   <i class="fa fa-truck" style="width:30px"> </i>  ${clien.typetruck}<br>
   <i class="fa fa-money" style="width:30px"> </i> ����� ������: ${clien.payment}<br>
   <i class="fa fa-line-chart" style="width:30px"> </i> ��'�� ${clien.transportVolume}<br>
   <i class="fa fa-sun-o" style="width:30px"> </i> ���������: ${clien.season}<br>
   <i class="fa fa-shopping-basket" style="width:30px"> </i> ������: ${clien.cargo}<br>
   <br>
   <i class="fa fa-info" style="width:30px"> </i> ���� ����������:<br>${clien.otherInfo}<br>
   <br>
   <i class="fa fa-bullhorn" style="width:30px"> </i> ������������:<br>
   ${clien.warning}<br><br>
   <i class="fa fa-fax" style="width:30px"> </i> ���������� ��� ����:<br>
   ${clien.driverInstruction}<br>
   <br>
   ${clien.creatingDate}
   <br>
   <br>
   <br>


  <br>
  
      </div>
      <div class="w3-half">
         <button onclick="document.getElementById('subscribe1').style.display='block'" class="w3-button w3-xlarge w3-circle w3-white"><i class="fa fa-exchange" style="width:30px"></i></button>
       <form method="POST">
      <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
         <c:forEach items="${directions}" var="dire" varStatus="theCount">
          <tr>
            <td>${dire.oblastFrom}</td>
            <td>-</td>
            <td>${dire.oblastTo}</td>
			<td>${dire.info}</td>
			<td><button type="submit" name="delete${dire.id}" class="w3-button w3-red w3-tiny" formnovalidate><i class="fa fa-remove" style="width:30px"></i></button></td>
          </tr>
          </c:forEach>
        </table>
</form>  
      
  </div>
    </div>
  </div>
 
  
</div>
<br>
  <div class="w3-container">

    

  </div>

  <hr>
<form method="POST">
<div id="subscribe" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>����������� �볺���</b></p>
		
		 <p><input pattern="[^\\/`\/\x22]+" name="company" class="w3-input w3-border" type="text" placeholder="����� �볺���" value="${clien.company}" maxlength="40" required></p>
		 <p><input pattern="[^\\/`\/\x22]+" name="code" class="w3-input w3-border" type="number" placeholder="������" maxlength="11" value="${clien.code}" required></p>
		 <p><input pattern="[^\\/`\/\x22]+" name="contactPerson" class="w3-input w3-border" type="text" placeholder="��������� �����" value="${clien.contactPerson}" maxlength="40" required></p>
		 <p><input  name="phone" class="w3-input w3-border" type="text" placeholder="�������" maxlength="99" value="${clien.phone}" required></p>
		 <p><input name="email" class="w3-input w3-border" type="email" placeholder="�����" maxlength="99" value="${clien.email}" required></p>
		 <p><input name="payment" class="w3-input w3-border" type="text" placeholder="������" maxlength="99" value="${clien.payment}" required></p>
		 <p><input name="transportVolume" class="w3-input w3-border" type="text" placeholder="��'��" maxlength="99" value="${clien.transportVolume}" required></p>
		 <p><input name="season" class="w3-input w3-border" type="text" placeholder="���������" maxlength="40" value="${clien.season}" required></p>
		 <p><input name="cargo" class="w3-input w3-border" type="text" placeholder="������" maxlength="40" value="${clien.cargo}" required></p>
		 
		 <p><input name="otherInfo" class="w3-input w3-border" type="text" placeholder="��������� ����������" value="${clien.otherInfo}" maxlength="149" required></p>
		    <p>
  <input type="radio" id="tilt" name="typetruck" ${tilt} value="����" required>
  <label for="tilt">����</label>
  <input type="radio" id="ref" name="typetruck" ${ref} value="���">
  <label for="ref">���</label>
  <input type="radio" id="any" name="typetruck" ${any} value="���� ��� ���">
  <label for="any">���� ��� ���</label>
</p>
<p><textarea name="warning" class="w3-input w3-border" rows="5" placeholder="������������" maxlength="999"  required>${clien.warning}</textarea></p>
<p><input type="text" pattern="[^\\/`\/\x22]+" name="driverInstruction" class="w3-input w3-border" placeholder="���������� ��� ����" value="${clien.driverInstruction}" maxlength="999"  required></p>
<p><input type="checkbox" name="toblacklist" value="yesToBlackList" ${checkBlackList} > ������ � ������ ������</p>
		  <br>
		  <p><button name="button" type="submit" class="w3-button w3-padding-large w3-blue w3-margin-bottom" >������</button></p>
		 
        

    </div>
  </div>
</div>

<div id="subscribe1" class="w3-modal">
  <div class="w3-modal-content  w3-padding-large">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('subscribe1').style.display='none'" class="fa fa-remove w3-button w3-xlarge w3-right w3-transparent"></i>
      <p>&nbsp;</p>
	     <p><b>������ �������</b></p>
		
		 <p>  <select name="oblastFrom">
		 <option value="������� �������">������� �������</option>
    <option value="������� �������">������� �������</option>
    <option value="��������������� �������">��������������� �������</option>
    <option value="���������� �������">���������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="���������� �������">���������� �������</option>
    <option value="���������� �������">���������� �������</option>
    
    <option value="��������� �������">��������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="�������� �������">�������� �������</option>
    <option value="��������� ��������� ����">��������� ��������� ����</option>
    <option value="³������� �������">³������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="ʳ������������ �������">ʳ������������ �������</option>
    <option value="������� �������">������� �������</option>
    <option value="�������� �������">�������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="г�������� �������">г�������� �������</option>
    <option value="�����-���������� �������">�����-���������� �������</option>
    <option value="������������ �������">������������ �������</option>
    <option value="������������ �������">������������ �������</option>
    <option value="���������� �������">���������� �������</option>
    
  </select>&nbsp; - &nbsp;<select name="oblastTo">
   <option value="������� �������">������� �������</option>
    <option value="������� �������">������� �������</option>
    <option value="��������������� �������">��������������� �������</option>
    <option value="���������� �������">���������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="���������� �������">���������� �������</option>
    <option value="���������� �������">���������� �������</option>
    <option value="������� �������">������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="�������� �������">�������� �������</option>
    <option value="��������� ��������� ����">��������� ��������� ����</option>
    <option value="³������� �������">³������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="ʳ������������ �������">ʳ������������ �������</option>
    <option value="������� �������">������� �������</option>
    <option value="�������� �������">�������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="����������� �������">����������� �������</option>
    <option value="��������� �������">��������� �������</option>
    <option value="г�������� �������">г�������� �������</option>
    <option value="�����-���������� �������">�����-���������� �������</option>
    <option value="������������ �������">������������ �������</option>
    <option value="������������ �������">������������ �������</option>
    <option value="���������� �������">���������� �������</option>
    
  </select>&nbsp; <input name="directioninfo" type="text" placeholder="��������� ����������" maxlength="40"></p>

		  <br>
		  <p><button name="button1" type="submit" class="w3-button w3-padding-large w3-green w3-margin-bottom" formnovalidate>������ �������</button></p>
		 
        

    </div>
  </div>
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