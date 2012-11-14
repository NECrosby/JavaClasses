import javax.swing.*;

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

public class StaffTable {
	
	private JButton jbtView = new JButton("View");
	private JButton jbtInsert = new JButton("Insert");
	private JButton jbtUpdate = new JButton("Update");
	private JButton jbtClear = new JButton("Clear");
	
	private JLabel jlblDatabaseStatus = new JLabel("Database not connected");

	public static void main(String[] args) {
		

	}
	
	public StaffTable() {
		
	}
}
