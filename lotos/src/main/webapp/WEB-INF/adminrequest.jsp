<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<html>
<head>
<title>Lotos</title>
</head>
 
<body>
    <h2>AdminRequestServlet</h2>
 
    <form method="POST">
        <table>
            <tr>
                <td>Company:</td>
                <td><input type="text"  name="newCompany" placeholder="${client.company}" value="${client.company}"/></td> 
                
            </tr>
            <tr>
                <td>Code:</td>
                <td><input type="text"  name="code" placeholder="${client.code}" value="${client.code}"/></td> 
            </tr>
            
            <tr>
                <td>Name:</td>
                <td><input type="text"  name="manager" placeholder="${client.manager}" value="${client.manager}"/></td> 
            </tr>
                       
            <tr>
                <td>Phone:</td>
                <td><input type="text"  name="phone" placeholder="${client.phone}" value="${client.phone}"/></td> 
            </tr>
              <tr>
                <td>Mobile:</td>
                <td><input type="text"  name="mobile" placeholder="${client.mobile}" value="${client.mobile}"/></td> 
            </tr>
            
            <tr>
                <td>Mail:</td>
                <td><input type="text"  name="mail" placeholder="${client.mail}" value="${client.mail}"/></td> 
            </tr>
     
            <tr>
            
                <td>Password:</td>
                <td><input type="text" name="password" placeholder="${client.password}" value="${client.password}"/></td>
            </tr>
            <tr>
                <td>WebAddress:</td>
                <td><input type="text"  name="webaddress" placeholder="" value=""/></td> 
            </tr>
              <tr>
                <td>Youcontrol:</td>
                <td><input type="text"  name="youcontrol" placeholder="" value=""/></td> 
            </tr>
            <tr>
                <td><button type="submit" name="add" value="add">Add</td>
            </tr>
             <tr>
                <td><button type="submit" name="delete" value="delete">Delete</td>
            </tr>
             <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td><a href="/lotos/adminRequests" >Back</a></td>
            </tr>
             <tr>
                <td>&nbsp;</td>
            </tr>
             <tr>
                <td>${company.company}</td>             
            </tr>
           <tr>
                <td>${company.code}</td>             
            </tr>
            
            <tr>
                <td>${company.mail}</td>             
            </tr>
                       
           <tr>
                <td>${company.manager}</td>             
            </tr>
            <tr>
                <td>${company.mobile}</td>             
            </tr>
            
            <tr>
                <td>${company.password}</td>             
            </tr>
     
        <tr>
                <td>${company.phone}</td>             
            </tr>
         <tr>
                <td>${company.webaddress}</td>             
            </tr>
          <tr>
                <td>${company.youcontrol}</td>             
            </tr>
            <tr>
                <td>${company.registration}</td>             
            </tr>
        </table>
    </form>
 
</body>
</html>