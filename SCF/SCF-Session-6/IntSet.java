/**
 * This class implements set of integers from range 0 to MAX_SIZE
 * @author Rajendra Singh Rathore
 */

package adt_cdt;

public final class IntSet {
    final int[] intSetArray;
    final int MAX_SIZE;

    /**
     * public constructor
     */
    public IntSet(int maxSize, int[] inputArray) {
        MAX_SIZE = maxSize;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] <= 0 || inputArray[i] > MAX_SIZE) {
                throw new AssertionError("INVALID INPUT VALUE : " + inputArray[i]);
            }
        }
        intSetArray = inputArray;
    }

    /**
     * check if a given element is already a member
     * 
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
     * 
     * @return size
     */
    public int size() {
        int size = 0;
        for (int element : intSetArray) {
            size++;
        }
        return size;
    }

    /**
     * Check if a given set is a member of the set
     * 
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
     * 
     * @return an array containing the complement
     */
    public int[] getComplement() {

        if (MAX_SIZE == size()) {
            System.out.println("Complement of this set is null set.");
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
     * 
     * @param s1
     * @param s2
     * @return union of sets passed as parameters
     */
    public static int[] union(IntSet s1, IntSet s2) {
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
