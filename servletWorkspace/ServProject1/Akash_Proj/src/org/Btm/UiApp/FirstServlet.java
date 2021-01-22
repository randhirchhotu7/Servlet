package org.Btm.UiApp;
import java.io.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class FirstServlet extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException 
	{
		String name = req.getParameter("nm");
		String place = req.getParameter("pl");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='Yellow'>"
				+"<h1>New member of our class is "+name+" from "+place+" !!"+"</h1>"
				+"</body></html>");
		out.close();
	}

}