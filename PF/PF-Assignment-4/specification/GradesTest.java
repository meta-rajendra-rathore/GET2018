<<<<<<< HEAD
package specification;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	Marksheet marksheet = new Marksheet(4);

	@Before
	public void init() {		// initialization 
		int[] userArray = {30, 40, 50, 60};
		marksheet.initializeGrades(userArray);
	}
	
	@Test(expected = AssertionError.class)		// assertion error test if 0 students
	public void testInitError() {
		Marksheet marksheetError = new Marksheet(0);
	}
	
	@Test(expected = AssertionError.class)		// assertion error test if invalid grades case
	public void testInvalidGradeError() {
		int[] userArray = {30, 110, 50, 60};
		marksheet.initializeGrades(userArray);
	}

	@Test
	public void testAverageOfGrades() {
		assertEquals(45.0, marksheet.averageOfGrades(), 0.001);
		assertNotEquals(40.0, marksheet.averageOfGrades(), 0.001);
	}

	@Test
	public void testMinimumGrades() {
		assertEquals(30.0, marksheet.minimumGrade(), 0.001);
		assertNotEquals(10.0, marksheet.minimumGrade(), 0.001);
	}

	@Test
	public void testMaximumGrades() {
		assertEquals(60.0, marksheet.maximumGrade(), 0.001);
		assertNotEquals(65.0, marksheet.maximumGrade(), 0.001);
	}

	@Test
	public void testPercentOfPassedStudents() {
		assertEquals(75.0, marksheet.percentOfPassedStudents(), 0.01);
		assertNotEquals(70.0, marksheet.percentOfPassedStudents(), 0.01);
	}

}
=======
package specification;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradesTest {
	Marksheet marksheet = new Marksheet(4);

	@Before
	public void init() {
		int[] userArray = {30, 40, 50, 60};
		marksheet.initializeGrades(userArray);
	}

	@Test
	public void testAverageOfGrades() {
		assertEquals(45.0, marksheet.averageOfGrades());
	}

	@Test
	public void testMinimumGrades() {
		assertEquals(30.0, marksheet.minimumGrade());
	}

	@Test
	public void testMaximumGrades() {
		assertEquals(60.0, marksheet.maximumGrade());
	}

	@Test
	public void testPercentOfPassedStudents() {
		assertEquals(75.0, marksheet.averageOfGrades());
	}

}
>>>>>>> a745297586dd13a7a7ae4c0a1de875f4b768cfa6
