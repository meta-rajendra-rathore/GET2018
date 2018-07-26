package invariants;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {
    
    int[][] inputForTranspose = { 
            {0, 0, 0, 0, 8, 0},
            {0, 3, 0, 0, 0, 0},
            {8, 0, 0, 1, 0, 0},
            {0, 2, 0, 0, 8, 0},
            {0, 0, 6, 0, 0, 0},
            {1, 0, 0, 0, 0, 5} };
    
    int[][] inputForSymmetric = { 
            {0, 0, 0, 0, 8, 0},
            {0, 3, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 8, 0},
            {8, 0, 0, 8, 0, 0},
            {0, 0, 0, 0, 0, 5} };
    
    SparseMatrix  matrixTranspose = new SparseMatrix(inputForTranspose);
    SparseMatrix  matrixSymmetric = new SparseMatrix(inputForSymmetric);

    @Test
    public void testGetTranspose() { 
        int[][] expectedMatrix = { 
                {0, 0, 8, 0, 0, 1},
                {0, 3, 0, 2, 0, 0},
                {0, 0, 0, 0, 6, 0},
                {0, 0, 1, 0, 0, 0},
                {8, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 5} };
        assertArrayEquals(expectedMatrix, matrixTranspose.getTranspose());
    }

    @Test
    public void testIsSymmetric() { 
        assertEquals(true, matrixSymmetric.isSymmetric());
    }

    @Test
    public void testAddMatrices() {
        int[][] expectedMatrix = { 
                {0, 0, 0, 0, 16, 0},
                {0, 6, 0, 0, 0, 0},
                {8, 0, 0, 2, 0, 0},
                {0, 2, 1, 0, 16, 0},
                {8, 0, 6, 8, 0, 0},
                {1, 0, 0, 0, 0, 10} }; 
        assertArrayEquals(expectedMatrix, SparseMatrix.addMatrices(matrixTranspose, matrixSymmetric));
    }

    @Test
    public void testMultiplyMatrices() {
        int[][] matrix1 = { {2, 0, 0}, {0, 6, 0} }; 
        int[][] matrix2 = { {1, 2}, {0, 6}, {0, 3} }; 
        int[][] expectedMatrix = { {2, 4}, {0, 36} }; 

        SparseMatrix  matrixObj1 = new SparseMatrix(matrix1);
        SparseMatrix  matrixObj2 = new SparseMatrix(matrix2);
        assertArrayEquals(expectedMatrix, SparseMatrix.multiplyMatrices(matrixObj1, matrixObj2));
    }
    
    @Test
    public void testMultiplyMatrices1() {
        int[][] matrix3 = { {1, 2, 0, 1}, {0, 3, 1, 0} }; 
        int[][] matrix4 = { {2, 0, 0}, {0, 6, 0}, {2, 1, 0}, {1, 0, 2} }; 
        int[][] expectedMatrix = { {3, 12, 2}, {2, 19, 0} }; 

        SparseMatrix  matrixObj3 = new SparseMatrix(matrix3);
        SparseMatrix  matrixObj4 = new SparseMatrix(matrix4);
        assertArrayEquals(expectedMatrix, SparseMatrix.multiplyMatrices(matrixObj3, matrixObj4));
    }

}
