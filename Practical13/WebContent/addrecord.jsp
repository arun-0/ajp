<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Record</title>
</head>
<body>
	<form action="rest/service/add" method="post">
		Name <input type="text" name="name">
		Contact No. <input type="text" name="number">
		<input type="submit" value="Save">
	</form>
	<center>
		<%= session.getAttribute("msg") == null?"":session.getAttribute("msg") %>
		<% session.removeAttribute("msg"); %>
	</center>
</body>
</html>