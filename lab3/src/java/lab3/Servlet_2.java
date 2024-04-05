package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab3.Servlet_2
 */
@WebServlet("/Servlet_2")
public class Servlet_2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        process(request, response);
    }

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "ajp", "ajp");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * From user");
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            out.println("<a href='/lab3/'>Add New User !</a>");
            out.println("<table align='center' border=2>");
            out.println("<tr>");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                out.println("<th>" + rsmd.getColumnName(i).toUpperCase() + "</th>");
            }
            out.println("</tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}