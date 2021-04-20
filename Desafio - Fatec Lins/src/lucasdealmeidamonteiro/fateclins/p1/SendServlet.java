package lucasdealmeidamonteiro.fateclins.p1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class SendServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String name = req.getParameter("name");
		req.setAttribute("name", name.toUpperCase());
		
		RequestDispatcher view = req.getRequestDispatcher("response.jsp");
		view.forward(req, res);
	}
}
