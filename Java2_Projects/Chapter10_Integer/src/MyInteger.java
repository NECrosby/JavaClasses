
public class MyInteger {
	private int value = 0;
	
	public MyInteger() {
		
	}
	
	public MyInteger(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven(int x) { 
		return (x % 2) == 0;
	}
}
