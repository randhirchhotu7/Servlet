package org.btm.Servlet_Context_App1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ep")
public class ElectronicServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp)
	throws ServletException, IOException
	{
		ServletContext ctx = getServletContext();
		//	Fetch Context Parameters 
		String offmsg = ctx.getInitParameter("ofm");
		String offper = ctx.getInitParameter("ofp");

		//	Add Context(ctx) object into Scope //
		
		Product p = new Product();

		ctx.setAttribute("prd", p);
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor = 'Orange'>"
				+ "<marquee><h1>Enjoy Offer on Electronics!!!</h1></marquee>"+"<h2>Electronic Product Details </h2><p>"
				+ " "+offmsg+" "+offper+" % off"
				+ "<br><a href=\"product.html\">Back</a>"
				+ "</body></html>");
		out.close();
	}
}
