package org.http.sendRedirect1_App1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("nm");
		resp.setContentType("text/html");
		resp.sendRedirect("https://www.google.co.in/#q="+name);
	}

}
