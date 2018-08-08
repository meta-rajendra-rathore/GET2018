package datastructure_3.lowestruns;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LowestRunsTest {
    LowestRuns low;
    
    @Before
    public void init() {
        low = new LowestRuns(20, new int[] {3, 6, 2, 9, 1, 5});
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {9, 6, 5, 0, 0, 0}, low.ballsDistribution()); 
    }

}
