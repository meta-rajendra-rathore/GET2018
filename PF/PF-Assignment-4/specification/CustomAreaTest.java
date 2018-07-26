<<<<<<< HEAD
package specification;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomAreaTest {
	CustomArea customArea = new CustomArea();
	
	@Test(expected = AssertionError.class)		// assertion error test
	public void testTriangleError() {
		customArea.areaOfTriangle(5.0, -4.0); 
	}
	
	@Test(expected = AssertionError.class)
	public void testRectangleError() {
		customArea.areaOfRectangle(5.0, -4.0); 
	}
	
	@Test(expected = AssertionError.class)
	public void testSquareError() {
		customArea.areaOfSquare(-4.0); 
	}
	
	@Test(expected = AssertionError.class)
	public void testCircleError() {
		customArea.areaOfCircle(-4.0); 
	}

	@Test
	public void testTriangle() {
		assertEquals(10.0, customArea.areaOfTriangle(5.0, 4.0), 0.001); 
		assertNotEquals(20.0, customArea.areaOfTriangle(5.0, 4.0), 0.001); 
	}

	@Test
	public void testRectangle() {
		assertEquals(42.5, customArea.areaOfRectangle(5.0, 8.5), 0.001);
		assertNotEquals(40.0, customArea.areaOfRectangle(5.0, 8.5), 0.001);
	}

	@Test
	public void testSquare() {
		assertEquals(32.49, customArea.areaOfSquare(5.7), 0.001);
		assertNotEquals(25.0, customArea.areaOfSquare(3.0), 0.001);
	}

	@Test
	public void testCircle() {
		assertEquals(153.94, customArea.areaOfCircle(7.0), 0.01);
		assertNotEquals(153.94, customArea.areaOfCircle(7.5), 0.01);
	}

}
=======
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
>>>>>>> a745297586dd13a7a7ae4c0a1de875f4b768cfa6
