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

public class Server extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Class variables
	private JTextArea jtaServer = new JTextArea();
	private JTextArea jtaClient = new JTextArea();

	private PrintWriter toClient;
	private Socket socket;

	// Main class
	public static void main(String[] args) {
		new Server();
	}

	// Constructor for Server & Server GUIs
	public Server() {
		setLayout(new GridLayout(2, 1));
		JScrollPane jscPane1 = new JScrollPane(jtaServer);
		JScrollPane jscPane2 = new JScrollPane(jtaClient);
		jscPane1.setBorder(new TitledBorder("Server"));
		jscPane2.setBorder(new TitledBorder("Client"));
		add(jscPane1);
		add(jscPane2);

		jtaServer.setLineWrap(true);
		jtaServer.setWrapStyleWord(true);

		jtaClient.setLineWrap(true);
		jtaClient.setWrapStyleWord(true);

		setSize(500, 300);
		setTitle("Server Chat Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		jtaServer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					toClient.println(jtaServer.getText());		
				}
			}
		});

		try {
			ServerSocket serverSocket = new ServerSocket(8000);

			while (true) {
				Socket socket = serverSocket.accept();

				toClient = new PrintWriter(socket.getOutputStream());
				PickUpInput task = new PickUpInput();
				new Thread(task).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}  // Closing Server Constructor

	class PickUpInput implements Runnable {
		public void run() {
			try {
				Scanner fromClient = new Scanner(socket.getInputStream());

				while (true){
					
					jtaClient.setText(fromClient.nextLine());

				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	} // Closing Inner TASK Class

}  // Closing Server CLASS
