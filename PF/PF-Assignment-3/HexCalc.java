/**
 * This class is used to provide various conversion, arithmetic and compare functions on hexadecimal numbers
 * @authore Rajendra Singh Rathore
 *
 */
 
import java.util.*;
import java.util.regex.*;
import java.lang.Math;
class HexOpration {
	
	public boolean isDecimal(String userInput) {
		return Pattern.matches("[(0-9)]*",userInput);		// @return false if userInput contain anything else than 0-9
	}
	
	public boolean isHexa(String userInput) {
		return Pattern.matches("([0-9A-F]*)",userInput);   // @return false if userInput contain anything else than 0-9 and A-F
	}
	
	public int hexToDecimal(String userInput) {
		int dec = 0;
		int digit;
		for (int i = 0; i < userInput.length(); i++) {
			digit = (int)userInput.charAt(i);
			if(digit > 57)									//  checking if character in hex number is greater than 57 : ASCII value of 9
				digit -= 55;								// for characters
			else
				digit -= 48;								// for numbers
			dec += digit*(Math.pow(16, userInput.length() -i -1));
		}
		return dec;
	}
	
	public String decimalTOHex(int userInput) {
		String hex = "";
		String digits = "0123456789ABCDEF";					
		int rem;
		while (userInput > 0) {
			rem = userInput % 16;							// find remainder of 16
			hex = digits.charAt(rem) + hex;					// add character from digits array according to remainder
			userInput = userInput / 16;						// update decimal number
			}
		return hex;
	}
	
	public int compare(String hex1, String hex2) {
		if(hex1.length() != hex2.length()) {
			return (hex1.length() > hex2.length()) ? 1 : -1;		// number with more digits is always bigger
		}
		else {
			for (int i = 0; i < hex1.length(); i++) {						// with numbers of same length
				if((int)(hex1.charAt(i)) > (int)(hex2.charAt(i)) ) {		// number with higher digit at an index is bigger
					return 1;												// @return 1 if first number is bigger
				}
				else if((int)(hex1.charAt(i)) < (int)(hex2.charAt(i)) ) {
					return -1;												// @return -1 if first number is smaller
				}
			}
		}
		return 0;															// @return 0 if both numbers are equal
	}
	
	public String arithOperations(String hex1, String hex2, char operation) {
		int num1, num2;
		int result;
		num1 = hexToDecimal(hex1);
		num2 = hexToDecimal(hex2);
		switch (operation) {
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case 'x' :
				result = num1 * num2;
				break;
			case 'X' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;
			default : 
				result = -1;
		}
		if(result==-1)
			return "null";
		else
			return decimalTOHex(result).toUpperCase();
	}
}

public class HexCalc {
	
	public static void main(String[] args) {
		HexOpration hex = new HexOpration();
		Scanner scan = new Scanner(System.in);
		char choice;
		String userInput,hex1,hex2;
		char compareOperation,arithOperation;
		
		while(true) {
			System.out.println("\n***********************\n  Hex calculator menu\n***********************");
			System.out.println("1.Convert Decimal to Hexadecimal ");
			System.out.println("2.Convert Hexadecimal to Decimal ");
			System.out.println("3.Compare ");
			System.out.println("4.Arithmetic Operations ");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			choice = scan.next().charAt(0);
			
			switch (choice) {
				
				case '1' :
					System.out.print("Enter the decimal number : ");
					userInput = scan.next();
					userInput = userInput.trim().toUpperCase();			// trim and uppercase to remove unwanted space and bring input to right format
					if(hex.isDecimal(userInput))
						System.out.println("Hexadecimal equivalent is : " + hex.decimalTOHex(Integer.parseInt(userInput)));
					else
						System.out.println("Wrong input!!! Not a decimal number.");
					break;
					
				case '2' :
					System.out.print("Enter the Hexadecimal number : ");
					userInput = scan.next();
					userInput = userInput.trim().toUpperCase();
					if(hex.isHexa(userInput))
						System.out.println("Decimal equivalent is : " + hex.hexToDecimal(userInput));
					else
						System.out.println("Wrong input!!! Not a hexadecimal number.");
					break;
					
				case '3' :
					System.out.print("Enter the first Hexadecimal number : ");
					hex1 = scan.next().trim().toUpperCase();
					hex1 = hex1.replaceFirst ("^0*", "");			// removing leading zeros
					if(!hex.isHexa(hex1)) {
						System.out.println("Wrong input!!! Not a hexadecimal number.");
						break;
					}
					
					System.out.print("Enter the second Hexadecimal number : ");
					hex2 = scan.next().trim().toUpperCase();
					hex2 = hex2.replaceFirst ("^0*", "");
					if(!hex.isHexa(hex1)) {
						System.out.println("Wrong input!!! Not a hexadecimal number.");
						break;
					}
					
					int result = hex.compare(hex1, hex2);
					if(result==0)
						System.out.println("First Hexadecimal number " + hex1 + " is equal to second hexadecimal number " + hex2);
					else if(result==1)
							System.out.println("First Hexadecimal number " + hex1 + " is greater than second hexadecimal number " + hex2);
						 else
							System.out.println("First Hexadecimal number " + hex1 + " is less than second hexadecimal number " + hex2);
					break;
					
				case '4' :
					System.out.print("Enter the first Hexadecimal number : ");
					hex1 = scan.next().trim().toUpperCase();
					System.out.print("Enter the second Hexadecimal number : ");
					hex2 = scan.next().trim().toUpperCase();
					System.out.print("Which Operation do you want to perform (+,-,x,/): ");
					arithOperation = scan.next().charAt(0);
					if(Pattern.matches("[+-xX/]*",(arithOperation+"")))
						System.out.println("Result : " + hex.arithOperations(hex1, hex2, arithOperation));
					else 
						System.out.println("Wrong input!!! Not an operation.");		
					break;
				case '5' :
					System.exit(0);
					break;
				default : 
					System.out.println("Wrong input!!!");
			}
			System.out.println("Press Enter.");
			System.console().readLine();		// wait for enter to make it easy for user to see previous results
		}
	}
}

//http://decimal-to-binary.com/decimal-to-binary-converter-online.html  website to check conversion results
