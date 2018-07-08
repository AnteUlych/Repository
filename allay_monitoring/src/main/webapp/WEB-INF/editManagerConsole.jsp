<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Manager Console</title>
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
<nav class="navbar navbar-default navbar-top" data-aos="flip-up">
    <div class="container">
        <div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		
        </div>
     
	
    </div>
</nav>
<!-- /navigation --> 
<!-- Page Content -->
<!-- header section -->
<section class="contact-w3ls">	
    <!-- Contact Form -->
	<div class="container">	
		<div class="col-md-12">
		<br><br><br>
			<h3 class="text-center" data-aos="flip-up">Edit/Delete Manager ${manager.name}</h3>
			<form method="post">
               
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Phone Number:</label>
                        <input type="tel" name="phone" value="${manager.phone}" placeholder="${manager.phone}" class="form-control" id="phone" required data-validation-required-message="Please enter phone number.">
                    </div>
                </div>
                <div class="control-group form-group" data-aos="flip-up">
                    <div class="controls">
                        <label>Email Address:</label>
                        <input type="email" name="mail"  value="${manager.mail}" placeholder="${manager.mail}" class="form-control" id="mail" required data-validation-required-message="Please enter email address.">
                    </div>
                </div>
                <input type="hidden" name="managerName" value="${manager.name}">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
				
                <div id="success"></div>
                <!-- For success/fail messages -->
				<button type="submit" name="submit" value="edit" class="btn btn-primary" data-aos="flip-up">Edit Manager</button>
				
                <button type="submit" name="submit" value="delete" class="btn btn-danger"  data-aos="flip-up"style="float: right;" ${permissionToDelete}>Delete Manager</button>
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
<!-- /js files -->
<script src="<c:url value="resources/js/jqBootstrapValidation.js"/>"></script>
</body>
</html>	