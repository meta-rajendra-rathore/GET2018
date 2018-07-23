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
