package datastructure_3.lowestruns;

import static org.junit.Assert.*;
import org.junit.Test;

public class LowestRunsTest {
    LowestRuns low;

    @Test
    public void testWithMaxBallsLess() {
        low = new LowestRuns(20, new int[] {3, 6, 2, 9, 1, 5});
        assertArrayEquals(new int[] {9, 6, 5, 0, 0, 0}, low.ballsDistribution()); 
    }
    
    @Test
    public void testWithMaxBallsExtra() {
        low = new LowestRuns(30, new int[] {3, 6, 2, 9, 1, 5});
        assertArrayEquals(new int[] {9, 6, 5, 3, 2, 1}, low.ballsDistribution()); 
    }
    
    @Test
    public void testWithMaxBallsExact() {
        low = new LowestRuns(34, new int[] {8, 6, 2, 9, 4, 5});
        assertArrayEquals(new int[] {9, 8, 6, 5, 4, 2}, low.ballsDistribution()); 
    }
    
    @Test
    public void testWithBallersWithSameBalls() {
        low = new LowestRuns(25, new int[] {4, 6, 2, 6, 1, 5});
        assertArrayEquals(new int[] {6, 6, 5, 4, 2, 1}, low.ballsDistribution()); 
    }

}
