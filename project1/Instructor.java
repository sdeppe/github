package project1;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Title: Course.java
 * Abstract: creates Instructor objects, and contains all of the functions to change and call them
 * Name: Shawn Deppe
 * Date: 10-10-2018
 */

public class Instructor {
	private int employeeNumber;
	private String instructorName;
	private String instructorEmail;
	private String phoneNumber;
	private HashMap<Integer, Integer> courses = new HashMap<Integer, Integer>();  // classNum, students
	
	public Instructor(int employeeNumber, String instructorName, String instructorEmail, String phoneNumber) {
		this.employeeNumber = employeeNumber;
		this.instructorName = instructorName;
		this.instructorEmail = instructorEmail;
		this.phoneNumber = phoneNumber;
		this.courses = new HashMap<Integer, Integer>();
	}
	
	public String toString() {
		String result;
		result = ("Instructor Number: " + this.employeeNumber + "\n" 
				+ "Name: " + this.instructorName + "\n"
				+"Courses Teaching: \n");
		for (int key : courses.keySet()) {
			result += ("\t" + key + ": " + courses.get(key) + " enrolled\n");
		}
		return result;
	}
	
	public int getEmployeeNumber() {
		return this.employeeNumber;
	}
	public String getInstructorName() {
		return this.instructorName;
	}
	public String getInstructorEmail() {
		return this.instructorEmail;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void addCourse(int classNum, int num) {
		this.courses.put(classNum, num);
	}
}
