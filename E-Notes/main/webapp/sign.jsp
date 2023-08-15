<%-- 
    Document   : sign
    Created on : 22-Jul-2023, 5:49:28 pm
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            
           try
           {
            Class.forName("com.mysql.jdbc.Driver");
       
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "root","");
           
           String query="insert into details (name,email,password)values(?,?,?)";
           PreparedStatement pst=con.prepareStatement(query);
           pst.setString(1,name);
           pst.setString(2,email);
           pst.setString(3,password);
           int x=pst.executeUpdate();
           if(x>0)
           {
           //Redirect to a succees page
            response.sendRedirect("Home.jsp");
           }
                     
           else
           {
              out.print("somthing went wrong");
      
           }
        }   
           catch(Exception e)
           {
           out.print(e);
           }
        %>
    </body>
</html>
