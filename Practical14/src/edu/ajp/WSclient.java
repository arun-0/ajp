package edu.ajp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class WSclient extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String endpoint = request.getParameter("endpoint");
		String number = request.getParameter("number");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/lab11/rest/converter/" + endpoint + "/" + number);
		String result = target.request().accept(MediaType.TEXT_HTML).get(String.class);
		response.getWriter().write("Response from Web Service : " + result);
	}
}