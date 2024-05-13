package ajp.struts;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String execute() throws Exception {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");
            String selectQuery = "SELECT * FROM phonebook";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(selectQuery);
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setAddress(rs.getString("address"));
                contact.setContactNumber(rs.getString("number"));
                contact.setEmailId(rs.getString("email"));
                contacts.add(contact);
            }
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "notok";
        }
    }
}