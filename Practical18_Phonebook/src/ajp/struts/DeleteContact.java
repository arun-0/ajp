package ajp.struts;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteContact extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int id;

	// getter and setter for id...
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	@Override
	public String execute() throws Exception {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
			String deleteQuery = "DELETE FROM phonebook WHERE id = " + id;
			Statement stm = con.createStatement();
			int rowsAffected = stm.executeUpdate(deleteQuery);
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