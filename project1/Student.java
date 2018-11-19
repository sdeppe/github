package project1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Title: Student.java
 * Abstract: creates student objects, and contains all of the functions to change and call them
 * Name: Shawn Deppe
 * Date: 10-10-2018
 */

public class Student {
	private int studentNumber;
	private String studentName;
	private HashMap<Integer, Double> coursesEnrolled = new HashMap<Integer, Double>();
	
	public Student() {
		this.studentNumber = 0;
		this.studentName = "Null";
		
	}
	
	public Student(int studentNumber, String studentName) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.coursesEnrolled = new HashMap<Integer, Double>();
	}
	
	public String toString() {
		String result;
		result = ("Student Number: " + this.studentNumber 
				+ "\nName: " + this.studentName 
				+ "\nCourses Enrolled: \n\t" + courses(coursesEnrolled)
				+ "\nCourse Average: " + getThisAverage());
		return result;
	}
	public String courses(HashMap<Integer,Double> yeah) {
		String thing = "";
		for ( int key : coursesEnrolled.keySet() ) {
		    int temp = key;
		    double temp2 = coursesEnrolled.get(key);
		    thing = thing + key + ": " + temp2  + "\n\t";
		}

		return thing;
	}
	public String getStudentName() {
		return this.studentName;
	}
	public int getStudentNumber() {
		return this.studentNumber;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public void addScore(int course, double score) {
		this.coursesEnrolled.put(course, score);
	}
	public void setScore(int course, double score) {
		if(this.coursesEnrolled.containsKey(course)) {
			this.coursesEnrolled.put(course, score);
		}
	}
	public double getScore(int courseNum) {
		if (this.coursesEnrolled.containsKey(courseNum)) {
			return this.coursesEnrolled.get(courseNum);
		}
		else {
			return 0;
		}
	}
	public double getThisAverage() {
		double avg = 0;
		int count = 0;
		for (int key : coursesEnrolled.keySet()) {
			avg += this.coursesEnrolled.get(key);
			count++;
		}
		return avg/count;
	}
}
