/**
 * It contains implementation for CustomArea class operations
 * @author Rajendra Singh Rathore
 * 
 */

package calculate_area;

import java.util.Scanner;

public class CalculateArea {
	public static void main(String[] args) {
		double width;
		double height;
		double radius;
		char choice;
		Scanner scan = new Scanner(System.in);
		CustomArea areaCalc = new CustomArea();
		
		while (true) {
			System.out.println("OPERATION MENU : \n");
			System.out.println("1.Area of Triangle");
			System.out.println("Area of Rectangle");
			System.out.println("3.Area of Square");
			System.out.println("4.Area of Circle");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.next().charAt(0);
			
			switch (choice) {
				case '1' :
					System.out.print("Enter Width of Triangle: ");
					width = scan.nextDouble();
					System.out.print("Enter Height of Triangle: ");
					height = scan.nextDouble();
					System.out.println("Area of Triangle: " + areaCalc.areaOfTriangle(width, height));
					break;
	
				case '2' :
					System.out.print("Enter Width of Rectangle: ");
					width = scan.nextDouble();
					System.out.print("Enter Height of Rectangle: ");
					height = scan.nextDouble();
					System.out.println("Area of Rectangle: " + areaCalc.areaOfRectangle(width, height));
					break;
	
				case '3' :
					System.out.print("Enter Width of Square: ");
					width = scan.nextDouble();
					System.out.println("Area of Square: " + areaCalc.areaOfSquare(width));
					break;
	
				case '4' :
					System.out.print("Enter Radius of Circle: ");
					radius = scan.nextDouble();
					System.out.println("Area of Circle: " + areaCalc.areaOfCircle(radius));
					break;
	
				case '5' :
					scan.close();
					System.exit(1);
	
				default :
					System.out.println("Wrong Input!!!");
			}
			/*System.out.print("Press Enter");
			String enter = System.console().readLine();*/

		}

	}
}

