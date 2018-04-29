<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

	<title>LCL Calculator</title>

	<!-- For-Mobile-Apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="доставка из китая, морские перевозки, посчитать груз, доставка из америки" />
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
									<form:form method="POST" class="agile_form" commandName="route">
										<!-- <input type="text" placeholder="Your Name" name="name" class="name agileits" required=""/>
										<input placeholder="Date" class="date" id="datepicker" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/> -->
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
											<!--  <select>	-->
											<form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:option value="Buenos Aires" label="Buenos Aires, Argentina" />
					                          <form:option value="Rio Grande, Brasil" label="Rio de Janeiro, Brasil" />	
					  								<!-- 				
												<option value="0">FOB (port of loading)</option>
												<option value="Buenos Aires, Argentina">Buenos Aires, Argentina</option>
												<option value="Rosario, Argentina">Rosario, Argentina</option>	
												<option value="Betim, Brasil">Betim, Brasil</option>
												<option value="Curitiba, Brasil">Curitiba, Brasil</option>
												<option value="Itajai, Brasil">Itajai, Brasil</option>
												<option value="Porto Alegro, Brasil">Porto Alegro, Brasil</option>
												<option value="Rio de Janeiro, Brasil">Rio de Janeiro, Brasil</option>
												<option value="Rio Grande, Brasil">Rio Grande, Brasil</option>
												<option value="Santos, Brasil">Santos, Brasil</option>
												<option value="Valparaiso, Chile">Valparaiso, Chile</option>
												<option value="Callao, Peru">Callao, Peru</option>
												<option value="Asuncion, Paraguay">Asuncion, Paraguay</option>
												<option value="Montevideo, Uruguay">Montevideo, Uruguay</option>
												<option value="Montreal, Canada">Montreal, Canada</option>
												<option value="Toronto, Canada">Toronto, Canada</option>
												<option value="Vancouver, Canada">Vancouver, Canada</option>
												<option value="Altamira, Mexico">Altamira, Mexico</option>
												<option value="Mexico City , Mexico">Mexico City , Mexico</option>
												<option value="Vera Cruz, Mexico">Vera Cruz, Mexico</option>
												<option value="Atlanta, USA">Atlanta, USA</option>
												<option value="Baltimore, USA">Baltimore, USA</option>
												<option value="Boston, USA">Boston, USA</option>
												<option value="Charleston, USA">Charleston, USA</option>
												<option value="Charlotte, USA">Charlotte, USA</option>
												<option value="Chicago, USA<">Chicago, USA</option>
												<option value="Cleveland, USA">Cleveland, USA</option>
												<option value="Dallas, USA">Dallas, USA</option>
												<option value="Detroit, USA">Detroit, USA</option>
												<option value="Houston, USA">Houston, USA</option>
												<option value="Los Angeles, USA">Los Angeles, USA</option>
												<option value="Memphis, USA">Memphis, USA</option>
												<option value="Miami, USA">Miami, USA</option>
												<option value="New Orleans, USA">New Orleans, USA</option>
												<option value="New York, USA">New York, USA</option>
												<option value="Norfolk, USA">Norfolk, USA</option>
												<option value="Philadelphia, USA">Philadelphia, USA</option>
												<option value="Portland, USA">Portland, USA</option>
												<option value="San Francisco, USA">San Francisco, USA</option>
												<option value="Seattle, USA">Seattle, USA</option>
												 -->
											  </form:select>
											</div>
											<div class="section_class_agileits sec-right">
											
											   <form:select path="destination">		
											   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                           <form:option value="Lviv" label="Lviv" />
					                           	  
	                                           </form:select>
											<!--  
											   <select>
												<option value="0">FOT (city of destination)</option>
												<option value="Kiev">Kiev, UA</option>
												<option value="Cherkasy‎">Cherkasy‎, UA</option>
												<option value="Chernihiv">Chernihiv, UA</option>
												<option value="Chernivtsi‎">Chernivtsi‎, UA</option>
												<option value="Dnipro‎">Dnipro‎, UA</option>
												<option value="Ivano-Frankivsk">Ivano-Frankivsk, UA</option>
												<option value="Kharkiv">Kharkiv, UA</option>
												<option value="Kherson">Kherson, UA</option>
												<option value="Khmelnytskyi">Khmelnytskyi, UA</option>
												<option value="Kropyvnytskyi‎">Kropyvnytskyi‎, UA</option>
												<option value="Lutsk‎">Lutsk‎, UA</option>
												<option value="Lviv‎">Lviv‎, UA</option>
												<option value="Mykolaiv‎">Mykolaiv‎, UA</option>
												<option value="Odessa‎">Odessa‎, UA</option>
												<option value="Poltava‎‎">Poltava‎‎, UA</option>
												<option value="Rivne‎">Rivne‎, UA</option>
												<option value="Sumy‎">Sumy‎, UA</option>
												<option value="Ternopil‎">Ternopil‎, UA</option>
												<option value="Uzhhorod‎">Uzhhorod‎, UA</option>
												<option value="Vinnytsia‎">Vinnytsia‎, UA</option>
												<option value="Zaporizhia‎">Zaporizhia‎, UA</option>
												<option value="Zhytomyr">Zhytomyr, UA</option>
											
											  </select>
											  -->  
											</div>	
											<div class="clear"></div>
										</div>	
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											 <form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
					                         <form:option value="1" label="1-2 cbm" />
					                         <form:option value="2" label="2-3 cbm" />	  
	                                         </form:select>
											<!--  
											 <select>
												<option value="0">Volume (cbm)</option>
												<option value="1">less 1.0 cbm</option>
												<option value="1">1.0-1.5 cbm</option>
												<option value="2">1.5-2.0 cbm</option>
												<option value="2">2.0-2.5 cbm</option>
												<option value="3">2.5-3.0 cbm</option>
												<option value="3">3.0-3.5 cbm</option>
												<option value="4">3.5-4.0 cbm</option>
												<option value="4">4.0-4.5 cbm</option>
												<option value="5">4.5-5.0 cbm</option>
												<option value="5">5.0-5.5 cbm</option>
												<option value="6">5.5-6.0 cbm</option>
												<option value="6">6.0-6.5 cbm</option>
												<option value="7">6.5-7.0 cbm</option>
												<option value="7">7.0-7.5 cbm</option>
												<option value="8">7.5-8.0 cbm</option>
											 </select>-->
											</div>	
											<div class="section_class_agileits sec-right">
											
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5t" />	  
	                                         </form:select>
											<!--  
											  <select>
												<option value="0">Weight (t)</option>
												<option value="1">less 0.5 t</option>
											    <option value="1">0.5-1.0 t</option>
												<option value="1">1.0-1.5 t</option>
												<option value="2">1.5-2.0 t</option>
												<option value="2">2.0-2.5 t</option>
												<option value="3">2.5-3.0 t</option>
												<option value="3">3.0-3.5 t</option>
												<option value="4">3.5-4.0 t</option>
												<option value="4">4.0-4.5 t</option>
												<option value="5">4.5-5.0 t</option>
												<option value="5">5.0-5.5 t</option>
												<option value="6">5.5-6.0 t</option>
												<option value="6">6.0-6.5 t</option>
												<option value="7">6.5-7.0 t</option>
												<option value="7">7.0-7.5 t</option>
												<option value="8">7.5-8.0 t</option>
											 </select>
											 -->
											</div>
											<div class="clear"></div>
										
										</div>		
									
										<div class="submit">
										  <input type="submit" value="calculate">
										</div> 
									</form:form>	
								</div>
							</div>
							
							<div class="tab-1 resp-tab-content">
								<div class="register agileits">
								<!--<form action="#" method="post" class="agile_form">-->
								<form:form method="POST" class="agile_form" commandName="route">
										<!--<input type="text" placeholder="Your Name" name="name" class="name agileits" required=""/>-->
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:option value="Singapore, Singapore" label="Singapore, Singapore" />
					                          <form:option value="Shanghai, China" label="Shanghai, China" />	
					                          </form:select>
											 <!-- <select>
												<option value="0">FOB (port of loading)</option>
												<option value="Singapore, Singapore">Singapore, Singapore</option>
												<option value="Beijing City, China">Beijing City, China</option>
												<option value="Dalian, China">Dalian, China</option>
												<option value="Foshan, China">Foshan, China</option>
												<option value="Fuzhou, China">Fuzhou, China</option>
												<option value="Guangzhou, China">Guangzhou, China</option>
												<option value="Hong Kong, China">Hong Kong, China</option>
												<option value="Huangpu, China">Huangpu, China</option>
												<option value="Jiangmen, China">Jiangmen, China</option>
												<option value="Ningbo, China">Ningbo, China</option>
												<option value="Qingdao, China">Qingdao, China</option>
												<option value="Shanghai, China">Shanghai, China</option>
												<option value="Shantou, China">Shantou, China</option>
												<option value="Shenzhen, China">Shenzhen, China</option>
												<option value="Shunde, China">Shunde, China</option>
												<option value="Yantian, China">Yantian, China</option>
												<option value="Xiamen, China">Xiamen, China</option>
												<option value="Xingang / Tianjin, China">Xingang / Tianjin, China</option>
												<option value="Zhongshan, China">Zhongshan, China</option>
												<option value="Zhuhai, China">Zhuhai, China</option>
												<option value="Belawan, Indonesia">Belawan, Indonesia</option>
												<option value="Jakarta, Indonesia">Jakarta, Indonesia</option>
												<option value="Semarang, Indonesia">Semarang, Indonesia</option>
												<option value="Surabaya, Indonesia">Surabaya, Indonesia</option>
												<option value="Kobe, Japan">Kobe, Japan</option>
												<option value="Nagoya, Japan">Nagoya, Japan</option>
												<option value="Osaka, Japan">Osaka, Japan</option>
												<option value="Tokyo, Japan">Tokyo, Japan</option>
												<option value="Yokohama, Japan">Yokohama, Japan</option>
												<option value="Busan, Korea">Busan, Korea</option>
												<option value="Inchon, Korea<">Inchon, Korea</option>
												<option value="Port Kelang, Malaysia">Port Kelang, Malaysia</option>
												<option value="Pasir Gudang, Malaysia">Pasir Gudang, Malaysia</option>
												<option value="Penang, Malaysia">Penang, Malaysia</option>
												<option value="Port Louis, Mauritius">Port Louis, Mauritius</option>
												<option value="Yangon, Mynamar">Yangon, Mynamar</option>
												<option value="Cebu, Philipines">Cebu, Philipines</option>
												<option value="Manila, Philipines">Manila, Philipines</option>
												<option value="Kaohsiung, Taiwan">Kaohsiung, Taiwan</option>
												<option value="Keelung, Taiwan">Keelung, Taiwan</option>
												<option value="Taichung, Taiwan">Taichung, Taiwan</option>
												<option value="Bangkok, Thailand">Bangkok, Thailand</option>
												<option value="Haiphong, Vietnam">Haiphong, Vietnam</option>
												<option value="Ho Chi Minh City, Vietnam">Ho Chi Minh City, Vietnam</option>
												<option value="Danang, Vietnam">Danang, Vietnam</option>
		
											  </select> --> 
											</div>
											
											<div class="clear"></div>
									<!--	</div>
										
										<input placeholder="Check in date" class="date" id="datepicker3" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>
										<input placeholder="Check out date" class="date" id="datepicker4" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>										
										<div class="section_class_agileits sec-right">
											  <select>
												<option value="0">Rooms</option>
												<option value="1">Single Room</option>
												<option value="3">Double Room</option>
												<option value="2">Suit Room</option>
				
											  </select>
											</div>
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											 <select>
												<option value="0">Adults</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3"> 2</option>
												<option value="4">3 or 3+</option>
											 </select>
											</div>	
											<div class="section_class_agileits sec-right">
											  <select>
												<option value="0">Children</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3"> 2</option>
												<option value="4">3 or 3+</option>
											 </select>
											</div>
											<div class="clear"></div>
										</div>		-->		
										<div class="section_class_agileits sec-right">
										
										 <form:select path="destination">		
											   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                          <form:option value="Lviv" label="Lviv" />
					                           	  
	                                     </form:select>
											<!--    <select>
												<option value="0">FOT (city of destination)</option>
												<option value="Kiev">Kiev, UA</option>
												<option value="Cherkasy‎">Cherkasy‎, UA</option>
												<option value="Chernihiv">Chernihiv, UA</option>
												<option value="Chernivtsi‎">Chernivtsi‎, UA</option>
												<option value="Dnipro‎">Dnipro‎, UA</option>
												<option value="Ivano-Frankivsk">Ivano-Frankivsk, UA</option>
												<option value="Kharkiv">Kharkiv, UA</option>
												<option value="Kherson">Kherson, UA</option>
												<option value="Khmelnytskyi">Khmelnytskyi, UA</option>
												<option value="Kropyvnytskyi‎">Kropyvnytskyi‎, UA</option>
												<option value="Lutsk‎">Lutsk‎, UA</option>
												<option value="Lviv‎">Lviv‎, UA</option>
												<option value="Mykolaiv‎">Mykolaiv‎, UA</option>
												<option value="Odessa‎">Odessa‎, UA</option>
												<option value="Poltava‎‎">Poltava‎‎, UA</option>
												<option value="Rivne‎">Rivne‎, UA</option>
												<option value="Sumy‎">Sumy‎, UA</option>
												<option value="Ternopil‎">Ternopil‎, UA</option>
												<option value="Uzhhorod‎">Uzhhorod‎, UA</option>
												<option value="Vinnytsia‎">Vinnytsia‎, UA</option>
												<option value="Zaporizhia‎">Zaporizhia‎, UA</option>
												<option value="Zhytomyr">Zhytomyr, UA</option>
											
											  </select>-->
											</div>	
											<div class="clear"></div>
										</div>	
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
					                         <form:option value="1" label="1-2 cbm" />
					                         <form:option value="2" label="2-3 cbm" />	  
	                                         </form:select>
										<!--  	 <select>
												<option value="0">Volume (cbm)</option>
												<option value="1">less 1.0 cbm</option>
												<option value="1">1.0-1.5 cbm</option>
												<option value="2">1.5-2.0 cbm</option>
												<option value="2">2.0-2.5 cbm</option>
												<option value="3">2.5-3.0 cbm</option>
												<option value="3">3.0-3.5 cbm</option>
												<option value="4">3.5-4.0 cbm</option>
												<option value="4">4.0-4.5 cbm</option>
												<option value="5">4.5-5.0 cbm</option>
												<option value="5">5.0-5.5 cbm</option>
												<option value="6">5.5-6.0 cbm</option>
												<option value="6">6.0-6.5 cbm</option>
												<option value="7">6.5-7.0 cbm</option>
												<option value="7">7.0-7.5 cbm</option>
												<option value="8">7.5-8.0 cbm</option>
											 </select>-->
											</div>	
											<div class="section_class_agileits sec-right">
											
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5t" />	  
	                                         </form:select>
	                                         <!--  
											  <select>
												<option value="0">Weight (t)</option>
												<option value="1">less 0.5 t</option>
											    <option value="1">0.5-1.0 t</option>
												<option value="1">1.0-1.5 t</option>
												<option value="2">1.5-2.0 t</option>
												<option value="2">2.0-2.5 t</option>
												<option value="3">2.5-3.0 t</option>
												<option value="3">3.0-3.5 t</option>
												<option value="4">3.5-4.0 t</option>
												<option value="4">4.0-4.5 t</option>
												<option value="5">4.5-5.0 t</option>
												<option value="5">5.0-5.5 t</option>
												<option value="6">5.5-6.0 t</option>
												<option value="6">6.0-6.5 t</option>
												<option value="7">6.5-7.0 t</option>
												<option value="7">7.0-7.5 t</option>
												<option value="8">7.5-8.0 t</option>
											 </select>-->
											</div>
											<div class="clear"></div>
										
										</div>		
										
										<div class="submit">
										  <input type="submit" value="calculate">
										</div>   
									</form:form>	
								</div>
							</div>
							<div class="tab-1 resp-tab-content gallery-images">
								<div class="wthree-subscribe">	
								<form:form method="POST" class="agile_form" commandName="route">
									<!--<form action="#" method="post" class="agile_form">-->
									<!--	<input type="text" placeholder="Your Name" name="name" class="name agileits" required=""/>
										<input type="text" placeholder="Going to landmark" name="name" class="name agileits" required=""/>
										
										<input placeholder="Check in date" class="date" id="datepicker1" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>
										<input placeholder="Check out date" class="date" id="datepicker2" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>										
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											 <select>
												<option value="0">Guests</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3"> 2</option>
												<option value="4">3 or 3+</option>
											 </select>
											</div>	
											
										</div>				
										<div class="submit">
										  <input type="submit" value="search">
										</div> -->
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:option value="Chittagong, Bangladesh" label="Chittagong, Bangladesh" />
					                          <form:option value="Nhava Sheva, India" label="Nhava Sheva, India" />	
					                          </form:select>
					                          
									<!--  
											<select>														
												<option value="0">FOB (port of loading)</option>
												<option value="Chittagong, Bangladesh">Chittagong, Bangladesh</option>
												<option value="Ahmedabad, India">Ahmedabad, India</option>
												<option value="Bangalore, India">Bangalore, India</option>
												<option value="Baroda, India">Baroda, India</option>
												<option value="Calcutta, India">Calcutta, India</option>
												<option value="Chennai, India">Chennai, India</option>
												<option value="Cochin, India">Cochin, India</option>
												<option value="Hyderabad, India">Hyderabad, India</option>
												<option value="Mumbai, India">Mumbai, India</option>
												<option value="Delhi, India">Delhi, India</option>
												<option value="Nhava Sheva, India">Nhava Sheva, India</option>
												<option value="Tuticorin, India">Tuticorin, India</option>
												<option value="Karachi, Pakistan">Karachi, Pakistan</option>
												<option value="Colombo, Sri Lanka">Colombo, Sri Lanka</option>
											  </select>
											  -->
											</div>
											
											<div class="section_class_agileits sec-right">
											
											 <form:select path="destination">		
											   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                          <form:option value="Lviv" label="Lviv" />
					                           	  
	                                     </form:select>
	                                     <!--  
											  <select>
												<option value="0">FOT (city of destination)</option>
												<option value="Kiev">Kiev, UA</option>
												<option value="Cherkasy‎">Cherkasy‎, UA</option>
												<option value="Chernihiv">Chernihiv, UA</option>
												<option value="Chernivtsi‎">Chernivtsi‎, UA</option>
												<option value="Dnipro‎">Dnipro‎, UA</option>
												<option value="Ivano-Frankivsk">Ivano-Frankivsk, UA</option>
												<option value="Kharkiv">Kharkiv, UA</option>
												<option value="Kherson">Kherson, UA</option>
												<option value="Khmelnytskyi">Khmelnytskyi, UA</option>
												<option value="Kropyvnytskyi‎">Kropyvnytskyi‎, UA</option>
												<option value="Lutsk‎">Lutsk‎, UA</option>
												<option value="Lviv‎">Lviv‎, UA</option>
												<option value="Mykolaiv‎">Mykolaiv‎, UA</option>
												<option value="Odessa‎">Odessa‎, UA</option>
												<option value="Poltava‎‎">Poltava‎‎, UA</option>
												<option value="Rivne‎">Rivne‎, UA</option>
												<option value="Sumy‎">Sumy‎, UA</option>
												<option value="Ternopil‎">Ternopil‎, UA</option>
												<option value="Uzhhorod‎">Uzhhorod‎, UA</option>
												<option value="Vinnytsia‎">Vinnytsia‎, UA</option>
												<option value="Zaporizhia‎">Zaporizhia‎, UA</option>
												<option value="Zhytomyr">Zhytomyr, UA</option>
											
											  </select>
											  -->
											</div>	
											<div class="clear"></div>
										</div>	
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
					                         <form:option value="1" label="1-2 cbm" />
					                         <form:option value="2" label="2-3 cbm" />	  
	                                         </form:select>
	                                         <!--  
											 <select>
												<option value="0">Volume (cbm)</option>
												<option value="1">less 1.0 cbm</option>
												<option value="1">1.0-1.5 cbm</option>
												<option value="2">1.5-2.0 cbm</option>
												<option value="2">2.0-2.5 cbm</option>
												<option value="3">2.5-3.0 cbm</option>
												<option value="3">3.0-3.5 cbm</option>
												<option value="4">3.5-4.0 cbm</option>
												<option value="4">4.0-4.5 cbm</option>
												<option value="5">4.5-5.0 cbm</option>
												<option value="5">5.0-5.5 cbm</option>
												<option value="6">5.5-6.0 cbm</option>
												<option value="6">6.0-6.5 cbm</option>
												<option value="7">6.5-7.0 cbm</option>
												<option value="7">7.0-7.5 cbm</option>
												<option value="8">7.5-8.0 cbm</option>
											 </select> -->
											</div>	
											<div class="section_class_agileits sec-right">
											
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5t" />	  
	                                         </form:select>
											<!--  
											  <select>
												<option value="0">Weight (t)</option>
												<option value="1">less 0.5 t</option>
											    <option value="1">0.5-1.0 t</option>
												<option value="1">1.0-1.5 t</option>
												<option value="2">1.5-2.0 t</option>
												<option value="2">2.0-2.5 t</option>
												<option value="3">2.5-3.0 t</option>
												<option value="3">3.0-3.5 t</option>
												<option value="4">3.5-4.0 t</option>
												<option value="4">4.0-4.5 t</option>
												<option value="5">4.5-5.0 t</option>
												<option value="5">5.0-5.5 t</option>
												<option value="6">5.5-6.0 t</option>
												<option value="6">6.0-6.5 t</option>
												<option value="7">6.5-7.0 t</option>
												<option value="7">7.0-7.5 t</option>
												<option value="8">7.5-8.0 t</option>
											 </select>-->
											</div>
											<div class="clear"></div>
										
										</div>			
										<div class="submit">
										  <input type="submit" value="calculate">
										</div> 
									</form:form>
								</div>
							</div>
							<div class="tab-1 resp-tab-content">
								<div class="agileinfo-recover">
								<form:form method="POST" class="agile_form" commandName="route">
							<!--  	<form action="#" method="post" class="agile_form">-->
										<!--<input type="text" placeholder="Your Name" name="name" class="name agileits" required=""/>
										<input type="text" placeholder="Picking up" name="name" class="name agileits" required=""/>
										<input type="text" placeholder="Dropping off" name="name" class="name agileits" required=""/>
										<input placeholder="Pick-up date" class="date" id="datepicker5" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>
										<input placeholder="Drop-off date" class="date" id="datepicker6" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>										
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											 <select>
												<option value="0">Guests</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3"> 2</option>
												<option value="4">3 or 3+</option>
											 </select>
											</div>	
											
										</div>				
										<div class="submit">
										  <input type="submit" value="search">
										</div>-->  
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
									          <form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:option value="Alexandria, Egypt" label="Alexandria, Egypt" />
					                          <form:option value="Jebel Ali, UAE" label="Jebel Ali, UAE" />	
					                          </form:select>
					                       <!--   
											<select>														
												<option value="0">FOB (port of loading)</option>
												<option value="Alexandria, Egypt">Alexandria, Egypt</option>
												<option value="Ashdod, Israel">Ashdod, Israel</option>
												<option value="Haifa, Israel">Haifa, Israel</option>
												<option value="Dubai, UAE">Dubai, UAE</option>
												<option value="Jebel Ali, UAE">Jebel Ali, UAE</option>
												<option value="Cape Town, South Afric">Cape Town, South Africa</option>
												<option value="Durban, South Africa">Durban, South Africa</option>
												<option value="Johannesburg, South Africa">Johannesburg, South Africa</option>
											  </select>-->  
											</div>
											<div class="section_class_agileits sec-right">
											
											<form:select path="destination">		
											   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                          <form:option value="Lviv" label="Lviv" />
					                           	  
	                                     </form:select>
											  <!-- <select>
												<option value="0">FOT (city of destination)</option>
												<option value="Kiev">Kiev, UA</option>
												<option value="Cherkasy‎">Cherkasy‎, UA</option>
												<option value="Chernihiv">Chernihiv, UA</option>
												<option value="Chernivtsi‎">Chernivtsi‎, UA</option>
												<option value="Dnipro‎">Dnipro‎, UA</option>
												<option value="Ivano-Frankivsk">Ivano-Frankivsk, UA</option>
												<option value="Kharkiv">Kharkiv, UA</option>
												<option value="Kherson">Kherson, UA</option>
												<option value="Khmelnytskyi">Khmelnytskyi, UA</option>
												<option value="Kropyvnytskyi‎">Kropyvnytskyi‎, UA</option>
												<option value="Lutsk‎">Lutsk‎, UA</option>
												<option value="Lviv‎">Lviv‎, UA</option>
												<option value="Mykolaiv‎">Mykolaiv‎, UA</option>
												<option value="Odessa‎">Odessa‎, UA</option>
												<option value="Poltava‎‎">Poltava‎‎, UA</option>
												<option value="Rivne‎">Rivne‎, UA</option>
												<option value="Sumy‎">Sumy‎, UA</option>
												<option value="Ternopil‎">Ternopil‎, UA</option>
												<option value="Uzhhorod‎">Uzhhorod‎, UA</option>
												<option value="Vinnytsia‎">Vinnytsia‎, UA</option>
												<option value="Zaporizhia‎">Zaporizhia‎, UA</option>
												<option value="Zhytomyr">Zhytomyr, UA</option>
											  </select> -->
											</div>	
											<div class="clear"></div>
										</div>	
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
					                         <form:option value="1" label="1-2 cbm" />
					                         <form:option value="2" label="2-3 cbm" />	  
	                                         </form:select>
	                                         <!--  
											 <select>
												<option value="0">Volume (cbm)</option>
												<option value="1">less 1.0 cbm</option>
												<option value="1">1.0-1.5 cbm</option>
												<option value="2">1.5-2.0 cbm</option>
												<option value="2">2.0-2.5 cbm</option>
												<option value="3">2.5-3.0 cbm</option>
												<option value="3">3.0-3.5 cbm</option>
												<option value="4">3.5-4.0 cbm</option>
												<option value="4">4.0-4.5 cbm</option>
												<option value="5">4.5-5.0 cbm</option>
												<option value="5">5.0-5.5 cbm</option>
												<option value="6">5.5-6.0 cbm</option>
												<option value="6">6.0-6.5 cbm</option>
												<option value="7">6.5-7.0 cbm</option>
												<option value="7">7.0-7.5 cbm</option>
												<option value="8">7.5-8.0 cbm</option>
											 </select>-->
											</div>	
											<div class="section_class_agileits sec-right">
											
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5t" />	  
	                                         </form:select>
	                                         <!-- 
											  <select>
												<option value="0">Weight (t)</option>
												<option value="1">less 0.5 t</option>
											    <option value="1">0.5-1.0 t</option>
												<option value="1">1.0-1.5 t</option>
												<option value="2">1.5-2.0 t</option>
												<option value="2">2.0-2.5 t</option>
												<option value="3">2.5-3.0 t</option>
												<option value="3">3.0-3.5 t</option>
												<option value="4">3.5-4.0 t</option>
												<option value="4">4.0-4.5 t</option>
												<option value="5">4.5-5.0 t</option>
												<option value="5">5.0-5.5 t</option>
												<option value="6">5.5-6.0 t</option>
												<option value="6">6.0-6.5 t</option>
												<option value="7">6.5-7.0 t</option>
												<option value="7">7.0-7.5 t</option>
												<option value="8">7.5-8.0 t</option>
											 </select> -->
											</div>
											<div class="clear"></div>
										
										</div>		
										<div class="submit">
										  <input type="submit" value="calculate">
										</div> 
									</form:form>
								</div>
							</div>
							<div class="tab-1 resp-tab-content">
								<div class="agile-send-mail">
								<form:form method="POST" class="agile_form" commandName="route">
							<!-- 	<form action="#" method="post" class="agile_form"> -->
										<!--<input type="text" placeholder="Your Name" name="name" class="name agileits" required=""/>
										<input type="text" placeholder="Going to" name="name" class="name agileits" required=""/>
										<input placeholder="Select date" class="date" id="datepicker7" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required=""/>
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											 <select>
												<option value="0">Guests</option>
												<option value="1">0</option>
												<option value="2">1</option>
												<option value="3"> 2</option>
												<option value="4">3 or 3+</option>
											 </select>
											</div>	
											
										</div>				
										<div class="submit">
										  <input type="submit" value="search">
										</div>-->
			                             	<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
							      		      <form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:option value="Sydney, Australia" label="Sydney, Australia" />
					                          <form:option value="Auckland, New Zealand" label="Auckland, New Zealand" />	
					                          </form:select>
					                          <!--  
											<select>														
												<option value="0">FOB (port of loading)</option>
												<option value="Adelaide, Australia">Adelaide, Australia</option>
												<option value="Brisbane, Australia">Brisbane, Australia</option>
												<option value="Fremantle, Australia">Fremantle, Australia</option>
												<option value="Melbourne, Australia">Melbourne, Australia</option>
												<option value="Sydney, Australia">Sydney, Australia</option>
												<option value="Auckland, New Zealand">Auckland, New Zealand</option>
												<option value="Lyttelton, New Zealand">Lyttelton, New Zealand</option>
											  </select>-->
											</div>
											<div class="section_class_agileits sec-right">
											
											<form:select path="destination">		
											   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                          <form:option value="Lviv" label="Lviv" />
					                           	  
	                                     </form:select>
											<!--   <select>
												<option value="0">FOT (city of destination)</option>
												<option value="Kiev">Kiev, UA</option>
												<option value="Cherkasy‎">Cherkasy‎, UA</option>
												<option value="Chernihiv">Chernihiv, UA</option>
												<option value="Chernivtsi‎">Chernivtsi‎, UA</option>
												<option value="Dnipro‎">Dnipro‎, UA</option>
												<option value="Ivano-Frankivsk">Ivano-Frankivsk, UA</option>
												<option value="Kharkiv">Kharkiv, UA</option>
												<option value="Kherson">Kherson, UA</option>
												<option value="Khmelnytskyi">Khmelnytskyi, UA</option>
												<option value="Kropyvnytskyi‎">Kropyvnytskyi‎, UA</option>
												<option value="Lutsk‎">Lutsk‎, UA</option>
												<option value="Lviv‎">Lviv‎, UA</option>
												<option value="Mykolaiv‎">Mykolaiv‎, UA</option>
												<option value="Odessa‎">Odessa‎, UA</option>
												<option value="Poltava‎‎">Poltava‎‎, UA</option>
												<option value="Rivne‎">Rivne‎, UA</option>
												<option value="Sumy‎">Sumy‎, UA</option>
												<option value="Ternopil‎">Ternopil‎, UA</option>
												<option value="Uzhhorod‎">Uzhhorod‎, UA</option>
												<option value="Vinnytsia‎">Vinnytsia‎, UA</option>
												<option value="Zaporizhia‎">Zaporizhia‎, UA</option>
												<option value="Zhytomyr">Zhytomyr, UA</option>
											
											  </select> -->
											</div>	
											<div class="clear"></div>
										</div>	
									<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
					                         <form:option value="1" label="1-2 cbm" />
					                         <form:option value="2" label="2-3 cbm" />	  
	                                         </form:select>
	                                         <!--  
											 <select>
												<option value="0">Volume (cbm)</option>
												<option value="1">less 1.0 cbm</option>
												<option value="1">1.0-1.5 cbm</option>
												<option value="2">1.5-2.0 cbm</option>
												<option value="2">2.0-2.5 cbm</option>
												<option value="3">2.5-3.0 cbm</option>
												<option value="3">3.0-3.5 cbm</option>
												<option value="4">3.5-4.0 cbm</option>
												<option value="4">4.0-4.5 cbm</option>
												<option value="5">4.5-5.0 cbm</option>
												<option value="5">5.0-5.5 cbm</option>
												<option value="6">5.5-6.0 cbm</option>
												<option value="6">6.0-6.5 cbm</option>
												<option value="7">6.5-7.0 cbm</option>
												<option value="7">7.0-7.5 cbm</option>
												<option value="8">7.5-8.0 cbm</option>
											 </select>-->
											</div>	
											<div class="section_class_agileits sec-right">
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5t" />	  
	                                         </form:select>
											<!--  <select>
												<option value="0">Weight (t)</option>
												<option value="1">less 0.5 t</option>
											    <option value="1">0.5-1.0 t</option>
												<option value="1">1.0-1.5 t</option>
												<option value="2">1.5-2.0 t</option>
												<option value="2">2.0-2.5 t</option>
												<option value="3">2.5-3.0 t</option>
												<option value="3">3.0-3.5 t</option>
												<option value="4">3.5-4.0 t</option>
												<option value="4">4.0-4.5 t</option>
												<option value="5">4.5-5.0 t</option>
												<option value="5">5.0-5.5 t</option>
												<option value="6">5.5-6.0 t</option>
												<option value="6">6.0-6.5 t</option>
												<option value="7">6.5-7.0 t</option>
												<option value="7">7.0-7.5 t</option>
												<option value="8">7.5-8.0 t</option>
											 </select> --> 
											</div>
											<div class="clear"></div>
										
										</div>		
										<div class="submit">
										  <input type="submit" value="calculate">
										</div> 										
									</form:form>
							</div>
							</div>
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