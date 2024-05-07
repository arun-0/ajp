package edu.mca.ajp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:8080/lab15/rest/Auth/"+request.getParameter("userId")+"/"+request.getParameter("password"));
		
		String res=target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		if(res.equals("success")) {
			request.getSession(true).setAttribute("userId", request.getParameter("userId"));
			response.sendRedirect("http://localhost:8080/lab15/home.jsp");
		} else if (res.equals("failure")) {
			request.getSession(true).setAttribute("error", "Invalid User Id or Password");
			response.sendRedirect("http://localhost:8080/lab15/index.jsp");
		} else {
			request.getSession(true).setAttribute("error", "Unable to Connect");
			response.sendRedirect("http://localhost:8080/lab15/index.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
