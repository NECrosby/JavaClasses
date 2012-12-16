/*
 *      Naomi Crosby
 */
package Chapter40;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseConnection {
    private Connection connection = null;
    private String username = "scott";
    private String password = "tiger";
    private String driver;
    private String url;

    public DatabaseConnection() {
        initializeJdbc();
    }
    public static void initializeJdbc() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = 
                    DriverManager.getConnection(
                    "jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected...");
        
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
