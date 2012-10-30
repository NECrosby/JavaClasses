// Naomi Crosby - September 12, 2012 - Java 2 
// In class exercise for Chapter 18 - Applets
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/* -------------------------------------------------------------- *
 *   Race car exercise from Chapter 18 but using Multi-Threading  *
 * -------------------------------------------------------------- */
@SuppressWarnings("serial")
public class Exercise29_2 extends JApplet {
	private RaceTrucks truck1 = new RaceTrucks();
	private RaceTrucks truck2 = new RaceTrucks();
	private RaceTrucks truck3 = new RaceTrucks();
	private RaceTrucks truck4 = new RaceTrucks();

	private JTextField jtfTruck1 = new JTextField(4);
	private JTextField jtfTruck2 = new JTextField(4);
	private JTextField jtfTruck3 = new JTextField(4);
	private JTextField jtfTruck4 = new JTextField(4);

	public static void main(String[] args) {
		//set up the frame in case execute as an app 
		JFrame frame = new JFrame("Race Cars");

		//create an instance of the applet and add it to the frame
		//the constructor will set up the picture
		Exercise29_2 applet = new Exercise29_2();
		frame.add(applet);

		frame.setTitle("Race Trucks");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 250);
		frame.setVisible(true);
	}

	public Exercise29_2() {
		// Constructor
		// Will be invoked by main method if running as an app
		// or by the browser is running as an applet
		//add(jtfCar1);
		//add(car1);
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Truck 1: "));
		p1.add(jtfTruck1);
		p1.add(new JLabel("Truck 2: "));
		p1.add(jtfTruck2);
		p1.add(new JLabel("Truck 3: "));
		p1.add(jtfTruck3);
		p1.add(new JLabel("Truck 4: "));
		p1.add(jtfTruck4);
		
		JPanel p2 = new JPanel(new GridLayout(4, 1));
		p2.add(truck1);
		p2.add(truck2);
		p2.add(truck3);
		p2.add(truck4);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		Truck1Speed cs1 = new Truck1Speed();
		jtfTruck1.addActionListener(cs1);
		
		Truck2Speed cs2 = new Truck2Speed();
		jtfTruck2.addActionListener(cs2);
		
		Truck3Speed cs3 = new Truck3Speed();
		jtfTruck3.addActionListener(cs3);
		
		Truck4Speed cs4 = new Truck4Speed();
		jtfTruck4.addActionListener(cs4);
	}

	public void init() {
		//Anything to do here?
	}

	public void start() {
		//Anything to do here?
	}

	public void stop() {
		//Anything to do here?
	}

	private class Truck1Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			truck1.setSpeed(Integer.parseInt(jtfTruck1.getText()));
		}
	}

	private class Truck2Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			truck2.setSpeed(Integer.parseInt(jtfTruck2.getText()));
		}
	}

	private class Truck3Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			truck3.setSpeed(Integer.parseInt(jtfTruck3.getText()));
		}
	}

	private class Truck4Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			truck4.setSpeed(Integer.parseInt(jtfTruck4.getText()));
		}
	}

}


