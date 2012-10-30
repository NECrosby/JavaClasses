import javax.swing.JOptionPane;


public class WhileLoops {

	// The while loop can be thought of as a repeating if statement.

	public static void main(String[] args) {
		/*int x = 0;
		while (x < 5) {
		    System.out.printf("x = %d\n", x);
		    x++;
		}

		if (x < 5){
			System.out.printf("x = %d\n", x);
		    x++;
		}*/

		// Validating User Input with GUI
		int number;
		int userGuess = -1;
		String stringNumber;
		String keepGoing;
		
		number = 1 + (int) (Math.random() * 10); // generate random number

		keepGoing = JOptionPane.showInputDialog("Do you want to guess a number? \nEnter Y or N");
		while (keepGoing.equalsIgnoreCase("Y")){
			while(keepGoing.compareToIgnoreCase("Y") == 0) {
				// Get user guess
				stringNumber = JOptionPane.showInputDialog("I'm thinking of a number between 1 and 10.");
				userGuess = Integer.parseInt(stringNumber);

				if(userGuess == number){
					keepGoing = JOptionPane.showInputDialog("You guessed it!! \nDo you want to PLAY again? \nY or N");
					number = 1 + (int) (Math.random() * 10);
					//JOptionPane.showMessageDialog (null, "You guessed it!", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);   //"You guessed it!"
				} else if (userGuess > number) {
					keepGoing = JOptionPane.showInputDialog("Your guess is too HIGH. \nDo you want to guess again? \nY or N");
				} else {
					keepGoing = JOptionPane.showInputDialog("Your guess is too LOW. \nDo you want to guess again? \nY or N");
				}
			}
		} 
			
		System.exit(0);
		
	}
}
