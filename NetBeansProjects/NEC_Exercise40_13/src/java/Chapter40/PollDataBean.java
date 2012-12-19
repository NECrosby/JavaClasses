/*
 *      Naomi Crosby
 */
package Chapter40;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.JdbcRowSet;

public class PollDataBean {

    private JdbcRowSet rowSet;
    private String yesNo;
    
    public PollDataBean() throws ClassNotFoundException, SQLException {
        // load the MySQL driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        rowSet = new JdbcRowSetImpl();
        rowSet.setUrl("jdbc:mysql://localhost/javabook");
        rowSet.setUsername("scott");
        rowSet.setPassword("tiger");

        String sql = "SELECT * FROM MultiQPoll ORDER BY question";
        rowSet.setCommand(sql);
        rowSet.execute();
    }

    public ArrayList<PollBean> getPollList() throws SQLException {
        ArrayList<PollBean> pollList = new ArrayList<PollBean>();

        rowSet.beforeFirst();  // Need to place cursor before first row

        while (rowSet.next()) {
            PollBean poll = new PollBean();
            poll.setId(rowSet.getInt("ID"));                  // Column 1
            poll.setQuestion(rowSet.getString("question"));   // Column 2
            poll.setYesCount(rowSet.getInt("yesCount"));      // Column 3
            poll.setNoCount(rowSet.getInt("noCount"));        // Column 4
            
            pollList.add(poll);
        }
        return pollList;
    }

    public void updateQuestion(int id, String yesNo) {
        try {
            
            Boolean isYes = Boolean.parseBoolean(yesNo);
            int count = 0;
            rowSet.absolute(id);
            if (isYes) {
                count = rowSet.getInt("yesCount");
                rowSet.updateInt("yesCount", (count + 1)); // Column 3
            } else {
                count = rowSet.getInt("noCount");
                rowSet.updateInt("noCount", (count + 1)); // Column 4
            }
            rowSet.updateRow();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public String getYesNo() {
        return yesNo;
    }

    public void setYesNo(String yesNo) {
        this.yesNo = yesNo;
    }
    
//    public String setUpdateCommand(String yesNo) {
//        String myString = "myString";
//        Boolean isYes = false;
//
//        if (isYes == yesNo.contentEquals("true")) {
//            myString = "UPDATE MultiQPoll SET yesCount = yesCount + 1";
//        } else {
//            myString = "UPDATE MultiQPoll SET noCount = noCount + 1";
//        }
//        return myString;
//    }
    
}
