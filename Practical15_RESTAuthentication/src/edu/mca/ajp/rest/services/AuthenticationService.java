package edu.mca.ajp.rest.services;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Auth")
public class AuthenticationService {
	
	@GET
	@Path("/{userId}/{password}")	
	@Produces(MediaType.TEXT_PLAIN)
	public Response authentiate(@PathParam("userId") String userId, 
			@PathParam("password") String password, 
			@Context HttpServletRequest request) throws URISyntaxException
	{
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "ajp","ajp");
			
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from credit where username='"+userId+"'");
			
			if(rs.next() && rs.getString("password").equals(password)) {
				return Response.status(200).entity("success").build();
			} else {
				return Response.status(200).entity("failure").build();
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return Response.status(200).entity("fail").build();
	}

}
