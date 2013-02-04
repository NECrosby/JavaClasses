/* **************************************
 * 	
 * 	Naomi Crosby
 * 	Data Structures
 * 	In Class Lab - Chapter 3
 * 
 ************************************** */
public class Bag {

	private int elements = -1;
	private int[] content;

	/* --- Constructors --- */
	public Bag() {
		elements = 0;
		content = new int[10];
	}

	public Bag(int initialCapacity) {
		elements = 0;
		content = new int[initialCapacity];
	}

	/* --- Getters and Setters --- */
	public int getElements() {
		return elements;
	}

	public void setElements(int elements) {
		this.elements = elements;
	}

	public int[] getContent() {
		return content;
	}

	public void setContent(int[] content) {
		this.content = content;
	}

	/* --- Methods --- */
	public boolean add(int number) {
		int elements = this.elements;
		if ( elements <= content.length ) {
			content[elements] = number;
		} else {
			content[elements] = number;
		}
		
		return true;
	}

	public void addMany(int... numbers) {

		/*
		 * for (int i = 0; i < content.length; i++) {
		 * 	content[i] = number;
		 * 	element++;
		 * }
		 * 
		 */

	}
	
	public void remove(int target) {
		
		/*
		 *	When removing a value from the original data[] insert a "-1" value
		 *	
		 *	int[] data = {1, -1, 2, 3, 4};
		 *	elements = 5;
		 *	
		 *	Declare a temporary array
		 *	int[] temp = new int[5];
		 *	int tempIndex = 0;
		 *	
		 *	Loop through data[] to copy non -1 values
		 *	for (int i = 0; i < data.length; i++) {
		 *		if (data[i] != -1) {
		 *			temp[tempIndex] = data[i];
		 *			tempIndex++;
		 *		}
		 *	}
		 *	data = temp;
		 *
		 *	return found; <--- true
		 *	
		 */
		
	}

	/* --- Testing Purposes --- */
	public static void main(String[] args) {

		Bag myBag = new Bag();
		myBag.add(4);
		System.out.println(myBag);

		

	}

}
