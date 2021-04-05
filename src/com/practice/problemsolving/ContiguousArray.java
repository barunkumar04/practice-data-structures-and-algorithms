package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**

Contiguous Array
Given an array of integers A consisting of only 0 and 1.
Find the maximum length of a contiguous subarray with equal number of 0 and 1.

 */
public class ContiguousArray {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0));

		System.out.println(solve(array));

	}
	
	/**
	 * Steps
	 * 1. Replace 0 with 1
	 * 2. Calculate prefix sum array
	 * 3. Using Hashmap, find max distance between same number in prefix sum
	 * 
	 * @param A
	 * @return
	 */
	 public static int solve(ArrayList<Integer> A) {
		 
		 ArrayList<Integer> prefixSum = new ArrayList<Integer>();
		 Map<Integer, Integer> elementFrequency = new HashMap<>();
		 
		 prefixSum.add(0); //Sum of no element is zero
		 int prevSum=0;
		 for(int i=0; i<A.size(); i++) {
			if(A.get(i) == 0) {
				prevSum = prevSum + (-1);
			}else {
				prevSum = prevSum + A.get(i);
			} 
			prefixSum.add(prevSum);
		 }
		 int maxDistance = 0;
		 for(int i=0; i<prefixSum.size(); i++) {
			 int element = prefixSum.get(i);
			 if(elementFrequency.keySet().contains(element)) {
				 int prevOccurance  = elementFrequency.get(element);
				 
				 if( (i - prevOccurance) > maxDistance) {
					 maxDistance =  i - prevOccurance;
				 }
			 }else {
				 elementFrequency.put(element, i);
			 }
		 }
		 return maxDistance;
	 }
}
