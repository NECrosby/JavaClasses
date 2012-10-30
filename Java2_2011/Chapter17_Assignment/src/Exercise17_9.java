import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Exercise17_9 extends JFrame {
	/** This is the Grape and Text Position/Alignment  */
	// Class level variables
	private final ImageIcon grapes = new ImageIcon("image/grapes.gif");  // Create an image icon
	private final JLabel jlblGrapes = new JLabel("Grapes", grapes, SwingConstants.CENTER);  // Create a label with text, an icon
	private final JButton jbtnGrapes = new JButton();
	private final JPanel jpGrapeContainer = new JPanel();

	private final String[] horizontalPositions = {"LEFT", "CENTER", "RIGHT"};
	private final String[] verticalPositions = {"TOP", "CENTER", "BOTTOM"};

	private final JComboBox jcboGrapeHorizontal = new JComboBox(horizontalPositions);
	private final JComboBox jcboGrapeVertical = new JComboBox(verticalPositions);
	private final JComboBox jcboTextHorizontal = new JComboBox(horizontalPositions);
	private final JComboBox jcboTextVertical = new JComboBox(verticalPositions);

	private final JLabel jlblRightHorizontal = new JLabel("Horizontal");
	private final JLabel jlblRightVertical = new JLabel("Vertical");
	private final JLabel jlblLeftHorizontal = new JLabel("Horizontal");
	private final JLabel jlblLeftVertical = new JLabel("Vertical");

	public static void main(String[] args) {
		// Frame Details
		Exercise17_9 frame = new Exercise17_9();
		frame.setLocationRelativeTo(null); // Center frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grape Icon: Adjusting Alignment and Position of Caption");
		frame.pack();
		frame.setVisible(true);
	}

	public Exercise17_9() {
		// Set label's text alignment and gap between Text and Image
		jlblGrapes.setHorizontalTextPosition(SwingConstants.CENTER);
		jlblGrapes.setVerticalTextPosition(SwingConstants.BOTTOM);
		jlblGrapes.setIconTextGap(5);
		jbtnGrapes.add(jlblGrapes);
		jpGrapeContainer.setPreferredSize(new Dimension(600, 400));  // Grapes Panel custom settings
		jpGrapeContainer.setLayout(new GridLayout(1, 0));
		this.add(jbtnGrapes, BorderLayout.NORTH);  // adding the Icon and Caption to the main frame

		// Creating a panel for the controls
		JPanel jpControlContainer = new JPanel();
		//jpControlContainer.setPreferredSize(new Dimension(300, 250));
		jpControlContainer.setLayout(new GridLayout(0, 2, 5, 5));
		add(jpControlContainer, BorderLayout.SOUTH);

		// Creating a panel for Alignment
		JPanel jpAlignment = new JPanel();
		jpAlignment.setBorder(new TitledBorder("Horizontal Alignment"));
		jpAlignment.setPreferredSize(new Dimension(200, 100));
		jpControlContainer.add(jpAlignment, BorderLayout.WEST);

		//Panel for Horizontal/Vertical Labels
		JPanel jpLeftHVlabels = new JPanel();
		jpLeftHVlabels.setLayout(new GridLayout(2, 0, 10, 10));
		jpLeftHVlabels.add(jlblLeftHorizontal);
		jpLeftHVlabels.add(jlblLeftVertical);
		jpAlignment.add(jpLeftHVlabels);

		// Left Combo Boxes
		JPanel jpLeftComboBoxes = new JPanel();
		jpLeftComboBoxes.setLayout(new GridLayout(2, 0, 10, 10));
		jpLeftComboBoxes.add(jcboGrapeHorizontal);
		jpLeftComboBoxes.add(jcboGrapeVertical);
		jpAlignment.add(jpLeftComboBoxes);

		// Creating a panel for text Position
		JPanel jpTextPosition = new JPanel();
		jpTextPosition.setBorder(new TitledBorder("Text Position"));
		jpTextPosition.setPreferredSize(new Dimension(200, 100));
		jpControlContainer.add(jpTextPosition, BorderLayout.EAST);

		JPanel jpRightTextPositionLabels = new JPanel();
		jpRightTextPositionLabels.setLayout(new GridLayout(2, 0, 10, 10));
		jpRightTextPositionLabels.add(jlblRightHorizontal);
		jpRightTextPositionLabels.add(jlblRightVertical);
		jpTextPosition.add(jpRightTextPositionLabels);

		// Right Combo Boxes
		JPanel jpRightComboBoxes = new JPanel();
		jpRightComboBoxes.setLayout(new GridLayout(2, 0, 10, 10));
		jpRightComboBoxes.add(jcboTextHorizontal);
		jpRightComboBoxes.add(jcboTextVertical);
		jpTextPosition.add(jpRightComboBoxes);

		/** -- Register Listeners  */
		jcboGrapeHorizontal.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				double indexValue = jcboGrapeHorizontal.getSelectedIndex();
				grapes.setHorizontalAlignment(SwingConstants.LEFT);
				grapes.setHorizontalAlignment(SwingConstants.CENTER);
				grapes.setHorizontalAlignment(SwingConstants.RIGHT);
			}
		});

		jcboGrapeVertical.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				double indexValue = jcboGrapeVertical.getSelectedIndex();
				grapes.setVerticalAlignment(SwingConstants.TOP);
				grapes.setVerticalAlignment(SwingConstants.CENTER);
				grapes.setVerticalAlignment(SwingConstants.BOTTOM);
			}
		});

		jcboTextHorizontal.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				jcboTextHorizontal.getSelectedIndex();
				jlblGrapes.setHorizontalTextPosition(SwingConstants.LEFT);
				jlblGrapes.setHorizontalTextPosition(SwingConstants.CENTER);
				jlblGrapes.setHorizontalTextPosition(SwingConstants.RIGHT);
			}
		});

		jcboTextVertical.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				jcboTextVertical.getSelectedIndex();
				jlblGrapes.setVerticalTextPosition(SwingConstants.TOP);
				jlblGrapes.setVerticalTextPosition(SwingConstants.CENTER);
				jlblGrapes.setVerticalTextPosition(SwingConstants.BOTTOM);
			}
		});

	}

}
