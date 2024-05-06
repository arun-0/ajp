<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <%= session.getAttribute("ses") %></h1>
	<form action="" method="post">
		<input type="submit" name="logout" value="Logout">
	</form>
</body>

<%
	if(request.getParameter("logout") != null){
		int users = (int) getServletContext().getAttribute("users");
		if(users > 0){
			getServletContext().setAttribute("users", --users);
		}
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>

</html>