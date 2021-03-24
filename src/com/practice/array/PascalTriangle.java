package com.practice.array;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		int row = 6;
		
		ArrayList<ArrayList<Integer>> pascalTriangle = generatePascalTriangle(row);
		
		System.out.println(pascalTriangle);
	}

	/**
	 * Logic - In Pascal's Triangle, each row is value of increasing power of 11. 
	 * Row 1 = 11^0 = 1
	 * Row 2 = 11^1 = 11
	 * Row 3 = 11^2 = 121
	 * ..... and so on.
	 * 
	 * @param row
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> generatePascalTriangle(int rowCount) {
		

	      
	      ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<ArrayList<Integer>>();
	      	ArrayList<Integer> row = null;
	      for(int i=1; i<=rowCount; i++){
	          row = new ArrayList<Integer>();
	          for(int j=1; j<=i; j++){
	              //first and last values are always 1
	              
	              if(j==1 || j==i){
	                  row.add(1);
	                  continue;
	              }else{
	            	  ArrayList<Integer> prevRow = pascalTriangle.get(i-2);
	                  int prevElement1 = prevRow.get(j-2);
	                  int prevElement2 = prevRow.get(j-1);
	                  row.add(prevElement1+prevElement2);
	              }
	              
	          }
	          
	          pascalTriangle.add(row);
	          
	      }  
	      
	      return pascalTriangle;
	}

}
