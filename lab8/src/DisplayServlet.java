import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = new ArrayList<>();

        try {
            // Retrieve account information using JDBC
            accounts = DBUtil.getAccounts();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

}
