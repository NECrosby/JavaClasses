// Naomi Crosby - Java II - Chapter 20 Assignment 
// Exercise 20.25 Page 703 - Due 10/3/2012

/* *********************************************************************************\	
|  	Hints:																			|
|		This is actually a short program. In your main method, invoke the first 	|
|		displayPermutation method passing to it a string. You can just hard code 	|
|		the string (meaning you don’t need to get the string from the user)			|
| 																					|
|		Hint: Define the following 2 methods. The second is a helper method.		|
|		public static void displayPermutation(String s)								|
|		public static void displayPermutation(String s1, String s2)					|
|																					|
| 		1) The first method simply invokes displayPermutation("", s).				|
|		2) The second method uses a loop to move a character from s2 to s1 and 		|
|		   recursively invoke it with a new s1 and s2								|
|		3) The base case is that s2 is empty and prints s1 to the console.			|
\***********************************************************************************/

public class StringPermutation {
	static String myString = "live";
	static int numberOfCombinations = 0;

	public static void displayPermutation(String s){
		displayPermutation("", s);
	}

	public static void displayPermutation(String newString, String myString){  
		// 			   displayPermutation(String s1, String s2)
		// s1 - new string of s2 after the char are shuffled
		// s2 - will shorten after all combos have completed by using substring
		if (myString.length() <= 1){	// Base case
			numberOfCombinations++;
			System.out.print("Version " + numberOfCombinations + ": ");
			System.out.println(newString + myString);
		} else {
			// Moving chars around here - Chapter 9: Strings & Text I/O P302
			// loop to shuffle characters 
			for (int i = 0; i < myString.length(); i++){
				try {
					// tempString is a holder for the 2 substrings needed from the original string
					// i = the "charAt" to stop at for the first substring
					// i = the "charAt" to start at for the second substring
					// then concatenate them to get the tempString
					String tempString = myString.substring(0, i) + myString.substring(i + 1);
					// Here is the recursive call - newString is empty and concat. with charAt my original string
					displayPermutation(newString + myString.charAt(i), tempString);
				} catch (StringIndexOutOfBoundsException ex){
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("The starting string is: " + myString + " \r");
		displayPermutation(myString);
		System.out.println("\rThere are " + numberOfCombinations + " permutations using the string: \"" + myString.toUpperCase() + "\"");
		System.out.println("This string contains " + myString.length() + " characters.");
	}
}
