import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Update extends HttpServlet
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
	out.println("<ul><li>Home</li><li><a href='Insert.html'>Insert</a></li><li><a href='Search.html'>Search</a></li><li><a href='ShowAll'>ShowAll</a></li><li><a href='Update'>Update</a></li><li><a href='Delete.html'>Delete</a></li><li><a href='Login.html'>LogOut</a></li><li>About</li><li>Contact Us</li></ul>");
	out.println("</div >");
	out.println("<div id='mydata'>");
        out.println("<center>");
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagedb?useSSL=false","root","root");
			Statement st=con.createStatement();
                        String s1=request.getParameter("u1");
                        String s2=request.getParameter("u2");
                        String s3=request.getParameter("u3");
                        String s4=request.getParameter("u4");
                        String s5=request.getParameter("u5");
                        
			String q1="update marks set UPHYSICS='"+s2+"', UCHEMISTRY ='"+s3+"',UMATHS='"+s4+"',UBIOLOGY='"+s5+"' Where UROLLNO='"+s1+"'";
			st.executeUpdate(q1);
		
		response.sendRedirect("ShowAll");
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