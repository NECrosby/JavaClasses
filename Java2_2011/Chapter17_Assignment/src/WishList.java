import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class WishList  extends JFrame {

	//Declare Window title options in an Array
	private final String[] windowTitles = {"Too much stuff to do", 
			"This assignment is a lot of work", "Easter took my weekend"};
	private final JCheckBox jchkBackgroundColor = new JCheckBox("Background Color");
	private final JComboBox jcboWinTitles = new JComboBox(windowTitles);
	private final JTextField jtxtMessagePanel = new JTextField();
	private final JLabel jlblChangingText = new JLabel("This text can be changed");
	private JRadioButton jrdArial, jrdTimes, jrCourier;
	private JSlider jSliderRed, jSliderGreen, jSliderBlue;
	private final JSlider jSliderSize = new JSlider(JSlider.VERTICAL);



	public static void main(String[] args) {
		WishList frame = new WishList();
		frame.setTitle("Travis' Christmas Wish List");
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

	public WishList(){
		JPanel enterTextNorthPanel = new JPanel();
		enterTextNorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		enterTextNorthPanel.add(new JLabel("Enter text to view: "));
		enterTextNorthPanel.add(jtxtMessagePanel);
		jtxtMessagePanel.setPreferredSize(new Dimension(200, 20));
		add(enterTextNorthPanel, BorderLayout.NORTH);

		JPanel winTitleComboBoxPanel = new JPanel();
		winTitleComboBoxPanel.setLayout(new BorderLayout.SOUTH);

	}

}
