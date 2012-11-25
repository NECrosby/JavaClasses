/* ******************************************************************
 *  Naomi Crosby - Exercise 38.2 Due November 26
 *  
 *	(Scrollable result set) Write a program that uses the buttons 
 *	First, Next, Prior, Last, Insert, Delete, and Update, and 
 *	modify a single record in the Address table, as shown in 
 *	Figure 38.7.
 *
 *	Program 38.2 on page 38-32, however use a RowSet
 *	The Address table in the database will need a primary
 *	key to get this to work. In MySQL, execute a SQL
 *	command to set the primary key.
 *
 * ***************************************************************** */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.RowSet;
import javax.swing.*;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;

public class Exercise38_2 extends JApplet {
	private static final long serialVersionUID = 1L;

	// UI - variables declared 
	private JTextField jtfStreet;
	private JTextField jtfLastName;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JTextField jtfMI;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton jbtLast;
	private JButton jbtPrior;
	private JTextField jtfCity;
	private JTextField jtfZip;
	private JButton jbtUpdate;
	private JTextField jtfEmail;
	private JTextField jtfFirstName;
	private JLabel jlblStatus;
	private JTextField jtfState;
	private JButton jbtInsert;
	private JButton jbtFirst;
	private JLabel jLabel9;
	private JButton jbtNext;
	private JLabel jLabel8;
	private JPanel jpAddress;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JTextField jtfTelephone;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JButton jbtDelete;

	private RowSet rowSet = new JdbcRowSetImpl();	// Row set
	private int currentRowNumber;		// Current row number

	/** CONSTRUCTOR */
	public Exercise38_2() {
		initComponents();
		initializeDB();		// Connect to database, create statement, get result set
	}

	/*******************************************************************************
	 * 	
	 *  				WARNING: Do NOT modify this code. 
	 *	This method is called from within the constructor to initialize the form.
	 *  The content of this method is always regenerated by the Form Editor.
	 *  
	 *******************************************************************************/

