import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Chapter18 extends JApplet {
	
	// Chapter18 - constructor
	public Chapter18() {
		add(new JLabel("Hi!", JLabel.CENTER));
	}

	// Running as an applet the Main method will not execute
	public static void main(String[] args) {
		JFrame frame = new JFrame("Applet Fun");
		// Replaces the "frame.add(new JLabel("Hi!", JLabel.CENTER));"
		// Chapter18 applet = new Chapter18();
		frame.add(new Chapter18());
		// frame.add(new JLabel("Hi!", JLabel.CENTER));
		frame.setVisible(true);
		frame.setSize(300, 300);
	}

}
