import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Test1 extends JFrame {
	/**  This is the Calendar Program  */
	// Class level variables - Contents of the Main Frame
	private final JButton jbtAppointment = new JButton("Make Appointment");
	private final static JLabel jlblHeader = new JLabel(" ", JLabel.CENTER);
	private final static JLabel[] jlblDay = new JLabel[49];   // Maximum number of labels to display day names and days
	private static java.util.Calendar calendar;
	private static int month;  // The specified month
	private static int year;  // The specified year
	private final static JPanel jpDays = new JPanel(new GridLayout(0, 7));  // Panel jpDays to hold day names and days
	private final JButton jbtPrior = new JButton("Prior");  // Buttons Prior and Next for displaying prior and next month
	private final JButton jbtNext = new JButton("Next");
	//private final static JTextArea jtaMemo = new JTextArea("");

	public static void main(String[] args) {
		// This is the main for the calendar 
		Test1 frame = new Test1();
		frame.setLocationRelativeTo(null); // Centers frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Test 1: Calendar");
		frame.pack();
		frame.setVisible(true);
	}

	public Test1 () {
		// Creating a scroll pane for the calendar to be held in
		jpDays.setPreferredSize(new Dimension(600, 400));

		// Panel jpButtons to hold buttons
		JPanel jpButtons = new JPanel(new FlowLayout());
		jpButtons.add(jbtPrior);
		jpButtons.add(jbtAppointment);
		jpButtons.add(jbtNext);

		// Place header and calendar body in the panel
		this.setLayout(new BorderLayout());
		this.add(jlblHeader, BorderLayout.NORTH);
		this.add(jpDays, BorderLayout.CENTER);
		this.add(jpButtons, BorderLayout.SOUTH);

		// Create labels for displaying days
		for (int i = 0; i < 49; i++) {
			jlblDay[i] = new JLabel();

			jlblDay[i].setBorder(new LineBorder(Color.black, 1));
			jlblDay[i].setHorizontalAlignment(JLabel.RIGHT);
			jlblDay[i].setVerticalAlignment(JLabel.TOP);
		}

		// Set current month and year
		calendar = new GregorianCalendar();
		month = calendar.get(Calendar.MONTH);
		year = calendar.get(Calendar.YEAR);
		updateCalendar();

		// Show calendar
		showHeader();
		showDays();

		// Register Listeners
		/*jpDays.addMouseListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblDay.setText();
			}
		});*/

		jbtAppointment.addActionListener(new ActionListener() {
			/** Handle the button action */
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add in desired action here
			}
		});

		jbtPrior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentMonth = Test1.getMonth();
				if (currentMonth == 0) // The previous month is 11 for Dec
					Test1.setYear(Test1.getYear() - 1);
				Test1.setMonth((currentMonth - 1) % 12);
			}});

		jbtNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentMonth = Test1.getMonth();
				if (currentMonth == 11) // The next month is 0 for Jan
					Test1.setYear(Test1.getYear() + 1);

				Test1.setMonth((currentMonth + 1) % 12);
			}});
	}

	/** Update the header based on local */
	private static void showHeader() {
		SimpleDateFormat sdf =
			new SimpleDateFormat("MMMM yyyy");
		String header = sdf.format(calendar.getTime());
		jlblHeader.setText(header);
	}

	/** Update the day names based on local */
	private static void showDayNames() {
		DateFormatSymbols dfs = new DateFormatSymbols();
		String dayNames[] = dfs.getWeekdays();

		// jlblDay[0], jlblDay[1], ..., jlblDay[6] for day names
		for (int i = 0; i < 7; i++) {
			jlblDay[i].setText(dayNames[i + 1]);
			jlblDay[i].setHorizontalAlignment(JLabel.CENTER);
			//jlblDay[i].add(jlblMemo, BorderLayout.CENTER);
			jpDays.add(jlblDay[i]); // Add to jpDays
		}
	}

	/** Display days */
	public static void showDays() {
		jpDays.removeAll(); // Remove all labels from jpDays

		showDayNames(); // Display day names

		// Get the day of the first day in a month
		int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);

		// Fill the calendar with the days before this month
		Calendar cloneCalendar = (Calendar)calendar.clone();
		cloneCalendar.add(Calendar.DATE, -1); // Becomes preceding month
		int daysInPrecedingMonth = cloneCalendar.getActualMaximum(
				Calendar.DAY_OF_MONTH);

		for (int i = 0; i < startingDayOfMonth - 1; i++) {
			jlblDay[i + 7].setForeground(Color.LIGHT_GRAY);
			jlblDay[i + 7].setText(daysInPrecedingMonth -
					startingDayOfMonth + 2 + i + "");
			jpDays.add(jlblDay[i + 7]); // Add to jpDays
		}

		// Display days of this month
		int daysInCurrentMonth = calendar.getActualMaximum(
				Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= daysInCurrentMonth; i++) {
			jlblDay[i - 2 + startingDayOfMonth + 7].setForeground(Color.black);
			jlblDay[i - 2 + startingDayOfMonth + 7].setText(i + "");
			//jlblDay[i - 2 + startingDayOfMonth + 7].add(jtaMemo, BorderLayout.CENTER); 
			jpDays.add(jlblDay[i - 2 + startingDayOfMonth + 7]);
		}

		// Fill the calendar with the days after this month
		int j = 1;
		for (int i = daysInCurrentMonth - 1 + startingDayOfMonth + 7;
		i % 7 != 0; i++) {
			jlblDay[i].setForeground(Color.LIGHT_GRAY);
			jlblDay[i].setText(j++ + "");
			jpDays.add(jlblDay[i]); // Add to jpDays
		}

		jpDays.repaint(); // Repaint the labels in jpDays
	}

	/** Set the calendar to the first day of the
	 *  specified month and year */
	private static void updateCalendar() {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, 1);
	}

	/** Return month */
	public static int getMonth() {
		return month;
	}

	/** Set a new month */
	public static void setMonth(int newMonth) {
		month = newMonth;
		updateCalendar();
		showHeader();
		showDays();
	}

	/** Return year */
	public static int getYear() {
		return year;
	}

	/** Set a new year */
	public static void setYear(int newYear) {
		year = newYear;
		updateCalendar();
		showHeader();
		showDays();
	}

	/** Set a new local */
	public void changeLocale(Locale newLocale) {
		setLocale(newLocale);
		showHeader();
		showDays();
	}
}
