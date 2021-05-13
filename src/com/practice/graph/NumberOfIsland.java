package com.practice.graph;

/**
 * 
 * Problem statement and example -
 * https://www.geeksforgeeks.org/find-number-of-islands/
 * 
 * Approach 
 * 1. Iterate 2-D matrix 
 * 		a. if matrix[i][j] == 1 and its not visited counter++ 
 * 		b. call a recursive function to mark all adjacent cells as visited
 * 
 * @author Barun
 *
 */

public class NumberOfIsland {

	private static int ROWS = 5;
	private static int COLS = 5;
	public static void main(String[] args) {
		
		int islands[][] = new int[][] { 
								{ 1, 1, 0, 0, 0 }, 
								{ 0, 1, 0, 0, 1 }, 
								{ 1, 0, 0, 1, 1 }, 
								{ 0, 0, 0, 0, 0 },
								{ 1, 0, 1, 0, 1 } };
				
		boolean visisted[][] = new boolean[ROWS][COLS];

		int countOfIsland = countNumberOfIsland(islands, visisted);
		System.out.println("Count of island:"+countOfIsland);
	}

	private static int countNumberOfIsland(int[][] islands, boolean[][] visisted) {
		int count = 0;
		
		//Represent 8 adjacent moves
		int[][] moves = new int[][]{
			{ -1, -1, -1, 0, 0, 1, 1, 1 },
			{ -1, 0, 1, -1, 1, -1, 0, 1 }
		};
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				if(islands[i][j] == 1 && !visisted[i][j]) {
					count++;
					markVisistedToAdjecents(i, j, islands, visisted, moves);
				}
				
				
				
				
			}
		}	
		
		return count;
	}

	/**
	 *  if its a safe move and not visited mark it to visited
	 * @param col 
	 * @param row 
	 * @param islands 
	 */
	private static void markVisistedToAdjecents(int row, int col, int[][] islands, boolean[][] visisted, int[][] moves) {
		
		//marking current as visited 
		visisted[row][col] = true;
		
		//marking adjacent as visited 
		for(int i=0; i<8;i++) {
			if(isSafe(row + moves[0][i], col + moves[1][i], islands, visisted)) {
				markVisistedToAdjecents(row + moves[0][i], col + moves[1][i], islands, visisted, moves);
			}
		}
		
	}

	private static boolean isSafe(int moveRow, int moveCol, int[][] islands, boolean[][] visisted) {
		if(moveRow >= 0 && moveCol >=0  && moveRow < ROWS && moveCol < COLS && islands[moveRow][moveCol] == 1 && !visisted[moveRow][moveCol])
			return true;
		return false;
	}


}
