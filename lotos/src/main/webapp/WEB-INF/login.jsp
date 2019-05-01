<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>LoginServlet</h2>
 
    <form method="POST">
        <table>
            <tr>
                <td>Enter a mail:</td>
                <td><input type="text"  name="mail"/></td>
        
            <tr>
                <td>Enter a password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><button type="submit" name="logIn" value="logIn">Log in</td>
                <td><button type="submit" name="watch" value="watch">Watch</td>
            </tr>
            <tr>
                <td><a href="/lotos/sign_in" >Sign in</a></td>
                <td><a href="/lotos/remind_email" >Forget Password</a></td>
            </tr>
            <tr>
        </table>
    </form>
 
</body>
</html>