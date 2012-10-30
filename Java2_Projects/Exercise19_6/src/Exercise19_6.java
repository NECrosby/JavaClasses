// Naomi Crosby

import java.io.*;

public class Exercise19_6 {

	
	public static void main(String[] args) {
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("loans.dat"));
			output.writeObject(new Loan(2.5, 5, 1000));
			output.writeObject(new Loan(6, 10, 20000));
			output.writeObject(new Loan(9.75, 2, 10000));
			output.writeObject(new Loan(3.25, 8, 6000));
			output.writeObject(new Loan(9, 4, 3000));
			
			output.close();
			
		}
		catch (IOException ex){
			System.out.println("Problem with the file");
		}
		

	}

}
