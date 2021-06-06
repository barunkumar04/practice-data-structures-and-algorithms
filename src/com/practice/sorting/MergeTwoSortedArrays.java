package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
Problem Description
	Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

Problem Constraints
	-1010 <= A[i],B[i] <= 1010

Input Format
	First Argument is a 1-D array representing A.
	Second Argument is also a 1-D array representing B.

Output Format
	Return a 1-D vector which you got after merging A and B.

Example Input
	Input 1:
		A = [4, 7, 9 ]
		B = [2 ,11, 19 ]
	Input 2:
		A = [1]
		B = [2]

Example Output
	Output 1:
		[2, 4, 7, 9, 11, 19]
	Output 2:
		[1, 2]

Example Explanation
	Explanation 1:
		Merging A and B produces the output as described above.
	Explanation 2:
		Merging A and B produces the output as described above.
 * 
 * @author Barun
 *
 */

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,5,6));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3,5,10));
		System.out.println(solve(list1, list2));

	}

	public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int lengthA = A.size();
		int lengthB = B.size();

		int pointerA = 0;
		int pointerB = 0;

		while (pointerA < lengthA && pointerB < lengthB) {
			if (A.get(pointerA) < B.get(pointerB)) {
				result.add(A.get(pointerA));
				pointerA = pointerA + 1;
			} else if (A.get(pointerA) >= B.get(pointerB)) {
				result.add(B.get(pointerB));
				pointerB = pointerB + 1;
			}

		}

		while (pointerA < lengthA) {
			result.add(A.get(pointerA));
			pointerA++;
		}
		while (pointerB < lengthB) {
			result.add(B.get(pointerB));
			pointerB++;
		}
		return result;

	}
}
