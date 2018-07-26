/**
 * This class provide methods to calculate HCF and LCM of two numbers
 * @author Rajendra Singh Rathore
 *
 */

package recursion;

public class LcmHcf { 
	
	/**
	 * calculate HCF using Euclid’s algorithm
	 * @param num1
	 * @param num2
	 * @return HCF of two numbers
	 */
	int calculateHCF(int num1, int num2) {
		if ( num1 == 0 )
			return num2;
		else if( num2 == 0 )
			return num1;
		
		if (num1 > num2) 
			return calculateHCF(num1 % num2, num2);
		else
			return calculateHCF(num2 % num1, num1);
	}
	
	/**
	 * calculate LCM using product and HCF of two numbers
	 * @param num1
	 * @param num2
	 * @return LCM of two numbers
	 */
	int calculateLCM(int num1, int num2) {	// 
		return num1 * num2 / calculateHCF(num1, num2);
	}

}
