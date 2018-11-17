<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>UPLG CRM</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
  <span class="w3-bar-item w3-right">UP Logistic Groupe </span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>

  <hr>

  <div class="w3-bar-block">
    <c:forEach items="${services}" var="service">
    <a href="/crm/service/${privateCode}${service}" class="w3-bar-item w3-button w3-padding">&nbsp; ${service}</a><br>
    </c:forEach>
	<br>
	<a href="/crm/editClient/${nextPage}" class="w3-bar-item w3-button w3-padding">edit client</a><br>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

 <div class="w3-container" id="contact">
    <h2>${company}</h2>
	Category: ${category}<br>
	Manager: ${person}<br>
    <i class="fa fa-phone" style="width:30px"></i>${phone}<br>
    <i class="fa fa-envelope" style="width:30px"> </i>${mail}<br>
    <p></p>
    <form method="post">
      <p><input class="w3-input w3-border" type="text" placeholder="Comment" maxlength="215" required  name="comment"></p>
      <p>Next Call:<input class="w3-input w3-border" type="date" required  name="nextcall"></p>
     
	  Funnel:<br>
				 <c:forEach items="${funnels}" var="fun" varStatus="step">
                       <input required type="radio" name="fun" value ="${fun}"> <label>${fun}</label><br>
		             </c:forEach>
		             <br>
					 
    <button type="submit" class="w3-button w3-green w3-third" name="add" value="add" ${mayIClick}>Add Information</button>
	<br>
    </form>
  </div>


  <div class="w3-container">
    <h5>Comments</h5>
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
	<c:forEach items="${statuses}" var="status">
  <tr>
	<td>${status.lasttime}</td>
    <td>${status.funnel}</td>
    <td>${status.answer}</td> 
  </tr>

</c:forEach>
    </table>
   
  </div>
  
   <div class="w3-container">
   <br>
    <h5>Requests:</h5>
    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
	
	<c:forEach items="${requests}" var="request">
	<tr>
	<td>${request.creating}</td>
	<td>${request.type}</td>
	<td>${request.readiness}</td> 
<td><a href="/crm/request/${today}_${managerId}_${request.id}">${request.route}</a></td>

<td>${request.size}</td>
<td>${request.weight}</td>
<td>${request.other}</td>
<td>${request.result}</td> 
</tr>
</c:forEach>
    </table><br>
   
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