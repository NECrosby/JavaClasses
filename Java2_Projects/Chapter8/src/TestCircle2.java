
public class TestCircle2 {
	/** Main Method	 */
	public static void main(String[] args) {
		System.out.println("Before creating objects");
		System.out.println("The number of Circle objects is " +
				Circle2.numberOfObjects);
		
		//create first circle
		Circle2 c1 = new Circle2();
		
		//Display c1 before c2 is created
		System.out.println("\nAfter creating c1");
		System.out.println("c1: radius (" + c1.radius +
				") and number of Circle objects (" +
				Circle2.numberOfObjects + ")");
		
		//create second circle
		Circle2 c2 = new Circle2(5);
		
		//modify c1
		c1.radius = 9;
		
		//Display c1 and c2 after c2 was created
		System.out.println("\nAfter creating c2 and modifying c1");
		System.out.println("c1: radius (" + c1.radius +
				") and number of Circle objects (" +
				Circle2.numberOfObjects + ")");
		System.out.println("c2: radius (" + c2.radius +
				") and number of Circle objects (" +
				Circle2.numberOfObjects + ")");
		

	}

}
