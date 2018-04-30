<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

	<title>LCL Calculator</title>

	<!-- For-Mobile-Apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //For-Mobile-Apps -->

	<!-- Style -->
	<link rel="stylesheet" href="<c:url value="resources/css/style.css" />" type="text/css" media="all" />
	<link href="<c:url value="resources/css/font-awesome.css" />" rel="stylesheet"> 
	<!-- Default-JavaScript-File --> <script type="text/javascript" src="<c:url value="resources/js/jquery.min.js" />"></script>

	<!-- Web-Fonts -->
		<link href='//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>
		<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
	<!-- //Web-Fonts -->
	<style>
whitecolour{
    color: white;
}
[hiding="false"]{
	visibility: collapse;
}
</style>
</head>
<body>

	<h1>LCL Calculator</h1>

	<div class="container">

		<div class="tab">

			<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
				<script src="<c:url value="resources/js/easyResponsiveTabs.js"/>" type="text/javascript"></script>
				<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default', //Types: default, vertical, accordion
							width: 'auto', //auto or any width like 600px
							fit: true,   // 100% fit in a container
							closed: 'accordion', // Start closed if in accordion view
							activate: function(event) { // Callback function if tab is switched
								var $tab = $(this);
								var $info = $('#tabInfo');
								var $name = $('span', $info);
								$name.text($tab.text());
								$info.show();
							}
						});

						$('#verticalTab').easyResponsiveTabs({
							type: 'vertical',
							width: 'auto',
							fit: true
						});
					});
				</script>

				<div class="tabs">

					<div class="tab-left">
						<ul class="resp-tabs-list">
							<li class="resp-tab-item"><i class="fa fa-plane" aria-hidden="true"></i>America</li>
							<li class="resp-tab-item"><i class="fa fa-university" aria-hidden="true"></i>China & Eastern Asia</li>
							<li class="resp-tab-item"><i class="fa fa-suitcase" aria-hidden="true"></i>India & Southern Asia</li>
							<li class="resp-tab-item"><i class="fa fa-car" aria-hidden="true"></i>Africa & Middle East</li>
							<li class="resp-tab-item"><i class="fa fa-ship" aria-hidden="true"></i>Australia & NZ</li>
						</ul>
					</div>

					<div class="tab-right">
					
						
						<div class="resp-tabs-container">
						
							<div class="tab-1 resp-tab-content">
							
								<div class="w3l-sign-in">
									
								<form method="post">
								<whitecolour>
	                                ${waybill}<br>
									<br>
	                              
	                                LCL tariff - ${seaRate} USD;<br>
	                                Delivery date - ${seaTime} days;<br>
									
									 </whitecolour>
									 
									<div class="submit">
	                                <br><input type="submit"  name="booking" value="Booking via LCL"><br><br>
									</div>
	                                <element hiding = ${rail}>
									
	                                <whitecolour>
                                    Rail tariff - ${railRate} USD;<br>
	                                Delivery date - ${railTime} days;<br>
									</whitecolour>
									
									<div class="submit">
	                                <br><input type="submit" name="booking" value="Booking via Rail"><br>
									</div>
                                    </element>
									<whitecolour>
                                    <br>
                                    - the rate is calculated for a consolidated non-dangerous cargo;<br>
                                    - payment is possible in UAH, USD and EUR;<br>
                                    - delivery for warehouse of Client.
                                	<br>
									</whitecolour>
                                    </form>	
									<br>
									<div class="submit" >
	                                <br><input type="submit" style="background-color:transparent; border: 2px solid #e7e7e7"  name="reset" value="Reset"  onclick="window.location='/lcl/calculator';"><br>
									</div>
								</div>
							</div>
							
							<!--<div class="tab-1 resp-tab-content">
								<div class="register agileits">
							
								
								
								
								</div>
							</div>
							<div class="tab-1 resp-tab-content gallery-images">
								<div class="wthree-subscribe">	
								
								
								
								
								</div>
							</div>
							<div class="tab-1 resp-tab-content">
								<div class="agileinfo-recover">
								
								
								
								</div>
							</div>
							<div class="tab-1 resp-tab-content">
								<div class="agile-send-mail">
							
							
							
							</div>
							</div> 
							-->
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<p> &copy; 2017 Travel Packages Widget. All Rights Reserved .</p>
	</div>
	<!--start-date-piker-->
		<link rel="stylesheet" href="<c:url value="resources/css/jquery-ui.css" />" />
		<script src="<c:url value="resources/js/jquery-ui.js" />" ></script>
			<script>
				$(function() {
				$( "#datepicker,#datepicker1,#datepicker2,#datepicker3,#datepicker4,#datepicker5,#datepicker6,#datepicker7" ).datepicker();
				});
			</script>
<!-- 97-rgba(0, 0, 0, 0.75)/End-date-piker -->	
</body>
</html>