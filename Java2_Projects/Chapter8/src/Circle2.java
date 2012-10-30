
public class Circle2 {
	/** radius of the circle */
	double radius;
	
	/**number of objects created */
	static int numberOfObjects = 0;
	
	/** construct a circle with a radius of 1.0 */
	Circle2() {
		radius = 1.0;
		numberOfObjects++;
	}
	
	/** construct a cirlce with a specific radius */
	Circle2(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}
	
	/**return number of objects */
	static int getNumberOfObjects() {
		return numberOfObjects;
	}
	
	/** return the area of this circle */
	double getArea() {
		return radius * radius * Math.PI;
	}
}
