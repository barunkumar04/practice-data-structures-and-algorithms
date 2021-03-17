package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SameElementWithMinDistance {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(6);
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		A.add(2);
		A.add(3);
		
		ArrayList<Integer> result = findMinDistantSameElements(A);
		System.out.println(result);
	}

	private static ArrayList<Integer> findMinDistantSameElements(ArrayList<Integer> a) {
		
		Map<Integer, Integer> elementVsIndexMap = new HashMap<Integer, Integer>();
		int min_dist = Integer.MAX_VALUE;
		int result_i = 0;
		int result_j = 0;
		
		for(int i=0; i<a.size();i++) {
			
			if(elementVsIndexMap.keySet().contains(a.get(i))){
				int lastIndex = elementVsIndexMap.get(a.get(i));
				if( (i - lastIndex) < min_dist) {
					min_dist = i - lastIndex;
					result_i = i;
					result_j = lastIndex;
				}
				
			}
			elementVsIndexMap.put(a.get(i), i);
		}

		return new ArrayList<Integer>(Arrays.asList(result_j, result_j));
	}

}
