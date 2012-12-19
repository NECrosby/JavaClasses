/* 
 *      Naomi Crosby
 *      Homework Chapter 40 - Exercise 40.13
 */
package Chapter40;

public class PollBean {
    
    /* ********* *\
     *  Globals  *
    \* ********* */

    private int id;
    private String question;
    private int yesCount;
    private int noCount;
        
    // Constructor
    public PollBean() {
    
    }

    // Getter/Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getYesCount() {
        return yesCount;
    }

    public void setYesCount(int yesCount) {
        this.yesCount = yesCount;
    }

    public int getNoCount() {
        return noCount;
    }

    public void setNoCount(int noCount) {
        this.noCount = noCount;
    }
    
}
