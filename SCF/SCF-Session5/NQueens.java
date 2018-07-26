/**
 * This class implements the famous N queens problem.
 * @author Rajendra Singh Rathore
 *
 */

package recursion;

public class NQueens {
	/**
	 * Initialize the NxN array with 0 to show empty board
	 * and print the array if solution possible
	 *
	 * @param startRow
	 * @param dimensionOfMatrix
	 * @return boolean if there is any solution for given dimension
	 */
	Boolean  nQueen(int startRow, int dimensionOfMatrix) {					// initializing function
		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++) {
				board[i][j] = 0;		//  making all nodes 0
			}
		}
		
		if (placeQueenInRow(board, startRow, dimensionOfMatrix)) {		// calling the recursive function for the first time
			for (int i = 0; i < dimensionOfMatrix; i++) {				// return true and print the array fir solution is possible
				for (int j = 0; j < dimensionOfMatrix; j++) {
					if (board[i][j] > 0)
						board[i][j] = 1;
					else
						board[i][j] = 0;
					System.out.print(board[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
			return true;
		} else
			return false;		// return false otherwise
	}
	
	/**
	 * main recursive function to implement the positions
	 * 
	 * @param board
	 * @param row
	 * @param dimension
	 * @return true if it is possible to place queen for the current row, otherwise false
	 */
	boolean placeQueenInRow(int[][] board, int row, int dimension) { 
		if (row >= dimension)		// base conditon : terminate recursion when row reach dimension
			return true;
		
		for (int i = 0; i < dimension; i++) {
			if (board[row][i] == 0) {
				blockPositions(board, row, i, dimension);  			// marking positions unavailable 
				if (placeQueenInRow(board, row + 1, dimension))		// starting recursion
					return true;
				else
					unblockPositions(board, row, dimension);		// backtracking : making the positions available again
			}
		}
		return false;
	}
	
	/**
	 * function to mark positions unavailable 
	 * @param board
	 * @param indexI
	 * @param indexJ
	 * @param dimension
	 */
	void blockPositions(int[][] board, int indexI, int indexJ, int dimension) {		
		for (int i = indexI; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (i == indexI && j == indexJ) {			// placing QUEEN
					board[i][j] = indexI + 1;
				} else if (i == indexI || j == indexJ || (indexI - i)*(indexI - i) == (indexJ - j)*(indexJ - j)) {  // marking attacking positions by queen
					if (board[i][j] == 0) 
						board[i][j] = -(indexI + 1);
				}
			}
		}
	}
	
	/**
	 * function to mark positions available again
	 * @param board
	 * @param indexI
	 * @param dimension
	 */
	void unblockPositions(int[][] board, int indexI, int dimension) {
		for (int i = indexI; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (board[i][j] == -(indexI + 1) || board[i][j] == (indexI + 1)) {
						board[i][j] = 0; 
				}
			}
		}
	}
	
}

