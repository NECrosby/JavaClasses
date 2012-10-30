// Naomi Crosby
// Networking with Java Chapter 30
// Server - sending out the array of 100 long prime numbers from the file

/* **************************************************************************************
 *  
 *  (Transferring last 100 numbers in an array) Exercise 23.9 retrieves the last 100
 *  prime numbers from a file Exercise23_8.dat. Write a client program that requests
 *  the server to send the 100 prime numbers in an array. Name the server program
 *  Exercise30_7Server and the client program Exercise30_7Client. Assume that the 
 *  numbers of the long type are stored in Exercise23_8.dat in binary format.
 *  
 ****************************************************************************************/

import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) {
		try {

			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server has started taking orders.");
			Socket socket = serverSocket.accept();

			// Input is used to get information OUT of the FILE INTO the PROGRAM  
			DataInputStream input =  new DataInputStream(new FileInputStream("letter.txt"));   

			int count = 0;  // count for the amount of numbers to retrieve from the array
			long[] numbers = new long[100];  // declaring array
			input.skip(input.available() - 800);

			while (input.available() > 0) {
				numbers[count] = input.read();
				System.out.println(numbers[count]);
				count++;
			}

			input.close();  // closing the file

			ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream()); // Stream to go TO THE CLIENT

			outputToClient.writeObject(numbers); // Sending to the client

		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
