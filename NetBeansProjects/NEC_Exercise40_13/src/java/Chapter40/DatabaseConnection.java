/*
 *      Naomi Crosby
 */
package Chapter40;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.Connection;
import javax.sql.RowSet;

public class DatabaseConnection {
    private static Connection connection = null;
    private String username = "scott";
    private String password = "tiger";
    private String driver;
    private String url;
    private static RowSet rowSet;

    public DatabaseConnection() {
        initializeJdbc();
    }
    public static void initializeJdbc() {
        try {
            
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl("jdbc:mysql://localhost/javabook");
            rowSet.setUsername("scott");
            rowSet.setPassword("tiger");
            String sql;
            sql = "SELECT * FROM MultiQPoll ORDER BY question";
            rowSet.setCommand(sql);
            rowSet.execute();
            rowSet.next();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void setUsername(String newUsername) {
        username = newUsername;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    public String getPassword() {
        return password;
    }
    public void setDriver(String newDriver) {
        driver = newDriver;
    }
    public String getDriver() {
        return driver;
    }
    public void setUrl(String newUrl) {
        url = newUrl;
    }
    public String getUrl() {
        return url;
    }
    
    // Need to add in methods to get MetaData
    
    // Need to add in methods to get Result Sets
}
