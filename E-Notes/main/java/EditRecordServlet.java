import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditRecordServlet extends HttpServlet{
	public final static String query="update addnotes set Name=?,Title=? ,Content=?,where id=?";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(req, res);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//Bootstrap
		pw.println("<link rel='stylesheet' href='style/bootstrap.css'></link>");
		//get the value
		       int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("Titel");
				String dob=req.getParameter("Date");
				String content=req.getParameter("Content");

				
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
					PreparedStatement ps=con.prepareStatement(query)) {
					ps.setString(1, name);
					ps.setString(2, dob);
					ps.setString(3, content);	
					ps.setInt(4, id);
					int count=ps.executeUpdate();
					pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px;'>");
					if(count==1)
					{
						pw.println("<h2 class='bg-danger text-light text-center'>Record Updated Succefully</h2>");
					}
					else
					{
						pw.println("<h2 class='bg-danger text-light text-center'>Somthing went wrong</h2>");

					}
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
		      pw.println("&nbsp;");
		      pw.println("<a href='showdata'><button class='btn btn-outline-success'>Show User</button></a>");
		      pw.println("</div>");	
	}


}
