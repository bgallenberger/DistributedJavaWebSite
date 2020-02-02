package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateList", urlPatterns = "/List")
public class UpdateList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Declare outside the try/catch so the variables are in scope in the finally block
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        try {
            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../../db";

            // Create a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "brian",  // db username
                    "brian"); // db password

            // Create a statement to executeSQL
            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("SELECT Item_ID, Item_Name FROM All_Items");

            StringBuilder output = new StringBuilder("<html><body><form><ul>");

            while (rset.next()) {
                int id = rset.getInt(1);
                String name = rset.getString(2);
                output.append("<li>").append(id);
                output.append(": ").append(name);
                output.append("</li>");
                output.append("<input type=\"button\" class=\"editItem\" value=\"edit\"><input type=\"button\" class=\"deleteItem\" value=\"delete\">");
            }

            output.append("</ul><input type=\"button\" class=\"addItem\" value=\"add\"></form></body></html>");

            // Send the HTML as the response
            response.setContentType("text/html");
            response.getWriter().print(output.toString());
        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
