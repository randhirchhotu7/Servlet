package org.btm.Servlet_Context_App1;
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/cp")

public class ClothServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse resp)
	throws ServletException, IOException
	{
		ServletContext ctx = getServletContext();
		//	Fetch Context Parameters 
		String offmsg = ctx.getInitParameter("ofm");
		String offper = ctx.getInitParameter("ofp");

		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor = 'Orange'>"
				+  "<marquee><h1>Enjoy Offer on Cloth!!!</h1></marquee>"+"<h1>Cloth Product Details </h1><p>"
				+ " "+offmsg+" "+offper+" % off"
				+ "<br><a href=\"product.html\">Back</a>"
				+ "</body></html>");
		out.close();
	}
}
