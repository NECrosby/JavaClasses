import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/* -------------------------------------------------------------- *
 *   Race car exercise from Chapter 18 but using Multi-Threading  *
 * -------------------------------------------------------------- */

@SuppressWarnings("serial")
public class RaceTrucks extends JPanel implements Runnable {

	private int xBase = 0;
	private Thread thread = new Thread(this); // need to create a Thread for Multi-Threading
	private int sleepTime = 100; // Max speed

	public RaceTrucks() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		thread.start();
	}

	public void setSpeed(int speed) {
		//timer.stop();
		//int truckSpeed = Math.abs(speed - 99);
		//timer.setDelay(carSpeed);
		//timer.start();
		sleepTime = Math.abs(speed - 99);
	}
	
	// Drawing the trucks
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Where is the car? Wrap it if need be
		int yBase = getHeight();
		if (xBase > getWidth()){
			xBase = -20;
		} else {
			xBase += 1;
		}

		//draw the car
		g.setColor(Color.BLACK);
		g.fillOval(xBase + 10, yBase - 10, 10, 10);
		g.fillOval(xBase + 30, yBase - 10, 10, 10);
		g.setColor(Color.BLUE);
		g.fillRect(xBase, yBase - 20, 50, 10);
		g.fillRect(xBase + 30, yBase - 30, 20, 20);
	}

	public void run() {
		try {
			while (true){
				if (sleepTime < 100){
					repaint();
				} 
				Thread.sleep(sleepTime);
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


