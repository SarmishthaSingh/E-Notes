<%-- 
    Document   : signin
    Created on : 22-Jul-2023, 6:21:37 pm
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
            String password=request.getParameter("password");
            
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
             //out.print("Driver open");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","root","");
            // out.print("New Connection");
           String query="select * from  details where Name=? and Password=?";
           PreparedStatement ps=con.prepareStatement(query);
           ps.setString(1,name);
           ps.setString(2, password);
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
           HttpSession st=request.getSession();
           st.setAttribute("LoggedUser",name);
           response.sendRedirect("Home.jsp");
            }
            else
            {
             response.sendRedirect("index.jsp");

             }
            rs.close();
            ps.close();
            con.close();
      }   
            catch(Exception e)
              {
              out.print(e);
              }
             %>
    </body>
</html>
