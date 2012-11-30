import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ApplicationWindowTester {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindowTester window = new ApplicationWindowTester();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindowTester() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblThisIsThe = DefaultComponentFactory.getInstance().createTitle("Your wish is my command: ");
		frame.getContentPane().add(lblThisIsThe, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 4, 5, 5));
		
		JLabel label = new JLabel(" ");
		panel.add(label);
		
		JLabel label_1 = new JLabel(" ");
		panel.add(label_1);
		
		JLabel label_2 = new JLabel(" ");
		panel.add(label_2);
		
		JButton btnGo = new JButton("GO");
		panel.add(btnGo);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}

}
