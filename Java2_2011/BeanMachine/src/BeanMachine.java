//Homework worth 50 pts

//replace the section with a correct Prolog

//make the whole thing bigger 
//bigger frame
//bigger number of slots
//bigger number of rows

//let the user input the number of balls that will be dropped
//possible ways of doing that.. input box, text box with button(either way need to add validation code..
//min. number of balls in 1 play with new panel to decide max number of balls


//let the user choose the color of balls

//let the user set the speed

//let the user choose the color of the nails that the balls bounce off of

//have the user input their name

//Change the title and add a title on the panel

//you can create another panel for your setting if desired
//don't over think this the program works you are just adding and modifying this one

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BeanMachine extends JFrame { 
	//comments at each section explain what they are used from and why
	private static final long serialVersionUID = 1L;
	final static int NUMBER_OF_SLOTS = 9;
	final static int NUMBER_OF_ROWS = NUMBER_OF_SLOTS - 2;

	private int shift = 0;
	private final int[] slots = new int[NUMBER_OF_SLOTS];
	private int numberOfBallsDropped = 0;
	private int moveCount = 0;
	private int position = 0;

	private final BeanMachinePanel paintPanel = new BeanMachinePanel();

	//comments at each section explain what they are used from and why
	private final Timer timer = new Timer(2, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			moveCount++;
			//comments at each section explain what they are used from and why
			if (moveCount <= NUMBER_OF_ROWS) {
				if (Math.random() < 0.5) 
					paintPanel.moveRedBallLeft();
				else {
					paintPanel.moveRedBallRight();
					position++;
				}
			}
			//comments at each section explain what they are used from and why
			else {
				slots[position]++;
				paintPanel.startRedBall();
				shift = 0;
				moveCount = 0;
				position = 0;

				numberOfBallsDropped++;
				if (numberOfBallsDropped == 10) {
					timer.stop();
					paintPanel.hideRedBall();
				}
			}
		}
	});

	//comments at each section explain what they are used from and why
	public BeanMachine() {
		add(paintPanel);
		timer.start();
	}

	//comments at each section explain what they are used from and why
	class BeanMachinePanel extends JPanel {

		//comments at each section explain what they are used from and why
		private static final long serialVersionUID = 1L;
		final static int HGAP = 20;
		final static int VGAP = 20;
		final static int RADIUS = 5;
		final static int LENGTH_OF_SLOTS = 40;
		final static int LENGTH_OF_OPENNING = 15;
		final static int Y_FOR_FIRST_NAIL = 50;
		final static int RED_BALL_START_Y = Y_FOR_FIRST_NAIL - RADIUS;

		private int yRed = RED_BALL_START_Y;
		private boolean hideRedBall = false;

		//comments at each section explain what they are used from and why
		public BeanMachinePanel(){}

		//comments at each section explain what they are used from and why
		public void moveRedBallLeft() {
			shift -= HGAP / 2;
			yRed += VGAP;
			repaint();
		}

		//comments at each section explain what they are used from and why
		public void moveRedBallRight() {
			shift += HGAP / 2;
			yRed += VGAP;
			repaint();
		}

		//comments at each section explain what they are used from and why
		public void startRedBall() {
			yRed = RED_BALL_START_Y;
			hideRedBall = false;
			repaint();
		}

		//comments at each section explain what they are used from and why
		public void hideRedBall() {
			hideRedBall = true;
			repaint();
		}

		//comments at each section explain what they are used from and why
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int y = Y_FOR_FIRST_NAIL;
			int xCenter = getWidth() / 2;

			//comments at each section explain what they are used from and why
			if (!hideRedBall) {
				g.setColor(Color.RED);
				int xRed = xCenter + shift;
				g.fillOval(xRed - RADIUS, yRed - RADIUS, 2 * RADIUS, 2 * RADIUS);
			}

			//comments at each section explain what they are used from and why
			g.setColor(Color.GREEN);
			for (int i = 0; i < NUMBER_OF_ROWS; i++) {
				y += VGAP;
				for (int k = 0; k <= i; k++) {
					g.fillOval(xCenter - i * HGAP / 2 + k * HGAP - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
				}
			}

			//comments at each section explain what they are used from and why
			g.setColor(Color.BLACK);
			y = y + RADIUS;
			for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
				int x = xCenter - (NUMBER_OF_ROWS - 1) * HGAP / 2 + (i - 1) * HGAP;
				g.drawLine(x, y, x, y + LENGTH_OF_SLOTS);
			}

			//comments at each section explain what they are used from and why
			g.drawLine(xCenter - (NUMBER_OF_ROWS - 1) * HGAP / 2 - HGAP, y + LENGTH_OF_SLOTS, 
					xCenter - (NUMBER_OF_ROWS - 1) * HGAP / 2 + NUMBER_OF_ROWS * HGAP, y + LENGTH_OF_SLOTS);
			//comments at each section explain what they are used from and why
			g.drawLine(xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - (NUMBER_OF_ROWS - 1) * HGAP / 2 + NUMBER_OF_ROWS * HGAP, y);
			g.drawLine(xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - (NUMBER_OF_ROWS - 1) * HGAP / 2 - HGAP, y);
			//comments at each section explain what they are used from and why
			g.drawLine(xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - HGAP / 2, Y_FOR_FIRST_NAIL - LENGTH_OF_OPENNING);
			g.drawLine(xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter + HGAP / 2, Y_FOR_FIRST_NAIL - LENGTH_OF_OPENNING);

			//comments at each section explain what they are used from and why
			g.setColor(Color.RED);      
			for (int i = 0; i < slots.length; i++) {
				int x = xCenter - (NUMBER_OF_ROWS) * HGAP / 2 + i * HGAP;
				for (int j = 0; j < slots[i]; j++) {
					g.fillOval(x - RADIUS, y + LENGTH_OF_SLOTS - 2 * RADIUS - j * 2 * RADIUS, 2 * RADIUS, 2 * RADIUS);
				}
			}
		}
	}

	//comments at each section explain what they are used from and why
	public static void main(String[] args) {
		JFrame frame = new BeanMachine();
		frame.setTitle("Exercise16_22");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}