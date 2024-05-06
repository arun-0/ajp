<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Record</title>
</head>
<body>

<% 
	try
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
		Statement statement = connection.createStatement();
		ResultSet rst = statement.executeQuery("select * from phonebook where id ="+request.getParameter("id"));
		rst.next();
		%>
		
		<form method="post" action="rest/service/update">
			<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
			Name <input type="text" name="name" value="<%=rst.getString(2)%>">
			Number <input type="text" name="number" value="<%=rst.getString(3)%>">
			<input type="submit" value="Update">
		</form>
		
		<%
	}catch(Exception e)
	{
		out.println(e.getMessage());
	}
	
%>

</body>
</html>