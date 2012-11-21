import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.sun.rowset.JdbcRowSetImpl;

public class History extends JFrame{
	String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	private JComboBox jcbMonth = new JComboBox(months);
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table = new JTable(tableModel);
	//private JScrollPane sp = new JScrollPane();
	private RowSet rowSet;

	public History() {
		this.setSize(400, 400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Date Selection History");
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter the month"));
		panel.add(jcbMonth);

		this.add(panel, BorderLayout.NORTH);
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		
		tableModel.addColumn("Day");
		tableModel.addColumn("Count");

		rowSet = new JdbcRowSetImpl();
		try {
			rowSet.setUrl("jdbc:mysql://localhost/javabook");
			rowSet.setUsername("scott");
			rowSet.setPassword("tiger");

			rowSet.setCommand("SELECT Day, Count FROM History WHERE Name =  ?");
			
			jcbMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String month = (String)jcbMonth.getSelectedItem();
					System.out.println(month);
					
					try {
						rowSet.setString(1, month);
						rowSet.execute();
						rowSet.last();
						int rows = rowSet.getRow();
						rowSet.first();
						Object [][] data = new Object[1][2];
						
						for (int x = 1; x <= rows; x++) {
							data[0][0] = rowSet.getInt(1);
							data[0][1] = rowSet.getInt(2);
							rowSet.next();
							tableModel.addRow(data[0]);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});

			// Let the user enter the month number through the textfield
			// Ensure that the month is 1 - 12
			// Set up the connection to retrieve 
			// retrieve the history for that month
			// display the day and the count in a 2 column table
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
