package adt_cdt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {
	IntSet intSet;
	
	@Before
	public void init() {
		intSet = new IntSet();    // Defining an intSet
		intSet.addItem(1);        // add few elements to the set
		intSet.addItem(3);
		intSet.addItem(4);
		intSet.addItem(2);
		intSet.addItem(5);
		intSet.addItem(8);
	}

	@Test
	public void testAddItem() {    // testing addItem function
		assertEquals(false, intSet.addItem(3));
	}
	
	@Test(expected = AssertionError.class)     // testing error occurance when invalid elements are passed
	public void testAddItemError() {
		intSet.addItem(-10);
		intSet.addItem(20);
	}

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
	public void testNewSize() {
		intSet.addItem(9);
		assertEquals(7, intSet.size());
	}

	@Test
	public void testIsSubsetTrue() {
		IntSet newSet = new IntSet();
		newSet.addItem(5);
		newSet.addItem(2);
		newSet.addItem(8);
		assertEquals(true, intSet.isSubSet(newSet));
	}

	@Test
	public void testIsSubsetFalse() {
		IntSet newSet = new IntSet();
		newSet.addItem(1);
		newSet.addItem(5);
		newSet.addItem(9);
		assertEquals(false, intSet.isSubSet(newSet));
	}

	@Test
	public void testGetComplement() {
		int[] expectedArray1 = {6, 7, 9, 10, 11, 12, 13, 14, 15};
		assertArrayEquals(expectedArray1, intSet.getComplement());
	}
	
	@Test(expected = AssertionError.class)     // test error occurrence if null set is passed 
	public void testGetComplementError() {
		intSet.addItem(6);
		intSet.addItem(7);
		intSet.addItem(9);
		intSet.addItem(10);
		intSet.addItem(11);
		intSet.addItem(12);
		intSet.addItem(13);
		intSet.addItem(14);
		intSet.addItem(15);
		intSet.getComplement();
	}

	@Test
	public void testUnion() {
		IntSet newSet = new IntSet();
		newSet.addItem(10);
		newSet.addItem(3);
		newSet.addItem(14);
		newSet.addItem(2);
		newSet.addItem(15);
		int[] expectedArray = {1, 3, 4, 2, 5, 8, 10, 14, 15, 0, 0};
		assertArrayEquals(expectedArray, intSet.union(intSet, newSet));
	}

}
