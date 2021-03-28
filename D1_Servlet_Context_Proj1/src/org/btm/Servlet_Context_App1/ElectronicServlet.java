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

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
		//	Add Context(ctx) object into Scope( Only once throughout the application ) //
		Product p = new Product();
		ctx.setAttribute("prd", p);

// syntax : setAttribute(String key, object obj)//		
//Note : Attribut can fetch back from the scope by using getAttribute(String Key) method here 'key is prd' //

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor = 'Orange'>"
				+ "<marquee><h1>Enjoy Offer on Electronics!!!</h1></marquee>"+"<h2>Electronic Product Details </h2><p>"
				+ " "+offmsg+" "+offper+" % off"
				+ "<br><a href=\"product.html\">Back</a>"
				+ "</body></html>");
		out.close();
	}
}
