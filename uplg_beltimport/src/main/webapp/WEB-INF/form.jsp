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
			<p>- Your logistic is our goal.</p>
		</div>
		<div class="book-appointment">
			<h2>Personal Details</h2>
			<div class="book-form">
				<form:form method="POST" commandName="request">
					<!--<div class="phone_email">
						<div class="btm-spc form-text1">
							<input type="text" name="Name" placeholder="Full Name" required="">
						</div>
						<div class="btm-spc form-text2">
							<input type="text" name="Phone no" placeholder="Phone number" required="">
						</div>
					</div>-->
					
					<div class="btm-spc form-text1">
							<form:select path="client" id="country1" onchange="change_country(this.value)" class="frm-field required sect">
							<form:option value="" label="Manager" />
					        <form:options items="${clients}" />
					        </form:select>
						</div>
						
					<!--<div class="btm-spc form-text">
						<input type="email" name="email" placeholder="Email" required="">
					</div> -->
					<div class="clear"></div>
					<h2 class="sub-head">Booking Details</h2>
					<div class="phone_email">
						<div class="btm-spc form-text1">
						<!--<form:input path="pickup" id="datepicker" name="Text" type="date" placeholder="Pick-up Date"></form:input>-->
							<form:input path="pickup" id="datepicker" name="Text" type="text" placeholder="Pick-up Date" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'dd/mm/yyyy';}"
							    required=""></form:input>
						</div>
						
						
						
						<div class="btm-spc form-text2">
						
						<br>
							<whitetext>
							${delivery}
							</whitetext>
							
							<!--<input type="text" id="timepicker" name="Time" class="timepicker form-control" placeholder="Pick-up Time" value="">-->
						</div>
					</div>
					<div class="phone_email">
					
					<div class="btm-spc form-text1">
							<form:select path="address" id="country1" onchange="change_country(this.value)" class="frm-field required sect">
												<form:option value="" label="Address" />
					                            <form:options items="${addresses}" />
											</form:select>
						</div>
						
						<div class="btm-spc form-text2">
							<br>
							<whitetext>
							${price}
							</whitetext>
						</div>
						<!--<div class="btm-spc form-text1">
							<input type="text" name="Pick-up Location" placeholder="Pick-up Location" required="">
						</div>
						<div class="btm-spc form-text2">
							<input type="text" name="Drop-off Location" placeholder="Drop-off Location" required="">
						</div>-->
					</div>

					<div class="phone_email">
						<div class="btm-spc form-text1">
							<form:select path="quantity" id="country1" onchange="change_country(this.value)" class="frm-field required sect">
												<form:option value="" label="Pallets (1200*800)" />
					                            <form:options items="${pallets}" />
											</form:select>
						</div>
						
						<div class="btm-spc form-text2">
							
							<whitetext>
							<c:forEach var="document" items="${request.documentation}">  
		       	            + <c:out value="${document}"/><br>
	                        </c:forEach>
							</whitetext>
						</div>
						<!--<div class="btm-spc form-text2">
							<select id="country" onchange="change_country(this.value)" class="frm-field required">
												<option value="">Direction</option>
												<option value="">Only One Way</option>
												<option value="">Return</option>       
											</select>
						</div>-->
					</div>
					<div class="package-info">
						<h6>Select Document Package</h6>
						<ul class="radio-button">
						<li>
						<form:checkboxes path="documentation" items="${documents}" />
						</li>
						<!--  
							<li>
								<input type="radio" id="a-option" name="selector1">
								<label for="a-option">EX-1</label>
								<div class="check"></div>
								
							</li>
							<li>
								<input type="radio" id="b-option" name="selector2">
								<label for="b-option">EUR1</label>
								<div class="check">
									<div class="inside"></div>
								</div>
							</li>
							<li>
								<input type="radio" id="c-option" name="selector1">
								<label for="c-option">T1</label>
								<div class="check">
									<div class="inside"></div>
								</div>
							</li>
							-->
						</ul>
						<div class="clear"></div>
					</div>
					
					<table style="width:100%">
					<tr>
					<td><input type="submit" style="width: 200px;" name="submit" value="Calculate"></td>
	               <!-- <input type="reset" value="Reset">-->
					<td><input type="submit" style="width: 200px; float: right;" name="submit" value="Booking"></td>
					</tr>
        	        </table>
					
					<div class="clear"></div>
				</form:form>
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
	<script>
		$(function () {
			$("#datepicker,#datepicker1,#datepicker2,#datepicker3").datepicker();
		});
	</script>
	<!-- //Calendar -->

</body>

</html>