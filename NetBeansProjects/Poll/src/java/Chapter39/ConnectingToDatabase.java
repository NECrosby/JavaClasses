/*
 * Naomi Crosby
 */
package Chapter39;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

    
public class ConnectingToDatabase {
    public static void main(String[] args) {
            initializeDB();
    }

    private static void initializeDB() {
        try {
            /** Load Driver(s) */
            Class.forName("com.mysql.jdbc.Driver"); 
            //Class.forName("oracle.jdbc.Driver.OracleDriver");
            System.out.println("Driver loaded");
            
            /** Establish Connection */
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
            //Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl", "scott", "tiger");
            connection.setAutoCommit(true);
            System.out.println("Database connected...");
            
            /** Create a statement for connection  */
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            /** Getting Result Set */
            ResultSet resultSet = statement.executeQuery("SELECT columnNames FROM TableName");
            
            /** To get into the Result Set  */
            resultSet.next();
            
            } catch (SQLException ex) {
                Logger.getLogger(ConnectingToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectingToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}    
    
