package com.practice.array;

public class SpiralTraversal {

	public static void main(String[] args) {
		int[][] array = new int[3][3];
		// initialization
		
		int counter = 1;
		for(int i=0;i<3; i++) {
			for(int j=0;j<3; j++) {
				array[i][j] = counter++;
			}
		}
		System.out.println("Input array:");
		for(int i=0;i<3; i++) {
			for(int j=0;j<3; j++) {
				System.out.print(array[i][j]+"   ");
			}
			
			System.out.println();
		}
		
		System.out.println("Spiral traversal: ");
		traverseSpiral(array, 3,3);
		

	}

	private static void traverseSpiral(int[][] array, int n, int m) {
		int top = 0;
		int right = m-1;
		int bottom = n-1;
		int left = 0;
		
		while(top <= bottom && left <= right) {
			// Top row, left to right traversal
			for(int i=left; i<=right; i++) {
				System.out.print(array[top][i]+"   ");
			}
			top++;
			
			// Last column, top to bottom traversal
			for(int i=top; i<=bottom; i++) {
				System.out.print(array[i][right]+"   ");
			}
			right--;
			
			// Bottom, right to left traversal
			for(int i=right; i>=left; i--) {
				System.out.print(array[bottom][i]+"   ");
			}
			bottom--;
			
			// left, bottom to top traversal
			for(int i=bottom; i>=top; i--) {
				System.out.print(array[i][left]+"   ");
			}
			left++;
		}
	}

}
