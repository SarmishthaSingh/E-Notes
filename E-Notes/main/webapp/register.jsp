<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<%@include file="all_component/allcss.jsp" %>
<style type="text/css">
            .back-img
            {
                background-image: url("Image/Book1.png");
                width: 100%;
                height: 80vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
            
        </style>
</head>
<body>
  <%@include file="all_component/Navbar.jsp"%>
         <div class="container-fluid div-color">
             <div class="row">
                 <div class="col-md-4 offset-md-4">
                     <div class="card mt-4">
                         <div class="card-header text-center text-white bg-custom">
                          <i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
                          <h4>Registration</h4>
                         </div>  
                         <div class="card-body">
                          <form action="sign.jsp" method="post">
                          <!--<form action="UserServlet1" method="post">-->
                          <div class="form-group">
                              <label>Full Name</label>
                              <input type="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" placeholder="Enter Name" required>
                         
                        </div>
                           <div class="form-group">
                                <label>Email</label>
                          <input type="email" class="form-control" id="exampleInputPassword1" name="email" placeholder="Email" required>
                        </div>    
                           <div class="form-group">
                                <label>Password</label>
                          <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password" required>
                        </div>
                      
                              <button type="submit" class="btn btn-primary bodge-pill btn-block" value="Register">Register</button>
                    </form> 
                            
                      </div>
                     </div>
                  </div> 
             </div>
         </div>
<%@include file="all_component/Footer.jsp" %>
</body>
</html>