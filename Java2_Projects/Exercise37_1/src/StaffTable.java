// Naomi Crosby
/* ---------------------------------------------------------------------------------
 *		Chapter 37 Assignment: Due 11/19/2012
 *		Program 37.1 on pages 1305 – 1306
 *		You can create the Staff table using a SQL statement from within 
 *		MySQL (i.e. you don’t need to do it from within your Java program). 
 *		Use the java book database. 
 *
 *		(Accessing and updating a Staff table) Write a Java Applet that views,
 *		inserts, and updates staff information stored in a database, as shown
 *		in Figure 37.25(a). The View button displays a record with a specified ID. 
 *		The Staff table is created as follows:
 *		
 *		create table Staff (
 *			id char(9) not null,
 *			lastName varchar(15),
 *			firstName varchar(15),
 *			mi char(1),
 *			address varchar(20),
 *			city varchar(20),
 *			state char(2),
 *			telephone char(10),
 *			email varchar(40),
 *			primary key (id)
 *		);
 *
 * --------------------------------------------------------------------------------- */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class StaffTable extends JApplet {

	private JButton jbtView = new JButton("View");
	private JButton jbtInsert = new JButton("Insert");
	private JButton jbtUpdate = new JButton("Update");
	private JButton jbtClear = new JButton("Clear");

	private JTextField jtfID = new JTextField(9);
	private JTextField jtfLastName = new JTextField(15);
	private JTextField jtfFirstName = new JTextField(15);
	private JTextField jtfMI = new JTextField(1);
	private JTextField jtfAddress = new JTextField(20);
	private JTextField jtfCity = new JTextField(20);
	private JTextField jtfState = new JTextField(2);
	private JTextField jtfTelephone = new JTextField(10);  // 2 digits for the dashes
	private JTextField jtfEmail = new JTextField(30);

	private JLabel jlblDatabaseStatus = new JLabel("Database is not connected");

	// Create panels with Flow Layout to keep like info together
	private JPanel jpIdInfo = new JPanel();
	private JPanel jpNameInfo = new JPanel();
	private JPanel jpAddressInfo = new JPanel();
	private JPanel jpContactInfo = new JPanel();
	private JPanel jpDataContents = new JPanel();
	private JPanel jpButtons = new JPanel();
	private JPanel jpCenter = new JPanel();
	private JPanel jpDataConnectionStatus = new JPanel();

	private PreparedStatement preparedStatement;
	private Connection connection;
	private Statement statement;
	private ResultSet viewResultSet;
	private ResultSetMetaData metadata;

	public static void main(String[] args) {
		StaffTable applet = new StaffTable();
		JFrame frame = new JFrame();
		frame.setTitle("Exercise 37.1: Staff Table");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		frame.setSize(640, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void init() {
		setSize(640, 245);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
			System.out.println("Connection made");
			jlblDatabaseStatus.setForeground(Color.BLACK);
			jpDataConnectionStatus.setBackground(Color.GREEN);
			jlblDatabaseStatus.setText("Database has been connected");
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void stop() {
		try {
			connection.close();
			jlblDatabaseStatus.setForeground(Color.WHITE);
			jpDataConnectionStatus.setBackground(Color.RED);
			jlblDatabaseStatus.setText("Database has been disconnected");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public StaffTable() {
		jpIdInfo.setBackground(Color.WHITE);
		jpNameInfo.setBackground(Color.WHITE);
		jpAddressInfo.setBackground(Color.WHITE);
		jpContactInfo.setBackground(Color.WHITE);
		jpButtons.setBackground(Color.WHITE);
		jpDataContents.setBackground(Color.WHITE);
		jpDataContents.setLayout(new GridLayout(5, 0));
		jpDataContents.setBorder(new TitledBorder("  Staff Information  "));

		jpIdInfo.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		jpIdInfo.add(new JLabel("ID"));
		jpIdInfo.add(jtfID);
		jpDataContents.add(jpIdInfo);

		jpNameInfo.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		jpNameInfo.add(new JLabel("Last Name"));
		jpNameInfo.add(jtfLastName);
		jpNameInfo.add(new JLabel("First Name"));
		jpNameInfo.add(jtfFirstName);
		jpNameInfo.add(new JLabel("MI"));
		jpNameInfo.add(jtfMI);
		jpDataContents.add(jpNameInfo);

		jpAddressInfo.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		jpAddressInfo.add(new JLabel("Address"));
		jpAddressInfo.add(jtfAddress);
		jpAddressInfo.add(new JLabel("City"));
		jpAddressInfo.add(jtfCity);
		jpAddressInfo.add(new JLabel("State"));
		jpAddressInfo.add(jtfState);
		jpDataContents.add(jpAddressInfo);

		jpContactInfo.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		jpContactInfo.add(new JLabel("Telephone"));
		jpContactInfo.add(jtfTelephone);
		jpContactInfo.add(new JLabel("Email"));
		jpContactInfo.add(jtfEmail);
		jpDataContents.add(jpContactInfo);

		jbtView.setBackground(Color.LIGHT_GRAY);
		jbtInsert.setBackground(Color.LIGHT_GRAY);
		jbtUpdate.setBackground(Color.LIGHT_GRAY);
		jbtClear.setBackground(Color.LIGHT_GRAY);
		jpButtons.add(jbtView);
		jpButtons.add(jbtInsert);
		jpButtons.add(jbtUpdate);
		jpButtons.add(jbtClear);

		jpCenter.setLayout(new BorderLayout());
		jpCenter.add(jpDataContents, BorderLayout.CENTER);
		jpCenter.add(jpButtons, BorderLayout.SOUTH);
		add(jpCenter, BorderLayout.CENTER);


		jlblDatabaseStatus.setForeground(Color.WHITE);
		jpDataConnectionStatus.setBackground(Color.RED);
		jpDataConnectionStatus.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 5));
		jpDataConnectionStatus.add(jlblDatabaseStatus);
		add(jpDataConnectionStatus, BorderLayout.SOUTH);

		jbtView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String viewQuery = "SELECT * " + 
							"FROM Staff " +
							"WHERE ID = ? ";
					preparedStatement = connection.prepareStatement(viewQuery);
					preparedStatement.setString(1, jtfID.getText() );
					viewResultSet = preparedStatement.executeQuery();
					while ( viewResultSet.next() ) {
						jtfID.setText(viewResultSet.getString(1));
						jtfLastName.setText(viewResultSet.getString(2));
						jtfFirstName.setText(viewResultSet.getString(3));
						jtfMI.setText(viewResultSet.getString(4));
						jtfAddress.setText(viewResultSet.getString(5));
						jtfCity.setText(viewResultSet.getString(6));
						jtfState.setText(viewResultSet.getString(7));
						jtfTelephone.setText(viewResultSet.getString(8));
						jtfEmail.setText(viewResultSet.getString(9));
					}
					
					/* // was using this to print to console - the full table
					   // No longer using
					 * preparedStatement = connection.prepareStatement(viewQuery);
					preparedStatement.setString(1, jtfID.getText() );
					ResultSet viewResultSet = preparedStatement.executeQuery();
					// Column Headings to console
					ResultSetMetaData metadata = viewResultSet.getMetaData();
					for (int count = 1; count <= metadata.getColumnCount(); count++) {
						System.out.print(metadata.getColumnName(count) + "\t");
					}
					System.out.println();
					// Table data loaded to console
					while ( viewResultSet.next() ) {
						System.out.println( viewResultSet.getString(1) + "\t" + 
								viewResultSet.getString(2) + "\t" +
								viewResultSet.getString(3) + "\t" +
								viewResultSet.getString(4) + "\t" +
								viewResultSet.getString(5) + "\t" +
								viewResultSet.getString(6) + "\t" +
								viewResultSet.getString(7) + "\t" +
								viewResultSet.getString(8) + "\t" +
								viewResultSet.getString(9) );
					} */

					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.LIGHT_GRAY);
					jlblDatabaseStatus.setText("Query results are ready");

					/*// Moved into Applet stop method
					 * connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");*/

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jbtInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String insertString = "INSERT INTO Staff ( ID, lastName, firstName, MI, address, city, state, telephone, email ) " + 
							"VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

					preparedStatement = connection.prepareStatement(insertString);
					preparedStatement.setString(1, jtfID.getText() );
					preparedStatement.setString(2, jtfLastName.getText() );
					preparedStatement.setString(3, jtfFirstName.getText() );
					preparedStatement.setString(4, jtfMI.getText() );
					preparedStatement.setString(5, jtfAddress.getText() );
					preparedStatement.setString(6, jtfCity.getText() );
					preparedStatement.setString(7, jtfState.getText() );
					preparedStatement.setString(8, jtfTelephone.getText() );
					preparedStatement.setString(9, jtfEmail.getText() );

					int insertStatement = preparedStatement.executeUpdate();
					if ( insertStatement == 1 ) {
						jlblDatabaseStatus.setForeground(Color.BLACK);
						jpDataConnectionStatus.setBackground(Color.LIGHT_GRAY);
						jlblDatabaseStatus.setText("Insert has been completed");
						System.out.println("Insert has been completed. To view new data click \"View\" button");
						clearTextFields();
					} else {
						jlblDatabaseStatus.setText("Data was not inserted. Please try again.");
						System.out.println("Data was not inserted. Please try again.");
					}
					/*connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");*/
				} catch (SQLException e1) {
					jlblDatabaseStatus.setText("ID value already in use, please try again.");
					System.out.println("ID value already in use, please try again.");
					
				}
			}
		});
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// add the update SQL string here
					String updateString = "UPDATE Staff " + 
							"SET lastName = ?, firstName = ?, MI = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? " +
							"WHERE ID = " + jtfID.getText();

					preparedStatement = connection.prepareStatement(updateString);
					preparedStatement.setString(1, jtfLastName.getText() );
					preparedStatement.setString(2, jtfFirstName.getText() );
					preparedStatement.setString(3, jtfMI.getText() );
					preparedStatement.setString(4, jtfAddress.getText() );
					preparedStatement.setString(5, jtfCity.getText() );
					preparedStatement.setString(6, jtfState.getText() );
					preparedStatement.setString(7, jtfTelephone.getText() );
					preparedStatement.setString(8, jtfEmail.getText() );

					preparedStatement.executeUpdate();
					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.LIGHT_GRAY);
					jlblDatabaseStatus.setText("Update has been completed");
					System.out.println("Update has been completed. To view new data click \"View\" button");
					clearTextFields();
					/*connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");*/
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jbtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextFields();
				jlblDatabaseStatus.setText("Ready for next command");
			}
		});
	}  // Closing Constructor
	
	public void clearTextFields() {
		jlblDatabaseStatus.setForeground(Color.BLACK);
		jpDataConnectionStatus.setBackground(Color.LIGHT_GRAY);
		
		jtfID.setText("");
		jtfLastName.setText("");
		jtfFirstName.setText("");
		jtfMI.setText("");
		jtfAddress.setText("");
		jtfCity.setText("");
		jtfState.setText("");
		jtfTelephone.setText("");
		jtfEmail.setText("");
	}
	
}  // Closing StaffTable Class
