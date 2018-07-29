package adt_cdt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {
	IntSet intSet = new IntSet(15, new int[] {2, 3, 5, 6, 9, 12});    // Defining an intSet

	@Test
	public void testIsMember() {           // test isMember function
		assertEquals(true, intSet.isMember(3));
		assertEquals(false, intSet.isMember(13));
	}

	@Test
	public void testSize() {
		assertEquals(6, intSet.size());
	}

	@Test
	public void testIsSubsetTrue() {
		IntSet newSet = new IntSet(15, new int[] {2, 5, 3, 9});
		assertEquals(true, intSet.isSubSet(newSet));
	}

	@Test
	public void testIsSubsetFalse() {
		IntSet newSet = new IntSet(15, new int[] {2, 3, 4});
		assertEquals(false, intSet.isSubSet(newSet));
	}

	@Test
	public void testGetComplement() {
		int[] expectedArray1 = {1, 4, 7, 8, 10, 11, 13, 14, 15};
		assertArrayEquals(expectedArray1, intSet.getComplement());
	}
	
	@Test(expected = AssertionError.class)     // test error occurrence if null set is passed 
	public void testGetComplementError() {
	    IntSet newSet = new IntSet(15, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
	    assertEquals("Complement of this set is null set.", newSet.getComplement());
	}

	@Test
	public void testUnion() {
		IntSet newSet = new IntSet(15, new int[] {1, 4, 14, 15});
		int[] expectedArray = {2, 3, 5, 6, 9, 12, 1, 4, 14, 15};
		assertArrayEquals(expectedArray, IntSet.union(intSet, newSet));
	}

}
