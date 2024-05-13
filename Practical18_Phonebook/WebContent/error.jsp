<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Error</title>
    </head>
    <body>
        <h1>An error occurred while processing your request.</h1>
        <p>${requestScope.error}</p>
<%--        <s:url action="listContacts" var="listContactsUrl"/>--%>
<%--        <a href="${listContactsUrl}">Go back to the list</a>--%>
        <a href="listContacts">Go to the Contact list</a>
    </body>
</html>