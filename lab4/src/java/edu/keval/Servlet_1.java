package edu.keval;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_1")
public class Servlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servlet_1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        process(request, response);
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userName = request.getParameter("uid");
        String passWord = request.getParameter("pwd");
        PrintWriter out = response.getWriter();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "ajp", "ajp");
            Statement stm = con.createStatement();
            String q = "Select * from credit";
            ResultSet rs = stm.executeQuery(q);
            while (rs.next()) {
                if (rs.getInt("id") > 0) {
                    if (rs.getString("username").equals(userName) && rs.getString("password").equals(passWord)) {
                        out.println("Login Successfull!");
                    } else {
                        out.println("Username or Passwrod is Invalid");
                    }
                }
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}