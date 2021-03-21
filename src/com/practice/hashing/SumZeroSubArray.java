package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SumZeroSubArray {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(-1);
		A.add(3);
		A.add(6);
		A.add(-4);
		A.add(-4);
		A.add(8);
		A.add(0);
		A.add(7);
		
		boolean result = findSumZeroSubArray(A);
		System.out.println(result);
	}

	private static boolean findSumZeroSubArray(ArrayList<Integer> a) throws Exception {
		
		
		if(a == null || a.size() == 0) {
			throw new Exception("Invalid input!");
		}
		long[] prefixSumArray = new long[a.size()];
		long sumTillCurrentIndex = 0;
		for(int i=0; i<a.size(); i++) {
			sumTillCurrentIndex+= a.get(i);
			if(sumTillCurrentIndex == 0) { 
				/**
				 * Zero sum sub array exists in beginning. 
				 * For this case the wont be repetition in prefix sum array. 
				 * For example: 
				 * 	Input   : 1, 2,-1,-2, 7, 4
				 *  PS array: 1, 3, 2, 0, 7, 11
				 */
				return true; 
			}
			prefixSumArray[i] = sumTillCurrentIndex;
		}
		
		Set<Long> prefixSumSet = new HashSet<Long>();
		for (int i = 0; i < prefixSumArray.length; i++) {
			if(prefixSumSet.contains(prefixSumArray[i])) {
				return true;
			}else {
				prefixSumSet.add(prefixSumArray[i]);
			}
			
		}
		
		return false;

	}

}
