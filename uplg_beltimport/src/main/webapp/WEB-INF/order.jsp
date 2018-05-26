<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>

<head>
	<title>UPLG</title>
	<!-- Meta tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="LTL"
	/>
	<script type="application/x-javascript">
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
		
	</script>
	<!-- //Meta tags -->
	<!-- Stylesheet -->
	<link href="<c:url value="resources/css/wickedpicker.css" />" rel="stylesheet" type='text/css' media="all" />
	<link rel="stylesheet" href="<c:url value="resources/css/jquery-ui.css" />"/>
	<link href="<c:url value="resources/css/style.css"/>" rel='stylesheet' type='text/css' />
	<!-- //Stylesheet -->
	<!--fonts-->
	<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Montserrat+Alternates:200,400,500,600,700" rel="stylesheet">
	<!--//fonts-->
	<style>
	     whitetext {
            color: white;
        }

	</style>
</head>

<body>
	<!--background-->
	<h1> <span>B</span>eltimport <span>L</span>ogistic <span>S</span>ervice</h1>
	<div class="bg-main">
		<div class="left-img">
			<h3>UPLG service:</h3>
			<ul>
				<li><span>.</span>24x7 UPLG service are available</li>
				<li><span>.</span>Online booking facility</li>
				<li><span>.</span>Prices includes delivery to WH at Kyiv</li>
				<li><span>.</span>Prices are valid only for Beltinport Ltd.</li>
			</ul>
			<p>- Your logistics is our goal.</p>
		</div>
		<div class="book-appointment">
			<h2>Order</h2>
			<div class="book-form">
				<whitetext>
							Dear ${request.client}, <br>
							Thank You for Your booking!<br><br>
							In 20 minutes our manager will connect with You to confirm booking details.<br><br><br>
							
							</whitetext>
					
			
					<h2 class="sub-head">Booking Details</h2>
					<div class="phone_email">
						<div class="btm-spc form-text1">
							<whitetext>
							<br>
							Route: ${request.address} - Kyiv, UA<br>
							Quantity: ${request.quantity} pallets (1200*800)<br>
							Ready: ${request.pickup}<br>
							${delivery}<br>
							${price} <br>
							<c:forEach var="document" items="${request.documentation}">  
		       	            + <c:out value="${document}"/> <br>
							
	                        </c:forEach>
							<br><br><br><br>
							Visit our <a href="http://uplg.com.ua/">webpage</a>.
							</whitetext>
						</div>
	
					</div>
				
			</div>
	
		</div>
	</div>
	<!--copyright-->
	<div class="copy">
		<p>&copy; 2018. Designed by <a href="https://www.facebook.com/profile.php?id=100009594527667">Anton Ulytskyi</a> </p>
	</div>
	<!--//copyright-->
	<script type="text/javascript" src="<c:url value="resources/js/jquery-2.2.3.min.js" />"></script>
	<!-- Time -->
	<script type="text/javascript" src="<c:url value="resources/js/wickedpicker.js" />"></script>
	<script type="text/javascript">
		$('.timepicker').wickedpicker({
			twentyFour: false
		});
	</script>
	<!--// Time -->
	<!-- Calendar -->
	<script src="<c:url value="resources/js/jquery-ui.js" />"></script>
	
	<!-- //Calendar -->

</body>

</html>