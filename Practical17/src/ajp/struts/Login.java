package ajp.struts;

import java.sql.*;


import com.opensymphony.xwork2.ActionSupport;


public class Login extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
		Statement stm = con.createStatement();
		String qry = "select id from user where username='"+username+"' AND password='"+password+"'";
		ResultSet rs = stm.executeQuery(qry);
		rs.next();
		if (rs.getRow()>0) {
			return "ok";
		}
		else{
			return "notok";
		}		
	}
}
