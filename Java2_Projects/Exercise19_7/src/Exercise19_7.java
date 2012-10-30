import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Exercise19_7 {
	
	public static void main(String[] args) {
		
		double total = 0;
		Loan myLoan = new Loan();
		int count = 0;
		ObjectInputStream input = null;
		
		try {
			
			
			input = new ObjectInputStream(new FileInputStream("C:\\Users\\Owner\\Documents\\4_Fall 2012\\Java2\\Java2_Projects\\Exercise19_6\\loans.dat"));
			
			while(true){
				myLoan = (Loan)(input.readObject());
				count++;
				total += myLoan.getLoanAmount();
				
			}

		}
		
		catch (EOFException eof){
			System.out.println("End of File");
			System.out.println("Number of loans is " + count);
			System.out.println("The total of the " + count + " loans equals $" + total);
			try {
				input.close();
				
			}
			catch (IOException ioProblem){
				System.out.println("Can't close the file");
			}
		}
		
		catch (IOException ex) {
			System.out.println("File Problem");
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
