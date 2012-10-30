// Naomi Crosby - Chapter 20 In Class exercise 20.35 on Page 705
// October 1, 2012 - Recursively

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HTree extends JApplet {
	private static final long serialVersionUID = 1L;
	// GUI variables used by the entire class
	private JTextField jtfOrder = new JTextField(5);
	private TreePanel tree = new TreePanel();
		
	public HTree() {
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter an order: "));
		panel.add(jtfOrder);
		add(tree, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		// Register Listener
		jtfOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// Add exception handling
				tree.setOrder(Integer.parseInt(jtfOrder.getText()));
				repaint();
			}
		});
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise: 20.35");
		HTree applet = new HTree();
		frame.add(applet);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
	
	// Chapter 15 - for the paint component
	public static class TreePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private int order = -1;  // Initialize order so that the frame starts with a blank slate
		
		public void setOrder(int o) {
			order = o;
		}
		
		public void paintComponent(Graphics g) {
			// Base condition
			if (order >= 0){  
				// g = graphics, Order = from user, 
				// Drawing initial H using (getWidth(), getHeight(), and getWidth() for the length)
				displayTree(g, order, getWidth()/2, getHeight()/2, getWidth()/4);
			}
		}
		
		private void displayTree(Graphics g, int o, int x, int y, int length) {
			// Base condition - draw the H
			g.drawLine(x - length, y, x + length, y);					// horizontal line in the H
			g.drawLine(x - length, y - length, x - length, y + length);	// left vertical line on the H
			g.drawLine(x + length, y - length, x + length, y + length);	// right vertical line on the H 
			
			if (o > 0){  // Recursive call here if Order is not Zero
				displayTree(g, o - 1, x - length, y - length, length/2);
				displayTree(g, o - 1, x + length, y - length, length/2);
				displayTree(g, o - 1, x - length, y + length, length/2);
				displayTree(g, o - 1, x + length, y + length, length/2);
			}
		}
	}

}
