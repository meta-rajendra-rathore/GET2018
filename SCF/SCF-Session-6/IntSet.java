/**
 * This class implements set of integers from range 0 to MAX_SIZE
 * @author Rajendra Singh Rathore
 */

package adt_cdt;

public class IntSet {
	int[] intSetArray;
	final int MAX_SIZE;

	/**
	 * public constructor
	 */
	public IntSet(int maxSize, int[] userArray) {
		MAX_SIZE = maxSize;
		intSetArray = userArray;
	}

	/**
	 * Add a new element to the set
	 * @param newElement
	 * @return true if element can be added and false otherwise
	 */
	public boolean addItem(int newElement) {
		if (newElement > 0 && newElement <= MAX_SIZE) {
			if (isMember(newElement)) {
				return false;
			} else {
				intSetArray[size()] = newElement;
				return true;
			}
		} else {
			throw new AssertionError();
		}
	}

	/**
	 * check if a given element is already a member
	 * @param element
	 * @return true if already a member and false otherwise
	 */
	public boolean isMember(int element) {
		for (int i = 0; i < size(); i++) {
			if (intSetArray[i] == element) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return the size of the set
	 * @return size
	 */
	public int getSize() {
		/*int size = 0;
		for (int i = 0; i < MAX_SIZE; i++) {
			if (intSetArray[i] != 0)
				size++;
			else
				return size;
		}*/
		return size;
	}

	/**
	 * Check if a given set is a member of the set
	 * @param s intSet
	 * @return true if a subset and false otherwise
	 */
	public boolean isSubSet(IntSet s) {
		for (int i = 0; i < s.size(); i++) {
			if (!isMember(s.intSetArray[i]))
				return false;
		}
		return true;
	}

	/**
	 * Get the complement of the given set
	 * @return an array containing the complement
	 */
	public int[] getComplement() {
		
		if (MAX_SIZE == size()) {
			throw new AssertionError("Complement of this set is null set.");
		}
		
		int pointer = 0;
		int[] complement = new int[MAX_SIZE - size()];
		for (int i = 0; i < MAX_SIZE; i++) {
			if (!isMember(i + 1)) {
				complement[pointer++] = i + 1;
			}
		}
		return complement;
	}

	/**
	 * Find the union of two given set
	 * @param s1
	 * @param s2
	 * @return union of sets passed as parameters
	 */
	public int[] union(IntSet s1, IntSet s2) {
		int size = s1.size() + s2.size();
		int[] union = new int[size];
		int pointer = 0;

		for (int i = 0; i < s1.size(); i++) {
			union[i] = s1.intSetArray[i];
		}

		for (int i = 0; i < s2.size(); i++) {
			if (!s1.isMember(s2.intSetArray[i]))
				union[s1.size() + pointer++] = s2.intSetArray[i];
		}
		return union;
	}
}
