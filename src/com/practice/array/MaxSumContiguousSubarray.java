package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
Problem Description
	Find the contiguous subarray within an array, A of length N which has the largest sum.

Problem Constraints
	1 <= N <= 1e6
	-1000 <= A[i] <= 1000

Input Format
	The first and the only argument contains an integer array, A.

Output Format
	Return an integer representing the maximum possible sum of the contiguous subarray.

Example Input
Input 1:
	A = [1, 2, 3, 4, -10] 
Input 2:
	A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Example Output
Output 1:
	10 
Output 2:
 	6 

Example Explanation
	Explanation 1:
		The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
	Explanation 2:
 		The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 * 
 * 
 * @author Barun
 *
 */
public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
		System.out.println(maxSubArray(A));

	}
	
	/**
     * Observation:
     *  1. When number are all +ve, whole array sum will be the result
     *  2. When numbers are all -ve, max element is the the result
     *  2. When numbers are mixed then there could be subarrays scaterred.
     *      2.a in this case sum of such subarray element will reach to < zero.
     * 
     * */
    public static  int maxSubArray(final List<Integer> A) {
       
         int sum = Integer.MIN_VALUE;
	    int last = 0;
	    
	    for (int num : A) {
	        
	        last += num;
	        sum = Math.max(sum, last);
	        if (last < 0)
	            last = 0;
	    }
	    
	    return sum;
    }

}
