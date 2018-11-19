package project1;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Title: Course.java
 * Abstract: creates Course objects, and contains all of the functions to change and call them
 * Name: Shawn Deppe
 * Date: 10-10-2018
 */

public class Course {
	private int courseNumber;
	private String courseTitle;
	private int courseCapacity;
	private String classLocation;
	private Integer totalEnrolled;
	private HashMap<Integer, Double> studentGrades = new HashMap<Integer, Double>();
	
	public Course() {
		this.courseNumber = 0;
		this.courseTitle = "Null";
		this.courseCapacity = 0;
		this.classLocation = "Null";
	}
	
	public Course(int courseNumber, String courseTitle, int courseCapacity, String classLocation) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.courseCapacity = courseCapacity;
		this.classLocation = classLocation;
		this.totalEnrolled = 0;
		this.studentGrades = new HashMap<Integer, Double>();
		
	}
	
	public String toString() {
		String result;
		result = (this.courseNumber + "  " 
				+ this.courseTitle + "  " 
				+ this.courseCapacity + "  " 
				+ this.classLocation);
		return result;
	}
	
	public void putScore(int i, int j, double d) {
		// TODO Auto-generated method stub
	}
	
	public int getCourseNumber() {
		return this.courseNumber;
	}
	public String getCourseTitle() {
		return this.courseTitle;
	}
	public int getCourseCapacity() {
		return this.courseCapacity;
	}
	public String getClassLocation() {
		return this.classLocation;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public void updateLocation(String location) {
		this.classLocation = location;
	}
	public void addEnr() {
		this.totalEnrolled += 1;
	}
	public void delEnr() {
		this.totalEnrolled -= 1;
	}
	public int getEnr() {
		return this.totalEnrolled;
	}
	public double getAverage(int course) {
		if (this.studentGrades.get(course) == null)
			return 0;
		else {
			return this.studentGrades.get(course);
		}
	}
	
}
