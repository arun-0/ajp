package edu.mca.ajp.services;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;

@Path("/registration")

public class Registration {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)	
	public Response addRecord(@FormParam("txtStudentID") String id,@FormParam("txtStudentName") String name,
			@FormParam("txtSemester") String sem,@FormParam("txtCity") String city,
			@FormParam("txtContact") String contact,@Context HttpServletRequest request) throws URISyntaxException
	{
		String str="Student ID : "+id+"<br> Student Name : "+name+"<br> Semester : "+sem+"<br> City : "+city+"<br> Contact :"+contact;
		
		request.getSession().setAttribute("message", str);

		String contextPath = request.getContextPath();
		return Response.temporaryRedirect(new URI(contextPath + "/Display.jsp")).build();
	}
}