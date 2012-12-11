/*
 *      Naomi Crosby
 */
package Chapter39;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Poll", urlPatterns = {"/Poll"})
public class Poll extends HttpServlet {

    private Boolean isYes;
    private String updateString;
    private String answer;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            processRequest(request, response);    
        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Process Request
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        isYes = Boolean.parseBoolean(request.getParameter("yesNo"));
        //setUpdateCommand(isYes);
        if (isYes) { // yes is checked
            updateString = "UPDATE Poll SET yesCount = yesCount + 1 WHERE ID = 1";
        } else {
            // Not a CS major
            updateString = "UPDATE Poll SET noCount = noCount + 1 WHERE ID = 1";
        }
        // This is the statement to update row table after request received
        //resultSet = statement.executeUpdate(updateString);
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exercise 39.13: Poll Status</title>");
            out.println("</head>");

            out.println("<body>");
            out.println("<h1>Servlet Poll Status at " + request.getContextPath() + "</h1>");
            out.println("<p>The current Yes count is 1.</p>");
            out.println("<p>The current No count is 1</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override  // INIT Method
    public void init() throws ServletException {
        try {
            initializeJdbc();
        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Initializing DB
    private void initializeJdbc() throws SQLException, ClassNotFoundException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook",
                    "scott", "tiger");
            System.out.println("Database connected...");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("SELECT ID, question, yesCount, noCount FROM Poll");
        } finally {
        }
    }
//    private void setUpdateCommand(Boolean value) throws SQLException {
//        Boolean yesValue = value;
//        String myString;
//        if (yesValue) { // yes is checked
//            myString = "UPDATE Poll SET yesCount = yesCount + 1 WHERE ID = 1";
//        } else {
//            // Not a CS major
//            myString = "UPDATE Poll SET noCount = noCount + 1 WHERE ID = 1";
//        }
//        // This is the statement to update row table after request received
//        resultSet = statement.executeUpdate(myString);
//    }
}
