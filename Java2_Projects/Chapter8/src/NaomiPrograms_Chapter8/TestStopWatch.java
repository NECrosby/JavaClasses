package NaomiPrograms_Chapter8;

import java.util.Random;

public class TestStopWatch {

	public static void main(String[] args) {
		final int NUM_OF_ELEMENTS = 10000;
		StopWatch myStopWatch = new StopWatch();  // instantiating stop watch
		int[] myArray = new int[NUM_OF_ELEMENTS];  // instantiating array
		int[] temp; // sorted array
		Random number = new Random();    // instantiating random number
		SelectionSort sortedArray = new SelectionSort();  // instantiating a selection sort 

		// Loading Random integers into myArray
		for (int i = 0; i < NUM_OF_ELEMENTS - 1; i++){
			myArray[i] = number.nextInt(100);
		}

		System.out.println("This is the initial array, prior to sorting: "); 

		// Printing the first array
		for (int i = 0; i < myArray.length; i++){
			if ((i + 1) % 100 == 0){
				if (myArray[i] >= 10) {
					System.out.println(" " + myArray[i]); // formatting column spacing
				} else {
					System.out.println("  " + myArray[i]); // formatting column spacing
				}
			} else {
				if (myArray[i] >= 10) {
					System.out.print(" " + myArray[i]); // formatting column spacing
				} else {
					System.out.print("  " + myArray[i]); // formatting column spacing
				}
			}
		}

		myStopWatch.start();  // Starting stop watch
		temp = sortedArray.selectionSort(myArray);  // Selection sort below
		myStopWatch.stop();  // stopping stop watch

		// reload the sorted array into myArray
		for (int i = 0; i < NUM_OF_ELEMENTS - 1; i++){
			myArray[i] = temp[i];
		}

		System.out.println("\nThis is the array after sorting has taken place: ");

		// display on console sorted array
		for (int i = 0; i < myArray.length; i++){
			if ((i + 1) % 100 == 0){
				if (myArray[i] >= 10) {
					System.out.println(" " + myArray[i]); // formatting column spacing
				} else {
					System.out.println("  " + myArray[i]); // formatting column spacing
				}
			} else {
				if (myArray[i] >= 10) {
					System.out.print(" " + myArray[i]); // formatting column spacing
				} else {
					System.out.print("  " + myArray[i]); // formatting column spacing
				}
			}
		}
		
		System.out.println("\nMyArray contains " + myArray.length + " elements.\n");  // Printing how many elements in array
		System.out.println("Started: " + myStopWatch.getStartTime());
		System.out.println("Stopped: " + myStopWatch.getStopTime());
		System.out.println(myStopWatch.toString());
	}

}
