<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Comment</title>
</head>

<body>
	<h2>Fill your form!</h2>
${route}
	<form:form method="POST">
		<table>
			
			<tr>
				<td>your rate</td>
				
				<td>
				<form>
				  <input type="radio" name="rate" value="1"> 1<br>
				  <input type="radio" name="rate" value="2"> 2<br>
				  <input type="radio" name="rate" value="3"> 3<br>
				  <input type="radio" name="rate" value="4"> 4<br>
				  <input type="radio" name="rate" value="5"> 5<br>
				    </form>
				    </td>
				</tr>
	
			<tr>

                <td>Your comment:</td>
                <td><input name="opinion" placeholder="text" value=""></td>
            </tr>		
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>