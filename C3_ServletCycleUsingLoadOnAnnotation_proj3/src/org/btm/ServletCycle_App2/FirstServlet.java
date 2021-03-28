package org.btm.ServletCycle_App2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.*;
@WebServlet(urlPatterns="/btm", loadOnStartup = 3)
public class FirstServlet extends GenericServlet
{
	public FirstServlet() 
	{
		System.out.println("Servlet object is created !!");
	}
	@Override
	public void init() throws ServletException 
	{
//		super.init();
		System.out.println("Servlet object is Initialized !!");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("nm");
		String fName = req.getParameter("fnm");
		String place = req.getParameter("pl");
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1>New Student of BTM is : "+name+"<br></br>"+"Father Name is : "+fName+"<br></br>"+"Home State is : "+place
				+ "</h1>"+"</body></html>");
		out.close();
		System.out.println("Service method is Executed !!");
	}
	
	@Override
	public void destroy() 
	{
//		super.destroy();
		System.out.println("Closed all costly resources !!");
	}
}