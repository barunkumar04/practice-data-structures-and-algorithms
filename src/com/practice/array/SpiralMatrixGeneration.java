package com.practice.array;

public class SpiralMatrixGeneration {

	public static void main(String[] args) {
		// initialization
		int size=4;
		
		System.out.println("Spiral traversal: ");
		int[][] result =  generateSpiralMatrix(size);
		System.out.println("result array:");
		for(int i=0;i<size; i++) {
			for(int j=0;j<size; j++) {
				System.out.print(result[i][j]+"   ");
			}
			
			System.out.println();
		}

	}

	private static int[][] generateSpiralMatrix(int n) {
		int[][] array = new int[n][n]; 
		int counter = 1;
		int top = 0;
		int right = n-1;
		int bottom = n-1;
		int left = 0;
		
		while(top <= bottom && left <= right && counter <= n*n) {
			// Top row, left to right traversal
			for(int i=left; i<=right; i++) {
				array[top][i] = counter++;
			}
			top++;
			
			// Last column, top to bottom traversal
			for(int i=top; i<=bottom; i++) {
				array[i][right]= counter++;
			}
			right--;
			
			// Bottom, right to left traversal
			for(int i=right; i>=left; i--) {
				array[bottom][i] = counter++;
			}
			bottom--;
			
			// left, bottom to top traversal
			for(int i=bottom; i>=top; i--) {
				array[i][left]= counter++;
			}
			left++;
		}
		
		return array;
	}

}
