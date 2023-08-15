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
@WebServlet("/showdata")

public class ShowUserServlet extends HttpServlet{
	public final static String query="select id,Title,Dinak,Content from addnotes";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(req, res);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//Bootstrap
		pw.println("<link rel='stylesheet' href='style/bootstrap.css'></link>");
		pw.println("<marquee><h2 class='text-primary'>Show Dtat</h2></marquee>");
				//Load the jdbc Driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				//connection
				
				try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","root","");
					PreparedStatement ps=con.prepareStatement(query)) {
					//Result Set
					ResultSet rs=ps.executeQuery();
					pw.println("<div style='margin:auto;width:800px;margin-top:80px;'>");
					pw.println("<table class='table table-hover table-striped'>");
					pw.println("<tr>");
					pw.println("<th>ID</th>");
					pw.println("<th>Tittle</th>");
					pw.println("<th>Information</th>");
					pw.println("<th>Date</th>");
					pw.println("<th>Update</th>");
					pw.println("<th>Delete</th>");
					pw.println("</tr>");
					while(rs.next()) {
						pw.println("<tr>");
						pw.println("<td>"+rs.getInt(1)+"</td>");
						pw.println("<td>"+rs.getString(2)+"</td>");
						pw.println("<td>"+rs.getString(3)+"</td>");
						pw.println("<td>"+rs.getString(4)+"</td>");
						pw.println("<td><a href='editurl?id="+rs.getInt(1)+"'>Update</a></td>");
						pw.println("<td><a href='deleteturl?id="+rs.getInt(1)+"'>Delete</a></td>");
						pw.println("</tr>");
					}
					pw.println("</table>");
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
		      pw.println("</div>");
		      pw.close();
	}

}
