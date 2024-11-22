//REGIS.JAVA
//MY SQL TABLE NAME=
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class regis extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		String s3=request.getParameter("u3");
	out.println("<html>");
	out.println("<body>");
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagedb?useSSL=false","root","root");
     


		Statement st=con.createStatement();
	    String q1="insert into Regis values ('"+s1+"','"+s2+"','"+s3+"')";
		st.executeUpdate(q1);
		
		response.sendRedirect("Login.html");
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