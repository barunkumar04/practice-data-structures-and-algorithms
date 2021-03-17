package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountSumKSubArray {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);
		A.add(5);
		A.add(1);
		A.add(2);
		A.add(6);
		A.add(7);
		A.add(13);
		A.add(12);
		A.add(17);
		
		int result = findCountSumKSubArray(A, 3);
		System.out.println(result);
	}

	private static int findCountSumKSubArray(ArrayList<Integer> a, int k) throws Exception {
		
		
		if(a == null || a.size() == 0) {
			throw new Exception("Invalid input!");
		}
		int[] binaryArray = new int[a.size()];
		int[] prefixSumArray = new int[a.size()];
		int sumTillCurrentIndex = 0;
		for(int i=0; i<a.size(); i++) {
			int element = a.get(i);
			if(element % 2 == 0) {
				binaryArray[i]  = 0;
				sumTillCurrentIndex+=0;
			}else {
				binaryArray[i]  = 1;
				sumTillCurrentIndex+=1;
			}
			prefixSumArray[i] = sumTillCurrentIndex;
		}
		
		Set<Integer> prefixSumSet = new HashSet<Integer>();
		int result_count = 0;
		/**
		 *  sum(l - r) = K
		 *  PS[r] - PS[l -1] = K
		 *  So, PS[r] =  K + PS[l -1]
		 */
		for (int r = 0; r < prefixSumArray.length; r++) {
			if(prefixSumArray[r] == k && !prefixSumSet.contains(prefixSumArray[r]) ) { // I.e. K odd numbers are found in begining sequence.
				result_count ++;
				prefixSumSet.add(prefixSumArray[r]);
				continue;
			}
			if(prefixSumSet.contains(prefixSumArray[r] - k) && binaryArray[r] == 1) {
				result_count ++;
			}else {
				prefixSumSet.add(prefixSumArray[r]);
			}
			
		}
		
		return result_count;

	}

}
