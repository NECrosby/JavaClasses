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
import java.sql.Connection;
import java.sql.DriverManager;
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
	private JTextField jtfEmail = new JTextField(30);
	private JTextField jtfTelephone = new JTextField(12);  // 2 digits for the dashes

	private JLabel jlblDatabaseStatus = new JLabel("Database not connected");

	// Create panels with Flow Layout to keep like info together
	private JPanel jpIdInfo = new JPanel();
	private JPanel jpNameInfo = new JPanel();
	private JPanel jpAddressInfo = new JPanel();
	private JPanel jpContactInfo = new JPanel();
	private JPanel jpDataContents = new JPanel();
	private JPanel jpButtons = new JPanel();
	private JPanel jpCenter = new JPanel();
	private JPanel jpDataConnectionStatus = new JPanel();
	
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
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
					System.out.println("Connection made");
					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.GREEN);
					jlblDatabaseStatus.setText("Database has been connected");
					
					Statement statement = connection.createStatement();
										
					connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jbtInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
					System.out.println("Connection made");
					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.GREEN);
					jlblDatabaseStatus.setText("Database has been connected");
					
					Statement statement = connection.createStatement();
										
					connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
					System.out.println("Connection made");
					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.GREEN);
					jlblDatabaseStatus.setText("Database has been connected");
					
					Statement statement = connection.createStatement();
										
					connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jbtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
					System.out.println("Connection made");
					jlblDatabaseStatus.setForeground(Color.BLACK);
					jpDataConnectionStatus.setBackground(Color.GREEN);
					jlblDatabaseStatus.setText("Database has been connected");
					
					Statement statement = connection.createStatement();
										
					connection.close();
					jlblDatabaseStatus.setForeground(Color.WHITE);
					jpDataConnectionStatus.setBackground(Color.RED);
					jlblDatabaseStatus.setText("Database has been disconnected");
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}  // Closing Constructor
}  // Closing StaffTable Class
