//login.JAVA
//MY SQL TABLE NAME=
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Login extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
	out.println("<html>");
	out.println("<body>");
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagedb?useSSL=false","root","root");

		Statement st=con.createStatement();
	    String q="select * from Regis where UNAME ='"+s1+"'AND UPASS='"+s2+"'";
		ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
			response.sendRedirect("Menu.html");	
		}
	else
	{
		out.println("<h1>INVALID USERNAME </h1>");
	}
		con.close();
	}
	catch(Exception e1)
	{
		out.println(e1);
	}
	out.println("</html>");
	out.println("</body>");
	out.close();
}}
