package edu.fateclins.soa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/square")
public class SquareServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int num = (int) req.getAttribute("num"); 
		int quad = num * num;
		 
		PrintWriter result = res.getWriter();
		result.println("Quadrado de " + num + " = " + quad);
		
	}
}
