import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class ColorChangeBall extends JFrame {
	// Class level variables
	//private final JLabel jlblRed = new JLabel("Red");
	//private final JLabel jlblGreen = new JLabel("Green");
	//private final JLabel lblBlue = new JLabel("Blue");
	private final JSlider jsldRed = new JSlider(JSlider.HORIZONTAL);
	private final JSlider jsldGreen = new JSlider(JSlider.HORIZONTAL);
	private final JSlider jsldBlue = new JSlider(JSlider.HORIZONTAL);


	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new ColorChangeBall();
		frame.setTitle("Color Change Ball");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	public ColorChangeBall() {
		setLayout(new GridLayout(4, 0, 5, 5));
		add(new FigurePanel(FigurePanel.OVAL, true));
		add(jsldRed);
		add(jsldGreen);
		add(jsldBlue);

		//Set properties for the sliders
		jsldRed.setMaximum(255);
		jsldRed.setPaintLabels(true);
		jsldRed.setPaintTicks(true);
		jsldRed.setMajorTickSpacing(15);
		jsldRed.setPaintTrack(false);

		jsldGreen.setMaximum(255);
		jsldGreen.setPaintLabels(true);
		jsldGreen.setPaintTicks(true);
		jsldGreen.setMajorTickSpacing(15);
		jsldGreen.setPaintTrack(false);

		jsldBlue.setMaximum(255);
		jsldBlue.setPaintLabels(true);
		jsldBlue.setPaintTicks(true);
		jsldBlue.setMajorTickSpacing(15);
		jsldBlue.setPaintTrack(false);

		//Listeners for sliders
		/*jsldRed.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				double value = jsldRed.getValue();
				double maximumValue = jsldRed.getMaximum();
				double newX = (value * messagePanel.getWidth() / maximumValue);
				messagePanel.setXCoordinate((int)newX);
			}
		}*/

	}

	/** Repaint the circle */
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		int width = getWidth();
		int height = getHeight();
		int radius = 50;
		g.setColor(Color.GREEN);
		//g.fillOval(200, 200, 200, 200);
		g.fillOval((width / 2) - radius, (height / 2) - radius, 2 * radius, 2 * radius);
	}
}




