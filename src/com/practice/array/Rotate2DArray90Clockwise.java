package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Rotate2DArray90Clockwise {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,2));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(3,4));
		
		A.add(row1);
		A.add(row2);
		solve(A);
		System.out.println(A);
		
	}

	private static void solve(ArrayList<ArrayList<Integer>> A) {
		int row = A.size();
		int col = A.get(0).size();
		
		
		
		int[][] array = new int[row][col];
		// initialization

		for(int i=0; i<A.size(); i++){
            ArrayList<Integer> arrayRow = A.get(i);
            for(int j=0; j<arrayRow.size(); j++){
                array[i][j] = arrayRow.get(j);
            }
      }
		
		System.out.println("Input array:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j] + "   ");
			}

			System.out.println();
		}

		
		rotate90DegreeClockwise(array, row, col);
		
		System.out.println("Rotated 90 -degree clockwise..");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(array[i][j] + "   ");
			}

			System.out.println();
		}
		
		System.out.println("Arraylist output...");
		A.clear(); 
		for(int i=0; i<row; i++){
             ArrayList<Integer> resultRow = new ArrayList<Integer>();
             //A.remove(i);
             for(int j=0; j<col; j++){
           	  resultRow.add(array[i][j]);
             }
             A.add(resultRow);
       }
		
	}

	private static void rotate90DegreeClockwise(int[][] array, int n, int m) {

		// Step 1 - Transpose the array
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < m; j++) {
				swap(array, i, j, j, i);
			}
		}
		
		System.out.println("Array after tranpose.");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(array[i][j] + "   ");
			}

			System.out.println();
		}
		
		// Step 2 - reverse each row
		for (int row = 0; row < n; row++) {
			int startCol = 0;
			int endCol = m-1;
			
			while(startCol <= endCol) {
				swap(array, row, startCol, row, endCol);
				startCol++;
				endCol--;
			}
		}
		

	}

	private static void swap(int[][] array, int row1, int col1, int row2, int col2) {
		int temp = array[row1][col1];
		array[row1][col1] = array[row2][col2];
		array[row2][col2] = temp;

	}
}
