import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        String u, p;
        u = request.getParameter("uname").trim();
        p = request.getParameter("pwd").trim();
        Connection c;
        try {
// PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ajp",
                    "ajp", "ajp");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    "select * from registration where name='" + u + "' AND pwd='" + p + "'");
            HttpSession session = request.getSession();
            System.out.println("Record fetched");
            if (rs.next()) {
                session.setAttribute("un", u);
                response.sendRedirect("/lab7/home.jsp");
            } else {
//session.setAttribute("flag", "Wrong Credentials");
                response.sendRedirect("/lab7/index.html");
            }
        } catch (Exception e) {
            out.println(e.toString());
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}