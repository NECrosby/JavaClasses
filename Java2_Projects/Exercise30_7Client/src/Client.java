// Naomi Crosby
// Networking with Java Chapter 30
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

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8000);  // new Socket("localhost", DNS name, or IP address, Port #);
			ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());  // this is the stream for the water to flow

			long[] numbers = (long[])fromServer.readObject();  // fromServer is the name of the stream

			for(int i = 0; i < numbers.length; i++) {
				System.out.println("Element " + i + ": " + numbers[i]);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
