import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editurl")
public class UpdateDataServlet extends HttpServlet{
	public final static String query="select name,dob from notes where id=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(req, res);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//get the value
		 int id=Integer.parseInt(req.getParameter("id"));

		//Bootstrap
		pw.println("<link rel='stylesheet' href='style/bootstrap.css'></link>");
						//Load the jdbc Driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//connection
				
				try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","");
					PreparedStatement ps=con.prepareStatement(query);) {
					//set the value
					ps.setInt(1, id);
					//Result Set
					ResultSet rs=ps.executeQuery();
					rs.next();
					pw.println("<div style='margin:auto;width:800px;margin-top:80px;'>");
					pw.println("<form action='edit?id="+id+"' method='post'>");
					pw.println("<table class='table table-hover table-striped'>");
					pw.println("<tr>");
					pw.println("<td>Name</td>");
					pw.println("<td><textarea type='text' name='username' value='"+rs.getString(1)+"'></textarea></td>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					pw.println("<td>Date</td>");
					pw.println("<td><input type='date' name='dob' value='"+rs.getString(2)+"'></td>");
					pw.println("</tr>");
					
					
					
					pw.println("<tr>");
					pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
					pw.println("<td><button type='submit' class='btn btn-outline-danger'>Cancel</button></td>");
					pw.println("</tr>");
					
					pw.println("</table>");
					pw.println("</form>");
				}
				catch(SQLException se)
				{
					pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
					se.printStackTrace();
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
		    
		      pw.println("<a href='index.html'><button class='btn btn-outline-success'>Home</button></a>");
		   //   pw.println("<a href='editurl'><button class='btn btn-outline-success'>Update</button></a>");
		      pw.println("</div>");
		      pw.close();
	}

	


}
