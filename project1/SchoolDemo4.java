package project1;

public class SchoolDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		School mySchool = new School("CSUMB");
		//Let's Start by reading some data
		System.out.println("===== Read Data =====");
		mySchool.readData("/Users/shawn/eclipse-workspace/week6/src/project1/test1.txt");
		mySchool.readData("/Users/shawn/eclipse-workspace/week6/src/project1/test2.txt");
		mySchool.courseInfo();
		
		System.out.println("===== Add Students, instructors, and courses =====");
		mySchool.addStudent(1111, "Johnny Boy");
		mySchool.addStudent(4444, "Santiago and the goons");
		mySchool.addStudent(5555, "Justin-san");
		mySchool.addInstructor(420, "Bob Marley", "bmarley@csumb.edu", "420-420-4242");
		mySchool.addCourse(123, "SMK420 - Intro to Memeology", 2, "BIT 210");
		
		System.out.println("===== Assign Bob-sensei to memeology =====");
		mySchool.assignInstructor(123, 420);
		
		System.out.println("===== Check Bob-sensei =====");
		mySchool.searchByEmail("bworley@csumb.edu");
		mySchool.searchByEmail("bmarley@csumb.edu");
		
		System.out.println("===== Give some grades (error) =====");
		mySchool.putScore(123, 1111, 42.0);
		
		System.out.println("===== Give some grades =====");
		mySchool.register(123, 1111);
		//mySchool.deleteCourse(123);
		mySchool.putScore(123, 1111, 42.0);
		mySchool.courseInfo(123);
		mySchool.graduateStudent(1111);
		mySchool.courseInfo(123);
		mySchool.courseInfo();
		mySchool.schoolInfo();
		mySchool.graduateStudent(1111);
		mySchool.graduateStudent(4444);
		mySchool.schoolInfo();
		mySchool.deleteCourse(123);
		//mySchool.courseInfo(123);
		mySchool.deleteCourse(336);
		mySchool.schoolInfo();
		mySchool.courseInfo();
		mySchool.assignInstructor(306, 420);
		mySchool.assignInstructor(306, 420);
		Instructor inst = mySchool.getInstructor(306);
		System.out.println(inst);
		mySchool.deleteCourse(306);
		inst = mySchool.getInstructor(306);
		if (inst == null) {
			System.out.println("Good Job!");
		}
		
	}
}