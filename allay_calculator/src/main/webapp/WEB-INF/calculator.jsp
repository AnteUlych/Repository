<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC dropdown box</title>
</head>

<body>
	<h2>What's your favourite colour?</h2>

	<form:form method="POST" commandName="route">
	
		<form:select path="port">			  
					  <form:option value="" label="Port of loading" />
					  <form:option value="Buenos Aires" label="Buenos Aires, Argentina" />
					  <form:option value="Shanghai" label="Shanghai, China" />	  
	    </form:select>
	    <br>
	    <form:select path="destination">			  
					  <form:option value="" label="City of destination" />
					  <form:option value="Kyiv" label="Kyiv" />
					  <form:option value="Lviv" label="Lviv" />	  
	    </form:select>
        <br>
        <form:select path="volume">			  
					  <form:option value="" label="Volume, cbm" />
					  <form:option value="1" label="1-2 cbm" />
					  <form:option value="2" label="2-3 cbm" />	  
	    </form:select>
        <br>
        <form:select path="weight">			  
					  <form:option value="" label="Weight, t" />
					  <form:option value="1" label="0.5-1.0 t" />
					  <form:option value="2" label="1.0-1.5t" />	  
	    </form:select>
        <br>
                            
			<input type="submit" name="submit" value="Calculate">
	</form:form>

</body>
</html>