package edu.ajp.ws;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service")
public class Services {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addRecord(@FormParam("name") String name,@FormParam("number") String number,@Context HttpServletRequest request) throws URISyntaxException
	{
		String contextPath = request.getContextPath();

		try {
			Statement stetement = DBConnection.getConnection().createStatement();
			String InsertQuery = "insert into phonebook(name,number) values('"+name+"','"+number+"')";

			if (stetement.executeUpdate(InsertQuery)>0) {
				request.getSession().setAttribute("msg", "Record Inserted!");
			} else {
				request.getSession().setAttribute("msg", "Somethig Went Wrong!");
			}
			return Response.temporaryRedirect(new URI(contextPath + "/addrecord.jsp")).build();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return Response.temporaryRedirect(new URI(contextPath + "/")).build();
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateRecord(@FormParam("id") String id,@FormParam("name") String name,@FormParam("number") String number,@Context HttpServletRequest request) throws URISyntaxException
	{
		String contextPath = request.getContextPath();

		try {
			Statement stetement = DBConnection.getConnection().createStatement();
			String UpdateQuery = "update phonebook set name='"+name+"',number='"+number+"' where id='"+id+"'";
			
			if (stetement.executeUpdate(UpdateQuery)>0) {
				request.getSession().setAttribute("msg", "Record Updated!");
			} else {
				request.getSession().setAttribute("msg", "Somethig Went Wrong!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Response.temporaryRedirect(new URI(contextPath + "/")).build();
	}

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deleteRecord(@FormParam("id") String id, @Context HttpServletRequest request) throws URISyntaxException
	{
		String contextPath = request.getContextPath();

		try {
			Statement statement = DBConnection.getConnection().createStatement();
			String deleteQuery = "delete from phonebook where id='" + id + "'";

			if (statement.executeUpdate(deleteQuery) > 0) {
				request.getSession().setAttribute("msg", "Record Deleted!");
			} else {
				request.getSession().setAttribute("msg", "Something Went Wrong!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Response.temporaryRedirect(new URI(contextPath + "/")).build();
	}

}
