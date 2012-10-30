import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ComboBox extends JFrame implements ActionListener {
		
		//Declare Window title options in an Array
		private String[] windowTitles = {"Too much stuff to do", 
				"This assignment is a lot of work", "Easter took my weekend"};
		
		//Declare Window title combo-box
		private JComboBox jcbo = new JComboBox(windowTitles);
		
		//Declare Window title label
		private JLabel jlblWindowTitles = new JLabel();
		
		//Main Method
		public static void main(String[] args){
			ComboBox frame = new ComboBox();
			frame.setTitle("Travis' Christmas Wish List");
			frame.setSize(300, 150);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
		public ComboBox() {
			//Set window title text
			windowTitles[0] = "Too much stuff to do";
			windowTitles[1] = "This assignment is a lot of work";
			windowTitles[2] = "Easter took my weekend";
			
			add(jlblWindowTitles, BorderLayout.NORTH);
			add(jcbo, BorderLayout.CENTER);
			
		}
		
		//Register the Event listener
		jcbo.addItemListener(new ItemListener() {
			//Handle the item selection
			public void itemStateChanged(ItemEvent e) {
				setTitle(jcbo.getSelectedIndex());
			}
		});
		
		public void setWindowTitle(int index){
			frame.setTitle(windowTitles[index]);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
		
}