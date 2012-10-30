// Naomi Crosby - Java II - Chapter 18 Assignment 
// Exercise 18.21 Page 645 - Due 9/17/2012
// Started 	9/15/2012	12:20am - 12:40am
//			9/15		 1:00am -  1:15am
//			9/15		10:45pm - 12:15am
//			9/17		 8:40am - 11:30am
//			9/19		 2:00pm -  3:00pm
//			9/19		 9:00pm - 10:45pm
//			9/24		12:30pm -  2:15pm

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/* *********************************************************************************\	
|  	Hints:																			|
|		Have a timer. In the event handler, display the hour, minute and second		| 
|		(see the get method for the Gregorian calendar class). If the alarm is 		|
|		turned on, check if the values in the alarm text fields match the clock		| 
|		time (you would probably store the values entered in the text fields		| 
|		into variables accessible to the classes for the program). If so, 			|
|		display a sound (something that sounds like an alarm). You could create		| 
|		a new frame (i.e. a new object) in your listener for the Set Alarm			|
|		button. Set that frame to be visible. In your listeners for the Ok and 		|
|		Cancel buttons for that frame, set the frame to be invisible.				|
|																					|
|		Your program should work as a stand alone program or as an applet.			|
|																					|
|		In setting the alarm, be sure to validate that proper values are entered	|
|		(i.e. hours: 0 -23, minutes and seconds: 0 – 59)							|
\***********************************************************************************/

@SuppressWarnings("serial")
public class Exercise18_21 extends JApplet {
	// Getting calendar object - will need to convert Time to a string to display in the clock
	Calendar calendar = new GregorianCalendar();
	String strCurrentHour, strCurrentMinute, strCurrentSecond; 
	Timer timer = new Timer(1000, new TimerListener());  // Get this timer correct
		
	// Frame 1 - components
	Font font = new Font("SanSerif", Font.BOLD, 40);
	private JButton jbtSetAlarm = new JButton("Set Alarm");
	private JButton jbtDismiss = new JButton("Dismiss");
	private JCheckBox jckAlarm = new JCheckBox("Alarm: OFF");
	private JLabel jlblAlarmTime = new JLabel("Alarm: ");
	private JLabel jlblClockHour = new JLabel("");	
	private JLabel jlblClockMinute = new JLabel("");	
	private JLabel jlblClockSecond = new JLabel("");
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	
	// Frame 2 - Declare a SetAlarm & Setup a new Frame to hold setAlarm
	private SetAlarm userInput = new SetAlarm();
	
	private int alarmHour, alarmMinute, alarmSecond;
	private int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
	private int currentMinute = calendar.get(Calendar.MINUTE);
	private int currentSecond = calendar.get(Calendar.SECOND);
	
