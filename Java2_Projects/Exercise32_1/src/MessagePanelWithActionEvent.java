// MessagePanel.java: Display a message on a JPanel
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MessagePanelWithActionEvent extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	/** The message to be displayed */
	private String message = "Welcome to Java";

	/** The x coordinate where the message is displayed */
	private int xCoordinate = 20;

	/** The y coordinate where the message is displayed */
	private int yCoordinate = 20;

	/** Indicate whether the message is displayed in the center */
	private boolean centered;

	/** The interval for moving the message horizontally and vertically */
	private int interval = 10;

	private ArrayList <MouseListener> actionList = new ArrayList<MouseListener>(1);  // Page 390

	/** Default constructor */
	public MessagePanelWithActionEvent() {
		//addMouseListener(this); 	// Betty had to have these listeners add to her program in order to work properly
	}

	/** Constructor with a message parameter */
	public MessagePanelWithActionEvent(String message) {
		this.message = message;
		//addMouseListener(this); 	// Betty had to have these listeners add to her program in order to work properly
	}

	/** Return message */
	public String getMessage() {
		return message;
	}

	/** Set a new message */
	public void setMessage(String message) {
		this.message = message;
		repaint();
	}

	/** Return xCoordinator */
	public int getXCoordinate() {
		return xCoordinate;
	}

	/** Set a new xCoordinator */
	public void setXCoordinate(int x) {
		this.xCoordinate = x;
		repaint();
	}

	/** Return yCoordinator */
	public int getYCoordinate() {
		return yCoordinate;
	}

	/** Set a new yCoordinator */
	public void setYCoordinate(int y) {
		this.yCoordinate = y;
		repaint();
	}

	/** Return centered */
	public boolean isCentered() {
		return centered;
	}

	/** Set a new centered */
	public void setCentered(boolean centered) {
		this.centered = centered;
		repaint();
	}

	/** Return interval */
	public int getInterval() {
		return interval;
	}

	/** Set a new interval */
	public void setInterval(int interval) {
		this.interval = interval;
		repaint();
	}

	/** Paint the message */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (centered) {
			// Get font metrics for the current font
			FontMetrics fm = g.getFontMetrics();

			// Find the center location to display
			int stringWidth = fm.stringWidth(message);
			int stringAscent = fm.getAscent();
			// Get the position of the leftmost character in the baseline
			xCoordinate = getWidth() / 2 - stringWidth / 2;
			yCoordinate = getHeight() / 2 + stringAscent / 2;
		}

		g.drawString(message, xCoordinate, yCoordinate);
	}

	/** Move the message left */
	public void moveLeft() {
		xCoordinate -= interval;
		repaint();
	}

	/** Move the message right */
	public void moveRight() {
		xCoordinate += interval;
		repaint();
	}

	/** Move the message up */
	public void moveUp() {
		yCoordinate -= interval;
		repaint();
	}

	/** Move the message down */
	public void moveDown() {
		yCoordinate -= interval;
		repaint();
	}

	/** Override get method for preferredSize */
	public Dimension getPreferredSize() {
		return new Dimension(200, 30);
	}

	public void mouseClicked(MouseEvent e) {
		for (int x = 0; x < actionList.size(); x++) {
			actionList.get(x).mouseClicked(e);
		}
	}

	// Has to be adMouseListener (with 1-"d" in ad_MouseListener - if has 2 "d" confuses program
	public synchronized void adMouseListener(MouseListener al) {
		if (!actionList.contains(al)){
			actionList.add(al);
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}