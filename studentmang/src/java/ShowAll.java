import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ShowAll extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet'href='abc.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<ul><li>Home</li><li><a href='Insert.html'>Insert</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='Delete.html'>Delete</a></li><li><a href='Update.html'>Update</a></li><li><a href='Search.html'>Search</a></li><li><a href='Log.html'>Logout</a></li><li>About</li><li>Contact us</li></ul>");
		out.println("</div>");
		out.println("<div id='mydata'>");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagedb?useSSL=false","root","root");
			Statement st=con.createStatement();
			String q="select * from marks";
			ResultSet rs=st.executeQuery(q);
			out.println("<center>");
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			
			out.println("<td>URollno.</td>");
			out.println("<td>Physics</td>");
			out.println("<td>Chemistry</td>");
			out.println("<td>Maths</td>");
			out.println("<td>Biology</td>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</center>");
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