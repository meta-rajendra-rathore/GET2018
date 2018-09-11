package sumofrowsequal;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfRowsEqualTest {
    SumOfRowsEqual sumOfRow = new SumOfRowsEqual();

    @Test
    public void test() {
        
        int testDimension = 4;
        
        int[][] expected = {
                { 1, 5, 9 },
                { 2, 6, 7 },
                { 3, 4, 8 }
        };
        
        int[][] actualMatrix = sumOfRow.getBalancedMatrix(testDimension);
        
        for ( int i = 0; i < testDimension; i++) {
            for ( int j = 0; j < testDimension; j++) {
                System.out.print(actualMatrix[i][j] + " ");
            }
            System.out.println();
        }

        //assertArrayEquals(expected, actualMatrix);
    }

}
