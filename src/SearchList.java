package src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchList", urlPatterns = "/Search")
public class SearchList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Declare outside the try/catch so the variables are in scope in the finally block
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            String searchName = request.getParameter("Item_Name");

            System.out.println("working");
            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../../db";

            // Create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "brian",  // db username
                    "brian"); // db password

            // Create a statement to executeSQL
            stmt = conn.createStatement();

            rset = stmt.executeQuery("SELECT Item_ID, Item_Name FROM All_Items WHERE Item_Name like %\" + searchName + \"% ");


        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {

        }
    }
}