package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckTest {
	Search search = new Search();

	@Test
	public void testLinear0() {				//assertEquals(expected, actual);
		int[] userArray = {2, 1, 2, 9, 4, 5, 6, 7, 8}; 
		assertEquals(3, search.linearSearch(userArray, 9));
	}

	@Test
	public void testLinear1() {
		int[] userArray = {2, 1, 2, 9, 4, 5, 6, 7, 8}; 
		assertEquals(-1, search.linearSearch(userArray, 3));
	}

	@Test
	public void testLinearError() {
		int[] userArray = {2, 1, 2, 9, 4, 5, 6, 7, 8}; 
		assertNotEquals(-1, search.linearSearch(userArray, 7));
	}

	@Test
	public void testBinary0() {
		int[] userArray = {0, 1, 3, 4, 5 ,6, 8, 9, 10, 11}; 
		assertEquals(2, search.binarySearch(userArray, 3, 0, 9));
	}

	@Test
	public void testBinary1() {
		int[] userArray = {1, 3, 5, 7, 8, 10, 11, 20, 23}; 
		assertEquals(6, search.binarySearch(userArray, 11, 0, 8));
	}

	@Test
	public void testBinary2() {
		int[] userArray = {0, 1, 2, 3, 4 ,6, 8, 9, 10}; 
		assertEquals(4, search.binarySearch(userArray, 4, 0, 8));
	}

	@Test
	public void testBinary4() {
		int[] userArray = {1, 3, 5, 7, 8, 10, 11, 20, 23}; 
		assertEquals(-1, search.binarySearch(userArray, 6, 0, 8));
	}

	@Test
	public void testBinaryError0() {
		int[] userArray = {1, 3, 5, 7, 8, 10, 11, 20, 23}; 
		assertNotEquals(3, search.binarySearch(userArray, 6, 0, 8));
	}

	@Test
	public void testBinaryError1() {
		int[] userArray = {0, 1, 2, 3, 4 ,6, 8, 9, 10}; 
		assertNotEquals(-1, search.binarySearch(userArray, 6, 0, 8));
	}

}
