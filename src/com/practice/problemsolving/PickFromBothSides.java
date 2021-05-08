package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Pick from both sides! Problem Description
 * 
 * Given an integer array A of size N.
 * 
 * You can pick B elements from either left or right end of the array A to get
 * maximum sum.
 * 
 * Find and return this maximum possible sum.
 * 
 * NOTE: Suppose B = 4 and array A contains 10 elements then:
 * 
 * You can pick first four elements or can pick last four elements or can pick 1
 * from front and 3 from back etc . you need to return the maximum possible sum
 * of elements you can pick.
 * 
 * 
 * Problem Constraints 1 <= N <= 105
 * 
 * 1 <= B <= N
 * 
 * -103 <= A[i] <= 103
 * 
 * 
 * 
 * Input Format First argument is an integer array A.
 * 
 * Second argument is an integer B.
 * 
 * 
 * 
 * Output Format Return an integer denoting the maximum possible sum of elements
 * you picked.
 * 
 * 
 * 
 * Example Input Input 1:
 * 
 * A = [5, -2, 3 , 1, 2] B = 3 Input 2:
 * 
 * A = [1, 2] B = 1
 * 
 * 
 * Example Output Output 1:
 * 
 * 8 Output 2:
 * 
 * 2
 * 
 * 
 * Example Explanation Explanation 1:
 * 
 * Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 =
 * 8 Explanation 2:
 * 
 * Pick element 2 from end as this is the maximum we can get
 * 
 * @author Barun
 *
 */

//TODO - Write alog 
public class PickFromBothSides {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 6, 0, 4, 5));
		int B = 3;
		System.out.println(solve(A, B));
		System.out.println(solve1(A, B));
	}

	private static int solve1(ArrayList<Integer> a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int solve(ArrayList<Integer> A, int B) {
		// 1,2,3,4,5,1,2,3,4,5 | 3
		int B_element_sum = 0;
		int size = A.size();

		for (int i = (size - B); i < size; i++) {
			B_element_sum += A.get(i);
		}
		int partToExcludeIndex = size - B;
		int maxSum = B_element_sum;

		A.addAll(A);

		for (int i = size; i < (size + B - 1); i++) {
			int tempSum = B_element_sum + A.get(i) - A.get(partToExcludeIndex); // 6 + 4 - 1
			if (tempSum > maxSum)
				maxSum = tempSum;
			B_element_sum = tempSum;
			partToExcludeIndex++;
		}

		return maxSum;

	}
}
