package com.practice.array;

import java.util.Arrays;

/**
 * 
Sum the Difference

Problem Description

	Given an integer array A of size N.
	You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
	As the number may be large, output the number modulo 1e9 + 7 (1000000007).
	NOTE: Subsequence can be non-contiguous.

Problem Constraints
	1 <= N <= 10000
	1<= A[i] <=1000

Input Format
	First argument is an integer array A.

Output Format
	Return an integer denoting the output.

Example Input
	Input 1:
		A = [1, 2]
	Input 2:
		A = [1]
Example Output
	Output 1:
		1
	Output 2:
		0
Example Explanation
	Explanation 1:

		All possible non-empty subsets are:
		[1]    largest-smallest = 1 - 1 = 0
		[2]    largest-smallest = 2 - 2 = 0
		[1 2]  largest-smallest = 2 - 1 = 1
		Sum of the differences = 0 + 0 + 1 = 1
		So, the resultant number is 1
Explanation 2:
 	Only 1 subsequence of 1 element is formed.
 * 
 * @author Barun
 *
 */

//TODO - Check why overflow issue for larger input
public class SumTheMaxMinDifferenceOfSubSequences {

	public static void main(String[] args) {
		int[] input = new int[3];
		input[0] = 2;
		input[1] = 5;
		input[2] = 1;
		
		System.out.println(solve(input));

	}
	
	 /**
     * Logic: 
     * 1. Lets say there n subsequence (i.e. sub-arrays with similar ordering as input array)
     * 2. For 1st sub-sequence, largest and smallest are l1 and s1 -> l1 - s1
     *    For 2nd sub-sequence, largest and smallest are l2 and s2 -> l2 - s2
     *    For 3rd sub-sequence, largest and smallest are l3 and s3 -> l3 - s3
     *    ....
     *    ....    
     *    For nth sub-sequence, largest and smallest are ln and sn -> ln - sn
     *    
     * 3. So expected output is: (l1 - s1) + (l2 - s2) + (l3 - s3) + ... + (ln - sn)
     * 4. #3, can be also interpreted as (l1 + l2 + l3 + ...+ ln) - (s1 + s2 + s3 + ...+ sn)
     * 5. So idea here is - 
     * 		a. Find largest elements in all possible subsequences      
     *      b. Find smallest elements is all possible subsequences
     *      c. Substract them and that will be the answer 
     * 6. Now, question burns down to 
     * 		a. How to find sum of all largest elements in all subsequences?
     * 			i. 	Element A[i] will present as largest element in 2^i subsequences, where i starts from 0 
     * 			ii.	Example: [1, 2, 3] -> [1], [1, 2], [1,3], [1,2,3], [2], [2, 3], [3] | 1 is largest element in 2^0, i.e. 1 subsequence | 2 is largest element in 2^1, i.e. 2 subsequence and so on..
     * 			iii. So, sum of all largest elements are: sum(A[i] x 2^i), where i starts from 0.  
     * 		b. How to find sum of all small elements in all subsequences?
     * 			i. 	Element A[i] will present as smallest element in 2^(n-1-i) subsequences, where i starts from 0 
     * 			ii.	Example: [1, 2, 3] -> [1], [1, 2], [1,3], [1,2,3], [2], [2, 3], [3] | 1 is smallest element in 2^(3-1-0), i.e. 4 subsequences | 2 is largest element in 2^(3-2-1), i.e. 2 subsequence and so on..
     * 			iii. So, sum of all largest elements are: sum(A[i] x 2^(n-1-i)), where i starts from 0.
     * 
     ***/
    
    public static int solve(int[] A) {
    	
    	Arrays.sort(A);
    	
    	long sumLargest = 0;
    	long sumSmallest = 0;
    	int length = A.length;
    	for(int i=0; i<length; i++) {
    		sumLargest = (long) (sumLargest + (A[i] * Math.pow(2, i))) ; // Refer derivation mentioned in 6.a.i
    		sumSmallest = (long) (sumSmallest + (A[i] * Math.pow(2, (length-1-i)))) ; // Refer derivation mentioned in 6.b.i
    		
    		sumLargest =sumLargest % 1000000007;
    		sumSmallest = sumSmallest % 1000000007; 
    	}
    	
    	return (int) ((sumLargest - sumSmallest) % 1000000007);
    }
}
