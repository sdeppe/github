package project1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

/*
 * Title: School.java
 * Abstract: main file for project 1, reads file, creates hashmaps to store data, and calls other classes to create objects
 * Name: Shawn Deppe
 * Date: 10-10-2018
 */

public class School {
	private String school;
	
	private HashMap<String, Instructor> instructors = new HashMap<String, Instructor>();  // email, instructor
	private HashMap<Integer, Instructor> instructors2 = new HashMap<Integer, Instructor>();  // id, instructor
    private HashMap<Integer, Course> courses2 = new HashMap<Integer, Course>();  // courseNum, course
    private HashMap<Integer, Student> students = new HashMap<Integer, Student>();  // studentNum, student
    private HashMap<Integer, Integer> courseList = new HashMap<Integer, Integer>();  // courseNum, EmployeeNum
    private HashMap<Integer, Integer> courseNumEnr = new HashMap<Integer, Integer>();  // studentNum, courseNum
    
	public School() {
		this.setSchool("None");
	}
	public School(String school) {
		this.school = school;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public void readData(String filename) {
		ArrayList<String> instr = new ArrayList<String>();
	    ArrayList<String> cour = new ArrayList<String>();
	    ArrayList<String> stu = new ArrayList<String>();
		String token1 = "";

	    Scanner inFile1;
		try {
			inFile1 = new Scanner(new File(filename)).useDelimiter("\n");
		    List<String> temps = new ArrayList<String>();

		    while (inFile1.hasNext()) {
		      token1 = inFile1.next();
		      temps.add(token1);
		    }

		    String[] tempsArray = temps.toArray(new String[0]);
		    int count = 0;
		    int total = 0;
		    
		    count = newCount(tempsArray[0]);  // instructors
		    total++;
		    for (int j=1; j<count+1; j++) {
		    	String x = tempsArray[j];
		    	instr.add(x);
		    	String[] temp = tempsArray[j].split(",");
		    	int thing = Integer.valueOf(temp[0]);
		    	Instructor tempIn = new Instructor(Integer.valueOf(temp[0]), temp[1], temp[2], temp[3]);
		    	if (instructors2.containsKey(thing)) {
		    		System.out.println("Instructor info reading failed - Employee number " + thing + " already used.");
		    	}
		    	else {
		    		instructors2.put(Integer.valueOf(temp[0]), tempIn);
		    		instructors.put(temp[2], tempIn);
		    	}
		    	total++;
		    }
		    
		    count = newCount(tempsArray[total]);  // courses
		    total++;
		    for (int j=1; j<count+1; j++) {
		    	String x = tempsArray[total];
		    	cour.add(x);
		    	String[] temp = tempsArray[total].split(",");
		    	int thing = Integer.valueOf(temp[0]);
		    	Course tempIn = new Course(Integer.valueOf(temp[0]), temp[1], Integer.valueOf(temp[2]), temp[3]);
		    	if (courses2.containsKey(thing)) {
		    		System.out.println("Course info reading failed - Course number " + thing + " already used.");
		    	}
		    	else {
		    		courses2.put(Integer.valueOf(temp[0]), tempIn);
		    	}
		    	total++;
		    }
		    //courses2.forEach((key, value) -> System.out.println(key + " : " + value));
		    
		    count = newCount(tempsArray[total]);  // students
		    total++;
		    for (int j=1; j<count+1; j++) {
		    	String x = tempsArray[total];
		    	stu.add(x);
		    	String[] temp = tempsArray[total].split(",");
		    	int thing = 0;
		    	thing = Integer.valueOf(temp[0]);
		    	Student tempIn = new Student(Integer.valueOf(temp[0]), temp[1]);
		    	if (students.containsKey(thing)) {
		    		System.out.println("Student info reading failed - Student ID " + thing + " already used.");
		    	}
		    	else {
		    		students.put(Integer.valueOf(temp[0]), tempIn);
		    	}
		    	total++;
		    }
		    //students.forEach((key, value) -> System.out.println(key + " : " + value));
		    System.out.println("Done.");
		} 
		catch (FileNotFoundException e) {
			System.out.println("File read error.");
		}
    }
		
	
	public static int newCount(String num) {
		int x = 0;
		x = Integer.valueOf(num);
		return x;
	}
	public void schoolInfo() {
		System.out.println("School Name: " + this.school);
		System.out.println("Instructor Information");
		instructors.forEach((key, value) -> System.out.println("\t" + value.getInstructorName()));
		System.out.println("Course Information");
		courses2.forEach((key, value) -> System.out.println("\t" + value.getCourseTitle()));
		System.out.println("Student Information");
		students.forEach((key, value) -> System.out.println("\t" + value.getStudentName()));
	}
	public void addStudent(int studentNum, String name) {
		if (students.containsKey(studentNum)) {
			System.out.println("Failed - Student ID " + studentNum + " already used.");
		}
		else {
			students.put(studentNum, new Student(studentNum, name));
		}
	}
	public void addInstructor(int employeeNum, String name, String email, String phone) {
		if (instructors2.containsKey(employeeNum)) {
    		System.out.println("Course info reading failed - Course number " + employeeNum + " already used.");
    	}
    	else {
    		instructors2.put(Integer.valueOf(employeeNum), new Instructor(employeeNum, name, email, phone));
    	}
	}
	public void addCourse(int courseNum, String className, int capacity, String location) {
		if (courses2.containsKey(courseNum)) {
    		System.out.println("Course info reading failed - Course number " + courseNum + " already used.");
    	}
    	else {
    		courses2.put(Integer.valueOf(courseNum), new Course(courseNum, className, capacity, location));
    	}
	}
	public void courseInfo() {
		System.out.println("Number of Courses: " + courses2.size());
		for (int key : courses2.keySet()) {
			System.out.println("\t" + key + ": " + courses2.get(key).getEnr());
		}
		System.out.println("");
	}
	public void assignInstructor(int courseNum, int employeeNum) {
		if (courses2.containsKey(courseNum)) {
			if (instructors2.containsKey(employeeNum)) {
				courseList.put(courseNum, employeeNum);
				instructors2.get(employeeNum).addCourse(courseNum, 0);
			}
			else {
				System.out.println("Instructor " + employeeNum + " does not exist.");
			}
		}
		else {
			System.out.println("Course number " + courseNum + " does not exist.");
		}
	}
	public Boolean deleteCourse(int courseNum) {
		if (courses2.containsKey(courseNum)) {
			int x = courses2.get(courseNum).getEnr();
			if (x != 0) {
				System.out.println("Course deletion failed - Enrolled student(s) in the class");
				return false;
			}
			else {
				courses2.remove(courseNum);
				return true;
			}
		}
		return false;
	}
	public void searchByEmail(String email) {
		if (instructors.containsKey(email)) {
			System.out.println("Search key: " + email);
			System.out.println("\tEmployee Number: " + instructors.get(email).getEmployeeNumber());
			System.out.println("\tName: " + instructors.get(email).getInstructorName());
			System.out.println("\tPhone: " + instructors.get(email).getPhoneNumber());
		}
		else {
			System.out.println("Search key: " + email);
			System.out.println("No employee with email " + email);
		}
	}
	public void register(int courseNum, int studentNum) {
		if (courses2.containsKey(courseNum)) {
			if (courses2.get(courseNum).getEnr() < courses2.get(courseNum).getCourseCapacity()) 
				if (students.containsKey(studentNum)) {
					courseNumEnr.put(studentNum, courseNum);
					courses2.get(courseNum).addEnr();
				}
				else {
					System.out.println("Student " + studentNum + " does not exist.");
				}
			else {
				System.out.println("Registration failed - Class is full.");
			}
		}
		else {
			System.out.println("Course number " + courseNum + "does not exist.");
		}
	}
	public Instructor getInstructor(int courseNum) {
		if (courseList.containsKey(courseNum)) {
			int x = courseList.get(courseNum);
			return instructors2.get(x);
			
		}
		else {
			return null;
		}
	}
	public void courseInfo(int courseNum) {
		if (courses2.containsKey(courseNum)) {
			System.out.println("Course Number: " + courses2.get(courseNum).getCourseNumber());
			if (courseList.containsKey(courseNum)) {
				int instrNum = courseList.get(courseNum);
				System.out.println("Instructor: " + instructors2.get(instrNum).getInstructorName());
			}
			System.out.println("Course Title: " + courses2.get(courseNum).getCourseTitle());
			System.out.println("Room: " + courses2.get(courseNum).getClassLocation());
			System.out.println("Total Enrolled: " + courses2.get(courseNum).getEnr());
			System.out.print("Course Average: ");
			//System.out.println("Course Average: " + getAverage(courseNum));
			getAverage(courseNum);
		}
	}
	public void putScore(int courseNum, int studentNum, double score) {
		if (students.containsKey(studentNum)) {
			try {
				if (courseNumEnr.get(studentNum) == courseNum) {
					students.get(studentNum).addScore(courseNum, score);
				}
			}
			catch (Exception e) {
				System.out.println("Student " + studentNum + " (" + students.get(studentNum).getStudentName() + ") is not enrolled in " + courseNum);
			}
		}
		else {
			System.out.println("putScore failed :(");
		}
	}
	public void unRegister(int courseNum, int studentNum) {
		if (courseNumEnr.containsKey(studentNum)) {
			if (courseNumEnr.get(studentNum) == courseNum) {
				courseNumEnr.remove(studentNum);
				courses2.get(courseNum).delEnr();
			}
		}
	}
	public Student getStudent(int studentNum) {  // fix
		for (int i=0; i<students.size(); i++) {
			if (students.containsKey(studentNum)) {
				return students.get(studentNum);
			}
		}
		return null;
	}
	public Course getCourse(int courseNum) { // fix
		for (int i=0; i<courses2.size(); i++) {
			if (courses2.containsKey(courseNum)) {
				return courses2.get(courseNum);
			}
    	}
		return new Course();
	}
	public void graduateStudent(int studentNum) {
		if(students.containsKey(studentNum)) {
			if (students.containsKey(studentNum)) {
				int x = courseNumEnr.get(studentNum);
				courses2.get(x).delEnr();
				students.remove(studentNum);
			}
		}
	}
	public void getAverage(int courseNum) {
		double total = 0;
		int count = 0;
		for (int key : courses2.keySet()) {
		    if (key == courseNum) {
				int temp = key;
				for(int key2 : students.keySet() ) {
					if (students.get(key2).getScore(courseNum) != 0.0) {
						count += 1;
						total = total + students.get(key2).getScore(courseNum);
					}
				}
		    }
		}
		System.out.println(total/count);
	}
}
