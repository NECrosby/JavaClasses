
public class Fan_Naomi {
	/** Fan class variables */
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	final static int FAST = 3;
	private int speed = SLOW;
	private boolean  on = false;
	private double radius = 5;
	public String color = "blue";
	
	//No argument constructor
	Fan_Naomi (){

	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public boolean isOn(){
		return on;
	}
	
	public void setOn(boolean on){
		this.on = on;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	@Override
	public String toString(){
		if (on){
			return "The Fan is on and it's speed is " + speed + ". \rThe fan is " + color 
			+ ". \rThe fan radius is " + radius + ". ";
		} 
		else {
			return "The Fan is off. \rThe fan is " + color 
			+ ". \rThe fan radius is " + radius + ". ";
		}
	}

}
