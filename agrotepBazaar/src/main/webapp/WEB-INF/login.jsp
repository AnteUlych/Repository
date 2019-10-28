
<!--A Design by W3layouts
   Author: W3layout
   Author URL: http://w3layouts.com
   License: Creative Commons Attribution 3.0 Unported
   License URL: http://creativecommons.org/licenses/by/3.0/
   -->

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <title>Agrotep</title>
    <!-- Meta tags -->

    <meta name="viewport" content="width=device-width, initial-scale=1" />
 
 
    <script>
        addEventListener("load", function () { setTimeout(hideURLbar, 0); }, false); function hideURLbar() { window.scrollTo(0, 1); }
    </script>
    <!-- Meta tags -->
    <!-- font-awesome icons -->
    <link href="<c:url value="resources/css/font-awesome.min.css" />" rel="stylesheet">
    <!-- //font-awesome icons -->
    <!--stylesheets-->
    <link href="<c:url value="resources/css/style.css" />" rel='stylesheet' type='text/css' media="all">
    <!--//style sheet end here-->
    <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
</head>
<body>
    <h1 class="error"></h1>
	<!---728x90--->
    <div class="w3layouts-two-grids">
	<!---728x90--->
        <div class="mid-class">
            <div class="img-right-side">
                <h3>Transport System Agrotep</h3>
                <p>If You forgot your code please ask your manager for reminding it</p>
                <img src="<c:url value="resources/images/b11.png" />" class="img-fluid" alt="">
            </div>
            <div class="txt-left-side">
                <h2> Log In </h2>
                <form method="POST">
                    <div class="form-left-to-w3l ">

                        <span class="fa fa-lock" aria-hidden="true"></span>
                        <input type="password" name="code" placeholder="Code" required>
                        <div class="clear"></div>
                    </div>
                    <div class="main-two-w3ls">

                    </div>
                    <div class="btnn">
                        <button type="submit">Login In </button>
                    </div>
                </form>
                <div class="w3layouts_more-buttn">
               
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>


</body>

</html>