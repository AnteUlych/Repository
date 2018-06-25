<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Monitoring</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="monitoring"/>
<!-- fonts -->
<link href="//fonts.googleapis.com/css?family=Michroma"   rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Comfortaa:300,400,700" rel="stylesheet">
<!-- /fonts -->
<!-- css -->
<link href="<c:url value="resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" media="all" />
<link href="<c:url value="resources/css/font-awesome.min.css" />" rel="stylesheet"  type="text/css" media="all" />
<link href="<c:url value='resources/css/aos.css' />" rel='stylesheet prefetch'  type="text/css" media="all" />
<link href="<c:url value="resources/css/style.css" />"  rel="stylesheet" type="text/css" media="all" />
<!-- /css -->
</head>
<body>

<!-- Page Content -->
<!-- header section -->
<section class="inner-w3ls">
    <div class="container">
		<h3 class="text-center" data-aos="zoom-in">Monitoring</h3>
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <ol class="breadcrumb" data-aos="zoom-in">
                    <li class="active">${booking.company}</li>
                    <li class="active">${booking.route}</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
	</div>
</section>
<!-- /header section -->
<section class="contact-w3layouts">
	<!-- Page Content -->
    <div class="container">
        <!-- Map Column -->
        <div class="col-md-8" data-aos="flip-left">
            <!-- Embedded Google Map --> 	
			
	
			<div class="map-w3ls">
			
			<div id="map" style="width:100%;height:400px"></div>

            <script>
              function myMap() {
                var myCenter = new google.maps.LatLng(${booking.longitude},${booking.latitude});
                var mapCanvas = document.getElementById("map");
                var mapOptions = {center: myCenter, zoom: 5};
                var map = new google.maps.Map(mapCanvas, mapOptions);
                var marker = new google.maps.Marker({position:myCenter});
                  marker.setMap(map);
                }
            </script>

             <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB9JP_ayj71orucQyQnfyX9j9VOtNs-Jd8&callback=myMap"></script>
				
			</div>
        </div>
        <!-- Contact Details Column -->
        <div class="col-md-4" data-aos="flip-right">
            <h3>Status Details</h3>
            <p><i class="fa fa-map-marker"></i>${booking.status}</p>
            <p><i class="fa fa-truck"></i> ETD ${booking.delivery}</p>
			<p><i class="fa fa-clock-o"></i> Update ${booking.update}</p>
			
			<br>
			<h3>All Bookings</h3>
            <p>

            <c:forEach items="${bookings}" var="transportation">
			<a href="${transportation.key}">${transportation.route}</a><br>
			</c:forEach>
			
			</p>
			<ul class="social-icons2">
				<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a></li>
			</ul>
        </div>
    </div>
</section>
		
<br>
<br>
<section class="last-w3layouts">
	<div class="container">

		<p class="text-center">&copy; 2017 Developed by <a href="https://www.facebook.com/profile.php?id=100009594527667">Anton Ulytskyi</a></p>
	</div>	
</section>
<!-- last section -->
<!-- back to top -->
<a href="#0" class="cd-top">Top</a>
<!-- /back to top -->	
<!-- js files -->
<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="resources/js/SmoothScroll.min.js"/>"></script>
<script src="<c:url value="resources/js/top.js"/>"></script> 
<script src="<c:url value="resources/js/modernizr.min.js"/>"></script>
<script src="<c:url value="resources/js/index.js"/>"></script>
<script src="<c:url value='resources/js/aos.js'/>"></script>
<script src="<c:url value="resources/js/aos2.js"/>"></script>
<!-- js for contact form -->
<script src="<c:url value="resources/js/jqBootstrapValidation.js"/>"></script>
<script src="<c:url value="resources/js/contact_me.js"/>"></script>
<!-- //js for contact form -->		
<!-- /js files -->



</body>
</html>		
