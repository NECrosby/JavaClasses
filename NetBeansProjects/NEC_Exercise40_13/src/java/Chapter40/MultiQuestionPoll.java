/* 
 *      Naomi Crosby
 *      Homework Chapter 40 - Exercise 40.13
 */
package Chapter40;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class MultiQuestionPoll extends DatabaseConnection {
    // Class variables
    DatabaseConnection connection = new DatabaseConnection();
    
    // Constructor
    public MultiQuestionPoll() {
        populate();
    }
    public void populate() {
        
    }
    public int getValue(int row, int column) {
        return value;
    }
    public String getQuestion(int question) {
        return value;
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
    
}
