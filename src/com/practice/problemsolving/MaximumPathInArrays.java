package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Problem Description Given two sorted arrays A and B, such that the arrays may
 * have some common elements. Find the sum of the maximum sum path to reach from
 * the beginning of any array to end of any of the two arrays. We can switch
 * from one array to another array only at common elements.
 * 
 * NOTE: The common elements do not have to be at the same indexes.
 * 
 * Problem Constraints 1 <= |A|, |B| <= 105 1 <= A[i], B[i] <= 103
 * 
 * Input Format First argument is an integer array A. Second argument is an
 * integer array B.
 * 
 * Output Format Return a single integer denoting the maximum sum path.
 * 
 * Example Input Input 1: A = [2, 3, 7, 10, 12] B = [1, 5, 7, 8] Input 2: A =
 * [10, 12] B = [5, 7, 9]
 * 
 * Example Output Output 1: 35 Output 2: 22
 * 
 * Example Explanation Explanation 1: 35 is sum of 1 + 5 + 7 + 10 + 12. We start
 * from the first element of B which is 1, then we move to 5, then 7. From 7, we
 * switch to A (as 7 is common) and traverse 10 and 12. Explanation 2: 22 is the
 * sum of 10 and 12. Since there is no common element, we need to take all
 * elements from the array with more sum.
 * 
 * @author Barun
 *
 */

public class MaximumPathInArrays {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 5, 6));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 8, 9, 9, 10));
		System.out.println(solve(A, B));
	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		int length1 = A.size();
		int length2 = B.size();

		int pointer1 = 0;
		int pointer2 = 0;

		int sum1 = 0;
		int sum2 = 0;

		int ans = 0;

		while (pointer1 < length1 && pointer2 < length2) {
			// ascending to lesser element
			if (A.get(pointer1) < B.get(pointer2)) {
				sum1 += A.get(pointer1);
				pointer1++;
			} else if (A.get(pointer1) > B.get(pointer2)) {
				sum2 += B.get(pointer2);
				pointer2++;
			} else { // we reached to a common element
				ans += A.get(pointer1);// Adding only one since both are common

				// Check which path has max value, that will accumulated to answer
				ans += sum1 > sum2 ? sum1 : sum2;

				// Since path is common now, reseting sum1 and sum2
				sum1 = 0;
				sum2 = 0;
				pointer1++;
				pointer2++;
			}
		}
		
		//processing for tail elements after last conjunction
		while(pointer1 < length1) {
			sum1 += A.get(pointer1);
			pointer1++;
		}
		while(pointer2 < length2) {
			sum2 += B.get(pointer2);
			pointer2++;
		}
		
		ans += sum1 > sum2 ? sum1 : sum2;

		return ans;

	}

}
