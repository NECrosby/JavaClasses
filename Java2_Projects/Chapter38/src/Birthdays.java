import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.sql.RowSet;
import javax.swing.*;
import com.sun.rowset.*;

public class Birthdays extends JFrame {

	JButton jbtSelect = new JButton("Select");
	JLabel jlblMonth = new JLabel("Month: ");
	JTextField jtfMonth = new JTextField(10);
	JLabel jlblDay = new JLabel("Day: ");
	JTextField jtfDay = new JTextField(3);
	JButton jbtHistory = new JButton("History");
	Random ran;
	RowSet rowSet1, rowSet2;

	public static void main(String[] args) {
		Birthdays bd = new Birthdays();
		bd.setTitle("Birthday selection");
		bd.setSize(300, 200);
		bd.setLocationRelativeTo(null);
		bd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bd.setVisible(true);
	}

	public Birthdays() {
		jtfMonth.setEditable(false);
		jtfDay.setEditable(false);

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.add(jlblMonth);
		panel1.add(jtfMonth);
		panel1.add(jlblDay);
		panel1.add(jtfDay);

		panel2.add(jbtSelect);
		panel2.add(jbtHistory);

		setLayout(new BorderLayout());
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);

		ran = new Random();

		jbtSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowSet1 = new JdbcRowSetImpl();
				rowSet2 = new JdbcRowSetImpl();

				int month = ran.nextInt(12) + 1;
				int maxdays, day;
				String monthName;

				try {
					rowSet1.setUrl("jdbc:mysql://localhost/javabook");
					rowSet1.setUsername("scott");
					rowSet1.setPassword("tiger");

					rowSet1.setCommand("SELECT Name, MaxDays FROM MonthNames WHERE MID = ?");
					rowSet1.setInt(1,  month);
					rowSet1.execute();

					rowSet1.next();
					monthName = rowSet1.getString(1);
					jtfMonth.setText(monthName);

					maxdays = rowSet1.getInt(2);
					day = ran.nextInt(maxdays) + 1;
					jtfDay.setText(String.valueOf(day));

					rowSet1.setCommand("SELECT * FROM History");	
					rowSet1.execute();

					/*  The following code initializes the History table 
					 *  Used to populate the History Table for the Random Birthday
					 *  Builds every month with the appropriate amount of days related to the month
					 *  Used once only - after that the History Table has been properly set up.
					 *  
					 * rowSet2.setUrl("jdbc:mysql://localhost/javabook");
					 * rowSet2.setUsername("scott");
					 * rowSet2.setPassword("tiger");
					 * rowSet2.setCommand("SELECT * FROM MonthNames");
					 * rowSet2.execute();
					 * 
					 * // rowSet1.last();
					 * rowSet1.moveToInsertRow();
					 * for (int x = 1; x <= 12; x++) {
					 * 
					 * 	rowSet2.next();
					 * 	String monthNames = rowSet2.getString("Name");
					 * 	day = rowSet2.getInt("MaxDays");
					 * 	
					 * 	for (int d = 1 ; d <= day; d++) {
					 * 		rowSet1.updateString("Name", monthNames);
					 * 		rowSet1.updateInt("Day", d);
					 * 		rowSet1.updateInt("Count", 0);
					 * 		rowSet1.insertRow();
					 * 	}
					 * }
					 * rowSet2.close();
					 */
					
					rowSet1.setCommand("SELECT * FROM History WHERE Name = ? AND Day = ?");
					rowSet1.setString(1, monthName);
					rowSet1.setInt(2, day);			// Getting into the RowSet that is needed after the Select Button was clicked
					rowSet1.execute();				// Executing the SQL Query
					rowSet1.next();					// Get the cursor into the RowSet

					/* Get the count for that month and day so that it can be incremented */
					int count = rowSet1.getInt("Count"); 
					count++;						// This increments the count for that Month/Day combo for the random day selected
					rowSet1.updateInt(3, count);
					rowSet1.updateRow();			// Commits the change to the database
					rowSet1.close();				// Close the row set
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		jbtHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				History hist = new History();
				hist.setVisible(true);		
			}
		});
	}
}
