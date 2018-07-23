/**
 * This class implement test cases for class LcmHcf
 */

package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckLcmHcf {
	LcmHcf lcm_hcf = new LcmHcf();

	@Test
	public void testHCFError() {
		assertNotEquals(12, lcm_hcf.calculateHCF(30,12));	//assertEquals(expected, actual);
	}

	@Test
	public void testLCMError() {
		assertNotEquals(70, lcm_hcf.calculateLCM(30,12));	//assertEquals(expected, actual);
	}

	@Test
	public void testHCF() {
		assertEquals(6, lcm_hcf.calculateHCF(30,12));	//assertEquals(expected, actual);
	}

	@Test
	public void testLCM() {
		assertEquals(60, lcm_hcf.calculateLCM(30,12));	//assertEquals(expected, actual);
	}

}