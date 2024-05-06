package ajp.exam;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     int counter =1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("UN");
		String pw = request.getParameter("PW");
		if (getServletContext().getAttribute("users")!=null) {
			
			int count = (int)getServletContext().getAttribute("users");
			if (count>=2) {
				response.sendRedirect("err.jsp");
			}
			else {
				getServletContext().setAttribute("users", ++count);
				request.getSession().setAttribute("session", un);
				response.sendRedirect("home.jsp");
			}
		}
		else {
			ServletContext application = getServletContext();
			application.setAttribute("users", counter);
			request.getSession().setAttribute("session", un);
			response.sendRedirect("home.jsp");
		}
	}

}
