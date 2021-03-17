package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A =  new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(4,5,6));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(7,8,9));
		
		A.add(row1);
		A.add(row2);
		A.add(row3);
		
		antiDiagonal(A);
	}
	
	/**
	 *  A : 
	 *	[
	 *	  [1, 2, 3]
	 *	  [4, 5, 6]
	 *	  [7, 8, 9]
	 *	]
	 *
	 *[1 ]  [2 4 ] 		  [3 5 7 ] 				[6 8 ] 		  [9 ] 
	 *[(0,0)] [(0,1) (1,0)] [(0,2) (1, 1) (2,1)]  [(1,2) (2,1)] [(2,2)]
	 * 
	 * @param A
	 * @return
	 */
	
	 public static ArrayList<ArrayList<Integer>> antiDiagonal(ArrayList<ArrayList<Integer>> A) {
	        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        int[][] twoDArray = new int[A.size()][A.size()];
	        int n = A.size();
	        for(int i=0; i<n; i++){
	            ArrayList<Integer> row = A.get(i);
	            for(int j=0; j< n; j++){
	                twoDArray[i][j] = row.get(j);
	            }
	        }
	        
	        for(int i=0; i<n; i++){
	             ArrayList<Integer> row = new  ArrayList<Integer>();
	            for(int j=0; j<=i; j++){
	                row.add(twoDArray[j][i]);
	            }
	            result.add(row);
	        }
	        
	        return result;
	        
	    }
}
