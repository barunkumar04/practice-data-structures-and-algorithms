package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxElementInSubarray {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
		int subArrayLength = 2;
		
		ArrayList<Integer> result = solve(list, subArrayLength);
		
		System.out.println(result);
		
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 10, 3, 6, 1, 5, 9, 4, 7));
		int subArrayLength1 = 3;
		
		ArrayList<Integer> result1 = solve(list1, subArrayLength1);
		
		System.out.println(result1);
		
		
	}

	private static ArrayList<Integer> solve(final List<Integer> A, int B) {
		
		LinkedList<Integer> candidateMaxElements = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// Finding max for first subarray
		int max = Integer.MIN_VALUE;
		for(int i=0; i<B; i++) {
			if(A.get(i) > max )
				max = A.get(i);	
			removeAllSmallerElements(candidateMaxElements, A.get(i));
			candidateMaxElements.addLast(A.get(i));
		}
		
		result.add(candidateMaxElements.getFirst());
		
		//Finding max for rest of elements
		for(int i=B; i<A.size(); i++) {
			if(candidateMaxElements.getFirst() == A.get(i-B))
				candidateMaxElements.removeFirst(); // As this is out of scope now.
			removeAllSmallerElements(candidateMaxElements, A.get(i));
			candidateMaxElements.addLast(A.get(i));
			
			result.add(candidateMaxElements.getFirst());
		}
		
		return result;
	}

	private static void removeAllSmallerElements(LinkedList<Integer> candidateMaxElements, Integer currentElement) {
		candidateMaxElements.removeIf(candidate -> (candidate < currentElement));
		
	}

}
