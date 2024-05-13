package ajp.struts;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class EditContact extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String address;
	private String contactNumber;
	private String emailId;

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getContactNumber() {return contactNumber;}
	public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}
	public String getEmailId() {return emailId;}
	public void setEmailId(String emailId) {this.emailId = emailId;}

	@Override
	public String execute() throws Exception {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
			String addqry="delete phonebook where id = "+id;
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