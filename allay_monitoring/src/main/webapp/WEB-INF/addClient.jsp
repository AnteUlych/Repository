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
			    <li><a href="index.html">Console</a></li>
				<li><a href="index.html">New Client</a></li>
				<li><a href="about.html">New Route</a></li>
				<li><a href="news.html">Monitoring</a></li>
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
			<h3 class="text-center" data-aos="flip-up">Add Client</h3>
			<form method="post">
               <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Company:</label>
                        <input type="text" name="companyClient" class="form-control" id="name" required data-validation-required-message="Please enter company.">
                        <p class="help-block"></p>
                    </div>
                </div>
				<div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Name of Client:</label>
                        <input  name="nameClient" type="text" class="form-control" id="name" required data-validation-required-message="Please enter name.">
                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Phone Number:</label>
                        <input  name="phoneClient" type="tel" class="form-control" id="phone" required data-validation-required-message="Please enter phone number.">
                    </div>
                </div>
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Email Address:</label>
                        <input  name="emailClient" type="email" class="form-control" id="email" required data-validation-required-message="Please enter email address.">
                    </div>
                </div>
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Manager:</label><br>
                     <c:forEach items="${managers}" var="manager_name" varStatus="step">
                       <input type="radio" name="managerClient" name="manager" required data-validation-required-message="Please select manager" value ="${manager_name}"> <label>${manager_name}</label><br>
		             </c:forEach>
					
                       <p class="help-block"></p>
                    </div>
                </div>
			
				
                <div id="success"></div>
               
                <button type="submit" class="btn btn-primary" data-aos="flip-up">Add Client</button>
			
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
<!--<script src="<c:url value="resources/js/contact_me.js"/>"></script>-->
<!-- //js for contact form -->		
<!-- /js files -->
</body>
</html>		