<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Notes</title>
<%@include file="all_component/allcss.jsp" %>
<style type="text/css">
            .back-img
            {
                background-image: url("Image/Book.png");
                width: 100%;
                height: 80vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
            
        </style>
</head>
<body>
<%@include file="all_component/Navbar.jsp" %>
 <div class="container-fluid back-img"> 
 <div class="text-center">
  <h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i> E-Notes Save Your Notes Here</h1>     
 <a href="login.jsp" class="btn btn-light"><i class="fa fa-key" aria-hidden="true"></i>Login</a>
 <a href="register.jsp" class="btn btn-light"><i class="fa fa-lock" aria-hidden="true"></i>SignUp</a> 
  </div> 
 </div>
 <%@include file="all_component/Footer.jsp" %>	
</body>

</html>