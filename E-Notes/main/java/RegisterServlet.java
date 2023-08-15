

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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
public final static String query="insert into details(Title,Dinak,Content)values(?,?,?)";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(req, res);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//Bootstrap
		pw.println("<link rel='stylesheet' href='style/bootstrap.css'></link>");
		//get the value
		        String name=req.getParameter("Name");
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
				
				try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","root","");
					PreparedStatement ps=con.prepareStatement(query)) {
					ps.setString(1, name);
					ps.setString(2, dob);
					ps.setString(3, content);
					
					int count=ps.executeUpdate();
					pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px;'>");
					if(count==1)
					{
						pw.println("<h2 class='bg-danger text-light text-center'>Record Registerd Succefully</h2>");
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
		    
		      pw.println("<a href='addNotes.html'><button class='btn btn-outline-success'>Home</button></a>");
		      pw.println("</div>");	
	}

}








