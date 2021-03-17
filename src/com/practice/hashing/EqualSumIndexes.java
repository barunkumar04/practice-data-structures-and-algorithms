package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualSumIndexes {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(7);
		A.add(3);
		A.add(2);
		A.add(8);
		A.add(12);
		A.add(1);
		A.add(5);
		A.add(4);
		
		boolean result = findEqualSum(A);
		System.out.println(result);
	}

	private static boolean findEqualSum(ArrayList<Integer> a) throws Exception {
		
		Map<Integer, ArrayList<Integer>> sumVsIndexMap = null;
		
		if(a == null || a.size() <= 4) {
			throw new Exception("Invalid input!");
		}
		sumVsIndexMap = new HashMap<>();
		
		int sum = 0;
		
		for(int i=0; i<a.size();i++) {
			for(int j=i+1; j<a.size();j++) {
				sum = a.get(i) + a.get(j);
				if(sumVsIndexMap.keySet().contains(sum)) {
					if(i != sumVsIndexMap.get(sum).get(1) && j != sumVsIndexMap.get(sum).get(0)) 
						return true;
				}else {
					sumVsIndexMap.put(sum, new ArrayList<Integer>(Arrays.asList(i, j)));
				}
			}
		}
		
		return false;

	}

}
