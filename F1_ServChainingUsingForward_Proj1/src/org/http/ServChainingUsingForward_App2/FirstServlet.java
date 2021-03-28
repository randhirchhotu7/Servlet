package org.http.ServChainingUsingForward_App2;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String pName=req.getParameter("pn");
		String pQty=req.getParameter("pq");
		//Add request object into scope//
		req.setAttribute("prdnm", pName);
		req.setAttribute("prdqt", pQty);
		RequestDispatcher rd=req.getRequestDispatcher("ss");
		rd.forward(req, resp);
	}	
}
