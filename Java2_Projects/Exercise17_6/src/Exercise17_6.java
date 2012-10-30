//Naomi Crosby - September 5, 2012 - Java 2 
// Help - Key Assist!!! Quick list!!!
// System.out.println();  //   <--- syso + 'enter'

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercise17_6 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JTextField jtfMile = new JTextField(10);
	private final JTextField jtfKilometer = new JTextField(10);

	public static void main(String[] args) {
		Exercise17_6 frame = new Exercise17_6();
		frame.setTitle("Exercise 17.6");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 100);
		frame.setVisible(true);
	}

	public Exercise17_6() {
		JPanel p1 = new JPanel(new GridLayout(2, 1));
		p1.add(new JLabel("Mile"));
		p1.add(new JLabel("Kilometer"));

		JPanel p2 = new JPanel(new GridLayout(2, 1));
		p2.add(jtfMile);
		p2.add(jtfKilometer);

		JPanel p3 = new JPanel(new BorderLayout(5, 5));
		p3.add(p1, BorderLayout.WEST);
		p3.add(p2, BorderLayout.CENTER);

		add(p3);

		jtfMile.setHorizontalAlignment(JTextField.RIGHT);
		jtfKilometer.setHorizontalAlignment(JTextField.RIGHT);

		jtfMile.addActionListener(this);
		jtfKilometer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jtfMile) {
			double mile = new Double(jtfMile.getText()).doubleValue();
			double kilometer = mile/0.6241;
			jtfKilometer.setText(new Double(kilometer).toString());
		}
		else {
			double kilometer = new Double(jtfKilometer.getText()).doubleValue();
			double mile = kilometer * 0.6241;
			jtfMile.setText(new Double(mile).toString());
		}

	}

}
