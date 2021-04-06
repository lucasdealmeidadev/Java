package edu.fateclins.soa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/soma")
public class AddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		int result = n1 + n2;
		req.setAttribute("num", result); 
	
		RequestDispatcher rd = req.getRequestDispatcher("square");
		rd.forward(req, res);
	}
}
