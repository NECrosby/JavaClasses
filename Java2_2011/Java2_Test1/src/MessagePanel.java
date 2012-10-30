import java.awt.Dimension;
import java.awt.FontMetrics;

import javax.swing.JPanel;


public class MessagePanel extends JPanel {

	private String message = "Welcome to Java!";
	private int xCoordinate = 20;
	private int yCoordinate = 20;
	private boolean centered;
	private final int interval = 10;

	public MessagePanel() {

	}

	public MessagePanel(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage() {
		this.message = message;
		repaint();
	}

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
		repaint();
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public int getInterval() {
		return interval;
	}

	public void setMessage(String message) {
		this.message = message;
		repaint();
	}

	protected void paintComponent(Graphic g) {
		super.paintComponent(g);

		if (centered) {
			FontMetrics fm = g.getFontMetrics();
			int stringWidth = fm.stringWidth(message);
			int stringAscent = fm.getAscent();

			xCoordinate = getWidth() / 2 - stringWidth /2;
			yCoordinate = getHeight() / 2 - stringAscent / 2;
		}
		g.drawString(message, xCoordinate, yCoordinate);

	}

	public void moveLeft() {
		xCoordinate -= interval;
		repaint();
	}
	public void moveRight() {
		xCoordinate += interval;
		repaint();
	}
	public void moveUp() {
		yCoordinate -= interval;
		repaint();
	}
	public void moveDown() {
		yCoordinate += interval;
		repaint();
	}
	public Dimension getPrefferedSize() {

	}




}
