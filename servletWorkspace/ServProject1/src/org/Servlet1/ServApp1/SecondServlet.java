package org.Servlet1.ServApp1;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/btm")
public class SecondServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException 
	{
		String name = req.getParameter("nm");
		String Fname = req.getParameter("fnm");
		String place = req.getParameter("pl");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='Yellow'>"
				+"<h1><marquee>Thunder !!!</Marquee></h1>"+"<h2>My name is "+name+"<br></br>"+"My Father name is "+Fname+"<br></br>"
				+" And I am from "+place+
				" !!"+"</h2>"+"</body></html>");
		out.close();
	}

}
