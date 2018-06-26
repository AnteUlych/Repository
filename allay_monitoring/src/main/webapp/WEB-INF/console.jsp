<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Monitoring</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- fonts -->
<link href="//fonts.googleapis.com/css?family=Michroma" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Comfortaa:300,400,700" rel="stylesheet">
<!-- /fonts -->
<!-- css -->
<link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href='<c:url value='resources/css/aos.css'/>' rel='stylesheet prefetch' type="text/css" media="all" />
<link href="<c:url value="resources/css/colorfulTab.min.css"/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="resources/css/style.css"/>" rel="stylesheet" type="text/css" media="all" />
<!-- /css -->
<style>

th, td {
    padding: 5px;
}
</style>
</head>
<body>
<!-- navigation -->
<nav class="navbar navbar-default navbar-fixed-top" data-aos="flip-up">
    <div class="container">
        <div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
        </div>
        <div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav slide-nav">
				<li><a href="index.html">New Client</a></li>
				<li><a href="about.html">New Route</a></li>
				<li><a href="news.html">Monitoring</a></li>

			</ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- /navigation --> 
<!-- Page Content -->
<!-- header section -->
<section class="inner-w3ls">
   
</section>
<!-- /header section -->

<section class="schedule-w3layouts">
	<div class="container">
		<h3 class="text-center" data-aos="zoom-in">Monitoring Settings</h3>
		<div class="table-responsive" data-aos="flip-down">   
			<table class="table">
				<thead>
					<tr>
						<th><h4>#</h4></th>
						<th><h4>Company</h4></th>
						<th><h4>Manager</h4></th>
						<th><h4>Route</h4></th>
						<th><h4>Status</h4></th>
						<th><h4>Delivery</h4></th>
						<th><h4>Update</h4></th>
						
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${bookings}" var="booking" varStatus="theCount">

			<tr class="${tableStatus[theCount.index]}">
				<td>${theCount.count}</td>
				<td>${booking.company}</td>
				<td>${managers[theCount.index]}</td>
			    <td>${booking.route}</td>
		
				<td><a data-toggle="modal"  href="#map${theCount.count}"  class="map-link" title="Click" ><i class="fa fa-map-marker" aria-hidden="true"></i>${booking.status}</a></td>
				<td>${booking.delivery}</td>
				<td>${booking.update}</td>
			</tr>
		</c:forEach>
		

					
				</tbody>
			</table>
		</div>	
	</div>	
	<form method="post" >
	<c:forEach items="${bookings}" var="booking" varStatus="theCount">
	<div class="modal fade" id="map${theCount.count}"   role="dialog" aria-labelledby="map${theCount.count}"  aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				  
					<h4 class="modal-title">  
	                ${bookings[theCount.index].route}
					</h4>
					
					
				</div>
				<div class="modal-body">
			
					<div id="googleMap${theCount.count}" style="width:100%;height:400px"></div>
				
		
			
					</div>
				</div>
				<div class="modal-footer">
				<table>
				<tr>
				<td>longitude:<input type = "number" step=any name="longitude${theCount.count}" placeholder= "${bookings[theCount.index].longitude}"  value= "${bookings[theCount.index].longitude}"></td>
				<td>latitude:<input type = "number" step=any name="latitude${theCount.count}" placeholder= "${bookings[theCount.index].longitude}" value=  "${bookings[theCount.index].latitude}"></td>
				<td>ETD:<input type = "date" name="etd${theCount.count}" value="${deliveries[theCount.index]}"></td>
				</tr>
				<tr>
				<td>status:<input type = "text" name="status${theCount.count}" placeholder= "${bookings[theCount.index].longitude}" value= "${bookings[theCount.index].status}"></td>
				<td><input type = "checkbox" name="close${theCount.count}">close booking</td>
				</tr>
				</table>
			
					<button type="submit" name = "submit" value="${theCount.count}" class="btn btn-default" >Add</button>
					<!--<input type="submit" name = "submit"  value="${theCount.count}">-->
				</div>	
			</div><!-- /.modal-content -->	
		</div><!-- /.modal-dialog -->
</c:forEach>
</form>
						  <script>

              function myMap() {
				  
				  <c:forEach items="${bookings}" var="booking" varStatus="theCount">
				  
                var myCenter${theCount.count}= new google.maps.LatLng(${bookings[theCount.index].longitude},${bookings[theCount.index].latitude});
                var mapCanvas${theCount.count} = document.getElementById("googleMap${theCount.count}");
                var mapOptions${theCount.count} = {center: myCenter${theCount.count}, zoom: 5};
                var googleMap${theCount.count} = new google.maps.Map(mapCanvas${theCount.count}, mapOptions${theCount.count});
                var marker${theCount.count} = new google.maps.Marker({position:myCenter${theCount.count}});
                  marker${theCount.count}.setMap(googleMap${theCount.count});
				  
				  </c:forEach>
				  
                }
			
            </script> 
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB9JP_ayj71orucQyQnfyX9j9VOtNs-Jd8&callback=myMap"></script>
</section>	





<section class="results-w3ls">
	
</section>	
<section class="last-w3layouts">
	<div class="container">
		
		<p class="text-center">&copy; 2017 Developed for UPLG</p>
	</div>	
</section>

<!-- last section -->	
<!-- back to top -->
<!-- /back to top -->
<!-- js files -->
<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="resources/js/SmoothScroll.min.js"/>"></script>
<script src="<c:url value="resources/js/top.js"/>"></script> 
<script src="<c:url value="resources/js/modernizr.min.js"/>"></script>
<script src="<c:url value="resources/js/index.js"/>"></script>
<script src='<c:url value='resources/js/aos.js'/>'></script>
<script src="<c:url value="resources/js/aos2.js"/>"></script>
<!-- js for table -->
<script type="text/javascript" src="<c:url value="resources/js/colorfulTab.min.js"/>"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#colorful").colorfulTab();      
    });
</script>
<!-- //js for table -->
<!-- /js files -->
</body>
</html>		