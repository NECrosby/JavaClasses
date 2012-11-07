// Naomi Crosby - Java II - Chapter 30 Assignment 
// Exercise 30.3 Page 1054 - Due 10/31/2012

/* *********************************************************************************\	
|  	Hints:																			|
|		Your server should use the Loan class (previously in the textbook – or see	| 
|		D2L content). Methods in the Loan class compute the payments.				| 
\***********************************************************************************/

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.*;

public class Server30_3 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea serverText = new JTextArea();

	// Main Class 
	public static void main(String[] args) {
		new Server30_3();
	}

	// Server Constructor - GUI set up
	public Server30_3 () {
		setLayout(new BorderLayout());
		add(new JScrollPane(serverText), BorderLayout.CENTER);
		setTitle("Exercise 30.3: Server Window");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try {
			// Create server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			serverText.append("Loan Server has started: " + new Date() + "\n");

			int clientCount = 1;  // Count the number of clients
			while (true) {
				// Listen for a new connection request
				Socket clientSocket = serverSocket.accept();

				// Display client number in Server window
				serverText.append("\nClient " + clientCount + ": connected @ " + new Date());

				// Create a new task & thread for the connection
				HandleAClient clientTask = new HandleAClient(clientSocket);
				new Thread(clientTask).start();

				clientCount++;
			}
		} 
		catch (IOException ex) {
			System.out.println(ex);
		}
	}

	// Inner "HandleAClient" Task - Definition of task for handling new client connection
	class HandleAClient implements Runnable {
		private Socket socket; // connected socket

		// HandleAClient constructor
		public HandleAClient(Socket socket) {
			this.socket = socket;
		}

		// Override the run method in Thread class with below
		public void run() {
			try {
				// Need data INPUT & OUTPUT streams of course :)
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

				// Continuously serve client
				while(true) {
					// Get loan input from client
					int intCreditScore = inputFromClient.readInt();
					boolean blnQualifies = inputFromClient.readBoolean();
					double dblLoanAmountRequest = inputFromClient.readDouble();
					int intLengthOfLoanRequest = inputFromClient.readInt();
					
					// Compute loan here
					double dblInterestRate = 0;
					double dblLoanPayment = 0;
										
					if ( (intCreditScore > 799) && (intCreditScore <= 850) ) {
						dblInterestRate = 3.0;
					} else if ( (intCreditScore > 699) && (intCreditScore <= 800) ) {
						dblInterestRate = 4.0;
					} else if ( (intCreditScore > 599) && (intCreditScore <= 700) ) {
						dblInterestRate = 5.0;
					} else if ( (intCreditScore > 499) && (intCreditScore <= 600) ) {
						dblInterestRate = 5.5;
					} else {
						blnQualifies = false;
					}
					
					if (blnQualifies) {
						Loan clientLoan = new Loan(dblInterestRate, intLengthOfLoanRequest, dblLoanAmountRequest);
						dblLoanPayment = clientLoan.getMonthlyPayment();
						
						// Send loan info back to client
						outputToClient.writeBoolean(blnQualifies);
						outputToClient.writeDouble(dblLoanPayment);
						outputToClient.writeDouble(dblInterestRate);
						serverText.append("\nLoan amount requested from Client $" + dblLoanAmountRequest + " to be paid within " + intLengthOfLoanRequest + " years.\n");
						serverText.append("Client payments are scheduled to amount in $" + dblLoanPayment + "/month.\n" +
										  "The interest rate granted was " + dblInterestRate + "%.\n");
					} else {
						outputToClient.writeBoolean(blnQualifies);
						outputToClient.writeUTF("Client loan request was denied.");
						serverText.append("\nClient must improve credit score to become higher than 499.\n");
					}
				}
			} 
			catch (IOException ex) {
				System.out.println(ex);
			}
		}
	}
}




//System.out.println("Credit score: " + intCreditScore +
//"\nQualifies: " + blnQualifies + 
//"\nLoan Amount: " + dblLoanAmountRequest +
//"\nYears: " + intLengthOfLoanRequest);
