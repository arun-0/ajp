package ajp.struts;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String username;
	private String password;
	private String contact;
	private String address;

	public String getName()
	{
		return name;
	}
	public String setName(String name)
	{
		return this.name=name;
	}
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
	public String getContact() {return contact;}
	public void setContact(String contact) {this.contact = contact;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String execute() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
			String addqry="insert into user(name,username,password, contact, address) values('"+name+"','"+username+"','"+password+"','"+contact+"','"+address+"')";
			Statement stm = con.createStatement();
			int rowsAffected = stm.executeUpdate(addqry);
			if (rowsAffected > 0) {
				return "ok";
			} else {
				return "notok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "notok";
		}
	}

}
