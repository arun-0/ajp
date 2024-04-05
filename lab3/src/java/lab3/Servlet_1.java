package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab3.Servlet_1
 */
@WebServlet("/Servlet_1")
public class Servlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        //process(request, response);
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
        String userName = request.getParameter("userName");
        String birthDate = request.getParameter("birthDate");
        String emailId = request.getParameter("emailId");
        String contactNo = request.getParameter("contactNo");
        PrintWriter out = response.getWriter();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/midsem", "root", "root");
            Statement stm = con.createStatement();
            String query = "insert into user value('" + userName + "','" + birthDate + "','" + emailId + "','" + contactNo + "')";
            if (stm.executeUpdate(query) > 0) {
                response.sendRedirect("/lab3/Servlet_2");
            } else {
                out.println("<font color='#e00'>Unable to Enter Data</font>");
            }
            stm.close();
            con.close();
        } catch (SQLException e) {
            // TODO: handle exception
            out.println("<font color='#e00'>Errore:" + e.getMessage() + "</font>");
        }
    }
}