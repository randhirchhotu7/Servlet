package org.http.ServChainingUsingForward_App2;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		//Fetching Request(req) object back from scope //
		String pname=(String)req.getAttribute("prdnm");
		String pqty=(String)req.getAttribute("prdqt");
		int qty = Integer.parseInt(pqty);
		
		double price=40000;
		double totalSum=(price*qty);//Busigness logic
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1>Product Details are "+totalSum+"</h1>"
				+ "</body></html>");		// Presentation Logic
		out.close();
		
		//	Persistance logic //
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.product values(?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=thunder");
			pstmt=con.prepareStatement(qry);
			//Set placeholder values //
			pstmt.setString(1, pname);
			pstmt.setInt(2, qty);
			pstmt.setDouble(3, totalSum);
			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
