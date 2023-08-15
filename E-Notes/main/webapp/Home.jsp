<%-- 
    Document   : Home
    Created on : 22-Jul-2023, 6:46:49 pm
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Home Page</title> 
        <%@include file="all_component/allcss.jsp" %>
        
    </head>
    <body>
         <%@include file="all_component/Navbar.jsp" %>
         <div class="container-fluid">
             <div class="card py-5">
                 <div class="card-body text-center">
                     <img src="Image/Book1.png" class="img-fluid mx-auto" style="max-width:300px">
                     <h1>Start Taking Your Notes!</h1>
                     <a href="addNotes.Html" class="btn btn-outline-primary">Start Here</a> 
                 </div>   
                 
              </div> 
         </div>
             <%
                 HttpSession st=request.getSession();
                 String LoggedUser=(String)session.getAttribute("LoggedUser");
                 if(LoggedUser!=null)
                 {
                 out.print("Welcome,"+LoggedUser);
                 }
                 else
                 {
                 out.println("Something went wrong");
                  }
             %>
         <%@include file="all_component/Footer.jsp" %>
    </body>
</html>





