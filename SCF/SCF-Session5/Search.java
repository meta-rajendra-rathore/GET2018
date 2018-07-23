/**
 * This class provide methods for linear search and binary search
 * @author Rajendra Singh Rathore
 *
 */

package recursion;

public class Search {
	
	/**
	 * Function to implement linear search
	 * @param userArray
	 * @param element
	 * @return index at which element was found, otherwise -1
	 */
	int linearSearch(int [] userArray, int element) {
		int size = userArray.length;
		
		for (int i = 0; i < size; i++) {
			if (userArray[i] == element)
				return i;
		}
		
		return -1;
	}
	
	/**
	 * Function to implement binary search
	 * @param userArray
	 * @param element
	 * @param startIndex
	 * @param endIndex
	 * @return index at which element was found, otherwise -1
	 */
	int binarySearch(int[] userArray, int element, int startIndex, int endIndex) {
		
		if (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			
			if (element == userArray[midIndex]) {
				return midIndex;
			} 
			
			if (element < userArray[midIndex]) {
				return binarySearch(userArray, element, startIndex, midIndex - 1); 
			} 

			return binarySearch(userArray, element, midIndex + 1, endIndex);
		}
		
		return -1;
	}
	
}
