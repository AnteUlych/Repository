<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>EditCompanyServlet</h2>
    ${logo}
    <form method="POST">
        <table>
            <tr>
                <td>Edit mail:</td>
                <td><input type="text"  name="mail" placeholder="${mail}"  value="${mail}"/></td>
            </tr>
             <tr>
                <td>Edit manager:</td>
                <td><input type="text"  name="manager" placeholder="${manager}"  value="${manager}"/></td>
            </tr>
             <tr>
                <td>Edit phone:</td>
                <td><input type="text"  name="phone" placeholder="${phone}"  value="${phone}"/></td>
            </tr>
             <tr>
                <td>Edit mobile:</td>
                <td><input type="text"  name="mobile" placeholder="${mobile}"  value="${mobile}"/></td>
            </tr>
             <tr>
                <td>Edit webaddress:</td>
                <td><input type="text"  name="webaddress" placeholder="${webaddress}"  value="${webaddress}"/></td>
            </tr>
            <tr>
                <td>Edit password:</td>
                <td><input type="password" name="password" placeholder="${password}"  value="${password}"/></td>
            </tr>
             <tr>
                <td>Confirm password:</td>
                <td><input type="password" name="confirmPassword" placeholder="${password}"  value="${password}"/></td>
            </tr>
            <tr>
                <td><button type="submit" name="edit" value="edit">edit</td>
                
            </tr>
  
        </table>
    </form>
 
</body>
</html>