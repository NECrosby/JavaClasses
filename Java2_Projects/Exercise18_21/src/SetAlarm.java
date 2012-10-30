// Naomi Crosby

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SetAlarm extends JFrame {
	// Frame 2 - components
	private JTextField jtfSetHour = new JTextField();
	private JTextField jtfSetMinute = new JTextField();
	private JTextField jtfSetSecond = new JTextField();
	private JButton jbtOk = new JButton("OK");
	private JButton jbtCancel = new JButton("Cancel");	

	// Variables for setting the alarm
	int intHour, intMinute, intSecond;

	// Setters
	public int setAlarmHour(){
		return intHour;
	}
	public int setAlarmMinute(){		
		return intMinute;
	}
	public int setAlarmSecond(){		
		return intSecond;
	}

	// constructor
	public SetAlarm(){
		setTitle("Set Alarm");
		setSize(250, 200);
		setLocationRelativeTo(null);
		setVisible(false);
		setLayout(new BorderLayout());

		// North panel contains panel "header"
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(new JLabel("Enter Hour, Minute, and Second"));
		add(p1, BorderLayout.NORTH);

		// Center panel contain text fields for user input
		JPanel p2 = new JPanel(new GridLayout(3, 2));
		p2.add(new JLabel("Hour"));
		p2.add(jtfSetHour);
		p2.add(new JLabel("Minute"));
		p2.add(jtfSetMinute);
		p2.add(new JLabel("Second"));
		p2.add(jtfSetSecond);
		add(p2, BorderLayout.CENTER);

		// South panel contains buttons
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(jbtOk);
		p3.add(jbtCancel);
		add(p3, BorderLayout.SOUTH);

		// Register Listeners
		jbtOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean isValid = true;
				String inputAlarmHour = jtfSetHour.getText();
				String inputAlarmMinute = jtfSetMinute.getText();
				String inputAlarmSecond = jtfSetSecond.getText();

				// Making sure that the input is numeric
				try {
					intHour = Integer.parseInt(inputAlarmHour);	
					try {
						intMinute = Integer.parseInt(inputAlarmMinute);	
						try {
							intSecond = Integer.parseInt(inputAlarmSecond);							
						}
						catch (NumberFormatException ex){
							isValid = false;
							JOptionPane.showMessageDialog(null, "WARNING: Please enter a number between 0-59 into Second text box.");
							jtfSetSecond.setText(null);
							jtfSetSecond.requestFocus();
						}
					}
					catch (NumberFormatException ex){
						isValid = false;
						JOptionPane.showMessageDialog(null, "WARNING: Please enter a number between 0-59 into Minute text box.");
						jtfSetMinute.setText(null);
						jtfSetMinute.requestFocus();
					}
				}
				catch (NumberFormatException ex){
					isValid = false;
					JOptionPane.showMessageDialog(null, "WARNING: Please enter a number between 0-23 into Hour text box.");
					jtfSetHour.setText(null);
					jtfSetHour.requestFocus();
				}

				if (isValid){		// Validating User Input
					while ((intHour >= 0) && (intHour > 24)){
						JOptionPane.showMessageDialog(null, "WARNING: Please enter an HOUR between 0-23");
						intHour = -1;
						jtfSetHour.setText(null);
						jtfSetHour.requestFocus();
					}
					while ((intMinute >= 0) && (intMinute > 60)){
						JOptionPane.showMessageDialog(null, "WARNING: Please enter a MINUTE between 0-59");
						intMinute = -1;
						jtfSetMinute.setText(null);
						jtfSetMinute.requestFocus();
					}
					while ((intSecond >= 0) && (intSecond > 60)){
						JOptionPane.showMessageDialog(null, "WARNING: Please enter a SECOND between 0-59");
						intSecond = -1;
						jtfSetSecond.setText(null);
						jtfSetSecond.requestFocus();
					}
				}
			}
		});					// End of OK Button Event Handler

		jbtCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});			// End of the Cancel Button
	}  		// END of constructor
}  			// END of Class
