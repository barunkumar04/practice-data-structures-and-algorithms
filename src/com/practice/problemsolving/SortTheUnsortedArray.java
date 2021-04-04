package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Q. Given an unsorted array, find the minimum length subarray, which if sorted, will sort the whole array.
 * 
 * 
 * @author Barun
 *
 */
public class SortTheUnsortedArray {

	public static void main(String[] args) {

		ArrayList<Integer> unsortedArray = new ArrayList<Integer>(
				Arrays.asList(10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60));

		int result = solve(unsortedArray);
		System.out.println(result);
	}

	public static int solve(ArrayList<Integer> A) {
		ArrayList<Integer> tempA= new ArrayList<Integer>();
		tempA.addAll(A);
		Collections.sort(tempA);
		int startIndex=0;
		for(; startIndex<tempA.size(); startIndex++) {
			if(tempA.get(startIndex) != A.get(startIndex)) {
				break;
			}
		}
		
		int endIndex=tempA.size()-1;
		for(; endIndex>0; endIndex--) {
			if(tempA.get(endIndex) != A.get(endIndex)) {
				break;
			}
		}
		int result = 0;
		if(startIndex == 0 || endIndex ==0) {
			result = 0;
		}else {
			result = endIndex - startIndex + 1;
		}
		return result;
	}
}
