<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Bike Race A Sports Category Flat Bootstrap Responsive  Website Template | Blogpost </title>
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
     
	
    </div>
</nav>
<!-- /navigation --> 
<!-- Page Content -->
<!-- header section -->
<section class="inner-w3ls">
    <div class="container">
		<h3 class="text-center" data-aos="zoom-in">Client`s Manager</h3>
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <ol class="breadcrumb" data-aos="zoom-in">
                  
                </ol>
            </div>
        </div>
        <!-- /.row -->
	</div>
</section>

<section class="schedule-w3layouts">
	<div class="container">
		<h3 class="text-center" data-aos="zoom-in">Change Client`s Manager</h3>
		<form method="post">
		<div class="table-responsive" data-aos="flip-down">   
			<table class="table">
				<thead>
					<tr>
				    	<th><h4>Client</h4></th>
				    	<c:forEach items="${managers}" var="manager">
				    	<th><h4>${manager}</h4></th>
					<!--  	<th><h4>Anton</h4></th>
						<th><h4>Inna</h4></th>
						<th><h4>Natasha</h4></th> -->
						</c:forEach>
					</tr>
				</thead>
				<tbody>
				 
				<c:forEach items="${clients}" var="client">
				    <tr>
						<td>${client.company}</td>
						
						<c:forEach items="${managers}" var="manager">
				    	<td><input type="radio" name="${client.company}" value="${manager}" <c:if test="${client.manager==manager}">checked</c:if>></td>
						</c:forEach>
						
						<!--  
						<td><input type="radio" name="${client}" value="${client}"></td>
						<td><input type="radio" name="${client}" value="${client}"></td>
						<td><input type="radio" name="${client}" value="${client}" checked></td>
						-->
					</tr> 
				</c:forEach>
				
				<!--  
					<tr>
						<td>M&M`s</td>
						<td><input type="radio" name="clent1" value="male"></td>
						<td><input type="radio" name="clent1" value="male"></td>
						<td><input type="radio" name="clent1" value="male" checked></td>
					</tr>      
					<tr>
						<td>Bounty</td>
						<td><input type="radio" name="clent2" value="male" checked></td>
						<td><input type="radio" name="clent2" value="male"></td>
						<td><input type="radio" name="clent2" value="male" ></td>
					</tr> 
					<tr>
						<td>Snikers</td>
						<td><input type="radio" name="clent3" value="male"></td>
						<td><input type="radio" name="clent3" value="male"></td>
						<td><input type="radio" name="clent3" value="male" checked></td>
					</tr> 
					<tr>
						<td>Mars</td>
						<td><input type="radio" name="clent4" value="male"></td>
						<td><input type="radio" name="clent4" value="male"checked></td>
						<td><input type="radio" name="clent4" value="male"></td>
					</tr> 
					-->
				</tbody>			
			</table>            
			
		</div>
		 <button type="submit" class="btn btn-primary" data-aos="flip-up" style="float: right;">Change</button>
		 </form>
	</div>	
	
</section>	

<section class="inner-w3ls">
    <div class="container">
		
        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <ol class="breadcrumb" >
                  
                </ol>
            </div>
        </div>
        <!-- /.row -->
	</div>
</section>

<section class="last-w3layouts">
	<div class="container">
	
		<p class="text-center">&copy; 2017 Bike Race. All Rights Reserved.</p>
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
<script src='<c:url value='resources/js/aos.js'/>'></script>
<script src="<c:url value="resources/js/aos2.js"/>"></script>
<!-- /js files -->
</body>
</html>	