<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phonebook</title>
</head>
<body>
<a href="addrecord.jsp">Add New Contact</a>
<%
	try{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from phonebook");
		%>
		<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Number</th>
		</tr>
		<%
		while(rs.next())
			{
				
				%>				
				<tr>
					<td><%= rs.getInt(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getString(3) %></td>
					<td> <a href="http://localhost:8080<%= request.getContextPath()%>/editrecord.jsp?id=<%=rs.getInt(1)%>">Update</a></td>
					<form action="rest/service/delete" method="post">
						<input type="hidden" name="id" value="<%=rs.getInt(1)%>">
						<td><input type="submit" value="Delete"></td>
					</form>
				</tr>
				<%
			}
		%>
		</table>
		<%
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}	
%>

</body>
</html>