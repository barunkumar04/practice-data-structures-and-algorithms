package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
SUBARRAY OR
Problem Description

Given an array of integers A of size N. Value of a subarray is defined as BITWISE OR of all elements in it.
Return the sum of Value of all subarrays of A % 10^9 + 7.

Problem Constraints
	1 <= N <= 105
	1 <= A[i] <= 108

Input Format
	The first argument given is the integer array A.

Output Format
	Return the sum of Value of all subarrays of A % 109 + 7.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [7, 8, 9, 10]

Example Output
Output 1:
	71
Output 2:
	110

Example Explanation
	Explanation 1:
		 Value([1]) = 1
		 Value([1, 2]) = 3
		 Value([1, 2, 3]) = 3
		 Value([1, 2, 3, 4]) = 7
		 Value([1, 2, 3, 4, 5]) = 7
		 Value([2]) = 2
		 Value([2, 3]) = 3
		 Value([2, 3, 4]) = 7
		 Value([2, 3, 4, 5]) = 7
		 Value([3]) = 3
		 Value([3, 4]) = 7
		 Value([3, 4, 5]) = 7
		 Value([4]) = 4
		 Value([4, 5]) = 5
		 Value([5]) = 5
		 Sum of all these values = 71
	Explanation 2:
 		Sum of value of all subarray is 110.
 * 
 * @author Barun
 *
 */

public class SubarrayBitwiseORsSum {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
		System.out.println(subarrayBitwiseORsSum(input));
	}
	
	public static int subarrayBitwiseORsSum(ArrayList<Integer> A) {
		long resultSum = 0;
		/**
		 *  Constructing vertical binary bit table
		 *  Eg - [1,2,3]
		 *  
		 *  0 0 0 
		 *  0 1 1
		 *  1 0 1
		 *  
		 *  col 1 : 1 x 2^0 + 0 x 2^1 + 0 x 2^2 = 1
		 *  col 2 : 0 x 2^0 + 1 x 2^1 + 0 x 2^2 = 2
		 *  col 1 : 1 x 2^0 + 1 x 2^1 + 0 x 2^2 = 3
		 *  
		 **/
		int[][] verticalBinaryTable = new int[32][A.size()];
		
		for (int i=0; i<A.size(); i++) {
				int num = A.get(i);
				for(int j=31; j>=0;j--) {
					verticalBinaryTable[j][i] = num & 1; // Taking LSB
					num = num>>1; // Right shifting
				}
		}
		
		/*
		 * for each row calculate
		 * 		Total number of sub-array - Total number subarrays having 0
		 * 		Above calculated result will be multiplied with its position power of 2.
		 * 		Sum it
		 * Final sum will be answer
		 * 
		 * Number of sub-arrays in a array is size n is n x n(+1) / 2	
		 */
		
		long arraysSize = A.size(); // i.e. number of columns in above binary table
		long totalSubArray = (arraysSize * (arraysSize + 1) )/ 2;
		long pow = 31;
		long mod = 1000000007;
		for(int i=0; i<32;i++){
			long zeroStartindex = -1;
			long zeroEndindex = -1;
			long totalZeroSubArray = 0;
			long sum = 0;
			long length = 0;
			for(int j=0;j<arraysSize;j++) {
				if(verticalBinaryTable[i][j] == 0 && zeroStartindex == -1) {
					zeroStartindex = j;
				}
				if(verticalBinaryTable[i][j] == 1 && zeroStartindex != -1) {
					zeroEndindex = j-1;
					length = zeroEndindex - zeroStartindex + 1;
					totalZeroSubArray = totalZeroSubArray + (length * (length+1)) / 2;
					zeroStartindex = zeroEndindex = -1;
				}
				sum+=verticalBinaryTable[i][j];
			}
			if(zeroStartindex != -1 && zeroEndindex == -1) { // i.e. this case 11000, then sub array for last 2 zero wont be calculated in above logic
				length = arraysSize - zeroStartindex;
				totalZeroSubArray = totalZeroSubArray + (length * (length+1)) / 2;
			}
			if(sum == 0 ) { // i.e. this case 00000.
				totalZeroSubArray = totalSubArray;
			}
			long totalSubArraysHavingOne = totalSubArray - totalZeroSubArray; 
			resultSum = (long)(resultSum + totalSubArraysHavingOne * Math.pow(2, pow)% mod) % mod;
			
			pow--;
		}
		
		return (int) (resultSum % 1000000007);
    }
}
