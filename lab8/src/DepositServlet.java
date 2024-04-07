import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from request
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {
            // Update account balance using JDBC
            DBUtil.updateBalance(accountId, amount);

            // Redirect to success page
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            response.sendRedirect("error.jsp");
        }
    }

}
