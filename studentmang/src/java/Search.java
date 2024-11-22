import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Search extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<link rel='stylesheet' href='abc.css'>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div id='mymenu'>");
	out.println("<ul><li>Home</li><li><a href='Insert.html'>Insert</a></li><li><a href='Search.html'>Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='Update'>Update</a></li><li><a href='Delete.html'>Delete</a></li><li><a href='logout'>LogOut</a></li><li>About</li><li>Contact Us</li></ul>");
	out.println("</div >");
	out.println("<div id='mydata'>");
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagedb?useSSL=false","root","root");
		Statement st=con.createStatement();
		String s1=request.getParameter("u1");
		
		String q="select * from marks where UROLLNO='"+s1+"'";
	    ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
                out.println("<form action='Update'>");    
		out.println("<center>");
		out.println("<table cellpadding='12'>");
		out.println("<tr>");
		out.println("<td>RNo.</td>");
		out.println("<td><input type='text' name='u1' value="+rs.getString(1)+"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>PHYSICS</td>");
		out.println("<td><input type='text' name='u2' value="+rs.getString(2)+"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>CHEMISTRY</td>");
		out.println("<td><input type='text' name='u3' value="+rs.getString(3)+"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>MATHS</td>");
		out.println("<td><input type='text' name='u4' value="+rs.getString(4)+"></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Biologyy</td>");
		out.println("<td><input type='text' name='u5' value="+rs.getString(5)+"></td>");
		out.println("</tr>");
                out.println("<tr>");
                out.println("<th colspan='2'>");
                out.println("<input type='submit' class='B' value='UPDATE'>");
                out.println("</th>");
                out.println("</tr>");
		}
		else
		{
			out.println("Invalid Roll no.");
		}
		
		
		
		
		
		
		
		
		out.println("</table>");
		out.println("</center>");
                out.println("</form>");
		out.println("</div>");
		
		con.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	
		out.println("</body>");
		out.println("</html>");
		out.close();
}
}