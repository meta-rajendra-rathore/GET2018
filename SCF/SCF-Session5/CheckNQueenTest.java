package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckNQueenTest {
	NQueens queens = new NQueens();
	
	@Test
	public void testNQueen0() {
		assertEquals(true, queens.nQueen(0, 6));
	}
	
	@Test
	public void testNQueenError0() {
		assertNotEquals(false, queens.nQueen(0, 7));
	}
	
	@Test
	public void testNQueen1() {
		assertEquals(false, queens.nQueen(0, 3));
	}
	
	@Test
	public void testNQueenError1() {
		assertNotEquals(true, queens.nQueen(0, 2));
	}

}
