
public class TestPassObject {
	//Main method
	public static void main(String[] args) {
		// create a Circle object with radius 1
		Circle3 myCircle = new Circle3(1);
		
		//print areas for radius 1, 2, 3, 4, 5
		int n = 5;
		printAreas(myCircle, n);
		
		//see myCircle.radius and times
		System.out.println("\n" + "Radius is " + myCircle.getRadius());
		System.out.println("n is " + n);
	}
	
	public static void printAreas(Circle3 c, int times) {
		System.out.println("Radius \t\tArea");
		while (times >= 1){
			System.out.println(c.getRadius() + "\t\t" + c.getArea());
			c.setRadius(c.getRadius() + 1);
			times--;
		}
	}
}
