package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
Problem Description
	Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right. You can only see the B numbers in the window. 
	Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
	Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
	Refer to the given example for clarity.

	NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
	1 <= |A|, B <= 106
	
Input Format
	The first argument given is the integer array A.
	The second argument given is the integer B.

Output Format
	Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Example Input
	Input 1:
		A = [1, 3, -1, -3, 5, 3, 6, 7]
		B = 3
Input 2:
		A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
		B = 6

Example Output
	Output 1:
		[3, 3, 5, 5, 6, 7]
	Output 2:
		[7, 7, 7, 7]

Example Explanation
	Explanation 1:
		 Window position     | Max
		 --------------------|-------
		 [1 3 -1] -3 5 3 6 7 | 3
		 1 [3 -1 -3] 5 3 6 7 | 3
		 1 3 [-1 -3 5] 3 6 7 | 5
		 1 3 -1 [-3 5 3] 6 7 | 5
		 1 3 -1 -3 [5 3 6] 7 | 6
		 1 3 -1 -3 5 [3 6 7] | 7
	Explanation 2:
		 Window position     | Max
		 --------------------|-------
		 [1 2 3 4 2 7] 1 3 6 | 7
		 1 [2 3 4 2 7 1] 3 6 | 7
		 1 2 [3 4 2 7 1 3] 6 | 7
		 1 2 3 [4 2 7 1 3 6] | 7
 * 
 * 
 * @author Barun
 *
 */
public class SlidingWindowMaximum {

	/**
	 * Approach
	 * 	1. Iterate the input array and populate data structure with candidate max values in each k-sized window. Logic is as below
	 * 		a. Every new element would be added to candidate DS
	 * 		b. When ever we are adding a new element, all smaller elements from candidate DS would be deleted. Reason being we have found a bigger value
	 *  2. for every window slide first element from the candidate DS will be added to answer array because we have slide a k window and max of that window is not to affect upcoming window 
	 *  3. About DS - use LinkedList so that first, last element can be obtained in O(1)
	 * 
	 * Time Complexity - O(n)
	 * Space Complexity - O(n), for candidate and answer array 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> input = new ArrayList<>(Arrays.asList(1,3,-1,-3,5,3,6,7));
		int windowSize = 3;	
		List<Integer> maxElements = findSlidingWindowMaximum(input, windowSize);
		
		System.out.println(maxElements);

	}

	private static List<Integer> findSlidingWindowMaximum(List<Integer> input, int windowSize) {
		List<Integer> maxElements = new ArrayList<Integer>();
		LinkedList<Integer> candiadteMaxElements = new LinkedList<Integer>();
		
		// processing for first window
		
		for(int i=0 ;i<windowSize; i++) {
			checkAndAddCandidate(candiadteMaxElements, input.get(i));
		}	
		//Picking max element from first window
		maxElements.add(candiadteMaxElements.getFirst());
		
		//Sliding through window
		for(int i=windowSize; i<input.size(); i++) {
			checkAndAddCandidate(candiadteMaxElements, input.get(i));
			maxElements.add(candiadteMaxElements.getFirst());
			if(candiadteMaxElements.contains(input.get(i-windowSize))) {
				candiadteMaxElements.remove(input.get(i-windowSize));
			}
		}
		
		return maxElements;
	}

	private static void checkAndAddCandidate(LinkedList<Integer> candiadteMaxElements, Integer currentElement) {
		//delete all smaller elements (as compared to current element) and add current element
		while(candiadteMaxElements.size() > 0) {
			int lastElement = candiadteMaxElements.getLast();
			if(lastElement < currentElement) {
				candiadteMaxElements.removeLast();
			}else {
				break; //because all element in candidate is always descending order
			}
			
		}
		
		candiadteMaxElements.add(currentElement);
		
	}

}
