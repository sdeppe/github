package project1;

/*
 * Title: SchoolDemo1.java
 * Abstract: test file for project 1
 * Name: Shawn Deppe
 * Date: 10-10-2018
 */

public class SchoolDemo1 
{
  public static void main(String[] args)
  {
    School SCD = new School("SCD");

    System.out.println("===== Read Data 1 =====");
    SCD.readData("/Users/shawn/eclipse-workspace/week6/src/project1/test1.txt");

    System.out.println("\n===== School Info 1 =====");
    SCD.schoolInfo();

    System.out.println("\n===== Read Data 2 =====");
    SCD.readData("/Users/shawn/eclipse-workspace/week6/src/project1/test2.txt");

    System.out.println("\n===== School Info 2 =====");
    SCD.schoolInfo();

    System.out.println("\n===== Search by email =====");
    SCD.searchByEmail("ybyun@csumb.edu");

    System.out.println("\n===== Search by email (fail) =====");
    SCD.searchByEmail("byun@csumb.edu");

    System.out.println("\n===== End of SchoolDemo1 =====");
  }
}
