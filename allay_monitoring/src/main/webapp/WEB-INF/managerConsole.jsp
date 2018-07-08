<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Manager Console</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bike Race Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
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
<section class="inner-w3ls">
    <div class="container">
		<h3 class="text-center" data-aos="zoom-in">Manager Console</h3>
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                 <ol class="breadcrumb" data-aos="zoom-in">
                    <li><a href="editManagerClientConsole">Edit</a>
                    </li>
                    <li class="active">Client`s Manager</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
	</div>
</section>	
<!-- /header section -->
<section class="blogpost-w3layouts">
	<div class="container">
		
		<div class="col-lg-8" data-aos="flip-left">
			
			<!-- Blog Comments -->
		
			<!-- Comments Form -->
			<div class="well">
                <h4 data-aos="flip-up">Add Manager:</h4>
                <form method="post">
					<div class="form-group" data-aos="flip-up">
						<h4 data-aos="flip-up">Name</h4><br>
						<input type="text" name="name" class="form-control" id="mail" required data-validation-required-message="Please enter name."><br>
						<h4 data-aos="flip-up">Phone</h4><br>
						<input type="tel" name="phone" class="form-control" id="mail" required data-validation-required-message="Please enter phone number."><br>
						<h4 data-aos="flip-up">Mail</h4><br>
						<input type="email" name="mail" class="form-control" id="mail" required data-validation-required-message="Please enter email address."><br>
						
                    </div>
                    <button type="submit" name="edit" value="edit" class="btn btn-primary" data-aos="flip-up">Add Manager</button>
                </form>
            </div>
		
			<!-- Posted Comments -->
	

            <!-- Comment -->
            
			
		</div><! --/col-lg-8 -->
	 	<! -- SIDEBAR -->
	 	 <form method="post">
		<div class="col-lg-4" data-aos="flip-right">
		 	<h4 class="post-w3ls">Edit / Delete</h4>
		 	<div class="hline"></div>
			<ul class="popular-posts">
			
				<c:forEach items="${managers}" var="manager">

                <li data-aos="flip-up">			
				<div class="postimg-agile">
				<button type="submit" name="edit" value ="${manager.name}" class="btn btn-link" data-aos="flip-up">${manager.name}
						
							<div class="hover15 column">
							
							</div>	
						</button>
					</div>		
					<div class="postinfo-agile">	
						<p>${manager.mail}</p>
						<em>${manager.phone}</em>
					</div>
					<div class="clearfix"></div>	
		        </li>
		        </c:forEach>
		      
		    </ul>   
			<div class="hline"></div>
		</div>
		 </form>
		<div class="clearfix"></div>
	</div><! --/container -->
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
<!-- /js files -->
<script src="<c:url value="resources/js/jqBootstrapValidation.js"/>"></script>
</body>
</html>	