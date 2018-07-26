package testing_junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {
	
	ArrOperation arrayOperation = new ArrOperation();

	@Test
	public void testMirror0() {
		int[] userArray = {1, 4, 5, 3, 5, 4, 1, 3};
		assertEquals(7, arrayOperation.largestMirror(userArray));
	}

	@Test
	public void testMirror1() {
		int[] userArray = {7, 3, 1, 4, 9, 7, 4, 1}; 
		assertEquals(2, arrayOperation.largestMirror(userArray));
	}

	@Test
	public void testMirror2() {
		int[] userArray = {2, 1, 2, 1, 4, 5, 6, 7, 8}; 
		assertEquals(3, arrayOperation.largestMirror(userArray));
	}

	@Test
	public void testMirror3() {
		int[] userArray = {1, 2, 3, 4, 9, 8, 9, 4, 2, 1}; 
		assertEquals(5, arrayOperation.largestMirror(userArray));
	}

	@Test
	public void testClump0() {
		int[] userArray = {1, 2, 2, 3, 4, 4};
		assertEquals(2, arrayOperation.countClumps(userArray));
	}

	@Test
	public void testClump1() {
		int[] userArray = {1, 1, 3, 1, 1, 1, 5, 8, 8};  
		assertEquals(3, arrayOperation.countClumps(userArray));
	}

	@Test
	public void testClump2() {
		int[] userArray = {5, 5, 5, 5, 5, 5, 5}; 
		assertEquals(1, arrayOperation.countClumps(userArray));
	}

	@Test
	public void testClump3() {
		int[] userArray = {0}; 
		assertEquals(0, arrayOperation.countClumps(userArray));
	}

	@Test
	public void testFixXY0() {
		int[] userArray = {5, 4, 9, 4, 9, 5}; 
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, arrayOperation.fixXY(userArray, 4, 5));
	}

	@Test
	public void testFixXY1() {
		int[] userArray = {1, 4, 1, 5}; 
		assertArrayEquals(new int[]{1, 4, 5, 1}, arrayOperation.fixXY(userArray, 4, 5));
	}

	@Test
	public void testFixXY3() {
		int[] userArray = {5, 9, 5, 5, 4, 9, 4, 9, 4, 1}; 
		assertArrayEquals(new int[]{9, 9, 9, 1, 4, 5, 4, 5, 4, 5}, arrayOperation.fixXY(userArray, 4, 5));
	}

	@Test
	public void testSplitArray0() {
		int[] userArray = {1, 1, 1, 2, 1}; 
		assertEquals(3, arrayOperation.splitArray(userArray));
	}

	@Test
	public void testSplitArray1() {
		int[] userArray = {2, 1, 1, 2, 1}; 
		assertEquals(-1, arrayOperation.splitArray(userArray));
	}

	@Test
	public void testSplitArray2() {
		int[] userArray = {10, 10}; 
		assertEquals(1, arrayOperation.splitArray(userArray));
	}

	@Test(expected = AssertionError.class)
	public void testMirrorError() {
		int[] userArray = {};
		arrayOperation.largestMirror(userArray);
	}

	@Test(expected = AssertionError.class)
	public void testCountClumpError() {
		int[] userArray = {};
		arrayOperation.countClumps(userArray);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYError0() {
		int[] userArray = {};
		arrayOperation.fixXY(userArray, 4, 5);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYError1() {
		int[] userArray = {5, 5, 4, 3, 6, 4};
		arrayOperation.fixXY(userArray, 4, 5);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYError2() {
		int[] userArray = {5, 5, 4, 3, 6, 4, 4};
		arrayOperation.fixXY(userArray, 4, 5);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYError3() {
		int[] userArray = {5, 5, 4, 3, 6, 4, 3, 4, 7};
		arrayOperation.fixXY(userArray, 4, 5);
	}

	@Test(expected = AssertionError.class)
	public void testSplitArrayError() {
		int[] userArray = {};
		arrayOperation.splitArray(userArray);
	}
		

}
