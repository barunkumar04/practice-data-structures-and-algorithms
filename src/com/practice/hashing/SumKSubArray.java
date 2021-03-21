package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumKSubArray {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(3,3,-2,4,-3,8));
		int k = 3;
		List<Integer> result = findSumKSubArray(array, k);
		
		System.out.println(result);
	}

	private static ArrayList<Integer> findSumKSubArray(ArrayList<Integer> list, int k) throws Exception {
		
		
		long[] prefixSumArray = new long[list.size()];
		int kSumSubArray_startIndex = 0;
		int kSumSubArray_endIndex = 0;
		
		long sumTillCurrentIndex = 0;
		for(int i=0; i<list.size(); i++) {
			sumTillCurrentIndex+= list.get(i);
			if(sumTillCurrentIndex == k) { 
				kSumSubArray_endIndex = i+1;
				break;
			}
			prefixSumArray[i] = sumTillCurrentIndex;
		}
		
		/**
		 * A sub-array with sum=k has found in begining itself. Example: 1, 1, 3, 4, -2. 
		 */
		if(kSumSubArray_endIndex != 0) {  
			return new ArrayList<Integer>(list.subList(kSumSubArray_startIndex, kSumSubArray_endIndex));
		}
		
		
		Map<Long, Integer> prefixSumVsIndexMap = new HashMap<Long, Integer>();
		for (int i = 0; i < prefixSumArray.length; i++) {
			if(prefixSumVsIndexMap.keySet().contains(prefixSumArray[i] - k)) {
				kSumSubArray_startIndex = prefixSumVsIndexMap.get(prefixSumArray[i] - k);
				kSumSubArray_endIndex = i+1;
				break;
			}else {
				prefixSumVsIndexMap.put(prefixSumArray[i], i);
			}
			
		}
		
		if(kSumSubArray_endIndex != 0)
			return new ArrayList<Integer>(list.subList(kSumSubArray_startIndex+1, kSumSubArray_endIndex));
		else 
			return new ArrayList<Integer>(Arrays.asList(-1));

	}

}
