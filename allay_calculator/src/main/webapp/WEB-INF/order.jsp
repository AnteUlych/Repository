<html>
<head>
<title>test_result</title>
</head>
<body>

	${transport} delivery;<br>
	${way};
	Tariff - ${price} USD;<br>
	Transit time -  ${time} days;<br>
	<br> 
	<br>

	<form method="post">
	
        <input type="date" name="date"><br> 
		<input name="name" placeholder="name" value=""><br> 
		<input name="company" placeholder="company" value=""><br> 
		<input name="mail" placeholder="mail" value=""><br> 
		<input name="phone" placeholder="phone" value=""><br>
		
	    <input type="submit" name="booking" value="booking">

	</form>
</body>
</html>