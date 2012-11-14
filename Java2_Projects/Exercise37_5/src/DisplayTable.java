// Naomi Crosby

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

// Exercise 37.5
public class DisplayTable extends JApplet {
	
	private JTextField jtfTableName = new JTextField(10);
	private JTextArea jtaDataTable = new JTextArea();
	private JButton jbtShow = new JButton("Show Contents");
	private JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		DisplayTable applet = new DisplayTable();
		JFrame frame = new JFrame();
		frame.setTitle("Exercise 37.5: Display Table Data using a Button Event");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// Constructor
	public DisplayTable() {
		panel.add(new JLabel("Table Name: "));
		panel.add(jtfTableName);
		panel.add(jbtShow);
		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(jtaDataTable), BorderLayout.CENTER);
		
		jbtShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook" , "scott" , "tiger");
					System.out.println("Connection made");
					
					Statement statement = connection.createStatement();
					String tableName = jtfTableName.getText();
					String sql = "SELECT * FROM " + tableName;
					
					ResultSet results = statement.executeQuery(sql);
					ResultSetMetaData metadata = results.getMetaData();
					
					jtaDataTable.setText("");
					
					for (int count = 1; count <= metadata.getColumnCount(); count++) {
						jtaDataTable.append(metadata.getColumnName(count) + "\t");
					}
					
					jtaDataTable.append("\n"); // separate heading row from data contents
					
					while(results.next()) {
						// While loop will bring us to the next row
						// For loop will process the columns within the current row
						for (int count = 1; count <= metadata.getColumnCount(); count++) {
							jtaDataTable.append(results.getObject(count) + "\t");
						}
						jtaDataTable.append("\n");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}); // Closing ActionListener
	} // Closing Constructor
} // Closing Class
