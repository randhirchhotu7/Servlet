package org.btm.ServletCycle_App1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		String place = req.getParameter("pl");
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1>New Student of BTM is "+name+" from "+place+" !!!"
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