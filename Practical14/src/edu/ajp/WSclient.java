package edu.ajp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WSclient {
	public static void main(String args[]) {
		Client client=ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080/lab11/rest/converter/rtod/100");
		String res=target.request().accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println("Response from Web Service: "+res);
	}
}