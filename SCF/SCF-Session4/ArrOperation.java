/**
 * This class include operations on strings
 * @author Rajendra Singh Rathore
 *
 */

package testing_junit;

public class ArrOperation {
	
	void swap(int[] userArray, int x, int y) {
		int tmp;
		tmp = userArray[x];
		userArray[x] = userArray[y];
		userArray[y] = tmp;
	}

	int largestMirror(int[] userArray) {
		int size = userArray.length;
		if (size == 0) {
			throw new AssertionError();
		}
		
		int largestMirror = 1, currentMirror = 1;
		
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j >= 0; j--) {
				
				if (userArray[i] == userArray[j]) {
					int index = i + 1, trace = j - 1;
					currentMirror = 1;
					
					while (index < size && trace >=0 ) {
						
						if (userArray[index] == userArray[trace]) {
							currentMirror++;
							index++;
							trace--;
						} else {
							break;
						}
						
						if (currentMirror > largestMirror) 
							largestMirror = currentMirror;
					}
				}
			}
		}
		return largestMirror;
	}
	
	int countClumps(int[] userArray) {
		int clumps = 0, size = userArray.length;
		boolean isInClump = false;

		if (size == 0) {
			throw new AssertionError();
		}
		
		for (int i = 0; i < size - 1; i++) {
			if (userArray[i] == userArray[i + 1]) {
				if (!isInClump) {
					isInClump = true;
					clumps++;
				}
			} else {
				if (isInClump) {
					isInClump = false;
				}
			}
		}
		return clumps;
	}
	
	int[] fixXY(int[] userArray, int x, int y) {
		int size = userArray.length;
		
		if (size == 0) {
			throw new AssertionError();
		} else if (userArray[size - 1] == x) 
			throw new AssertionError();
		
		int[] newArray = userArray; 

		for (int i = 0; i < size - 1; i++) {		
			if (userArray[i] == x) {
				if (userArray[i + 1] == x)
					throw new AssertionError();
				
				for (int j = 0; j < size; j++) {
					if (userArray[j] == y ) {
						if (j != 0) {
							if (userArray[j-1] != x) {
								swap(userArray, j, i + 1);
								break;
							}
						} else {
							swap(userArray, j, i + 1);
							break;
						}
					} else if (j == size -1 )
						throw new AssertionError();
				}
			}
		}
		return newArray;
	}
	
	int splitArray(int[] userArray) {
		int splitIndex = -1, size = userArray.length;
		if (size == 0) {
			throw new AssertionError();
		}
		int firstSum = 0, lastSum = 0;
		for(int i = 1; i < size; i++) {
			splitIndex = i ;
			for (int j = 0; j < size; j++) {
				if (j < splitIndex) {
					firstSum += userArray[j];
				} else {
					lastSum += userArray[j];
				}
			}
			
			if (firstSum == lastSum) 
				return splitIndex;
			
			firstSum = 0; 
			lastSum = 0;
		}
		
		return -1;
	}
}
