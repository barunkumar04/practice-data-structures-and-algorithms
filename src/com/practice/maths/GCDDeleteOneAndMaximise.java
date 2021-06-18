package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 

Problem Description
	Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
	Find the maximum value of GCD.

Problem Constraints
	2 <= N <= 105
	1 <= A[i] <= 109

Input Format
	First argument is an integer array A.

Output Format
	Return an integer denoting the maximum value of GCD.

Example Input
	Input 1:
		A = [12, 15, 18]
	Input 2:
		A = [5, 15, 30]
		
Example Output
	Output 1:
		6
	Output 2:
		15

Example Explanation
Explanation 1:
 
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.

 *
 * @author Barun
 *
 */
public class GCDDeleteOneAndMaximise {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12, 15, 18));
		
		System.out.println(maximizeGCD(A));
	}

	public static int maximizeGCD(ArrayList<Integer> A) {

		if(A == null || A.size() < 2) {
			return -1;
		}
		if(A.size() == 2) {
			return Math.max(A.get(0), A.get(1));
		}
		
		int size = A.size();
		
		int[] prefixGCD = new int[size];
		int[] postfixGCD = new int[size];

		// Calculate prefix gcd
		prefixGCD[0] = A.get(0);
		for (int i = 1; i < size; i++) {
			prefixGCD[i] = gcd(A.get(i), prefixGCD[i - 1]);
		}

		postfixGCD[size-1] = A.get(size-1);
		for (int i = A.size() - 2; i >= 0; i--) {
			postfixGCD[i] = gcd(A.get(i), postfixGCD[i + 1]);
		}
		
		int maxGCD = Integer.MIN_VALUE;

		// gcd after removing first element
		maxGCD = Math.max(maxGCD, postfixGCD[1]);

		// gcd after removing last element
		maxGCD = Math.max(maxGCD, prefixGCD[A.size() - 2]);

		for (int i = 1; i <= A.size() - 2; i++) {
			maxGCD = Math.max(maxGCD, gcd(prefixGCD[i - 1], postfixGCD[i + 1]));
		}

		return maxGCD;
	}

	private static int gcd(int a, int b) {

		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

}
