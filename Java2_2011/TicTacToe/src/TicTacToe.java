import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TicTacToe extends JApplet {
	private static final long serialVersionUID = 1L;

	private char whoseTurn = 'X';  // Indicate which player has a turn; initially player X starts
	private final Cell[][] cells = new Cell[3][3];  // Create game board
	private final JLabel jlblStatus = new JLabel("X's turn to play");  // Create a label to show whose turn it is
	private Gametrack currentGame = null;

	public TicTacToe() {
		// Panel to hold the game board
		JPanel gameBoardPanel = new JPanel(new GridLayout(3, 3, 0, 0));
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				gameBoardPanel.add(cells[i][j] = new Cell());
			}
		}
		// Set up borders on game board
		gameBoardPanel.setBorder(new LineBorder(Color.red, 1));
		jlblStatus.setBorder(new LineBorder(Color.yellow, 1));

		//add the game board panel to the applet
		add(gameBoardPanel, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);
		currentGame = getGameTrack();
	}

	// Determine whether the game board is completely full
	public boolean isFull() {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (cells[i][j].getToken() == ' '){
					return false; // if there is an empty space then false the game can continue
				}
			}
		} 
		return true;
	}

	// Determine if there is a winner and who is the winner
	public boolean isWon(char token) {
		for (int i = 0; i < 3; i++){
			if ((cells[i][0].getToken() == token) && (cells[i][1].getToken() == token) && (cells[i][2].getToken() == token)) {
				return true; // Checking the rows
			}
		}

		for (int j = 0; j < 3; j++){
			if ((cells[0][j].getToken() == token) && (cells[1][j].getToken() == token) && (cells[2][j].getToken() == token)) {
				return true; // checking the columns
			}
		}

		if ((cells[0][0].getToken() == token) && (cells[1][1].getToken() == token) && (cells[2][2].getToken() == token)) {
			return true; // checking major diagonal
		}

		if ((cells[0][2].getToken() == token) && (cells[1][1].getToken() == token) && (cells[2][0].getToken() == token)) {
			return true; // check opposite diagonal
		}
		return false;
	}

	public Gametrack getGameTrack(){
		Gametrack oldGame = null;
		ObjectInputStream input = null;
		File testFile = null;
		try {
			testFile = new File("tictactoe.dat");
			if (testFile.exists()){
				input = new ObjectInputStream(new FileInputStream("tictactoe.dat"));
				oldGame = (Gametrack)input.readObject();
				input.close();
			}
			else {
				oldGame = new Gametrack();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldGame;
	}

	public void setGameTrack(Gametrack _G){
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream("tictactoe.dat"));
			output.writeObject(_G);
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Inner Class for the Cells
	public class Cell extends JPanel {

		private static final long serialVersionUID = 1L;
		private char token = ' ';  // Token to fill the cell before game play

		public Cell() {
			setBorder(new LineBorder(Color.black, 1)); // cell borders are black
			addMouseListener(new MyMouseListener());   // Register a mouse listener
		}

		public char getToken() {  // Return Token used
			return token;
		}

		public void setToken(char c) {  // Set a new token
			token = c;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (token == 'X') {  // draw an X
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}
			else if (token == 'O') {  // draw an O
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}

		private class MyMouseListener extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				// If cell is empty and game is not over
				if (token == ' ' && whoseTurn != ' ') {
					setToken(whoseTurn);
					if (isWon(whoseTurn)) {
						jlblStatus.setText(whoseTurn + " won! The game is over" +"   NUM " + currentGame.getWins());
						whoseTurn = ' ';  // Game Over!
						currentGame.setWins(currentGame.getWins() + 1);
						setGameTrack(currentGame);
					}
					else if (isFull()) {
						jlblStatus.setText("Draw! The game is over. Everyone loses."+"   NUM " + currentGame.getLosses());
						whoseTurn = ' '; // Game Over!
						currentGame.setWins(currentGame.getLosses() + 1);
						setGameTrack(currentGame);
					}
					else {
						// Change Turns
						whoseTurn = (whoseTurn == 'X') ? 'O': 'X';
						// Show whose turn it is
						jlblStatus.setText(whoseTurn + "'s turn.");
					}
				}
			}
		}
	}
}
