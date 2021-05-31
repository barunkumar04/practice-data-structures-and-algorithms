package com.practice.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 
Problem description
	The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
	Given an integer A, return all distinct solutions to the n-queens puzzle.
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
	The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
	1 <= A <= 10

Input Format
	First argument is an integer n denoting the size of chessboard

Output Format
	Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Example Input
	Input 1:
		A = 4
	Input 2:
		A = 1

Example Output
	Output 1:
		[
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
	Output 2:

	[
	 [Q]
	]


Example Explanation
	Explanation 1:
		There exist only two distinct solutions to the 4-queens puzzle:
	Explanation 1:
		There exist only one distinct solutions to the 1-queens puzzle:
 * 
 * @author Barun
 *
 */

public class NQueen {

	private static ArrayList<ArrayList<String>> boardWithQueens = null;
	private static int rows = 0;
	private static int cols = 0;
	private static Map<Integer, Boolean> queensInColTracker = null;
	private static Map<Integer, Boolean> queensInLeftDiagonalTracker = null;
	private static Map<Integer, Boolean> queensInRightDiagonalTracker = null;

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));

	}

	public static ArrayList<ArrayList<String>> solveNQueens(int A) {

		
		boardWithQueens = new ArrayList<ArrayList<String>>();
		
		rows = A;
		cols = A;
		
		//These maps helps in identifying in a queen is placed in same column/left diagonal /right diagonal in O(1) time.  
		queensInColTracker = new HashMap<>();
		queensInLeftDiagonalTracker = new HashMap<>();
		queensInRightDiagonalTracker = new HashMap<>();

		//create a board of AxA to place A queens
		int[][] board = new int[A][A]; // by default all values are zero

		int startRow = 0;
		placeAQueens(board, startRow);

		return boardWithQueens;
	}

	private static void placeAQueens(int[][] board, int row) {
		// base case - when row reaches end of the board
		if (row >= rows) {
			// Converting board (with 0 and 1) to result format i.e. ". . Q ."
			convertBoardToStringFormat(board);
			return;
		}

		// In current row, iterate each columns check for valid placements
		for (int col = 0; col < cols; col++) {
			if (isSafe(board, row, col)) { 
				board[row][col] = 1;
				//Mark that a queen is placed in current column, left diagonal and right diagonal
				queensInColTracker.put(col, true);
				queensInLeftDiagonalTracker.put(col - row, true);
				queensInRightDiagonalTracker.put(col + row, true);

				placeAQueens(board, row + 1);
				
				//Back track - Queen placement, column marking, left diagonal marking and right doagonal marking
				board[row][col] = 0;
				queensInColTracker.put(col, false);
				queensInLeftDiagonalTracker.put(col - row, false);
				queensInRightDiagonalTracker.put(col + row, false);

				
			}
		}

	}
	
	private static void convertBoardToStringFormat(int[][] board) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < rows; i++) {
			String resultRow = "";
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 1) {
					resultRow = resultRow + "Q";
				} else {
					resultRow = resultRow + ".";
				}
			}
			result.add(resultRow);
		}
		boardWithQueens.add(result);
		
	}

	/**
	 * 1. No need to check for row as we are proceeding row wise and only one queen is placed in that row
	 * 2. Column check - Column number is hashed to track if any queen in same column
	 * 3. Left to right diagonal check - Difference of column and row is same for each element in left diagonal. 
	 * 4. Right to Left diagonal check - Sum of column and row is same for each element in right diagonal
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isSafe(int[][] board, int row, int col) {

		// No ned to check for row as we are proceeding after
		// putting 1 queen in the row, so we were sure there were no other queens in
		// that row

		// checking if there exists a queen in cols, left diagonal or right diagonal
		boolean placedInColumn = (queensInColTracker.get(col) == null || queensInColTracker.get(col) == false)? false:true;
		boolean placedInLeftDiagonal = (queensInLeftDiagonalTracker.get(col - row) == null || queensInLeftDiagonalTracker.get(col - row) == false)? false:true;
		boolean placedInRightDiagonal = (queensInRightDiagonalTracker.get(col + row) == null|| queensInRightDiagonalTracker.get(col + row) == false)?false:true;
		if (placedInColumn || placedInLeftDiagonal || placedInRightDiagonal) {
			return false;
		}

		return true;
	}
}
