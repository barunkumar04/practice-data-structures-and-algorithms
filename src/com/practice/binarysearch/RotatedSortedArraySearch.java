package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
Problem Description

	Given a sorted array of integers A of size N and an integer B. array A is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
	
	You are given a target value B to search. If found in the array, return its index, otherwise return -1. You may assume no duplicate exists in the array.
	NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
	1 <= N <= 1000000
	1 <= A[i] <= 10^9
all elements in A are disitinct.

Input Format
	The first argument given is the integer array A.
	The second argument given is the integer B.

Output Format
	Return index of B in array A, otherwise return -1

Example Input
	Input 1:
		A = [4, 5, 6, 7, 0, 1, 2, 3]
		B = 4
Input 2:
		A = [1]
		B = 1


Example Output
	Output 1:
		0
	Output 2:
		0


Example Explanation
	Explanation 1:
		Target 4 is found at index 0 in A.
	Explanation 2:
		Target 1 is found at index 0 in A.
 * 
 * @author Barun
 *
 */

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 67, 133, 178));
		int B = 1;
		int start = 0;
		int end = A.size() - 1;
		int pivotIndex = findPivotIndex(A, start, end);
		int matchedIndex = -1;
		if (pivotIndex == -1) {
			matchedIndex = binarySearch(A, start, end, B);
		} else if (B >= A.get(0))
			matchedIndex = binarySearch(A, start, pivotIndex - 1, B);
		else
			matchedIndex = binarySearch(A, pivotIndex, end, B);
		System.out.println(matchedIndex);

	}

	/**
	 * Observation: 
	 * 
	 * 1. Left and Right elemnt of rotation start element(lets say
	 * pivot element) is always greater than the element. For example 7 and 1 are
	 * greater than 0 [4, 5, 6, 7, 0, 1, 2, 3] 
	 * 
	 * 2. If we are able to find pivot
	 * element then a. If element to search (say k), is greated than A[0] then k
	 * must be between 0 and pivot-1 b. Otherwise k is in between pivot and end
	 * 
	 */

	private static int binarySearch(List<Integer> A, int start, int end, int k) {
		if (start > end) {
			return -1; // K not found
		}

		int mid = start + ((end - start) / 2);
		if (k == A.get(mid))
			return mid;
		if (k > A.get(mid)) {
			return binarySearch(A, mid + 1, end, k);
		} else {
			return binarySearch(A, start, mid - 1, k);
		}

	}

	private static int findPivotIndex(List<Integer> A, int start, int end) {
		if (start > end) {
			return -1; // there is no rotation in input
		}

		int mid = start + ((end - start) / 2);

		int leftElement = Integer.MIN_VALUE;
		if ((mid - 1) >= 0) {
			leftElement = A.get(mid - 1);
		}

		int rightElement = Integer.MAX_VALUE;
		if ((mid + 1) <= end) {
			rightElement = A.get(mid + 1);
		}

		// checking if its pivot element
		if (leftElement > A.get(mid) && rightElement > A.get(mid)) {
			return mid;
		}

		if (A.get(mid) > A.get(0)) {
			return findPivotIndex(A, mid + 1, end);
		} else {
			return findPivotIndex(A, start, mid);
		}

	}
}
