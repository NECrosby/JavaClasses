import javax.swing.*;
public class GUIComponents {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Create a button with text OK
		JButton jbtnOK = new JButton("OK");
		
		//Create a button with text Cancel
		JButton jbtnCancel = new JButton("Cancel");
		
		//Create a label with text "Enter your name"
		JLabel jlblName = new JLabel("Enter your name: ");
		
		//create a text field with text Type Name Here
		JTextField jtfName = new JTextField("Type Name Here");
		
		//create a check box with text bold
		JCheckBox jchkBold = new JCheckBox("Bold");
		
		//create a check box with text italic
		JCheckBox jchkItalic = new JCheckBox("Italic");
		
		//create a radio button with text red
		JRadioButton jrbRed = new JRadioButton("Red");
		
		//Create a radio button with text yellow
		JRadioButton jrbYellow = new JRadioButton("Yellow");
		
		//create a combo box with several choices
		@SuppressWarnings("rawtypes")
		JComboBox jcboColor = new JComboBox(new String[]{"Freshman", "Sophomore", "Junior", "Senior"});
		
		//Create a panel to group components
		JPanel panel = new JPanel();
		panel.add(jbtnOK);
		panel.add(jbtnCancel);
		panel.add(jlblName);
		panel.add(jtfName);
		panel.add(jchkBold);
		panel.add(jchkItalic);
		panel.add(jrbRed);
		panel.add(jrbYellow);
		panel.add(jcboColor);
		
		//Create a frame
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("Show GUI Components");
		frame.setSize(450, 100);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
