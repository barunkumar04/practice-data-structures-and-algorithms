package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Observation:
 *  1. To under stand the pattern and relation, let try to break out the equation |A[i] - A[j]| + |i - j|
 *      a. (A[i] - A[j]) + (i - j) where A[i] >= A[j] and i >= j
 *      b. (A[i] - A[j]) + (j - i) where A[i] >= A[j] and i < j
 *      c. (A[j] - A[i]) + (j - i) where A[j] >= A[i] and j >= i
 *      d. (A[j] - A[i]) + (i - j) where A[j] >= A[i] and j < i
 * 
 * 2. 1a can be re-written as (A[i] + i) - (A[j] + j). This is noting but sum of element and index. 
 *    Now to maximize this we need to take maximum for (A[i] + i) and minimum of (A[j] + j)
 * 
 * 3. 1b can be re-written as (A[i] - i) - (A[j] - j). This is noting but sum of element and index. 
 *    Now to maximize this we need to take maximum for (A[i] - i) and minimum of (A[j] - j)
 * 
 * 4. 1c can be re-written as (A[j] + j) - (A[i] + i). This is noting but sum of element and index. 
 *    Now to maximize this we need to take maximum for (A[j] + j) and minimum of (A[i] + i). Since we are dealing with absolute this statment is same as #2
 * 
 * 5. 1d can be re-written as (A[j] - j) - (A[i] - i). This is noting but sum of element and index. 
 *    Now to maximize this we need to take maximum for (A[j] - j) and minimum of (A[i] - i). Since we are dealing with absolute this statment is same as #3
 * 
 * 
 * Approach:
 * 1. With the help of above observation, create following array :
 *      a. ArrayIndexAdd such that ArrayIndexAdd[i] is having sum of element and index
 *      b. ArrayIndexSubs such that ArrayIndexSubsd[i] is having substraction of element and index
 * 2. Take differences of max and min from #1a
 * 3. Take differences of max and min from #1b
 * 4. Maximum between #2 and #3 is answer.
 * 
 * */

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 3, -1));
		System.out.println(maxArr(input));

	}

	public static int maxArr(ArrayList<Integer> A) {
		int result = 0;
		ArrayList<Integer> arrayIndexAdd = new ArrayList<Integer>();
		ArrayList<Integer> arrayIndexSubs = new ArrayList<Integer>();

		for (int i = 0; i < A.size(); i++) {
			arrayIndexAdd.add(A.get(i) + i);
			arrayIndexSubs.add(A.get(i) - i);
		}
		
		// Above tow arrays have values as element and index combined
		
		//Find max and min when i > j
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {
			if (arrayIndexAdd.get(i) > max)
				max = arrayIndexAdd.get(i);

			if (arrayIndexAdd.get(i) < min)
				min = arrayIndexAdd.get(i);

		}

		result = max - min;
		
		//Find max and min when i < j
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			if (arrayIndexSubs.get(i) > max)
				max = arrayIndexSubs.get(i);

			if (arrayIndexSubs.get(i) < min)
				min = arrayIndexSubs.get(i);

		}

		if ((max - min) > result) {
			result = max - min;
		}

		return result;
	}
}
