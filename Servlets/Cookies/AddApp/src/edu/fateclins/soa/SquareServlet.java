package edu.fateclins.soa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/square")
public class SquareServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		Cookie cookies[] = req.getCookies();
		
		if (cookies != null) {
			PrintWriter write = res.getWriter();
			for (Cookie c: cookies){
				write.println("Nome=" + c.getName() + ", " + 
			                  "Valor=" + c.getValue());
			}
		}
	}
}
