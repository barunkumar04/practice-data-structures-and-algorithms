package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**
  
Problem Description
	You are given an array A (containing only 0 and 1) as element of N length.
	Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.

Problem Constraints
	1<=N,Q<=100000
	1<=L<=R<=N

Input Format
	First argument contains the array of size N containing 0 and 1 only. 
	Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.

Output Format
	Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.

Example Input
	A=[1,0,0,0,1]
	B=[ [2,4],
	    [1,5],
	    [3,5] ]

Example Output
	[[0 3]
	[0 3]
	[1 2]]


Example Explanation
	In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
	For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
	Similarly for other queries.
  
 * @author Barun
 *
 */

public class XORQueries {

	public static void main(String[] args) {
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1,0,0,0,1));
		
		ArrayList<ArrayList<Integer>> queries = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> q1 = new ArrayList<Integer>(Arrays.asList(2,4)); 
		ArrayList<Integer> q2 = new ArrayList<Integer>(Arrays.asList(1,5)); 
		ArrayList<Integer> q3 = new ArrayList<Integer>(Arrays.asList(3,5)); 
		
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		
		System.out.println(solve(inputArray, queries));

	}
	
	public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> prefixSumList = new ArrayList<Integer>();
		prefixSumList.add(0); 
		int previousSum = 0;
		for(int i=0; i<A.size(); i++) {
			previousSum += A.get(i);
			prefixSumList.add(previousSum);
		}
		ArrayList<Integer> q_result = null;
		for (ArrayList<Integer> query : B) {
			q_result =  new ArrayList<Integer>();
			int left = query.get(0);
			int right = query.get(1);
			findXoRAndCountUnsetBit(left, right, q_result, prefixSumList); // Not doing left -1 and right-1, because in prefix sum array added one extra 0
			result.add(q_result);
			
		}
		return result;
    }

	private static void findXoRAndCountUnsetBit(int left, int right, ArrayList<Integer> q_result, ArrayList<Integer> prefixSumList) {
		int countof1 = prefixSumList.get(right) - prefixSumList.get(left - 1);
		int countof0 = (right-left + 1) - countof1; // total length right-left + 1
		
		int xor = 0;
		if(countof1 % 2 != 0) {
			xor = 1;
		}
		
		q_result.add(xor);
		q_result.add(countof0);
	}
}
