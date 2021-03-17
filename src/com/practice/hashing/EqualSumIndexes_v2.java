package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualSumIndexes_v2 {

	public static void main(String[] args) throws Exception {

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(0);
		A.add(1);
		A.add(0);
		A.add(2);
		A.add(1);
		
		ArrayList<Integer> resultArray = findEqualSum(A);
		System.out.println(resultArray);
	}

	private static ArrayList<Integer> findEqualSum(ArrayList<Integer> a) throws Exception {
        Map<Integer, ArrayList<Integer>> sumVsIndexMap = new HashMap<>();
		ArrayList<Integer> resultArray = new ArrayList<>();
		if(a == null || a.size() < 4) {
			return resultArray;
		}
		
		
        int sum = 0;	
		for(int i=0; i<a.size();i++) {
			for(int j=i+1; j<a.size();j++) {
				sum = a.get(i) + a.get(j);
				if(sumVsIndexMap.keySet().contains(sum)) {
				    int prev_i = sumVsIndexMap.get(sum).get(0);
				    int prev_j = sumVsIndexMap.get(sum).get(1);
					if(prev_i < prev_j && i < j && prev_i < i && prev_j < j && prev_j != j && prev_j != i) {
					   if(resultArray.size() > 0 ) {
						   	if(set1LexicographicallySmallThanSet2(prev_i, prev_j, i, j, resultArray.get(0), resultArray.get(1), resultArray.get(2), resultArray.get(3)) ){ // lexicographically check 
    					        resultArray.clear();
    					        resultArray.add(prev_i);
    					        resultArray.add(prev_j);
    					        resultArray.add(i);
    					        resultArray.add(j);    
					        }
					    }else{
					        resultArray.add(prev_i);
    					        resultArray.add(prev_j);
    					        resultArray.add(i);
    					        resultArray.add(j);
					    }
					    
					}
						
				}else {
					sumVsIndexMap.put(sum, new ArrayList<Integer>(Arrays.asList(i, j)));
				}
			}
		}
		
		return resultArray;

    }

	private static boolean set1LexicographicallySmallThanSet2(int A1, int B1, int C1, int D1, Integer A2,
			Integer B2, Integer C2, Integer D2) {
		if( (A1 < A2) || (A1 == A2 && B1 < B2) || (A1 == A2 && B1 == B2 &&C1 < C2) || (A1 == A2 && B1 == B2 && C1 == C2 && D1 < D2) ){ 
			return true;
		}else {
			return false;
		}
	}

}
