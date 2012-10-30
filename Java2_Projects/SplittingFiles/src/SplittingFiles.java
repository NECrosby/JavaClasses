import java.io.*;

import javax.swing.JOptionPane;

public class SplittingFiles {

   public static void main(String[] args) throws Exception {

      String fileName = JOptionPane.showInputDialog(null,"Enter the location of the file you want to split.");

      String numberOfFiles = JOptionPane.showInputDialog(null, "How many files would you like to split it into?");

      BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(fileName)));                 
      int numberOfPieces = Integer.parseInt(numberOfFiles);
      JOptionPane.showMessageDialog(null, "The original file size was successfully split into " + numberOfFiles + " files.");
      long fileSize = input.available();
      int splitFileSize = (int)
         Math.ceil(1.0 * fileSize / numberOfPieces);
      for (int i = 1; i <= numberOfPieces; i++) {
         BufferedOutputStream output = new BufferedOutputStream(
            new FileOutputStream(new File(fileName + "." + i)));
         int value;
         int count = 0;
       while (count++ < splitFileSize && (value = input.read()) != -1) {
            output.write(value);
         }
         output.close();
      }
      input.close();
   }
}
