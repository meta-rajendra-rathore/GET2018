/*
 * This class provide various operation on the grades of students
 *@author Rajendra Singh Rathore
 *
 */

package grades;

import java.util.Scanner;

class Marksheet {
	double grades[];
	int noOfStudents;
	
	/**
	 * Constructor of class Marksheet
	 * Initialize number of students and grades array
	 * 
	 */
	public Marksheet(int noOfStudents) {
		this.noOfStudents = noOfStudents;
		grades = new double[noOfStudents];  
	}
	
	/**
	 * Initialize grades array
	 * 
	 * By taking input for the array one by one
	 */
	void initializeGrades() {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < noOfStudents; i++) {
			System.out.print("Enter the grade for Student " + (i + 1) + " between 0 to 100 : ");
			grades[i] = scan.nextDouble(); 
		}
	}
	
	/**
	 * Calculate average of grades of all students
	 * 
	 * @return average grade
	 */
	double averageOfGrades() {
		double averageGrades = 0;
		for (int i = 0; i < noOfStudents; i++) {
			averageGrades = averageGrades + grades[i];
		}
		
		try {
			return (double)averageGrades / noOfStudents;
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException : "+ e);
		}
		return averageGrades;
	}
	
	/**
	 * Calculate maximum of the grades of all students
	 * 
	 * @return maximum grade achieved 
	 */
	double maximumGrade() {
		double maxGrade = grades[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (maxGrade < grades[i]) {
				maxGrade = grades[i];
			}
		}
		return maxGrade;
	}
	
	/**
	 * Calculate minimum of grades of all students
	 * 
	 * @return minimum grade achieved 
	 */
	double minimumGrade() {
		double minGrade = grades[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (minGrade > grades[i]) {
				minGrade = grades[i];
			}
		}
		return minGrade;
	}
	
	/**
	 * Calculate percent of students passed among all students
	 * 
	 * @return passed percent 
	 */
	double percentOfPassedStudents() {
		int noOfPassedStudents = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (grades[i] >= 40) {
				noOfPassedStudents++;
			}
		}
		return Math.round((double)noOfPassedStudents / noOfStudents * 100);
	}
	
	/**
	 * Check if grades are in valid range 0 to 100
	 * 
	 * @return true if any of grades is invalid, otherwise false 
	 */
	boolean invalidGrades() {
		for (int i = 0; i < noOfStudents; i++) {
			if (grades[i] > 100 || grades[i] < 0) {
				return true;
			}
		}
		return false;
	}
}

/**
 * This class implements the methods in the Marksheet class
 * 
 */
public class ImplementGrades {
	
	public static void main(String[] args) {
		
		int noOfstudents;
		char choice;
		System.out.print("Enter the number of Students : ");
		Scanner scan = new Scanner(System.in);
		noOfstudents = scan.nextInt();
		Marksheet marksheetOfStudents = new Marksheet(noOfstudents);
		
		marksheetOfStudents.initializeGrades();
		
		if (marksheetOfStudents.invalidGrades()) {		// exit if invalid grades are entered
			scan.close();								// closing scanner object
			System.out.println("Entered grades should only be between 0 and 100");
			System.exit(1);
		}
		
		while (true) {
			System.out.println("OPERATION MENU");
			System.out.println("1.Average of Grades");
			System.out.println("2.Maximum of Grades");
			System.out.println("3.Minimum of Grades");
			System.out.println("4.Percent of Students Passed");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.next().charAt(0);
			switch (choice) {
			case '1' :
				double averageGrade = marksheetOfStudents.averageOfGrades();
				System.out.println("Average of Grades:- " + averageGrade);
				break;
				
			case '2' :
				double maxgrade = marksheetOfStudents.maximumGrade();
				System.out.println("Maximum Grade achieved : " + maxgrade);
				break;
				
			case '3' :
				double minGrade = marksheetOfStudents.minimumGrade();
				System.out.println("Minimum Grade achieved: " + minGrade);
				break;
			
			case '4' :
				double percentPassedStudents = marksheetOfStudents.percentOfPassedStudents();
				System.out.println("Percentage of Passed Students: " + percentPassedStudents);
				break;
				
			case '5' :
				scan.close();
				System.exit(1);
			
			default :
				System.out.println("Wrong Input!!!");
			}
		}
		
	}
}
