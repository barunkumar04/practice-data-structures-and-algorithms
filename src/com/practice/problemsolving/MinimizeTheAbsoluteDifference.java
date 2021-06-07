package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**

Minimize the absolute difference
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :
	Input:
		A : [ 1, 4, 5, 8, 10 ]
		B : [ 6, 9, 15 ]
		C : [ 2, 3, 6, 6 ]
	Output:
		1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 
 
 * 
 * @author Barun
 *
 */
public class MinimizeTheAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 8, 10 ));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(6, 9, 15));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 6));
		
		System.out.println(solve(A, B, C));
	}
	
	/**
	 * Approach - https://docs.google.com/document/d/17aH49Hpk94X2wtLi0Qa2VSmattzIAWFnHJ0uPd4hgbo/edit#
	 * 	
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

		int i = 0;
		int j = 0;
		int k = 0;

		int result = Integer.MAX_VALUE;
		while (i < A.size() && j < B.size() && k < C.size()) {
			int max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
			int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

			if (Math.abs(max - min) < result) {
				result = Math.abs(max - min);
			}

			if (min == A.get(i)) {
				i++;
			} else {
				if (min == B.get(j)) {
					j++;
				} else {
					k++;
				}
			}
		}

		return result;

	}
}
