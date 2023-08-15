<%-- 
    Document   : Login
    Created on : 20-Jul-2023, 12:35:04 pm
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%@include file="all_component/allcss.jsp" %>
  <link rel="stylesheet" href="Css/Style.css">
    </head>
    <body>
         <%@include file="all_component/Navbar.jsp" %>
         <div class="container-fluid div-color">
             <div class="row">
                 <div class="col-md-4 offset-md-4">
                     <div class="card mt-4">
                         <div class="card-header text-center text-white bg-custom">
                          <i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
                          <h4>Registration</h4>
                         </div>  
                         <div class="card-body">
                             <form action="signin.jsp" method="post">
                          
                           <div class="form-group">
                                <label>Name</label>
                          <input type="name" class="form-control" id="exampleInputPassword1" name="name" placeholder="Name">
                        </div>    
                           <div class="form-group">
                                <label>Password</label>
                          <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
                        </div>
                      
                    <button type="submit" class="btn btn-primary bodge-pill btn-block" value="Login">Login</button>
                    </form> 
                            
                      </div>
                     </div>
                  </div> 
             </div>
         </div>
      <%@include file="all_component/Footer.jsp" %>
    </body>
</html>
