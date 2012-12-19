/* 
 *      Naomi Crosby
 *      Homework Chapter 40 - Exercise 40.13
 */
package Chapter40;

import java.sql.SQLException;
import javax.sql.RowSet;

public class MultiQuestionPoll extends DatabaseConnection {
    // Class variables

    private DatabaseConnection connection = new DatabaseConnection();
    private Boolean isYes, isNo;
    private String question;
    private int yesCount, noCount;
    private String responseString;
    private RowSet rowSet;
    private String answer;

    // Constructor
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MultiQuestionPoll() {
        try {
           populate(); 
        } catch (SQLException ex) {
            System.out.println("There is a SQL syntax error.");
            ex.printStackTrace();
        }
    }

    public void populate() throws SQLException {
        rowSet.last();
        rowSet.moveToCurrentRow();
        int questionCount = rowSet.getRow();
        rowSet.beforeFirst();
        while (rowSet.next()) {
            for (int row = 1; row < questionCount; row++) {
                question = getQuestion(row);
            }
        }
    }
    
    public String getQuestion(int row) throws SQLException {
        return rowSet.getString("question");
    }
    public void setYesCount(int value)throws SQLException {
        rowSet.updateInt(3, value);
    }
    public int getYesCount(int row) throws SQLException {
        return rowSet.getInt("yesCount");
    }
    public void setNoCount(int value)throws SQLException {
        rowSet.updateInt(4, value);
    }
    public int getNoCount(int row) throws SQLException {
        return rowSet.getInt("noCount");
    }
}
