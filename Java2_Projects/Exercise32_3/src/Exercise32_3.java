import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Naomi Crosby - Java II - Chapter 32 Assignment 
// Exercise 32.3 Page 1107 - Due 11/7/2012

/* *********************************************************************************\	
|  	Hints:																			|
|		Figure 32.10 may confuse this a bit. If this was to be a single-user type 	|
|		of program, it may seem overkill to have a separate Hurricane class 		|
|		(i.e. if the user enters a category of 3, in the event handler for this 	|
|		entry, it would be fairly easy, via a decision structure, to just generate 	|
|		the appropriate message). Broaden out to a bigger picture. Image there are 	|
|		multiple “clients” all listening for hurricane warnings. If a user enters 	|
|		a category 3, all listeners would want to know about it.					| 
\***********************************************************************************/

public class Exercise32_3 extends JApplet {
	private static final long serialVersionUID = 1L;

	// Create a Hurricane Object
	Hurricane hurricane = new Hurricane();
	private int intCategory;
	private JTextField jtxtCategory = new JTextField();
	private JPanel topPanel = new JPanel(new GridLayout(0, 2));
	private JLabel jlblPrompt = new JLabel("Enter Hurricane Category: ");
	JPanel bodyPanel = new JPanel(new BorderLayout());
	JLabel jlblbHurricaneMessage = new JLabel("Category not known at this time");

	public static void main(String[] args) {
		Exercise32_3 applet = new Exercise32_3();
		JFrame frame = new JFrame();
		frame.setTitle("Exercise 32.3: Hurricane Warnings");
		frame.add(applet, BorderLayout.CENTER);
		frame.setSize(600, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		applet.init();
	}

	public void init() {
		setSize(new Dimension(600, 200));
		add(hurricane);
	}

	public Exercise32_3() {
		setLayout(new BorderLayout(5, 5));
		setBackground(Color.WHITE);
		jlblPrompt.setHorizontalAlignment(JLabel.RIGHT);
		jtxtCategory.setHorizontalAlignment(JTextField.RIGHT);
		topPanel.setBackground(Color.WHITE);
		topPanel.add(jlblPrompt);
		topPanel.add(jtxtCategory);
		add(topPanel, BorderLayout.NORTH);
		
		jlblbHurricaneMessage.setHorizontalAlignment(JLabel.CENTER);
		jlblbHurricaneMessage.setVerticalAlignment(JLabel.CENTER);
		jlblbHurricaneMessage.setFont(new Font("Arial", Font.BOLD, 20));
		jlblbHurricaneMessage.setForeground(Color.BLACK);
		bodyPanel.setBackground(Color.LIGHT_GRAY);
		bodyPanel.add(jlblbHurricaneMessage);
		add(bodyPanel, BorderLayout.CENTER);
		
		ActionListener listener = new Listener();
		jtxtCategory.addActionListener(listener);
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				intCategory = Integer.parseInt(jtxtCategory.getText().trim());
				while ( (intCategory > 5 || intCategory < 0) ) {
					//JOptionPane.showMessageDialog(null, "Category cannot exceed a level 5 and must be greater than 0.");
					jtxtCategory.setText("");
					intCategory = (Integer) null;
				}
				hurricane.setCategory(intCategory);
				if ( hurricane.isWarningNeeded() ) {
					jlblbHurricaneMessage.setForeground(Color.WHITE);
					bodyPanel.setBackground(Color.RED);
				}
				jlblbHurricaneMessage.setText(hurricane.setWarningMessage());
			} catch (Exception ex) {
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Category cannot exceed a level 5 and must be greater than 0.");
			}
		}
	}
}
