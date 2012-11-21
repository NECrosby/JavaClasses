import javax.swing.JButton;
import javax.swing.JTextField;

// Naomi Crosby
// Exercise 38.2 Due November 26

/* ******************************************************************
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

public class ScrollableTable {
	private JButton jbtFirst = new JButton("First");
	private JButton jbtNext = new JButton("Next");
	private JButton jbtPrior = new JButton("Prior");
	private JButton jbtLast = new JButton("Last");
	private JButton jbtInsert = new JButton("Insert");
	private JButton jbtDelete = new JButton("Delete");
	private JButton jbtUpdate = new JButton("Update");
	
	private JTextField jtfFirstName = new JTextField();
	private JTextField jtfMI = new JTextField();
	private JTextField jtfLastName = new JTextField();
	private JTextField jtfStreet = new JTextField();
	private JTextField jtfCity = new JTextField();
	private JTextField jtfState = new JTextField();
	private JTextField jtfZip = new JTextField();
	private JTextField jtfTelephone = new JTextField();
	private JTextField jtfEmail = new JTextField();
	

	public static void main(String[] args) {
		
	}

}
