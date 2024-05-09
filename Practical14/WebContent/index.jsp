<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>WS-Client code in Servlet</title>
    </head>
    <body>
        <form method="get" action="WSclient">
            <input type="hidden" name="endpoint" value="rtod">
            <label>Enter a number for Rupee to Dollar:</label>
            <input type="text" name="number" required>
            <input type="submit" value="Submit">
        </form>
        <form method="get" action="WSclient">
            <input type="hidden" name="endpoint" value="dtor">
            <label>Enter a number for Dollar to Rupee:</label>
            <input type="text" name="number" required>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>