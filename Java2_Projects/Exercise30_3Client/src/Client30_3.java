// Naomi Crosby - Java II - Chapter 30 Assignment 
// Exercise 30.3 Page 1054 - Due 10/31/2012

/* *********************************************************************************\	
|  	Hints:																			|
|		Your server should use the Loan class (previously in the textbook – or see	| 
|		D2L content). Methods in the Loan class compute the payments.				| 
\***********************************************************************************/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.*;

public class Client30_3 extends JFrame {
	private static final long serialVersionUID = 1L;

	// Input from Client
	private JTextField jtfLoanAmountRequest = new JTextField();
	private JTextField jtfLengthOfLoanRequest = new JTextField();
	private JTextField jtfCreditScore = new JTextField();

	// Display area from Loan Server
	private JTextArea jtaServerOutput = new JTextArea();

	// IO Streams
	private DataOutputStream toServer;
	private DataInputStream fromServer;

	// Main method
	public static void main(String[] args) {
		new Client30_3();
	}

	// Client Constructor - GUI build
	public Client30_3() {
		// User Input area - user panel
		JPanel userInput = new JPanel();
		userInput.setLayout(new GridLayout(2, 4));
		userInput.add(new JLabel("Amount of loan: "));
		userInput.add(jtfLoanAmountRequest);
		userInput.add(new JLabel("Years of loan requested: "));
		userInput.add(jtfLengthOfLoanRequest);
		userInput.add(new JLabel("Your credit score: "));
		userInput.add(jtfCreditScore);
		userInput.add(new JLabel("     "));
		userInput.add(new JLabel("     "));
		setLayout(new BorderLayout());
		add(userInput, BorderLayout.NORTH);
		// Server output to client text area
		add(new JScrollPane(jtaServerOutput), BorderLayout.CENTER);

		// Register listeners for user input from text fields
		jtfLoanAmountRequest.addActionListener(new TextFieldListener());
		jtfLengthOfLoanRequest.addActionListener(new TextFieldListener());
		jtfCreditScore.addActionListener(new TextFieldListener());

		// Setting GUI Frame
		setTitle("Client Window");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Request Connection to the server
		try {
			// Create a socket to connection to server
			Socket clientSocket = new Socket("localhost", 8000);
			// Create an input stream in order to receive server data
			fromServer = new DataInputStream(clientSocket.getInputStream());
			// Create an output stream in order to send data to server
			toServer = new DataOutputStream(clientSocket.getOutputStream());
		}
		catch (IOException ex) {
			jtaServerOutput.append(ex.toString() + "\n");
		}
	}

	// Inner class for textFieldlistener
	private class TextFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// Getting data from user input
				double dblLoanAmountRequest = -1.0;
				int intLengthOfLoanRequest = -1;
				int intCreditScore = -1;
				try {
					dblLoanAmountRequest = Double.parseDouble(jtfLoanAmountRequest.getText().trim());
					intLengthOfLoanRequest = Integer.parseInt(jtfLengthOfLoanRequest.getText().trim());
					intCreditScore = Integer.parseInt(jtfCreditScore.getText().trim());
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please enter values into all fields.");
				}
				
				// Send data to server
				toServer.writeInt(intCreditScore);
				toServer.writeBoolean(true);
				toServer.writeDouble(dblLoanAmountRequest);
				toServer.writeInt(intLengthOfLoanRequest);
				toServer.flush();

				boolean blnQualifies = fromServer.readBoolean();

				if (blnQualifies) {
					// Get data returned from server
					double dblLoanPayment = fromServer.readDouble();
					double dblInterestRate = fromServer.readDouble();
					// Display in the server return text area 
					jtaServerOutput.append("\nServer has responded to your loan request: \nYour monthly payments will be " 
							+ dblLoanPayment + " for " + intLengthOfLoanRequest + 
							" years. \nThe interest rate granted was " + dblInterestRate + "%.\n");
				} else {
					String strLoanStatus = fromServer.readUTF();
					jtaServerOutput.append(strLoanStatus);
					jtaServerOutput.append("\nSorry, your credit score does not meet our requirements. \n" +
							"Please focus on improving your credit score to become higher than 499. Thank you\n");
				}
			}
			catch (IOException ex) {
				System.out.println(ex);
			}
		}
	}
}


/*boolean isAllFieldsFilled = true;
//System.out.println("\nBefore the LOOP isAllFieldsFilled = " + isAllFieldsFilled);
//System.out.println("\nwhile (" + !isAllFieldsFilled + ") {");

while ( !isAllFieldsFilled ) {
	//System.out.println("\nBefore the Level 1 - IF isAllFieldsFilled = " + isAllFieldsFilled);
	
	boolean isAmountFilled, isYearsFilled, isScoreFilled = true;
	
	if (!isAllFieldsFilled){
		//System.out.println("\nBefore the Level 1A -IF isAllFieldsFilled = " + isAllFieldsFilled);
		if (dblLoanAmountRequest == 0.0) {
			isAmountFilled = false;
			JOptionPane.showMessageDialog(null, "Please enter a loan amount.");
		} 
		//System.out.println("\nBefore the Level 1B -IF isFilled = " + isAllFieldsFilled);
		if (intLengthOfLoanRequest == 0) {
			isYearsFilled = false;
			JOptionPane.showMessageDialog(null, "Please enter how long for the loan in years.");
		}
		//System.out.println("\nBefore the Level 1c -IF isFilled = " + isAllFieldsFilled);
		if (intCreditScore == 0) {
			isScoreFilled = false;
			JOptionPane.showMessageDialog(null, "Please enter your credit score.");
		}
	} else {
		isAllFieldsFilled = true;
	}
}*/
