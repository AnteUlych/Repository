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
					                          
					                          <form:option value="Rosario, Argentina" label="Rosario, Argentina" />	
					                          <form:option value="Betim, Brasil" label="Betim, Brasil" />	
					                          <form:option value="Curitiba, Brasil" label="Curitiba, Brasil" />	
					                          <form:option value="Itajai, Brasil" label="Itajai, Brasil" />	
					                          <form:option value="Porto Alegro, Brasil" label="Porto Alegro, Brasil" />	
					                          <form:option value="Rio de Janeiro, Brasil" label="Rio de Janeiro, Brasil" />	
					                          <form:option value="Santos, Brasil" label="Santos, Brasil" />	
					                          <form:option value="Valparaiso, Chile" label="Valparaiso, Chile" />	
					                          <form:option value="Callao, Peru" label="Callao, Peru" />	
					                          <form:option value="Asuncion, Paraguay" label="Asuncion, Paraguay" />	
					                          <form:option value="Montevideo, Uruguay" label="Montevideo, Uruguay" />	
					                          <form:option value="Montreal, Canada" label="Montreal, Canada" />	
					                          <form:option value="Toronto, Canada" label="Toronto, Canada" />	
					                          <form:option value="Vancouver, Canada" label="Vancouver, Canada" />	
					                          <form:option value="Altamira, Mexico" label="Altamira, Mexico" />	
					                          <form:option value="Mexico City, Mexico" label="Mexico City, Mexico" />	
					                          <form:option value="Vera Cruz, Mexico" label="Vera Cruz, Mexico" />	
					                          <form:option value="Atlanta, USA" label="Atlanta, USA" />	
					                          <form:option value="Baltimore, USA" label="Baltimore, USA" />	
					                          <form:option value="Boston, USA" label="Boston, USA" />	
					                          <form:option value="Charleston, USA" label="Charleston, USA" />	
					                          <form:option value="Charlotte, USA" label="Charlotte, USA" />	
					                          <form:option value="Chicago, USA" label="Chicago, USA" />	
					                          <form:option value="Cleveland, USA" label="Cleveland, USA" />	
					                          <form:option value="Dallas, USA" label="Dallas, USA" />	
					                          <form:option value="Detroit, USA" label="Detroit, USA" />
					                          <form:option value="Houston, USA" label="Houston, USA" />
					                          <form:option value="Los Angeles, USA" label="Los Angeles, USA" />
					                          <form:option value="Memphis, USA" label="Memphis, USA" />
					                          <form:option value="Miami, USA" label="Miami, USA" />
					                          <form:option value="New Orleans, USA" label="New Orleans, USA" />
					                          <form:option value="New York, USA" label="New York, USA" />
					                          <form:option value="Norfolk, USA" label="Norfolk, USA" />
					                          <form:option value="Philadelphia, USA" label="Philadelphia, USA" />
					                          <form:option value="Portland, USA" label="Portland, USA" />
					                          <form:option value="San Francisco, USA" label="San Francisco, USA" />
					                          <form:option value="Seattle, USA" label="Seattle, USA" />
					                          
											  </form:select>
											</div>
											<div class="section_class_agileits sec-right">
											
											   <form:select path="destination">	
						   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                           <form:option value="Lviv" label="Lviv" />
					                           <form:option value="Cherkasy" label="Cherkasy" />
					                           <form:option value="Chernihiv" label="Chernihiv" />
					                           <form:option value="Chernivtsi" label="Chernivtsi"/>
					                           <form:option value="Dnipro" label="Dnipro" />
					                           <form:option value="Ivano-Frankivsk" label="Ivano-Frankivsk" />
					                           <form:option value="Kharkiv" label="Kharkiv" />
					                           <form:option value="Kherson" label="Kherson" />
					                           <form:option value="Khmelnytskyi" label="Khmelnytskyi" />
					                           <form:option value="Kropyvnytskyi" label="Kropyvnytskyi" />
					                           <form:option value="Lutsk" label="Lutsk" />
					                           <form:option value="Mykolaiv" label="Mykolaiv" />
					                           <form:option value="Odessa" label="Odessa" />
					                           <form:option value="Poltava" label="Poltava" />
					                           <form:option value="Rivne" label="Rivne" />
					                           <form:option value="Sumy" label="Sumy" />
					                           <form:option value="Ternopil" label="Ternopil" />
					                           <form:option value="Uzhhorod" label= "Uzhhorod" />
					                           <form:option value="Vinnytsia" label="Vinnytsia" />
					                           <form:option value="Zaporizhia" label="Zaporizhia" />
					                           <form:option value="Zhytomyr" label="Zhytomyr" />
					                          	  
	                                           </form:select>
											
											</div>	
											<div class="clear"></div>
										</div>	
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											 <form:select path="volume">			  
				          	                 <form:option value="" label="Volume, cbm" />
				          	                 <form:option value="1" label="less 1.0 cbm" />
					                         <form:option value="1" label="1.0-1.5 cbm" />
					                         <form:option value="2" label="1.5-2.0 cbm" />
					                         <form:option value="2" label="2.0-2.5 cbm" />	 
					                         <form:option value="3" label="2.5-3.0 cbm" />	
					                         <form:option value="3" label="3.0-3.5 cbm" />	
					                         <form:option value="4" label="3.5-4.0 cbm" />	
					                         <form:option value="4" label="4.0-4.5 cbm" />	
					                         <form:option value="5" label="4.5-5.0 cbm" />	
					                         <form:option value="5" label="5.0-5.5 cbm" />	
					                         <form:option value="6" label="5.5-6.0 cbm" />	
					                         <form:option value="6" label="6.0-6.5 cbm" />	
					                         <form:option value="7" label="6.5-7.0 cbm" />
					                         <form:option value="7" label="7.0-7.5 cbm" />	
					                         <form:option value="8" label="7.5-8.0 cbm" />		 
	                                         </form:select>
						
											</div>	
											<div class="section_class_agileits sec-right">
											
											 <form:select path="weight">			  
					                         <form:option value="" label="Weight, t" />
					                         <form:option value="1" label="less 0.5 t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5 t" />	
				                         	 <form:option value="2" label="1.5-2.0 t" />	
				                         	 <form:option value="2" label="2.0-2.5 t" />
				                         	 <form:option value="3" label="2.5-3.0 t" />
				                         	 <form:option value="3" label="3.0-3.5 t" />
				                         	 <form:option value="4" label="3.5-4.0 t" />
				                         	 <form:option value="4" label="4.0-4.5 t" />
				                         	 <form:option value="5" label="4.5-5.0 t" />
				                         	 <form:option value="5" label="5.0-5.5 t" />
				                         	 <form:option value="6" label="5.5-6.0 t" />
				                         	 <form:option value="6" label="6.0-6.5 t" /> 
				                         	 <form:option value="7" label="6.5-7.0 t" />  
				                         	 <form:option value="8" label="7.5-8.0 t" />  
				                           
	                                         </form:select>
											
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
					                          <form:option value="Beijing City, China" label="Beijing City, China" />	
					                          <form:option value="Dalian, China" label="Dalian, China" />	
					                          <form:option value="Foshan, China" label="Foshan, China" />	
					                          <form:option value="Fuzhou, China" label="Fuzhou, China" />	
					                          <form:option value="Guangzhou, China" label="Guangzhou, China" />	
					                          <form:option value="Hong Kong, China" label="Hong Kong, China" />	
					                          <form:option value="Huangpu, China" label="Huangpu, China" />	
					                          <form:option value="Jiangmen, China" label="Jiangmen, China" />	
					                          <form:option value="Ningbo, China" label="Ningbo, China" />	
					                          <form:option value="Qingdao, China" label="Qingdao, China" />	
					                          <form:option value="Shantou, China" label="Shantou, China" />	
					                          <form:option value="Shenzhen, China" label="Shenzhen, China" />	
					                          <form:option value="Shunde, China" label="Shunde, China" />	
					                          <form:option value="Yantian, China" label="Yantian, China" />	
					                          <form:option value="Xiamen, China" label="Xiamen, China" />	
					                          <form:option value="Xingang / Tianjin, China" label="Xingang / Tianjin, China" />	
					                          <form:option value="Zhongshan, China" label="Zhongshan, China" />	
					                          <form:option value="Zhuhai, China" label="Zhuhai, China" />	
					                          <form:option value="Belawan, Indonesia" label="Belawan, Indonesia" />	
					                          <form:option value="Jakarta, Indonesia" label="Jakarta, Indonesia" />	
					                          <form:option value="Semarang, Indonesia" label="Semarang, Indonesia" />	
					                          <form:option value="Surabaya, Indonesia" label="Surabaya, Indonesia" />	
					                          <form:option value="Kobe, Japan" label="Kobe, Japan" />	
					                          <form:option value="Nagoya, Japan" label="Nagoya, Japan" />	
					                          <form:option value="Osaka, Japan" label="Osaka, Japan" />	
					                          <form:option value="Tokyo, Japan" label="Tokyo, Japan" />	
					                          <form:option value="Yokohama, Japan" label="Yokohama, Japan" />	
					                          <form:option value="Busan, Korea" label="Busan, Korea" />	
					                          <form:option value="Inchon, Korea" label="Inchon, Korea" />	
					                          <form:option value="Port Kelang, Malaysia" label="Port Kelang, Malaysia" />	
					                          <form:option value="Pasir Gudang, Malaysia" label="Pasir Gudang, Malaysia" />	
					                          <form:option value="Penang, Malaysia" label="Penang, Malaysia" />	
					                          <form:option value="Port Louis, Mauritius" label="Port Louis, Mauritius" />
					                          <form:option value="Yangon, Mynamar" label="Yangon, Mynamar" />
					                          <form:option value="Cebu, Philipines" label="Cebu, Philipines" />
					                          <form:option value="Manila, Philipines" label="Manila, Philipines" />
					                          <form:option value="Kaohsiung, Taiwan" label="Kaohsiung, Taiwan" />
					                          <form:option value="Keelung, Taiwan" label="Keelung, Taiwan" />
					                          <form:option value="Taichung, Taiwan" label="Taichung, Taiwan" />
					                          <form:option value="Bangkok, Thailand" label="Bangkok, Thailand" />
					                          <form:option value="Haiphong, Vietnam" label="Haiphong, Vietnam" />
					                          <form:option value="Ho Chi Minh City, Vietnam" label="Ho Chi Minh City, Vietnam" />
					                          <form:option value="Danang, Vietnam" label="Danang, Vietnam" />
		                          
					                          </form:select>
											 
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
					                           <form:option value="Cherkasy" label="Cherkasy" />
					                           <form:option value="Chernihiv" label="Chernihiv" />
					                           <form:option value="Chernivtsi" label="Chernivtsi"/>
					                           <form:option value="Dnipro" label="Dnipro" />
					                           <form:option value="Ivano-Frankivsk" label="Ivano-Frankivsk" />
					                           <form:option value="Kharkiv" label="Kharkiv" />
					                           <form:option value="Kherson" label="Kherson" />
					                           <form:option value="Khmelnytskyi" label="Khmelnytskyi" />
					                           <form:option value="Kropyvnytskyi" label="Kropyvnytskyi" />
					                           <form:option value="Lutsk" label="Lutsk" />
					                           <form:option value="Mykolaiv" label="Mykolaiv" />
					                           <form:option value="Odessa" label="Odessa" />
					                           <form:option value="Poltava" label="Poltava" />
					                           <form:option value="Rivne" label="Rivne" />
					                           <form:option value="Sumy" label="Sumy" />
					                           <form:option value="Ternopil" label="Ternopil" />
					                           <form:option value="Uzhhorod" label= "Uzhhorod" />
					                           <form:option value="Vinnytsia" label="Vinnytsia" />
					                           <form:option value="Zaporizhia" label="Zaporizhia" />
					                           <form:option value="Zhytomyr" label="Zhytomyr" />
					                          	  
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
				          	                 <form:option value="1" label="less 1.0 cbm" />
					                         <form:option value="1" label="1.0-1.5 cbm" />
					                         <form:option value="2" label="1.5-2.0 cbm" />
					                         <form:option value="2" label="2.0-2.5 cbm" />	 
					                         <form:option value="3" label="2.5-3.0 cbm" />	
					                         <form:option value="3" label="3.0-3.5 cbm" />	
					                         <form:option value="4" label="3.5-4.0 cbm" />	
					                         <form:option value="4" label="4.0-4.5 cbm" />	
					                         <form:option value="5" label="4.5-5.0 cbm" />	
					                         <form:option value="5" label="5.0-5.5 cbm" />	
					                         <form:option value="6" label="5.5-6.0 cbm" />	
					                         <form:option value="6" label="6.0-6.5 cbm" />	
					                         <form:option value="7" label="6.5-7.0 cbm" />
					                         <form:option value="7" label="7.0-7.5 cbm" />	
					                         <form:option value="8" label="7.5-8.0 cbm" />		 
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
					                         <form:option value="1" label="less 0.5 t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5 t" />	
				                         	 <form:option value="2" label="1.5-2.0 t" />	
				                         	 <form:option value="2" label="2.0-2.5 t" />
				                         	 <form:option value="3" label="2.5-3.0 t" />
				                         	 <form:option value="3" label="3.0-3.5 t" />
				                         	 <form:option value="4" label="3.5-4.0 t" />
				                         	 <form:option value="4" label="4.0-4.5 t" />
				                         	 <form:option value="5" label="4.5-5.0 t" />
				                         	 <form:option value="5" label="5.0-5.5 t" />
				                         	 <form:option value="6" label="5.5-6.0 t" />
				                         	 <form:option value="6" label="6.0-6.5 t" /> 
				                         	 <form:option value="7" label="6.5-7.0 t" />  
				                         	 <form:option value="8" label="7.5-8.0 t" />  
				                           
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
					                          <form:option value="Ahmedabad, India" label="Ahmedabad, India" />	
					                          <form:option value="Bangalore, India" label="Bangalore, India" />	
					                          <form:option value="Baroda, India" label="Baroda, India" />	
					                          <form:option value="Calcutta, India" label="Calcutta, India" />	
					                          <form:option value="Chennai, India" label="Chennai, India" />	
					                          <form:option value="Cochin, India" label="Cochin, India" />	
					                          <form:option value="Hyderabad, India" label="Hyderabad, India" />	
					                          <form:option value="Mumbai, India" label="Mumbai, India" />	
					                          <form:option value="Delhi, India" label="Delhi, India" />	
					                          <form:option value="Tuticorin, India" label="Tuticorin, India" />	
					                          <form:option value="Karachi, Pakistan" label="Karachi, Pakistan" />	
					                          <form:option value="Colombo, Sri Lanka" label="Colombo, Sri Lanka" />	
					                          </form:select>
					                          
								
											</div>
											
											<div class="section_class_agileits sec-right">
											
											    <form:select path="destination">	
						   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                           <form:option value="Lviv" label="Lviv" />
					                           <form:option value="Cherkasy" label="Cherkasy" />
					                           <form:option value="Chernihiv" label="Chernihiv" />
					                           <form:option value="Chernivtsi" label="Chernivtsi"/>
					                           <form:option value="Dnipro" label="Dnipro" />
					                           <form:option value="Ivano-Frankivsk" label="Ivano-Frankivsk" />
					                           <form:option value="Kharkiv" label="Kharkiv" />
					                           <form:option value="Kherson" label="Kherson" />
					                           <form:option value="Khmelnytskyi" label="Khmelnytskyi" />
					                           <form:option value="Kropyvnytskyi" label="Kropyvnytskyi" />
					                           <form:option value="Lutsk" label="Lutsk" />
					                           <form:option value="Mykolaiv" label="Mykolaiv" />
					                           <form:option value="Odessa" label="Odessa" />
					                           <form:option value="Poltava" label="Poltava" />
					                           <form:option value="Rivne" label="Rivne" />
					                           <form:option value="Sumy" label="Sumy" />
					                           <form:option value="Ternopil" label="Ternopil" />
					                           <form:option value="Uzhhorod" label= "Uzhhorod" />
					                           <form:option value="Vinnytsia" label="Vinnytsia" />
					                           <form:option value="Zaporizhia" label="Zaporizhia" />
					                           <form:option value="Zhytomyr" label="Zhytomyr" />
					                          	  
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
				          	                 <form:option value="1" label="less 1.0 cbm" />
					                         <form:option value="1" label="1.0-1.5 cbm" />
					                         <form:option value="2" label="1.5-2.0 cbm" />
					                         <form:option value="2" label="2.0-2.5 cbm" />	 
					                         <form:option value="3" label="2.5-3.0 cbm" />	
					                         <form:option value="3" label="3.0-3.5 cbm" />	
					                         <form:option value="4" label="3.5-4.0 cbm" />	
					                         <form:option value="4" label="4.0-4.5 cbm" />	
					                         <form:option value="5" label="4.5-5.0 cbm" />	
					                         <form:option value="5" label="5.0-5.5 cbm" />	
					                         <form:option value="6" label="5.5-6.0 cbm" />	
					                         <form:option value="6" label="6.0-6.5 cbm" />	
					                         <form:option value="7" label="6.5-7.0 cbm" />
					                         <form:option value="7" label="7.0-7.5 cbm" />	
					                         <form:option value="8" label="7.5-8.0 cbm" />		 
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
					                         <form:option value="1" label="less 0.5 t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5 t" />	
				                         	 <form:option value="2" label="1.5-2.0 t" />	
				                         	 <form:option value="2" label="2.0-2.5 t" />
				                         	 <form:option value="3" label="2.5-3.0 t" />
				                         	 <form:option value="3" label="3.0-3.5 t" />
				                         	 <form:option value="4" label="3.5-4.0 t" />
				                         	 <form:option value="4" label="4.0-4.5 t" />
				                         	 <form:option value="5" label="4.5-5.0 t" />
				                         	 <form:option value="5" label="5.0-5.5 t" />
				                         	 <form:option value="6" label="5.5-6.0 t" />
				                         	 <form:option value="6" label="6.0-6.5 t" /> 
				                         	 <form:option value="7" label="6.5-7.0 t" />  
				                         	 <form:option value="8" label="7.5-8.0 t" />  
				                           
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
					                          <form:option value="Ashdod, Israel" label="Ashdod, Israel" />	
					                          <form:option value="Haifa, Israel" label="Haifa, Israel" />
					                          <form:option value="Dubai, UAE" label="Dubai, UAE" />
					                          <form:option value="Cape Town, South Africa" label="Cape Town, South Africa" />
					                          <form:option value="Durban, South Africa" label="Durban, South Africa" />
					                          <form:option value="Johannesburg, South Africa" label="Johannesburg, South Africa" />
					                          </form:select>
					                      
											</div>
											<div class="section_class_agileits sec-right">
											
											   <form:select path="destination">	
						   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                           <form:option value="Lviv" label="Lviv" />
					                           <form:option value="Cherkasy" label="Cherkasy" />
					                           <form:option value="Chernihiv" label="Chernihiv" />
					                           <form:option value="Chernivtsi" label="Chernivtsi"/>
					                           <form:option value="Dnipro" label="Dnipro" />
					                           <form:option value="Ivano-Frankivsk" label="Ivano-Frankivsk" />
					                           <form:option value="Kharkiv" label="Kharkiv" />
					                           <form:option value="Kherson" label="Kherson" />
					                           <form:option value="Khmelnytskyi" label="Khmelnytskyi" />
					                           <form:option value="Kropyvnytskyi" label="Kropyvnytskyi" />
					                           <form:option value="Lutsk" label="Lutsk" />
					                           <form:option value="Mykolaiv" label="Mykolaiv" />
					                           <form:option value="Odessa" label="Odessa" />
					                           <form:option value="Poltava" label="Poltava" />
					                           <form:option value="Rivne" label="Rivne" />
					                           <form:option value="Sumy" label="Sumy" />
					                           <form:option value="Ternopil" label="Ternopil" />
					                           <form:option value="Uzhhorod" label= "Uzhhorod" />
					                           <form:option value="Vinnytsia" label="Vinnytsia" />
					                           <form:option value="Zaporizhia" label="Zaporizhia" />
					                           <form:option value="Zhytomyr" label="Zhytomyr" />
					                          	  
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
				          	                 <form:option value="1" label="less 1.0 cbm" />
					                         <form:option value="1" label="1.0-1.5 cbm" />
					                         <form:option value="2" label="1.5-2.0 cbm" />
					                         <form:option value="2" label="2.0-2.5 cbm" />	 
					                         <form:option value="3" label="2.5-3.0 cbm" />	
					                         <form:option value="3" label="3.0-3.5 cbm" />	
					                         <form:option value="4" label="3.5-4.0 cbm" />	
					                         <form:option value="4" label="4.0-4.5 cbm" />	
					                         <form:option value="5" label="4.5-5.0 cbm" />	
					                         <form:option value="5" label="5.0-5.5 cbm" />	
					                         <form:option value="6" label="5.5-6.0 cbm" />	
					                         <form:option value="6" label="6.0-6.5 cbm" />	
					                         <form:option value="7" label="6.5-7.0 cbm" />
					                         <form:option value="7" label="7.0-7.5 cbm" />	
					                         <form:option value="8" label="7.5-8.0 cbm" />		 
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
					                         <form:option value="1" label="less 0.5 t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5 t" />	
				                         	 <form:option value="2" label="1.5-2.0 t" />	
				                         	 <form:option value="2" label="2.0-2.5 t" />
				                         	 <form:option value="3" label="2.5-3.0 t" />
				                         	 <form:option value="3" label="3.0-3.5 t" />
				                         	 <form:option value="4" label="3.5-4.0 t" />
				                         	 <form:option value="4" label="4.0-4.5 t" />
				                         	 <form:option value="5" label="4.5-5.0 t" />
				                         	 <form:option value="5" label="5.0-5.5 t" />
				                         	 <form:option value="6" label="5.5-6.0 t" />
				                         	 <form:option value="6" label="6.0-6.5 t" /> 
				                         	 <form:option value="7" label="6.5-7.0 t" />  
				                         	 <form:option value="8" label="7.5-8.0 t" />  
				                           
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
					                          <form:option value="Adelaide, Australia" label="Adelaide, Australia" />	
					                          <form:option value="Brisbane, Australia" label="Brisbane, Australia" />	
					                          <form:option value="Fremantle, Australia" label="Fremantle, Australia" />	
					                          <form:option value="Melbourne, Australia" label="Melbourne, Australia" />	
					                          <form:option value="Sydney, Australia" label="Sydney, Australia" />	
					                          <form:option value="Auckland, New Zealand" label="Auckland, New Zealand" />	
					                          <form:option value="Lyttelton, New Zealand" label="Lyttelton, New Zealand" />	
					                          	
					                          </form:select>
					                         

											</div>
											<div class="section_class_agileits sec-right">
											
											   <form:select path="destination">	
						   	  
					                          <form:option value="" label="City of destination" />
				                           	  <form:option value="Kyiv" label="Kyiv" />
					                           <form:option value="Lviv" label="Lviv" />
					                           <form:option value="Cherkasy" label="Cherkasy" />
					                           <form:option value="Chernihiv" label="Chernihiv" />
					                           <form:option value="Chernivtsi" label="Chernivtsi"/>
					                           <form:option value="Dnipro" label="Dnipro" />
					                           <form:option value="Ivano-Frankivsk" label="Ivano-Frankivsk" />
					                           <form:option value="Kharkiv" label="Kharkiv" />
					                           <form:option value="Kherson" label="Kherson" />
					                           <form:option value="Khmelnytskyi" label="Khmelnytskyi" />
					                           <form:option value="Kropyvnytskyi" label="Kropyvnytskyi" />
					                           <form:option value="Lutsk" label="Lutsk" />
					                           <form:option value="Mykolaiv" label="Mykolaiv" />
					                           <form:option value="Odessa" label="Odessa" />
					                           <form:option value="Poltava" label="Poltava" />
					                           <form:option value="Rivne" label="Rivne" />
					                           <form:option value="Sumy" label="Sumy" />
					                           <form:option value="Ternopil" label="Ternopil" />
					                           <form:option value="Uzhhorod" label= "Uzhhorod" />
					                           <form:option value="Vinnytsia" label="Vinnytsia" />
					                           <form:option value="Zaporizhia" label="Zaporizhia" />
					                           <form:option value="Zhytomyr" label="Zhytomyr" />
					                          	  
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
				          	                 <form:option value="1" label="less 1.0 cbm" />
					                         <form:option value="1" label="1.0-1.5 cbm" />
					                         <form:option value="2" label="1.5-2.0 cbm" />
					                         <form:option value="2" label="2.0-2.5 cbm" />	 
					                         <form:option value="3" label="2.5-3.0 cbm" />	
					                         <form:option value="3" label="3.0-3.5 cbm" />	
					                         <form:option value="4" label="3.5-4.0 cbm" />	
					                         <form:option value="4" label="4.0-4.5 cbm" />	
					                         <form:option value="5" label="4.5-5.0 cbm" />	
					                         <form:option value="5" label="5.0-5.5 cbm" />	
					                         <form:option value="6" label="5.5-6.0 cbm" />	
					                         <form:option value="6" label="6.0-6.5 cbm" />	
					                         <form:option value="7" label="6.5-7.0 cbm" />
					                         <form:option value="7" label="7.0-7.5 cbm" />	
					                         <form:option value="8" label="7.5-8.0 cbm" />		 
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
					                         <form:option value="1" label="less 0.5 t" />
					                         <form:option value="1" label="0.5-1.0 t" />
				                         	 <form:option value="2" label="1.0-1.5 t" />	
				                         	 <form:option value="2" label="1.5-2.0 t" />	
				                         	 <form:option value="2" label="2.0-2.5 t" />
				                         	 <form:option value="3" label="2.5-3.0 t" />
				                         	 <form:option value="3" label="3.0-3.5 t" />
				                         	 <form:option value="4" label="3.5-4.0 t" />
				                         	 <form:option value="4" label="4.0-4.5 t" />
				                         	 <form:option value="5" label="4.5-5.0 t" />
				                         	 <form:option value="5" label="5.0-5.5 t" />
				                         	 <form:option value="6" label="5.5-6.0 t" />
				                         	 <form:option value="6" label="6.0-6.5 t" /> 
				                         	 <form:option value="7" label="6.5-7.0 t" />  
				                         	 <form:option value="8" label="7.5-8.0 t" />  
				                           
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