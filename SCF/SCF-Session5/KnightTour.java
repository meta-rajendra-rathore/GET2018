/**
 * This class implements the famous Knight's tour problem.
 * @author Rajendra Singh Rathore
 *
 */

package recursion;

public class KnightTour {
	/**
	 * Initialize the NxN array with -1 to show no step yet
	 * and print the array if solution possible
	 *
	 * @param dimensionOfMatrix
	 * @return boolean if there is any solution for given dimension
	 */
	boolean  initialize(int dimensionOfMatrix) {
		int[][] board = new int[dimensionOfMatrix][dimensionOfMatrix];
		for (int i = 0; i < dimensionOfMatrix; i++) {
			for (int j = 0; j < dimensionOfMatrix; j++) {
				board[i][j] = -1;
			}
		}
		
		if (placeKnight(board, 0, 0, dimensionOfMatrix, 0)) {	// calling the recursive implementation function for the first time
			for (int i = 0; i < dimensionOfMatrix; i++) {
				for (int j = 0; j < dimensionOfMatrix; j++) {	// if true then print
					if(board[i][j] < 10)						// to maintain visual clarity, add 0 to single digit numbers
						System.out.print("0" + board[i][j] + "  ");
					else
						System.out.print(board[i][j] + "  ");
				}
				System.out.println("");
			}
			System.out.println("");
			return true;
		} else {
			System.out.println("No tour found for this dimension!\n");
			return false;
		}
	}

	/**
	 * function to modify nodes according to steps and call recursion
	 * 
	 * @param NxN array
	 * @param row index of the point to take step
	 * @param column index of the point to take step
	 * @param dimensionOfMatrix
	 * @param next step index
	 * @return true if it is possible to take step on given indices
	 */
	boolean placeKnight(int[][] board, int x, int y, int dimension, int step) {
		if (step == dimension * dimension) {	// base condition : terminate recursion when N*N steps already been taken
			return true;
		}
		
        int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};		// listing combination of moves from a node
        int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
		if (x >= 0 && x < dimension && y >= 0 && y < dimension) {	// to avoid arrayOutOfIndex exception
			if (board[x][y] == -1) {
				board[x][y] = step;
			} else							// return false if node already contain a step
				return false;
		} else {
			return false;
		}
		
		for (int i = 0; i < 8; i++) {		// checking all the eight possible moves
			if (placeKnight(board, x + moveX[i], y + moveY[i], dimension, step + 1)) {  // calling recursive function for next step
				return true;
			}
		}
		board[x][y] = -1; 					// backtracking
		return false; 
	}
	
}