	// Audio Clip
	@SuppressWarnings("rawtypes")
	Class metaObject = this.getClass();
	URL urlForAudio = metaObject.getResource("alarm-clock-1.wav");
	AudioClip audioClip = Applet.newAudioClip(urlForAudio);
	
	
	public Exercise18_21 (){		// Applet Constructor
		timer.start();
		
		// Set up NORTH Panel
		JPanel p1 = new JPanel(new GridLayout(1, 3));	// Header info (Hour - Minute - Second)
		p1.add(new JLabel("Hour", JLabel.CENTER));
		p1.add(new JLabel("Minute", JLabel.CENTER));
		p1.add(new JLabel("Second", JLabel.CENTER));
		add(p1, BorderLayout.NORTH);
		
		// Set up CENTER Panel									
		JPanel p6 = new JPanel(new GridLayout(1, 3, 10, 0));	// Panel that contains the Clock
		jlblClockHour.setFont(font);							// Hour on Center panel
		p3.setBackground(Color.WHITE);							
		jlblClockHour.setHorizontalAlignment(JLabel.CENTER);
		jlblClockHour.setVerticalAlignment(JLabel.BOTTOM);
		p3.add(jlblClockHour);
		p6.add(p3);
		 						
		jlblClockMinute.setFont(font);				// Minute on Center panel
		p4.setBackground(Color.WHITE);
		jlblClockMinute.setHorizontalAlignment(SwingConstants.CENTER);
		jlblClockMinute.setVerticalAlignment(SwingConstants.BOTTOM);
		p4.add(jlblClockMinute);
		p6.add(p4);
								
		jlblClockSecond.setFont(font);				// Second on Center panel
		p5.setBackground(Color.WHITE);
		jlblClockSecond.setHorizontalAlignment(SwingConstants.CENTER);
		jlblClockSecond.setVerticalAlignment(SwingConstants.BOTTOM);
		p5.add(jlblClockSecond);
		p6.add(p5);
		add(p6, BorderLayout.CENTER);

		// Set up SOUTH Panel
		JPanel p2 = new JPanel(new GridLayout(1, 4, 5, 0));	// Set Check box & Button Panel
		p2.add(jckAlarm);
		p2.add(jlblAlarmTime);			
		p2.add(jbtSetAlarm);
		p2.add(jbtDismiss);
		add(p2, BorderLayout.SOUTH);
				
		// Register Listeners
		jckAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jckAlarm.isSelected()) {
					jckAlarm.setText("Alarm: ON");
					alarmHour = userInput.setAlarmHour();
					alarmMinute = userInput.setAlarmMinute();
					alarmSecond = userInput.setAlarmSecond();
					jlblAlarmTime.setText("Alarm: " + alarmHour + ":" + alarmMinute + ":" + alarmSecond);
					userInput.setVisible(false);
				}
				else {
					jckAlarm.setText("Alarm: OFF");
					
				}
			}
		});
		
		jbtSetAlarm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userInput.setVisible(true);
				jckAlarm.setSelected(false);
				jckAlarm.setText("Alarm: OFF");
				alarmHour = userInput.setAlarmHour();
				alarmMinute = userInput.setAlarmMinute();
				alarmSecond = userInput.setAlarmSecond();
				
			}
		});
		
		jbtDismiss.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jlblClockHour.setForeground(Color.BLACK);
				p3.setBackground(Color.WHITE);
				jlblClockMinute.setForeground(Color.BLACK);
				p4.setBackground(Color.WHITE);
				jlblClockSecond.setForeground(Color.BLACK);
				p5.setBackground(Color.WHITE);
				
				// Stop alarm sound loop
				audioClip.stop();
			}
		});
	}
	
	class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("timer");
			calendar = new GregorianCalendar();
			currentHour = calendar.get(Calendar.HOUR_OF_DAY);
			currentMinute = calendar.get(Calendar.MINUTE);
			currentSecond = calendar.get(Calendar.SECOND);
			strCurrentHour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
			strCurrentMinute = Integer.toString(calendar.get(Calendar.MINUTE));
			strCurrentSecond = Integer.toString(calendar.get(Calendar.SECOND));
			jlblClockHour.setText(strCurrentHour);
			jlblClockMinute.setText(strCurrentMinute);
			jlblClockSecond.setText(strCurrentSecond);
			
			if (jckAlarm.isSelected() && ((currentHour == alarmHour) && ((currentMinute == alarmMinute) && (currentSecond == alarmSecond)))) {
				// alarms goes off IF current time = alarm time
				jlblClockHour.setForeground(Color.WHITE);
				p3.setBackground(Color.RED);
				jlblClockMinute.setForeground(Color.WHITE);
				p4.setBackground(Color.RED);
				jlblClockSecond.setForeground(Color.WHITE);
				p5.setBackground(Color.RED);
				
				// Play sound here too
				audioClip.play();
				audioClip.loop();
				
			}
			
		}
	}
	
	public static void main(String[] args) {						// To make the Applet as a stand alone add a main method
		JFrame frame = new JFrame("Exercise 18.21: Alarm Clock");   // Create a frame
		Exercise18_21 applet = new Exercise18_21();					// Create an instance of the applet in the main method
		frame.add(applet);   										// Adding applet to the frame
		frame.setSize(500, 150);									// setting frame preferences
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
