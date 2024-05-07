<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%= session.getAttribute("error")!=null?"<font color='red'>"+session.getAttribute("error")+"</font>":"" %>

<% session.removeAttribute("error"); %>


<form action="Authentication" method="post">
	<input type="text" name="userId" placeholder="Enter User ID"/><br/>
	<input type="password" name="password" placeholder="Enter Password"/><br/>
	<input type="submit" value="Log In"/>
	<input type="reset" value="Cancel"/>
</form>

</body>
</html>