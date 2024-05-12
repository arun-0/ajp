package edu.ajp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import javassist.SerialVersionUID;

public class authenticate extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	private String pass;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


	public String execute() throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from credit where username = '"+user+"'&& password = '"+pass+"'");
		rs.next();
		if(rs.getRow()>0) {
			return "ok";
		} else {
			return "notok";
		}
	}
}
