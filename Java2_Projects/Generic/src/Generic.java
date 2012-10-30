// Naomi Crosby - Chapter 21 October 3, 2012
// October 8, 2012

public class Generic<T> {

	public static void main(String[] args) {
		Integer[] myArray = {10, 12, 56, 98, 645, 20, 789};
		
		System.out.println("The max value in the array is: " + max(myArray));
		
		Double[] myDArray = {1.1, 5.9, 56.897, 56.8};
		System.out.println("The max value in the array is: " + max(myDArray));
		
		Student s1 = new Student("Smith", "Joe", 3.0);
		Student s2 = new Student("Anderson", "Bob", 3.5);
		Student s3 = new Student("Crosby", "Naomi", 4.0);
		Student[] students = {s1, s2, s3};
		
		System.out.println("The max GPA is " + max(students).getGpa());
		System.out.println("The max value in the array is: " + max(students).getGpa());
		
		Student acheiver = max(students);
		
		// System.out.println method automatically looks for the "toString" method to use.
		System.out.println("The max GPA is " + acheiver.getGpa() + " by student " + acheiver + ".\r");
		
		System.out.print("My Integer array is: ");
		printElements(myArray);
		System.out.print("\rMy Double array is: ");
		printElements(myDArray);
		System.out.print("\rMy Student array is: ");
		printElements(students);

	}
	
	// MAX method to work any type of Objects
	public static <T extends Comparable <T>> T max(T[] list){
		T maxValue = list[0];
		
		for (int i = 1; i < list.length; i++){
			
			/*	The below relational operator will not work because 
			 *	compiler doesn't know how to compare Objects to Objects.
			 *	So the Comparable Interface must be used.
			 *		!!!!!	extends Comparable <T>	!!!!!
			 *	Integer & Double Objects need to be used when declaring
			 *	and initializing the arrays within the Main method.
			 * 
			 *		if(list[i] > maxValue){
			 *				maxValue = list[i];
			 *		}
			 */
			
			if (list[i].compareTo(maxValue) > 0){
				maxValue = list[i];
			}
		}
		return maxValue;  // This method returns an Object
	}
	
	public static <T> void printElements(T[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}

}
