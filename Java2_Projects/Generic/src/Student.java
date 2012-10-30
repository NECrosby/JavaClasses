


public class Student implements Comparable <Student> {
	private Double gpa; 
	private String lastName;
	private String firstName;
	
	public Student(String l, String f, double g) {
		lastName = l;
		firstName = f;
		gpa = g;
	}
	
	public void setLastName(String l) {
		lastName = l;
	}
	public void setFirstName(String f) {
		firstName = f;
	}
	public void setGpa(double g) {
		gpa = g;
	}
	public double getGpa() {
		return gpa;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	// public class Student implements Comparable <Student> { <-- need to implement the Comparable Interface in the class header
	public int compareTo(Student s) {
		int result;
		if (this.gpa > s.getGpa()) {
			result = 1;
		} else if (this.gpa > s.getGpa()) {
			result = -1;
		} else {
			result = 0;
		}
		return result;
	}
	
	public String toString() {
		String studentString;
		studentString = firstName + " " + lastName;
		return studentString;
	}
}
