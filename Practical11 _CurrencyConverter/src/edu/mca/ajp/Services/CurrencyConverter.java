package edu.mca.ajp.Services;

import javax.ws.rs.*;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;

@Path("/converter") 

public class CurrencyConverter {
	
	@GET
	@Path("/rtod/{amt}")
	@Produces("text/html")
	public String rupee2dollar(@PathParam("amt")float amt)
	{
		float dollar = amt/67;
		return "<b>Converted Dollar : </b>"+dollar+"$";
		
	}
	
	@GET
	@Path("/dtor/{amt}")
	@Produces("text/html")	
	public String dollar2rupee(@PathParam("amt")float amt)
	{
		float dollar = amt*67;
		return "<b>Converted rupees : </b>"+dollar+"$";
		
	}
}
