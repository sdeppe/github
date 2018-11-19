package project1;

public class SchoolDemoTest {

	public static void main(String[] args) {
		School CSUMB = new School("CSUMB");
		CSUMB.readData("/Users/jeremys./Desktop/sample_test0.txt");
		CSUMB.schoolInfo();
		CSUMB.courseInfo();
		//CSUMB.readData("/Users/jeremys./Desktop/sample_test2.txt");
	}

}