import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.*;


@SuppressWarnings("serial")
public class RaceCar extends JPanel implements ActionListener {
	
	private int xBase = 0;
	private Timer timer = new Timer(200, this);
	
	public RaceCar() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	
	public void setSpeed(int speed) {
		timer.stop();
		int carSpeed = Math.abs(speed - 99);
		timer.setDelay(carSpeed);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Where is the car? Wrap it if need be
		int yBase = getHeight();
		if (xBase > getWidth())
			xBase = -20;
		else
			xBase += 1;
		
		//draw the car
		g.setColor(Color.BLACK);
		g.fillOval(xBase + 10, yBase - 10, 10, 10);
		g.fillOval(xBase + 30, yBase - 10, 10, 10);
		
		
	}

}

