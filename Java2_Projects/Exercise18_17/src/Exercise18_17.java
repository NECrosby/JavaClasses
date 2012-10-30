// Naomi Crosby - September 12, 2012 - Java 2 
// In class exercise for Chapter 18 - Applets
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Exercise18_17 extends JApplet {
	private RaceCar car1 = new RaceCar();
	private RaceCar car2 = new RaceCar();
	private RaceCar car3 = new RaceCar();
	private RaceCar car4 = new RaceCar();

	private JTextField jtfCar1 = new JTextField(4);
	private JTextField jtfCar2 = new JTextField(4);
	private JTextField jtfCar3 = new JTextField(4);
	private JTextField jtfCar4 = new JTextField(4);


	public static void main(String[] args) {
		//set up the frame in case execute as an app 
		JFrame frame = new JFrame("Race Cars");

		//create an instance of the applet and add it to the frame
		//the constructor will set up the picture
		Exercise18_17 applet = new Exercise18_17();
		frame.add(applet);

		frame.setTitle("Race Cars");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		frame.setVisible(true);

	}

	public Exercise18_17() {
		// Constructor
		// Will be invoked by main method if running as an app
		// or by the browser is running as an applet
		//add(jtfCar1);
		//add(car1);
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Car 1: "));
		p1.add(jtfCar1);
		p1.add(new JLabel("Car 2: "));
		p1.add(jtfCar2);
		p1.add(new JLabel("Car 3: "));
		p1.add(jtfCar3);
		p1.add(new JLabel("Car 4: "));
		p1.add(jtfCar4);
		
		JPanel p2 = new JPanel(new GridLayout(4, 1));
		p2.add(car1);
		p2.add(car2);
		p2.add(car3);
		p2.add(car4);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		Car1Speed cs1 = new Car1Speed();
		jtfCar1.addActionListener(cs1);
		
		Car2Speed cs2 = new Car2Speed();
		jtfCar2.addActionListener(cs2);
		
		Car3Speed cs3 = new Car3Speed();
		jtfCar3.addActionListener(cs3);
		
		Car4Speed cs4 = new Car4Speed();
		jtfCar4.addActionListener(cs4);
		
		
		
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

	private class Car1Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			car1.setSpeed(Integer.parseInt(jtfCar1.getText()));
		}
	}

	private class Car2Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			car2.setSpeed(Integer.parseInt(jtfCar2.getText()));
		}
	}

	private class Car3Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			car3.setSpeed(Integer.parseInt(jtfCar3.getText()));
		}
	}

	private class Car4Speed implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			car4.setSpeed(Integer.parseInt(jtfCar4.getText()));
		}
	}

}


