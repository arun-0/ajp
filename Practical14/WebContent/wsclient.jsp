<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="javax.ws.rs.client.Client" %>
<%@ page import="javax.ws.rs.client.ClientBuilder" %>
<%@ page import="javax.ws.rs.client.WebTarget" %>
<%@ page import="javax.ws.rs.core.MediaType" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>WS-Client code in JSP</title>
    </head>
    <body>
        <form method="post">
            <label>Enter a number for Rupee to Dollar:</label>
            <input type="text" name="number" required>
            <input type="hidden" name="endpoint" value="rtod">
            <input type="submit" value="Submit">
        </form>
        <form method="post">
            <label>Enter a number for Dollar to Rupee:</label>
            <input type="text" name="number" required>
            <input type="hidden" name="endpoint" value="dtor">
            <input type="submit" value="Submit">
        </form>
        <%
            String endpoint = request.getParameter("endpoint");
            String number = request.getParameter("number");
            if (endpoint != null) {
                Client client = ClientBuilder.newClient();
                WebTarget target = client.target("http://localhost:8080/lab11/rest/converter/" + endpoint + "/" + number);
                String result = target.request().accept(MediaType.TEXT_HTML).get(String.class);
                out.println("Response from Web Service : " + result);
            }
        %>
    </body>
</html>