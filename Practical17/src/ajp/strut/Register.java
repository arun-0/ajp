package ajp.strut;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String name;
	
	public String getUsername()
	{
		return username;
	}
	public String setUsername(String username)
	{
		return this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public String setPassword(String password)
	{
		return this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public String setName(String name)
	{
		return this.name=name;
	}
	
	public String execute() throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
		Statement stm = con.createStatement();
		String addqry="insert into user(name,username,passw)";
		return "notok";
	}
}
