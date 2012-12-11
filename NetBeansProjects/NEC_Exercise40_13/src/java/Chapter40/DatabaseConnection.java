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
    
//    public void initializeJdbc() {
//        try {
//            System.out.println("Driver is " + driver);
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public void initializeJdbc() {
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
    
    public String[] getTables() {
        String[] tables = null;
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null,
                    new String[] {"TABLE"});
            int size = 0;
            while ( resultSet.next() ) {
                size++;
            }
            
            resultSet = metaData.getTables(null, null, null, 
                    new String[] {"TABLE"});
             
            tables = new String[size];
            int i = 0;
            while ( resultSet.next() ) {
                tables[i++] = resultSet.getString("TABLE_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tables;
    }
    
    public String[] getColumns() {
        String[] columns = null;
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "MultiQPoll", null);
            
            int size = 0;
            while ( resultSet.next() ) {
                size++;
            }
            // Need to complete this method
            resultSet = metaData.getColumns(null, null, null, "question");
             
            columns = new String[size];
            int i = 0;
            while ( resultSet.next() ) {
                columns[i++] = resultSet.getString("COLUMN_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return columns;
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
}
