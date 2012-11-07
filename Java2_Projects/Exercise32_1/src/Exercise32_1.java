import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JApplet;
import javax.swing.JFrame;


public class Exercise32_1 extends JApplet {
	private static final long serialVersionUID = 1L;
	
	MessagePanelWithActionEvent messagePanel = new MessagePanelWithActionEvent();
	
	public static void main(String[] args) {
		Exercise32_1 applet = new Exercise32_1();
		JFrame frame = new JFrame();
		frame.setTitle("Message Panel");
		frame.add(applet, BorderLayout.CENTER);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		applet.init();
	}
	
	public void init() {
		setSize(new Dimension(400, 300));
		messagePanel.setCentered(true);
		messagePanel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		messagePanel.setMessage("");
		add(messagePanel, BorderLayout.CENTER);
		messagePanel.addMouseListener(new panelMouseListener());
	}
	
	private class panelMouseListener implements MouseListener {
	
		public void mouseClicked(MouseEvent arg0) {
			messagePanel.setMessage(new Date().toString());
		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}			
	}

}
