<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Send Monitoring</title>
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
<link href="<c:url value="resources/css/style.css"/>" rel="stylesheet" type="text/css" media="all" />
<!-- /css -->

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
			    <li><a href="index.html">Console</a></li>
				<li><a href="index.html">New Client</a></li>
				<li><a href="about.html">New Route</a></li>
				<li><a href="news.html">Monitoring</a></li>
			</ul>
        </div><!--/.nav-collapse -->
		
    </div>
</nav>
<!-- /navigation --> 
<section class="inner-w3ls">
</section>
<!-- /header section -->
<form method="post" >
<section class="schedule-w3layouts">
	<div class="container">
		<h3 class="text-center" data-aos="zoom-in">Send Monitoring</h3>
		<div class="table-responsive" data-aos="flip-down">   
			<table class="table">
				<thead>
					<tr>
					    <th><h4>#</h4></th>
						<th><h4>Company</h4></th>
						<th><h4>Route</h4></th>
						<th><h4>Status</h4></th>
						<th><h4>Delivery</h4></th>
						<th><h4>Update</h4></th>
						
					</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${bookings}" var="booking" varStatus="theCount">
					<tr>
						<td><input type="checkbox" name="${theCount.count}" checked></td>
						<td>${booking.company}</td>
						<td>${booking.route}</td>
						   <td>${booking.status}</td>
						    <td>${booking.delivery}</td>
							 <td><label>${booking.update}</label></td>
					</tr> 
					</c:forEach>  
				</tbody>
				
			</table>
			 <button type="submit" class="btn btn-primary">Send Monitoring</button>
		</div>	
	</div>	
	
		
</section>	
</form>
<section class="results-w3ls">
	
</section>	
<section class="last-w3layouts">
	<div class="container">
		
		<p class="text-center">&copy; 2017 Developed for UPLG</p>
	</div>	
</section>
<!-- last section -->
<!-- js files -->
<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="resources/js/SmoothScroll.min.js"/>"></script>
<script src="<c:url value="resources/js/top.js"/>"></script> 
<script src="<c:url value="resources/js/modernizr.min.js"/>"></script>
<script src="<c:url value="resources/js/index.js"/>"></script>
<script src='<c:url value='resources/js/aos.js'/>'></script>
<script src="<c:url value="resources/js/aos2.js"/>"></script>
<!-- js for contact form -->
<script src="<c:url value="resources/js/jqBootstrapValidation.js"/>"></script>

<!-- //js for contact form -->		
<!-- /js files -->
</body>
</html>		