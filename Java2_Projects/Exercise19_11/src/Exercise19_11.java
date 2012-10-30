// Naomi Crosby - Java II - Chapter 19 Assignment 
// Exercise 19.11 P. 673 - Due	9/26/2012
// page 329 - Chapter  9 Strings & Text I/O
// page 661 - Chapter 19 Binary I/O

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* *********************************************************************************\	
|  	Hints:																			|
|		Under the D2L content, there’s a file named Exercise19_11.dat that you 		|
|		can use for splitting (keep in mind however that because it is a binary		|
|		file, you will not be able to verify the contents of the split). Using a	| 
|		larger file however may prove more beneficial.								| 
\***********************************************************************************/

@SuppressWarnings("serial")
public class Exercise19_11 extends JFrame {
	// Variables used for GUI build
	static JTextField jtfSourceFile = new JTextField(10);
	static JTextField jtfNumberOfTargetFile = new JTextField(10);
	static JButton jbtBrowse = new JButton("Browse");
	static JButton jbtStart = new JButton("Start");

	// Program data variables
	static String strSourceFileName = "";  // "Exercise19_11.dat";  + jtfSourceFile.getText()
	static String strTargetFile = "";	   // C:\\Users\\Owner\\Documents\\4_Fall 2012\\Java2\\Java2_Projects\\Exercise19_11\\temp.dat
	static String strTextAreaMessage = "\n\tWaiting for user input...";
	// String Builder here
	static JTextArea jtaDescription = new JTextArea(strTextAreaMessage);

	static Integer intNumberOfTargetFile = -1;  // Might not need this variable
	static Double dblNumberOfBytesInSourceFile = 0.0;

	// Building the GUI
	public Exercise19_11(){
		// Adding description of the program
		jtaDescription.setRows(3);
		jtaDescription.setEditable(false);
		jtaDescription.setLineWrap(true);
		jtaDescription.setWrapStyleWord(true);
		add(jtaDescription, BorderLayout.NORTH);

		// Creating and setting up user input panel
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("Enter or choose a file: "));
		p1.add(jtfSourceFile);
		p1.add(jbtBrowse);
		p1.add(new JLabel("Specify the number of smaller files: "));
		p1.add(jtfNumberOfTargetFile);
		add(p1, BorderLayout.CENTER);

		// Create the start button
		add(jbtStart, BorderLayout.SOUTH);
	}

	public static void main(String[] args) throws IOException {
		Exercise19_11 frame = new Exercise19_11();
		frame.setTitle("Exercise 19.11: Split a File");
		frame.setSize(350, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// setting the file name for the source file 
				// whether the browse button or user entered 
				if (strSourceFileName == ""){
					strSourceFileName = jtfSourceFile.getText();
				}
				final File sourceFile = new File(strSourceFileName);
				// Check to see if source file exists 
				if (!sourceFile.exists()){
					System.out.println("Source file " + strSourceFileName + " does not exist");
					// Show this is a dialog warning box - preference here only
				} else {    // Debugging only
					System.out.println("Source file found - " + strSourceFileName);
				}

				try {
					// Creating an input stream
					BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));

					// Read info from input and write it to output "Copying Data"
					dblNumberOfBytesInSourceFile = (double) sourceFile.length();
					intNumberOfTargetFile = Integer.parseInt(jtfNumberOfTargetFile.getText());
					// getting the byte value per new file after split
					int byteValue = (int)(Math.ceil(dblNumberOfBytesInSourceFile/intNumberOfTargetFile));
					int numberOfBytesCopied = 0;   // Used to tell us how many bytes were copied
					strTextAreaMessage = "If you split file < " + strSourceFileName + " > into " + 
							jtfNumberOfTargetFile.getText().toString() + " smaller files, the new " + jtfNumberOfTargetFile.getText().toString() + 
							" smaller files are: ";
					for (int i = 1; i <= intNumberOfTargetFile; i++){
						
						// Check to see if the target file exists 
						strTargetFile = "CopiedBytes" + i + ".dat";
						final File targetFile = new File(strTargetFile);
						if (targetFile.exists()){
							System.out.println("Target file " + strTargetFile + " already exists");
							// Show this is a dialog warning box - preference here only
						} 
						
						// Creating an output stream which
						BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(strTargetFile)));

						int r; int count = 0;
						while ( (count < byteValue) && (r = input.read()) != -1) {
							output.write((byte) byteValue);
							count++;
							numberOfBytesCopied++;
						}
						output.close();
						if (i == intNumberOfTargetFile) {
							strTextAreaMessage = strTextAreaMessage +  " " + targetFile.getName() + ".";
						} else {
							strTextAreaMessage = strTextAreaMessage +  " " + targetFile.getName() + " and";
						} 
					}
					
					System.out.println(numberOfBytesCopied + " bytes copied");
					jtaDescription.setText(strTextAreaMessage);
					input.close();									
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});

		jbtBrowse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser fileChooser = new JFileChooser("C:\\Users\\Owner\\Documents\\4_Fall 2012\\Java2\\Java2_Projects");
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					java.io.File sourceFile = fileChooser.getSelectedFile();
					jtfSourceFile.setText(sourceFile.getName());
				}
			}
		});
	}
}

/*
// ---------------- Debugging purposes only ---------------
// --------- Display Info acquired during copying --------- 
System.out.println(numberOfBytesCopied + " bytes copied"); // SysO then Ctrl Space - Quick key enter
if (targetFile.exists()){
	System.out.println("Copy Successful: Target file " + strTargetFile + " does exist");
	// Show this is a dialog warning box

}
targetFile.delete();
System.out.println("*** WARNING: NOW Target file: " + strTargetFile + " has been deleted");
// ^^^ ---------- Debugging purpose code above -------  ^^^
 */	
