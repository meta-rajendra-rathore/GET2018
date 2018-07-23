package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckKnightTour {
	KnightTour knight = new KnightTour();
	
	@Test
	public void testKnight0() {
		assertEquals(true, knight.initialize(8));
	}
	
	@Test
	public void testKnight1() {
		assertEquals(false, knight.initialize(4));
	}
	
	@Test
	public void testKnightError0() {
		assertNotEquals(false, knight.initialize(7));
	}
	
	@Test
	public void testKnightError1() {
		assertNotEquals(true, knight.initialize(3));
	}

}
