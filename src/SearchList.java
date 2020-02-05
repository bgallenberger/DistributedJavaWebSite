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
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchName = request.getParameter("Item_Name");
            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../classes/db";

            // Create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "ITEMS",  // db username
                    "brian"); // db password

            // Build the query as a String
            StringBuilder sql = new StringBuilder("select Item_ID, Item_Name from All_Items");
            sql.append("Where Item_Name like %?%");
            // Create a statement to executeSQL
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, searchName);

            rset = pstmt.executeQuery();

            StringBuilder output = new StringBuilder("<html>" +
                    "<head>\n" +
                    "    <title>List</title>\n" +
                    "    <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/style.css\">\n" +
                    "</head><body>" +
                    "   <div id=\"loginLink\"><a href=\"/DistributedJavaWebSite/view/List.jsp\">Login</a></div>\n" +
                    "   <h1>My Site</h1>" +
                    "<form method=\"get\" action=\"/DistributedJavaWebSite/Search\">" +
                    "<input type=\"text\" class=\"searchItem\" value=\"search\" name=\"Item_Name\">" +
                    "</form>" +
                    "<form><table>");

            output.append("<p>");
            output.append(searchName);
            output.append("</p>");

            output.append("<table>");
            output.append("<th>ID</th>");
            output.append("<th>Name</th>");
            output.append("<th>Edit</th>");
            output.append("<th>Delete</th>");

            int loop = 0;
            while (rset.next()) {
                System.out.println("looping search " + ++loop);
                int id = rset.getInt("Item_Id");
                String name = rset.getString(2);
                output.append("<tr><td>").append(id);
                output.append("</td><td>").append(name);
                output.append("</td><td><input type=\"button\" class=\"editItem\" value=\"edit\"></td><td><input type=\"button\" class=\"deleteItem\" value=\"delete\"></td>");
                output.append("</tr>");
            }

            output.append("</table><p><input type=\"button\" class=\"addItem\" value=\"add\"></p></form></body></html>");

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
            if (pstmt != null) {
                try {
                    pstmt.close();
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