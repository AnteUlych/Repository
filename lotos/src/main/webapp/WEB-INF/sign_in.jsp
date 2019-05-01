<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>LoginServlet</h2>
 
    <form method="POST">
        <table>
            <tr>
                <td>Company:</td>
                <td><input type="text"  name="company"/></td> 
                
            </tr>
            <tr>
                <td>Code:</td>
                <td><input type="text"  name="code"/></td> 
            </tr>
            
            <tr>
                <td>Name:</td>
                <td><input type="text"  name="name"/></td> 
            </tr>
                       
            <tr>
                <td>Phone:</td>
                <td><input type="text"  name="phone"/></td> 
            </tr>
              <tr>
                <td>Mobile:</td>
                <td><input type="text"  name="mobile"/></td> 
            </tr>
            
            <tr>
                <td>Mail:</td>
                <td><input type="text"  name="mail"/></td> 
            </tr>
     
            <tr>
            
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
             <tr>
            
                <td>PasswordConfirm:</td>
                <td><input type="password" name="passwordConfirm"/></td>
            </tr>
            <tr>
                <td><button type="submit" name="signIn" value="signIn">Sign In</td>
            </tr>
            <tr>
                <td><a href="/lotos/sign_in" >Back</a></td>
            </tr>
            <tr>
        </table>
    </form>
 
</body>
</html>