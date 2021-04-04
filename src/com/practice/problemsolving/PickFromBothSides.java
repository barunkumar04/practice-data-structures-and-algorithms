package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 10, -2, 3 , 1, 2, -10));
		int B =3;
		System.out.println(solve(A, B));
	}
	
	 public static int solve(ArrayList<Integer> A, int B) {
	        
	        int B_element_sum = 0;
	        
	        for(int i=0; i<B; i++){
	            B_element_sum += A.get(i);
	        }
	        
	        int partToExcludeIndex = 0;
	        int maxSum = Integer.MIN_VALUE;
	        
	        A.addAll(A);
	        
	        for(int i = B; i<A.size(); i++){
	            int tempSum = B_element_sum + A.get(i) - A.get(partToExcludeIndex);
	            if(tempSum > maxSum)
	                maxSum = tempSum;
	            B_element_sum = tempSum;
	            partToExcludeIndex++;
	        }
	        
	        return maxSum;
	        
	    }
}
