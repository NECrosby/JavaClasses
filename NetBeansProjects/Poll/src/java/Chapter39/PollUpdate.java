// Naomi Crosby
package Chapter39;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PollUpdate", urlPatterns = {"/PollUpdate"})
public class PollUpdate extends HttpServlet {
    private Statement statement;
    private Boolean isYes;
    private String updateString;
    private String responseString;
    
    // doPost Method
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            if (true){ // yes is checked
                isYes = true;
                out.println();
            } else {
                isYes = false;
                out.println();
            }
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        }
        
             
    }
    
    // INIT Method
    public void init() throws ServletException {
        initializeJdbc();
    }
    
    // Initializing DB
    private void initializeJdbc() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            
            // Establish a connection
            Connection connection = 
                    DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected");
            
            // Create a statement
            //statement = connection.statement("IN");
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // Updating the DB as needed
    private void storePollAnswer() {
        // Notes from the board on Monday 12/3/2012
        isYes = request.getParameter("yes");
        try {
            if (true) {  // yes is checked
                updateString = "UPDATE Poll SET yesCount = yesCount + 1 WHERE QuestionID = 1;";
                responseString = "The current Yes count is ";   //+ yesCount; <--- yesCount = column.getValuein column;
            } else {
                updateString = "UPDATE Poll SET noCount = noCount + 1 WHERE QuestionID = 1;";
                responseString = "The current No count is ";   //+ noCount; <--- noCount = column.getValuein column;
            } 
            statement.executeQuery();
        } catch (Exception ex) {
            out.println("Error: " + ex.Message());
         } finally { out.close(); } 
    }
}


