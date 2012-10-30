//Naomi Crosby - September 10, 2012 - Java 2 
//Homework due 9/10/2012 (found on page 611)

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Exercise17_15 extends JFrame implements ActionListener {

	/** Chapter 17 assignment  */
	private JScrollBar jscbRed = new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jscbGreen = new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jscbBlue = new JScrollBar(JScrollBar.HORIZONTAL);
	private JLabel jlblShowColor = new JLabel("Show Colors");
	int red = 0, green = 0, blue = 0;

	public static void main(String[] args) {
		// This is the frame to hold everything in place.
		Exercise17_15 frame = new Exercise17_15();
		frame.setTitle("Exercise 17.15");
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);  //center on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public Exercise17_15() {
		// Panel that holds SHOW COLORS; Setting values on LABEL & SCROLL BARS
		JPanel p1 = new JPanel(new GridLayout(1, 1));
		jlblShowColor.setHorizontalAlignment(SwingConstants.CENTER);
		jlblShowColor.setVerticalAlignment(SwingConstants.CENTER);
		jlblShowColor.setForeground(Color.BLUE);
		jscbRed.setMaximum(255);
		jscbRed.setMinimum(0);
		jscbGreen.setMaximum(255);
		jscbGreen.setMinimum(0);
		jscbBlue.setMaximum(255);
		jscbBlue.setMinimum(0);
		p1.add(jlblShowColor);
		
		// Panel holds Labels
		JPanel p2 = new JPanel(new GridLayout(3, 1));
		p2.add(new JLabel("Red: "));
		p2.add(new JLabel("Green: "));
		p2.add(new JLabel("Blue: "));
		
		// Panel holds scroll bars
		JPanel p3 = new JPanel(new GridLayout(3, 1));
		p3.add(jscbRed);
		p3.add(jscbGreen);
		p3.add(jscbBlue);
		
		// Panel that holds the 2 sub panels for labels & scroll bars
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 2));
		p4.setBorder(new TitledBorder("Choose Colors"));
		p4.add(p2);
		p4.add(p3);
		// Adding panels to frame
		setLayout(new GridLayout(2, 1));
		add(p1);
		add(p4);
		
		//Registering event handlers - to change the label color
		jscbRed.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent e){
				red = jscbRed.getValue();
				jlblShowColor.setForeground(new Color(red, green, blue));
			}
		});
		jscbGreen.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent e){
				green = jscbGreen.getValue();
				jlblShowColor.setForeground(new Color(red, green, blue));
			}
		});
		jscbBlue.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent e){
				blue = jscbBlue.getValue();
				jlblShowColor.setForeground(new Color(red, green, blue));
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
				
	}

	
}
