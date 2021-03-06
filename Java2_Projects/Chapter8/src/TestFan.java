
public class TestFan {

	/** Main method */
	public static void main(String[] args) {
		//Create two new fans
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		//Setting the first fan to maximum speed (3), Radius of 10, and color of yellow.
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);   //This fan should be on
		
		System.out.println();
		System.out.println("The first fan is: \r\t");
		System.out.println(fan1.toString());//Print the fan1 information
		
		//Setting the second fan to medium speed (2), Radius of 5, and color of blue.
		fan2.setSpeed(Fan.MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.isOn(); //This fan should be off.
		
		System.out.println();
		System.out.println("The second fan is: \r\t");
		System.out.println(fan2.toString());//Print the fan2 information
	}

}
