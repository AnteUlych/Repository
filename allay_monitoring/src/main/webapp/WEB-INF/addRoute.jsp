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
		    <li><a href="console">Console</a></li>
				<li><a href="addClient">New Client</a></li>
				<li><a href="addRoute">New Route</a></li>
			</ul>
        </div><!--/.nav-collapse -->
		
    </div>
</nav>
<!-- /navigation --> 

<section class="contact-w3ls">	
    <!-- Contact Form -->
	<div class="container">	
		<div class="col-md-12">
		<br><br><br>
			<h3 class="text-center" data-aos="flip-up">Add Route</h3>
			<form method="post" >
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Route:</label>
                        <input type="text" name="route" class="form-control" id="name" required data-validation-required-message="Please enter Route.">
                        <p class="help-block"></p>
                    </div>
                </div>
				<div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Company:</label><br>
                         <c:forEach items="${clients}" var="customer" varStatus="step">
                       <input type="radio" name="client" required data-validation-required-message="Please select manager" value ="${customer}"> <label>${customer}</label><br>
		             </c:forEach>
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Delivery Date:</label>
                        <input type="date" name="delivery" class="form-control" id="name" required data-validation-required-message="Please enter ETD.">
                    </div>
                </div>
			
				
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary" data-aos="flip-up">Add Booking</button>
            </form>
		</div>
	</div>
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