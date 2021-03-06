<<<<<<< HEAD
package specification;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomStringTest {
	CustomString customString; 
	
	@Before
	public void init() {
		customString = new CustomString("This is a Custom string");
	}

	@Test
	public void testIsEquals() {
		assertEquals(1, customString.isEquals("This is a Custom string")); 
		assertEquals(0, customString.isEquals("This is a Custom")); 
	}

	@Test
	public void testReverseString() {
		assertEquals("gnirts motsuC a si sihT", customString.reverseString()); 
		assertNotEquals("motsuC a si sihT", customString.reverseString()); 
	}

	@Test
	public void testViceVersa() {
		assertEquals("tHIS IS A cUSTOM STRING", customString.viceVersa()); 
		assertNotEquals("tHIS IS A cUSTOM string", customString.viceVersa()); 
	}

	@Test
	public void testLongestWord() {
		assertEquals("string", customString.longestWord()); 
		assertNotEquals("This", customString.longestWord()); 
	}

}
=======
package specification;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomStringTest {
	CustomString customString;
	
	@Before
	public void init() {
		customString = new CustomString("This is a Custom string");
	}

	@Test
	public void testIsEquals() {
		assertEquals(1, customString.isEquals("This is a Custom string")); 
		assertEquals(0, customString.isEquals("This is a Custom String")); 
	}

	@Test
	public void testReverseString() {
		assertEquals("gnirts motsuC a si sihT", customString.reverseString()); 
	}

	@Test
	public void testViceVersa() {
		assertEquals("tHIS IS A cUSTOM STRING", customString.viceVersa()); 
	}

	@Test
	public void testLongestWord() {
		assertEquals("string", customString.longestWord()); 
	}

}
>>>>>>> a745297586dd13a7a7ae4c0a1de875f4b768cfa6
