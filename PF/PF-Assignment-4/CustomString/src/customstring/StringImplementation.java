/**
 * This class provide implementation for 
 * @author Rajendra Singh Rathore
 * 
 */

package customstring;

import java.util.Scanner;

public class StringImplementation {
	
	public static void main(String args[]) {
		
		System.out.print("Enter String : ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		char choice;
		CustomString customString = new CustomString(userInput);
		
		while (true) {
			System.out.println("String operation menu:\n");
			System.out.println("1.Check equivalence with other String");
			System.out.println("2.Reverse String");
			System.out.println("3.Replace Lowercase with Uppercase and vice-versa");
			System.out.println("4.Longest word in String");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.next().charAt(0);
			
			switch (choice) {
				case '1' :
					System.out.println("Enter String to check equivalence : ");
					String checkEqualString = new Scanner(System.in).nextLine();
					System.out.println(customString.isEquals(checkEqualString));
					break;
	
				case '2' :
					System.out.println("Reverse of String: " + customString.reverseString());
					break;
	
				case '3' :
					System.out.println("Replaced String: " + customString.viceVersa());
					break;
	
				case '4' :
					System.out.println("Longest Word in String: " + customString.longestWord());
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
