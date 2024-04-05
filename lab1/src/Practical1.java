import java.sql.*;
import java.util.Scanner;

public class Practical1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username");
        String un = scan.next();
        System.out.println("Enter Password");
        String pw = scan.next();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "ajp", "ajp");
            Statement stm = con.createStatement();
            String Query = "select data from credit where username ='" + un + "' AND password='" + pw + "'";
            ResultSet rs = stm.executeQuery(Query);
            rs.next();
            if (rs.getRow() > 0) {
                System.out.println("Login Successfull !" + rs.getString("data"));
            } else {
                System.out.println("Login Fail");
            }
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}