// FanControlPanel.java: Control a fan
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class FanControl extends JPanel implements ActionListener, AdjustmentListener {

	private static final long serialVersionUID = 1L;
	private JButton jbtStart, jbtStop, jbtReverse;
	private JScrollBar jscb;
	private Fan fan;

	public FanControl() {
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3));
		p1.add(jbtStart = new JButton("Start"));
		p1.add(jbtStop = new JButton("Stop"));
		p1.add(jbtReverse = new JButton("Reverse"));
		p1.setBorder(new LineBorder(Color.black, 1));

		JPanel p2 = new JPanel();
		setLayout(new BorderLayout());
		add("North", p1);
		add("Center", fan = new Fan());
		add("South", jscb = new JScrollBar(
				JScrollBar.HORIZONTAL, 100, 100, 0, 800));
		jscb.setMaximum(1000);

		jbtStart.addActionListener(this);
		jbtStop.addActionListener(this);
		jbtReverse.addActionListener(this);
		jscb.addAdjustmentListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if (e.getSource() instanceof JButton)
			if ("Start".equals(arg))
				start();
			else if ("Stop".equals(arg))
				stop();
			else if ("Reverse".equals(arg))
				reverse();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	// Start the fan
	public void start() {
		fan.timer.start();
	}

	// Stop the fan
	public void stop() {
		fan.timer.stop();
	}

	// Reverse the fan
	public void reverse() {
		fan.reverse();
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		//fan.setSpeed((jscb.getMaximum() - jscb.getValue())/10);
		new Thread(new RunFanThread(e)).start();
	}

	//Runnable fanTask = new RunFan();
	//Thread fanThread = new Thread(fanTask);
	//fanThread.start();
	// Task class for Running the Fan on separate Thread
	class RunFanThread implements Runnable {
		private AdjustmentEvent event;
		
		// RunFanThread Constructor
		public RunFanThread(AdjustmentEvent event) {
			this.event = event;
		}

		public void run() {

		}
	}

}