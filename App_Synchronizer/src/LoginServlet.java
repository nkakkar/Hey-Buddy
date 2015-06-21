

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("username");
		String passw = request.getParameter("pass");
		
		boolean valid = LoginDAO.validate(usr, passw);
		if(valid)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",usr);
			session.setMaxInactiveInterval(30*60);
			Cookie userNew = new Cookie("username",usr);
			userNew.setMaxAge(30*60);
			response.addCookie(userNew);
			response.sendRedirect("LoginSuccess.jsp");
		}
		else
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignIn.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red size=5>Username/Password Invalid</font>");
			rd.include(request,response);
		}
	}

}
