import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class AssignmentChapter17 extends JFrame {

	/** Chapter 17 assignment - pack a lot of stuff onto one frame  */
	private final String[] windowTitles = {"Travis' Full Window", "This is crazy!", "How much more can this handle?"};

	private final JCheckBox jchkBackgroundColor = new JCheckBox("Background Color");
	private final JComboBox jcboWindowTitles = new JComboBox(windowTitles);
	private final JTextField jtxtboNewMessageDisplayField = new JTextField();
	private final JLabel jlblTextInMessageDisplay = new JLabel("Change this text by entering new text into text field");
	private JRadioButton jrbArial, jrbTimes, jrbCourier;
	private final JSlider jSlider_Red, jSlider_Green, jSlider_Blue;
	private final JSlider jSliderFontSize = new JSlider(JSlider.VERTICAL);

	JPanel centerPanelHoldingArea;
	int red = 0, green = 0, blue = 0;

	public static void main(String[] args) {
		// This is the frame to hold everything in place.
		AssignmentChapter17 frame = new AssignmentChapter17();
		frame.setTitle("Travis' Christmas Wish List");
		frame.setSize(480, 600);
		frame.setLocationRelativeTo(null);  //center on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public AssignmentChapter17() {
		JPanel northEnterTextPanel = new JPanel();
		northEnterTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		northEnterTextPanel.add(new JLabel("Enter your new text here: "));
		northEnterTextPanel.add(jtxtboNewMessageDisplayField);
		jtxtboNewMessageDisplayField.setPreferredSize(new Dimension(200, 20));
		add(northEnterTextPanel, BorderLayout.NORTH);

		centerPanelHoldingArea = new JPanel();
		centerPanelHoldingArea.setLayout(new BorderLayout(5, 10));
		centerPanelHoldingArea.add(jcboWindowTitles, BorderLayout.SOUTH);
		centerPanelHoldingArea.add(jlblTextInMessageDisplay, BorderLayout.CENTER);
		jlblTextInMessageDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTextInMessageDisplay.setOpaque(false);
		centerPanelHoldingArea.add(jSliderFontSize, BorderLayout.WEST);
		add(centerPanelHoldingArea, BorderLayout.CENTER);

		jSlider_Red = getSlider(0, 255, 0, 50, 5);  //setting default slider location for RED
		jSlider_Green = getSlider(0, 255, 0, 50, 5);  //setting default slider location for GREEN
		jSlider_Blue = getSlider(0, 255, 0, 50, 5);  //setting default slider location for BLUE

		JPanel southRGBSliderPanel = new JPanel();
		southRGBSliderPanel.setLayout(new GridLayout(3, 2));
		southRGBSliderPanel.add(new JLabel("Red: "));
		southRGBSliderPanel.add(jSlider_Red);
		southRGBSliderPanel.add(new JLabel("Green: "));
		southRGBSliderPanel.add(jSlider_Green);
		southRGBSliderPanel.add(new JLabel("Blue: "));
		southRGBSliderPanel.add(jSlider_Blue);

		JPanel eastFontPanel = new JPanel();
		eastFontPanel.setLayout(new GridLayout(4, 1));
		eastFontPanel.add(jchkBackgroundColor, BorderLayout.EAST);
		eastFontPanel.add(jrbArial = new JRadioButton("Arial"));
		eastFontPanel.add(jrbCourier = new JRadioButton("Courier"));
		eastFontPanel.add(jrbTimes = new JRadioButton("Times"));

		ButtonGroup fontButtonGroup = new ButtonGroup();
		fontButtonGroup.add(jrbArial);
		fontButtonGroup.add(jrbCourier);
		fontButtonGroup.add(jrbTimes);

		add(northEnterTextPanel, BorderLayout.NORTH);
		add(southRGBSliderPanel, BorderLayout.SOUTH);
		add(eastFontPanel, BorderLayout.EAST);

		final Font currentFont = jlblTextInMessageDisplay.getFont();  //Current default Font in message display
		jlblTextInMessageDisplay.setFont(new Font("Arial", Font.PLAIN, 12)); //set message display font

		jSliderFontSize.setMaximum(32);
		jSliderFontSize.setMinimum(6);
		jSliderFontSize.setMajorTickSpacing(10);
		jSliderFontSize.setMinorTickSpacing(2);
		jSliderFontSize.setPaintTicks(true);
		jSliderFontSize.setSnapToTicks(true);
		jSliderFontSize.setValue(12);
		jSliderFontSize.setPaintLabels(true);

		//Registering Action listeners

		//This is for the Background Color
		jchkBackgroundColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if (jchkBackgroundColor.isSelected()){
					BGColor(red, green, blue);
				}
				else {
					BGColor(0, 0, 0);
				}
			}
		});

		//This is for the Title Combo box
		jcboWindowTitles.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				FrameTitle(windowTitles[jcboWindowTitles.getSelectedIndex()]);
			}
		});

		//This is for the RED slider
		jSlider_Red.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				JSlider jSlider_Red = (JSlider)e.getSource();
				red = jSlider_Red.getValue();
				ChangeColor(red, green, blue);
			}
		});

		//This is for the GREEN slider
		jSlider_Green.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				JSlider jSlider_Green = (JSlider)e.getSource();
				green = jSlider_Green.getValue();
				ChangeColor(red, green, blue);
			}
		});

		//This is for the BLUE slider
		jSlider_Blue.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				JSlider jSlider_Blue = (JSlider)e.getSource();
				blue = jSlider_Blue.getValue();
				ChangeColor(red, green, blue);
			}
		});

		//Change font listener
		jSliderFontSize.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				jlblTextInMessageDisplay.setFont(new Font(currentFont.getFontName(), 
						currentFont.getStyle(), (jSliderFontSize.getValue())));
				repaint();
			}
		});

		//Change the display message
		jtxtboNewMessageDisplayField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jlblTextInMessageDisplay.setText(jtxtboNewMessageDisplayField.getText());
			}
		});

		//Listen for Arial font radio button selection
		jrbArial.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jlblTextInMessageDisplay.setFont(new Font("Arial", 
						Font.PLAIN, jSliderFontSize.getValue()));
			}
		});

		//Listen for Courier font radio button selection
		jrbCourier.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jlblTextInMessageDisplay.setFont(new Font("Courier", 
						Font.PLAIN, jSliderFontSize.getValue()));
			}
		});

		//Listen for Times New Roman font radio button selection
		jrbTimes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				jlblTextInMessageDisplay.setFont(new Font("Times New Roman", 
						Font.PLAIN, jSliderFontSize.getValue()));
			}
		});



	}
	private void FrameTitle(String string){
		this.setTitle(string);
	}

	private void ChangeColor(int a, int b, int c){
		Color myColor = new Color(a, b, c);
		jlblTextInMessageDisplay.setForeground(myColor);
	}

	private void BGColor(int r, int b, int g){
		Color myColor1 = new Color(r, g, b);
		centerPanelHoldingArea.setBackground(myColor1);
	}

	protected Font deriveFont(int value){
		return null;
	}

	public JSlider getSlider(int min, int max, int init, int mjrTkSp, int mnrTkSp){
		JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, init);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		slider.setPaintLabels(true);
		return slider;
	}
}
