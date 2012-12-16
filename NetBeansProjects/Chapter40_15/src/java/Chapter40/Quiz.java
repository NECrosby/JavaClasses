/* 
 *      Naomi Crosby
 *      In class Chapter 40 - Exercise 40.15
 */
package Chapter40;
import java.util.Random;

public class Quiz {
    private int[][]questions = new int[10][4];
    private String[] qp = new String[10];
    private int correctCount;
    
    public Quiz(){
        populate();
    }
    public void populate() {
        Random random = new Random();
        int first, second;
        
        for (int row = 0; row < 10; row++){
            qp[row] = "answer" + row;
            first = random.nextInt(100 + 1);
            questions[row][0] = first;
            second = random.nextInt(first);
            questions[row][1] = second;
            questions[row][2] = first - second;           
        }
        correctCount = 0;
    }
    
    public int getValue(int row, int column){
        return questions[row][column];
    }
    
    public String getQuestion(int question) {
        return qp[question];
    }
    public String correctIt(int row) {
        String value = "";
        if (questions[row][2] == questions[row][3]) {
            correctCount++;
            value = "Correct";
        } else {
            value = "Wrong";
        }
        return value;
    }
    public int getCorrectCount() {
        return correctCount;
    }
    public void setAnswer(int question, int answer) {
        questions[question][3] = answer;
    }
    public void setCorrectCount(int correctCount) {
        correctCount = 0;
    }
}
