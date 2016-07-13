<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Address Book</title>
<body>

<form:form method="POST" commandName="message">

Subject: 
<br />
<input  size="47" name="subject">
<br />
<br />
Message: <br />
<textarea name="text" cols="50" rows="10"></textarea>
<br />
<br />
<input type="submit"  name="Send" value="Send" /> 
</form:form>
<br />
<a href="/spammer/email">back to address book</a>
</body>
</html>