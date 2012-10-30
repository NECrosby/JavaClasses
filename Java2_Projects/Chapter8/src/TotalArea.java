
public class TotalArea {
	/** Main Method	 */
	public static void main(String[] args) {
		// Declare circleArray
		Circle3[] circleArray;
		
		//Create CircleArray
		circleArray = createCircleArray();
		
		//Print circleArray and total areas of the circles
		printCircleArray(circleArray);
	}
	
	public static Circle3[] createCircleArray(){
		Circle3[] circleArray = new Circle3[5];
		
		for (int i = 0; i < circleArray.length; i++){
			circleArray[i] = new Circle3(Math.random() * 100);
		}
		
		//Return Circle Array
		return circleArray;
	}
	
	/** Print an array of circles and their totals area */
	public static void printCircleArray(Circle3[] circleArray){
		System.out.printf("%-30s%-15s\n", "Radius", "Area");
		for (int i = 0; i < circleArray.length; i++){
			System.out.printf("%-30f%-15f\n", circleArray[i].getRadius(), circleArray[i].getArea());
		}
		System.out.println("__________________________________________________");
		
		//Compute and display the results
		System.out.printf("%-30s%-15f\n", "The total area of circles is", sum(circleArray));
	}
	
	/** Add circles areas */
	public static double sum(Circle3[] circleArray){
		//Initialize sum
		double sum = 0;
		
		//Add areas of sum
		for (int i = 0; i < circleArray.length; i++){
			sum += circleArray[i].getArea();
		}
		
		return sum;
	}
}
