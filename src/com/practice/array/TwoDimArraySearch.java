package com.practice.array;

public class TwoDimArraySearch {
	
	/***
	 * Observation - 
	 * 	1. Start from bottom left cell, i.e. 18 
	 * 	2. if target is greater than current cell value, we must increase column 
	 * 	3. if target is less than current cell value, we must decrease row
	 *
	 **/
	
	public static void main(String[] args) {
		int[][] input = new int[][] {
			{1,4,7,11,15},
			{2,5,8,12,19},
			{3,6,9,16,22},
			{10,13,14,17,24},
			{18,21,23,26,30}
		};
		int target = 12;
		System.out.println(searchMatrix(input, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {

		int currentRow = matrix.length - 1;
		int currentCol = 0;
		int cols = matrix[0].length;

		while (currentRow >= 0 && currentCol < cols) {
			if (target == matrix[currentRow][currentCol]) {
				return true;
			}

			if (target > matrix[currentRow][currentCol])
				currentCol++;
			else if (target < matrix[currentRow][currentCol])
				currentRow--;
		}

		return false;
	}
}
