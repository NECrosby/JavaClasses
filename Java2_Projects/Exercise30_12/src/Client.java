import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

// Naomi Crosby - Networking Chapter 30


public class Client extends JFrame {

	private static final long serialVersionUID = -3381685244399694389L;

	// Class Variables
	private JTextArea jtaServer = new JTextArea();
	private JTextArea jtaClient = new JTextArea();

	private PrintWriter toServer;
	private Socket socket;

	// Main Class
	public static void main(String[] args) {
		new Client();
	}

	// Client Constructor
	public Client() {
		setLayout(new GridLayout(2, 1));
		JScrollPane jscPane1 = new JScrollPane(jtaServer);
		JScrollPane jscPane2 = new JScrollPane(jtaClient);
		jscPane1.setBorder(new TitledBorder("Server"));
		jscPane2.setBorder(new TitledBorder("Client"));
		add(jscPane2);
		add(jscPane1);

		jtaServer.setLineWrap(true);
		jtaServer.setWrapStyleWord(true);

		jtaClient.setLineWrap(true);
		jtaClient.setWrapStyleWord(true);

		setSize(500, 300);
		setTitle("Client Chat Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		jtaClient.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					toServer.println(jtaClient.getText());		
				}
			}
		});

		try {
			socket = new Socket("localhost", 8000);
			toServer = new PrintWriter(socket.getOutputStream());
			PickUpInput task = new PickUpInput();
			new Thread(task).start();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} // Closing Client Constructor

	class PickUpInput implements Runnable {
		public void run() {
			try {
				Scanner fromServer = new Scanner(socket.getInputStream());

				while (true){

					jtaServer.setText(fromServer.nextLine());

				}


			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	} // Closing Inner TASK Class

} // Closing Client CLASS
