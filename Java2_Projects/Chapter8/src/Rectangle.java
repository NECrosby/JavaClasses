
public class Rectangle {
	
	private double width = 1;
	private double height = 1;
	
	Rectangle () {
		
	}
	
	Rectangle (Double myWidth, Double myHeight) {
		width = myWidth;
		height = myHeight;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea(Double w, Double h) {
		double areaValue = 0;
		areaValue = w * h;
		return areaValue;
	}
	
	public double getPerimeter(Double w, Double h) {
		double perimeterValue = 0;
		perimeterValue = (2 * w) + (2 * h);
		return perimeterValue;
	}
	
	public void printRectangle (){
		System.out.println("Width: " + this.getWidth() + " Height: " + this.getHeight());
		System.out.println("Area: " + this.getArea(this.getWidth(), this.getHeight()) ); 
		System.out.println("Perimeter: " + this.getPerimeter(this.getWidth(), this.getHeight()) ); 
	}
}
