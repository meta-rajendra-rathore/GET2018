package specification;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomAreaTest {
	CustomArea customArea = new CustomArea();

	@Test
	public void testTriangle() {
		assertEquals(10.0, customArea.areaOfTriangle(5.0, 4.0));
	}

	@Test
	public void testRectangle() {
		assertEquals(42.5, customArea.areaOfRectangle(5.0, 8.5));
	}

	@Test
	public void testSquare() {
		assertEquals(32.49, customArea.areaOfSquare(5.7));
	}

	@Test
	public void testCircle() {
		assertEquals(153.94, customArea.areaOfCircle(7.0));
	}

}
