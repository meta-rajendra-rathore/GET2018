package sumofrowsequal;

public class SumOfRowsEqual {
    public int[][] getBalancedMatrix(int N) {

        int[][] balancedMatrix = new int[N][N];
        int[] valuePool = new int[N * N];

        for (int i = 0; i < N * N; i++) {
            valuePool[i] = i + 1;
        }
        
        int expectedSum = ((N * N) * (N * N + 1)) / (2 * N);
        
        for ( int i = 0; i < N; i++) {
            int sumOfRow = 0;
            int j = 0;
            if (placeElement(i, j, sumOfRow, expectedSum, valuePool, balancedMatrix)) {
                System.out.println("Row " + (i + 1 ) + " added successfully.");
            }
        }
        return balancedMatrix;
    }
    
    public boolean placeElement(int i, int j, int sumOfRow, int expectedSum, int[] valuePool, int[][] balancedMatrix) {
        for (int k = 0; k < valuePool.length; k++) {
            if (valuePool[k] != -1) {
                balancedMatrix[i][j] = valuePool[k];
                sumOfRow += balancedMatrix[i][j];
                valuePool[k] = -1;
            } else {
                continue;
            }
            
            if ( j == balancedMatrix.length - 1) {
                if (sumOfRow == expectedSum) {
                    return true;
                } else {
                    valuePool[k] = k + 1;
                    sumOfRow -= k + 1;
                    continue;
                }
            }
            
            if (placeElement(i, j + 1, sumOfRow, expectedSum, valuePool, balancedMatrix)) {
                return true;
            } else {
                valuePool[k] = k + 1;
                sumOfRow -= k + 1;
            }
        }
        return false; 
    }
}
