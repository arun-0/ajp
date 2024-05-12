<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
</head>
<body>

<form action="registration" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br/>
    <label for="username">User ID:</label>
    <input type="text" id="username" name="username"><br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br/>
    <label for="contact">Contact Number:</label>
    <input type="text" id="contact" name="contact"><br/>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address"><br/><br>
    <input type="submit" value="Register">
</form>


</body>
</html>