	private void initComponents() {
		jPanel1 = new JPanel();
		jbtFirst = new JButton();
		jbtNext = new JButton();
		jbtPrior = new JButton();
		jbtLast = new JButton();
		jbtInsert = new JButton();
		jbtDelete = new JButton();
		jbtUpdate = new JButton();
		jlblStatus = new JLabel();
		jpAddress = new JPanel();
		jPanel2 = new JPanel();
		jLabel1 = new JLabel();
		jtfFirstName = new JTextField();
		jLabel2 = new JLabel();
		jtfMI = new JTextField();
		jLabel3 = new JLabel();
		jtfLastName = new JTextField();
		jPanel3 = new JPanel();
		jLabel4 = new JLabel();
		jtfStreet = new JTextField();
		jPanel4 = new JPanel();
		jLabel5 = new JLabel();
		jtfCity = new JTextField();
		jLabel6 = new JLabel();
		jtfState = new JTextField();
		jLabel7 = new JLabel();
		jtfZip = new JTextField();
		jPanel5 = new JPanel();
		jLabel8 = new JLabel();
		jtfTelephone = new JTextField();
		jPanel6 = new JPanel();
		jLabel9 = new JLabel();
		jtfEmail = new JTextField();
		jbtFirst.setText("First");
		jbtFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtFirstActionPerformed(e);
			}
		});
		jPanel1.add(jbtFirst);
		jbtNext.setText("Next");
		jbtNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtNextActionPerformed(e);
			}
		});
		jPanel1.add(jbtNext);
		jbtPrior.setText("Prior");
		jPanel1.add(jbtPrior);
		jbtLast.setText("Last");
		jbtLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtLastActionPerformed(e);
			}
		});
		jPanel1.add(jbtLast);
		jbtInsert.setText("Insert");
		jbtInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtInsertActionPerformed(e);
			}
		});
		jPanel1.add(jbtInsert);
		jbtDelete.setText("Delete");
		jbtDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtDeleteActionPerformed(e);
			}
		});
		jPanel1.add(jbtDelete);
		jbtUpdate.setText("Update");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtUpdateActionPerformed(e);
			}
		});
		jPanel1.add(jbtUpdate);
		add(jPanel1, BorderLayout.NORTH);
		//jlblStatus.setText("jLabel1");  <-- Might add back in
		add(jlblStatus, BorderLayout.SOUTH);
		jpAddress.setLayout(new GridLayout(5, 0));
		jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jLabel1.setText("First Name");
		jPanel2.add(jLabel1);
		jtfFirstName.setColumns(10);
		jPanel2.add(jtfFirstName);
		jLabel2.setText("MI");
		jPanel2.add(jLabel2);
		jtfMI.setColumns(2);
		jPanel2.add(jtfMI);
		jLabel3.setText("Last Name");
		jPanel2.add(jLabel3);
		jtfLastName.setColumns(15);
		jPanel2.add(jtfLastName);
		jpAddress.add(jPanel2);
		jPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jLabel4.setText("Street");
		jPanel3.add(jLabel4);
		jtfStreet.setColumns(40);
		jPanel3.add(jtfStreet);
		jpAddress.add(jPanel3);
		jPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jLabel5.setText("City");
		jPanel4.add(jLabel5);
		jtfCity.setColumns(15);
		jPanel4.add(jtfCity);
		jLabel6.setText("State");
		jPanel4.add(jLabel6);
		jtfState.setColumns(2);
		jPanel4.add(jtfState);
		jLabel7.setText("ZIP");
		jPanel4.add(jLabel7);
		jtfZip.setColumns(5);
		jPanel4.add(jtfZip);
		jpAddress.add(jPanel4);
		jPanel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		jLabel8.setText("Telephone");
		jPanel5.add(jLabel8);
		jtfTelephone.setColumns(12);
		jPanel5.add(jtfTelephone);
		jpAddress.add(jPanel5);
		jPanel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		jLabel9.setText("Email");
		jPanel6.add(jLabel9);
		jtfEmail.setColumns(25);
		jPanel6.add(jtfEmail);
		jpAddress.add(jPanel6);
		add(jpAddress, BorderLayout.CENTER);
	}
	private void jbtUpdateActionPerformed(ActionEvent e) {
		try {
			updateRecord();			// Update fields in the current row
			rowSet.updateRow();		// Invoke the update method in the result set
		} catch (Exception ex) {
			jlblStatus.setText(ex.toString());
		}
	}
	private void jbtDeleteActionPerformed(ActionEvent e) {
		try {
			rowSet.deleteRow();
			jlblStatus.setText("Deletion succeeded");
		} catch (Exception ex) {
			jlblStatus.setText(ex.toString());
		}
	}
	private void jbtInsertActionPerformed(ActionEvent e) {
		try {
			insert();
			jlblStatus.setText("Insertion succeeded");
		} catch (SQLException ex) {
			jlblStatus.setText(ex.getMessage());
		}
	}
	private void jbtLastActionPerformed(ActionEvent e) {
		try {
			if ( rowSet.isFirst() )
				jlblStatus.setText("This is already the first row");
			else {
				rowSet.previous();
				showRecord();
			}
		} catch (Exception ex) {
			jlblStatus.setText(ex.toString());
		}
	}
	private void jbtNextActionPerformed(ActionEvent e) {
		try {
			if ( rowSet.isLast() )
				jlblStatus.setText("This is already the last row");
			else {
				rowSet.next();
				showRecord();
			}
		}
		catch (Exception ex) {
			jlblStatus.setText(ex.toString());
		}
	}
	private void jbtFirstActionPerformed(ActionEvent e) {
		try {
			rowSet.first();
			if ( rowSet.first() )
				showRecord();
			else
				jlblStatus.setText("There is no row in the result set");
		} catch (Exception ex) {
			
			jlblStatus.setText(ex.toString());
		}
	}
	private void initializeDB() {
		// Initialize the database connection, create statement, & result set
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			rowSet.setUrl("jdbc:mysql://localhost/javabook");
			rowSet.setUsername("scott");
			rowSet.setPassword("tiger");
			System.out.println("Database connected");
			rowSet.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
			rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			rowSet.setCommand("SELECT * FROM Address");
			rowSet.execute();
			rowSet.next();
					
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void showRecord() throws Exception {
		jtfFirstName.setText(rowSet.getString("firstName"));
		jtfLastName.setText(rowSet.getString("lastName"));
		jtfMI.setText(rowSet.getString("mi"));
		jtfStreet.setText(rowSet.getString("Street"));
		jtfCity.setText(rowSet.getString("City"));
		jtfState.setText(rowSet.getString("State"));
		jtfTelephone.setText(rowSet.getString("Telephone"));
		jtfZip.setText(rowSet.getString("zip"));
		jtfEmail.setText(rowSet.getString("email"));

		currentRowNumber = rowSet.getRow();
		jlblStatus.setText("Current row number: " + currentRowNumber);
	}
	public static void main(String[] args) {
		Exercise38_2 applet = new Exercise38_2();
		JFrame frame = new JFrame();
		frame.setTitle("Exercise38_2");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	protected void insert() throws SQLException {
		// Insert a new record into the database
		updateRecord();				// Update the fields
		rowSet.insertRow();			// Insert the row
		rowSet.moveToCurrentRow();	// Move the cursor back to the position before the insertion
	}
	protected void updateRecord() throws SQLException {
		// Update fields in the record
		// Gather data from the UI and update the database fields
		rowSet.updateString("firstName", jtfFirstName.getText().trim());
		rowSet.updateString("MI", jtfMI.getText().trim());
		rowSet.updateString("lastName", jtfLastName.getText().trim());
		rowSet.updateString("Street", jtfStreet.getText().trim());
		rowSet.updateString("City", jtfCity.getText().trim());
		rowSet.updateString("zip", jtfZip.getText().trim());
		rowSet.updateString("Telephone", jtfTelephone.getText().trim());
		rowSet.updateString("email", jtfEmail.getText().trim());
	}
}