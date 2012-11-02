import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Naomi Crosby - Java II - Chapter 29 Assignment 
// Exercise 29.5 Page 1014 - Due 10/22/2012
// Used the books previously used code from Exercises: 
// 18.11 found on page 641, Figure 18.19(b) found on page 642

/* ------------------------------------------------------------------------------------*\
|	(Simulation: a running fan) Write a Java applet that simulates a running fan, as	|
|	shown in Figure 18.19(b). The buttons Start, Stop, and Reverse control the fan.		|
|	The scroll bar controls the fan's speed. Create a class named Fan, a subclass of	|
|	JPanel, to display the fan. This class also contains the methods to suspend and		|
|	resume the fan, set its speed, and reverse its direction. Create a class named		|
|	FanControl that contains a fan, and three buttons and a scroll bar to control the	|
|	fan. Create a Java applet that contains an instance of FanControl.					|
|																						|
|	18.11 found on page 641, Figure 18.19(b) found on page 642							|
\* ------------------------------------------------------------------------------------*/

public class Exercise29_5 extends JApplet {
	
	private static final long serialVersionUID = 1L;
	private FanControl fanControl = new FanControl();
	
	public void init() {
		// Panel to hold the fan
		JPanel fanPanel = new JPanel();
		fanPanel.setLayout(new GridLayout(1, 2));
		fanPanel.add(fanControl);
		add(fanPanel, BorderLayout.CENTER);  // Add panel to Applet
	}

	// Main if Application or Applet
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise 29.5: Operating a Fan using Threads");
		Exercise29_5 applet = new Exercise29_5();  
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 400);			// Display frame if needs for Application
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}
	
	
	
}
