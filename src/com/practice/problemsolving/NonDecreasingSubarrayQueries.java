package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
Non decreasing subarray queries
	Problem Description
		Given an array A of size N. You will be given M queries to process. Each query will be of the form B[i][0] B[i][1].
		If the subarray from B[i][0] to B[i][1] is non decreasing, the output should be 1 else output should be 0.
		Return an array of integers answering each query.

Problem Constraints
	1 <= N <= 105
	1 <= A[i] <= 109
	1 <= M <= 105
	1 <= B[i][0], B[i][1] <= N

Input Format
	First argument contains the array A.
	Second argument contains B, denoting the queries.

Output Format
	Return an array of integers consisting of 0 and 1

Example Input
Input :
	A = [1, 7, 3, 4, 9]
	B = [ 
	      [1, 2], 
	      [2, 4]
	    ]

Example Output
	Input : [1, 0]

Example Explanation
	Explanation :
	Query 1: The subarray in the range [1, 2] is {1, 7} which is non-decreasing. Therefore, ans = 1
	Query 2: The subarray in the range [2, 4] is {7, 3, 4, 9} which is not non-decreasing. Therefore, ans = 0
 * 
 * 
 * @author Barun
 *
 */

public class NonDecreasingSubarrayQueries {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 3, 4, 9));
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
		
		System.out.println(solve(A, B));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<Integer> subsidiaryArray = new ArrayList<Integer>();

		// Preparing sub-sidiary array
		subsidiaryArray.add(0);
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) >= A.get(i - 1)) {
				subsidiaryArray.add(0);
			} else {
				subsidiaryArray.add(1);
			}
		}
		ArrayList<Integer> prefixSum = new ArrayList<Integer>();
		prefixSum.add(subsidiaryArray.get(0));

		// Prefix sum
		for (int i = 1; i < subsidiaryArray.size(); i++) {
			prefixSum.add(subsidiaryArray.get(i) + prefixSum.get(i - 1));
		}

		// Processing queries
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < B.size(); i++) {
			int l = B.get(i).get(0) - 1;
			int r = B.get(i).get(1) - 1;

			int sum = prefixSum.get(r) - prefixSum.get(l);

			if (sum == 0) {
				result.add(1);
			} else {
				result.add(0);
			}
		}

		return result;

	}
}
