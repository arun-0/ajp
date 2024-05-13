package ajp.struts;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class AddContact extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String number;
	private String email;

	// getters and setters...
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getNumber() {return number;}
	public void setNumber(String number) {this.number = number;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	@Override
	public String execute() throws Exception {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
			String addqry="insert into phonebook(name,address,number,email) values('"+name+"','"+address+"','"+ number +"','"+ email +"')";
			Statement stm = con.createStatement();
			int rowsAffected = stm.executeUpdate(addqry);
			if (rowsAffected > 0) {
				return "ok";
			} else {
				return "notok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return "error";
		}

	}
}