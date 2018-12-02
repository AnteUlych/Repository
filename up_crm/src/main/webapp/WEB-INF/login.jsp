<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="zxx">

<head>
	<title>UPLG</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />

	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="<c:url value="resources/css/style.css" />" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="<c:url value="resources/css/fontawesome-all.css" />">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Nova+Round" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<!-- title -->
	<h1>
		<span>C</span>ustomer  
		<span>R</span>elationship
		<span>M</span>anagement
	</h1>
	<!-- //title -->
	<!-- content -->
	<div class="sub-main-w3">
		<form method="post">
			<h2>Login Your Account</h2>
			
			<div class="form-group">
				<input type="password" class="form-control textbox" name="password" placeholder="Password" required="">
			</div>
			<div class="form-group-2">
				<button class="btn  btn-osx btn-lg" type="submit">
					<i class="fas fa-long-arrow-alt-right"></i>
				</button>
			</div>

		</form>
		<!-- //switch -->
	</div>
	<!-- //content -->

	<!-- copyright -->
	<div class="footer">
		<p>&copy;  Design for
			<a href="https://www.facebook.com/profile.php?id=100009594527667">UPLG</a>
		</p>
	</div>
	<!-- //copyright -->


</body>

</html>