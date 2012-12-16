// Naomi Crosby
package Chapter39;

import com.sun.rowset.JdbcRowSetImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;

@WebServlet(name = "PollUpdate", urlPatterns = {"/PollUpdate"})
public class PollUpdate extends HttpServlet {
    
    private Boolean isYes;
    private String responseString;
    private RowSet rowSet;
    private String answer;
    
    
    @Override  // doPost Method
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        answer = request.getParameter("yesNo");
        try {
            isYes = setIsYes(answer);
            if ( answer.isEmpty() ) {
                out.println("Please make a choice before submitting.");
            } else {
                int count = 0;
                if (isYes){
                    count = rowSet.getInt(3);
                    count++;
                    rowSet.updateInt(3, count);
                } else {
                    count = rowSet.getInt(4);
                    count++;
                    rowSet.updateInt(4, count);
                }

                rowSet.updateRow();
                
                responseString = "The current YES count is: " +  
                        rowSet.getInt(3) + "<br>The current NO count is: " + 
                        rowSet.getInt(4); 
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exercise 39.13: Poll Status</title>");
                out.println("</head>");

                out.println("<body>");
                out.println("<h1>Servlet Poll Status</h1>");
                out.println("<p>" + responseString + "</p>");
                out.println("</body>");
                out.println("</html>");
                
            }
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        } finally { out.close(); }
    }
    
    
    @Override  // INIT Method
    public void init() throws ServletException {
        initializeJdbc();       
    }
    
    // Initializing DB
    private void initializeJdbc() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/javabook");
            rowSet.setUsername("scott");
            rowSet.setPassword("tiger");
            String sql;
            sql = "SELECT * FROM Poll";
            rowSet.setCommand(sql);
            rowSet.execute();
            rowSet.next();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private Boolean setIsYes(String ans) {
        // Notes from the board on Monday 12/3/2012
        String myAnswer = ans;
        if ( myAnswer.contentEquals("true") ){ // yes is checked
            isYes = true;
        } else {
            isYes = false;
        } 
        return isYes;
    }
    
//    private String setUpdateCommand(Boolean value) {
//        Boolean yesValue = value;
//        String myString;
//        if ( yesValue ){ // yes is checked
//            //isYes = true;
//            //myString = "yesCount";
//            myString = "UPDATE Poll SET yesCount = yesCount + 1 WHERE ID = 1";
//         } else {
//            //isYes = false;
//            //myString = "noCount";
//            myString = "UPDATE Poll SET noCount = noCount + 1 WHERE ID = 1";
//        }
//        return myString;
//    }
}


