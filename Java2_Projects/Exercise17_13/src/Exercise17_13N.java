//Naomi Crosby - September 10, 2012 - Java 2 
//Homework due 9/10/2012 (found on page 610)
// Resubmitted on 9/17/2012 2am

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Exercise17_13N extends JFrame implements ActionListener {

	// Class level GUI variables (available to this class only)
	private JTextField jtfLoanAmount = new JTextField(15);
	private JTextField jtfNumberOfYears = new JTextField(3);
	private JTextArea jta = new JTextArea(5, 30);
	private JButton jbtShowTable = new JButton("Show Table");

	// User input OR needed calculation variables
	double annualInterestRate = 5.0, totalPayment;
	double monthlyInterestRate, monthlyPayment, numberOfYears;
	double loanAmount;

	// Table strings declared
	String header = "Interest Rate \tMonthly Payment \tTotal Payment \n"; 
	String payments = "";
	String nextLine = "";
	NumberFormat decimalFormat = new DecimalFormat("##,###.00");

	public static void main(String[] args) {
		Exercise17_13N frame = new Exercise17_13N();
		frame.setTitle("Exercise 17.13");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Constructor
	public Exercise17_13N() {
		// Create the panel for the top Text Fields & Button, etc.
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		p1.add(new JLabel("Loan Amount:"));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("Number of Years:"));
		p1.add(jtfNumberOfYears);
		p1.add(jbtShowTable);
		add(p1);

		// Create the scroll pane for the text area pane
		JScrollPane scrollPane = new JScrollPane(jta);		
		scrollPane.setPreferredSize(new Dimension(600, 325));
		add(scrollPane, BorderLayout.SOUTH);

		// Fine tune the Text Fields
		jtfLoanAmount.setHorizontalAlignment(JTextField.RIGHT);
		jtfNumberOfYears.setHorizontalAlignment(JTextField.RIGHT);

		// Button Action Listener Registered
		jbtShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean isValid = true;
				String inputLoanAmount = jtfLoanAmount.getText();
				String inputNumberOfYears = jtfNumberOfYears.getText();
				
				// Testing input for Loan Amount
				try {
					Double.parseDouble(inputLoanAmount);
					// Testing input for Number of Years
					try {
						Double.parseDouble(inputNumberOfYears);
					}
					catch (NumberFormatException ex) {
						isValid = false;
						JOptionPane.showMessageDialog(null, "WARNING: Incorrect input, please enter a number into the Number of Years.");
						jtfNumberOfYears.setText(null);
						jtfNumberOfYears.requestFocus();
					}
				}
				catch (NumberFormatException ex) {
					isValid = false;
					JOptionPane.showMessageDialog(null, "WARNING: Incorrect input, please enter a number into the Loan Amount.");
					jtfLoanAmount.setText(null);
					jtfLoanAmount.requestFocus();
				}
				
				if (isValid) {
					// Loop for interest rate 5-8%
					while(annualInterestRate <= 8.0) {
						// Get user input after "show" button is clicked
						loanAmount = new Double (jtfLoanAmount.getText()).doubleValue();
						numberOfYears = new Double (jtfNumberOfYears.getText()).doubleValue();

						// Calculate info needed for table
						monthlyInterestRate = annualInterestRate / 1200;
						monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
						totalPayment = monthlyPayment * numberOfYears * 12;
						
						// The next line needs to be formatted to show monthlyPayment & totalPayment with only 2 digits after decimal
						nextLine = annualInterestRate + "%\t$" + decimalFormat.format(monthlyPayment) + "\t\t$" + decimalFormat.format(totalPayment) + "\n";
						payments = payments + nextLine;
						annualInterestRate = annualInterestRate + .125;
					}
					jta.setText(header + payments);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}