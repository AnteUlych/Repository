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
							<li class="resp-tab-item"><i class="fa fa-globe" aria-hidden="true"></i>America</li>
							<li class="resp-tab-item"><i class="fa fa-industry" aria-hidden="true"></i>China & Eastern Asia</li>
							<li class="resp-tab-item"><i class="fa fa-university" aria-hidden="true"></i>India & Southern Asia</li>
							<li class="resp-tab-item"><i class="fa fa-diamond" aria-hidden="true"></i>Africa & Middle East</li>
							<li class="resp-tab-item"><i class="fa fa-leaf" aria-hidden="true"></i>Australia & NZ</li>
						</ul>
					</div>

					<div class="tab-right">
						<div class="resp-tabs-container">
							<div class="tab-1 resp-tab-content">
								<div class="w3l-sign-in">
									<form:form method="POST" class="agile_form" commandName="route">
										
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
											<!--  <select>	-->
											<form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:options items="${americanPorts}" />
											  </form:select>
											  
											</div>
											<div class="section_class_agileits sec-right">
											
											   <form:select path="destination">				
					                           <form:option value="" label="City of destination" />
				                               <form:options items="${destinations}" />
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
					                          <form:options items="${eastAsiaPorts}" />
											  </form:select>
											 
											</div>
											
											<div class="clear"></div>
									
										<div class="section_class_agileits sec-right">
										
										    <form:select path="destination">				
					                           <form:option value="" label="City of destination" />
				                               <form:options items="${destinations}" />
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
							<div class="tab-1 resp-tab-content gallery-images">
								<div class="wthree-subscribe">	
								<form:form method="POST" class="agile_form" commandName="route">
									
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
											
											<form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:options items="${southAsiaPorts}" />
											  </form:select>
					                          
								
											</div>
											
											<div class="section_class_agileits sec-right">
											
							          	       <form:select path="destination">				
					                           <form:option value="" label="City of destination" />
				                               <form:options items="${destinations}" />
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
								<div class="agileinfo-recover">
								<form:form method="POST" class="agile_form" commandName="route">
							 
										<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
									          <form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:options items="${africaPorts}" />
											  </form:select>
					                      
											</div>
											<div class="section_class_agileits sec-right">
											
											     <form:select path="destination">				
					                             <form:option value="" label="City of destination" />
				                                 <form:options items="${destinations}" />
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
								<div class="agile-send-mail">
								<form:form method="POST" class="agile_form" commandName="route">
							         	<div class="list_agileits_w3layouts">
											<div class="section_class_agileits sec-left">
									
							      		     <form:select path="port">	
											  <form:option value="" label="FOB (port of loading)" />
					                          <form:options items="${ocaniaPorts}" />
											  </form:select>
					                         

											</div>
											<div class="section_class_agileits sec-right">
											
											     <form:select path="destination">				
					                             <form:option value="" label="City of destination" />
				                                 <form:options items="${destinations}" />
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
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<p> &copy; 2017 Developed by <a href="https://www.facebook.com/profile.php?id=100009594527667">Anton Ulytskyi</a></p>
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