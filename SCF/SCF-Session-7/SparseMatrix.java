/**
 * This class is used to implement sparse matrix by using less space
 * @author Rajendra Singh Rathore
 */

package invariants;

public final class SparseMatrix {
    final int[][] matrix;
    private int countNonZero;
    final private int noOfRows, noOfColumns;

    /**
     * Class constructor to initiate sparse matrix and spot nonzero elements
     * 
     * @param inputMatrix
     */
    public SparseMatrix(int[][] inputMatrix) {
        for (int row = 0; row < inputMatrix.length; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (inputMatrix[row][col] != 0)
                    countNonZero++; // counting total no of nonzero elements
            }
        }

        this.matrix = new int[3][countNonZero]; // multidimensional array of 3 rows to store rowIndex,
                                                // columnIndex and value

        noOfRows = inputMatrix.length; // calculating dimensions of input matrix
        noOfColumns = inputMatrix[noOfRows - 1].length;
        int pointer = 0;
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) { // storing rowIndex, columnIndex and value
                if (inputMatrix[row][column] != 0) {
                    this.matrix[0][pointer] = row;
                    this.matrix[1][pointer] = column;
                    this.matrix[2][pointer++] = inputMatrix[row][column];
                }
            }
        }
    }

    /**
     * This function returns the transpose of the given matrix
     * 
     * @return
     */
    public int[][] getTranspose() {
        int[][] transpose = new int[noOfColumns][noOfRows]; // creating empty matrix of transposed dimension than
                                                            // original array

        for (int i = 0; i < countNonZero; i++) {
            transpose[(matrix[1][i])][(matrix[0][i])] = matrix[2][i]; // switching indexes
        }
        return transpose;
    }

    /**
     * This function checks if the given matrix is symmetric or not
     * 
     * @return true if matrix is symmetric, otherwise false
     */
    public boolean isSymmetric() {
        if (noOfRows != noOfColumns) { // return false as different dimension matrices can't be symmetric
            return false;
        }
        boolean flag;
        for (int i = 0; i < countNonZero; i++) {
            flag = false;
            for (int j = 0; j < countNonZero; j++) {
                // if (matrix[0][i] == matrix[1][j] && matrix[0][j] == matrix[1][i] &&
                // matrix[2][i] == matrix[2][j])            MORE DETAILED CONDITIONS FOR SYMMETRY
                if (matrix[0][i] == matrix[1][j] && matrix[2][i] == matrix[2][j])
                    flag = true;
            }
            if (flag)
                break;
            else
                return false;
        }
        return true;
    }

    /**
     * This function returns the sum of two matrices of same dimensions, throws
     * assertionError if dimensions don't match
     * 
     * @param matrixObj1
     * @param matrixObj2
     * @return sum matrix
     */
    public static int[][] addMatrices(SparseMatrix matrixObj1, SparseMatrix matrixObj2) {
        if (matrixObj1.noOfRows != matrixObj2.noOfRows || matrixObj1.noOfRows != matrixObj2.noOfColumns) {  // necessary condition for addition
            throw new AssertionError("Dimensions of both the two matrices should be equal.");
        }

        int[][] sumOfMatrices = new int[matrixObj1.noOfRows][matrixObj1.noOfColumns];

        for (int i = 0; i < Math.max(matrixObj1.countNonZero, matrixObj2.countNonZero); i++) {  // looping till bigger nonzero count
            if (i < matrixObj1.countNonZero) {                                                  // avoiding out of index exception
                sumOfMatrices[matrixObj1.matrix[0][i]][matrixObj1.matrix[1][i]] += matrixObj1.matrix[2][i];
            }

            if (i < matrixObj2.countNonZero) {
                sumOfMatrices[matrixObj2.matrix[0][i]][matrixObj2.matrix[1][i]] += matrixObj2.matrix[2][i];
            }
        }
        return sumOfMatrices;
    }

    /**
     * This function returns the product of two matrices of compatible dimensions,
     * throws assertionError otherwise
     * 
     * @param matrixObj1
     * @param matrixObj2
     * @return
     */
    public static int[][] multiplyMatrices(SparseMatrix matrixObj1, SparseMatrix matrixObj2) {
        if (matrixObj1.noOfColumns != matrixObj2.noOfRows) {    // necessary condition for multiplication 
            throw new AssertionError(
                    "Number of columns in first matrix should be equal to the number rows in second matrix.");
        }

        int[][] productOfMatrices = new int[matrixObj1.noOfRows][matrixObj2.noOfColumns];

        for (int i = 0; i < matrixObj1.countNonZero; i++) { 
            for (int j = 0; j < matrixObj2.countNonZero; j++) {
                if (matrixObj1.matrix[1][i] == matrixObj2.matrix[0][j]) {
                    productOfMatrices[matrixObj1.matrix[0][i]][matrixObj2.matrix[1][j]] += matrixObj1.matrix[2][i]
                            * matrixObj2.matrix[2][j];
                }
            }
        }

        return productOfMatrices;
    }
}
