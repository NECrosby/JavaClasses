// Naomi Crosby - Java II - Chapter 20 Assignment 
// Exercise 20.25 Page 703 - Due 10/3/2012
// Started  9/26/2012 2:00pm -  3:30pm
//		    10/1/2012 1:30pm -

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

public class Exercise20_25 {
	private static String myString = "1234";
	static int numberOfCombinations = 0;
	
	public static void main(String[] args) {
		System.out.println("The starting string is: " + myString);
		
		displayPermutation("", myString);
		
		System.out.println("There are " + numberOfCombinations + " permutations using this string.");
	}
	
	public static void displayPermutation(String s1, String s2){  
		if (s2.length() <= 1){	// Base case
			System.out.println(s1 + s2);
			numberOfCombinations = numberOfCombinations + 1;
		} else {
			for (int i = 0; i < s2.length(); i++){
				try {
					String s3 = s2.substring(0, i) + s2.substring(i + 1);
					displayPermutation(s1 + s2.charAt(i), s3);
				} catch (StringIndexOutOfBoundsException ex){
					ex.printStackTrace();
				}
			}
		}
	}
}