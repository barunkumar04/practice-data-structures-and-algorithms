package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PairSumDivisibleByK {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,3,7,9,8,4));
		int result = solution.solve(list, 4);
		System.out.println(result);

	}

}

class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        
        // Take base number
    	int countOfZero = 0;
        for(int i=0; i<A.size(); i++){
        	int baseNumber = A.get(i) % B;
        	if(baseNumber == 0)
        		countOfZero++;
            A.set(i, baseNumber);
            
        }
        
        /**
         * Apply logic of 2 sum problem
         *  - Maintain a Hashset for each element such that
         *      - if (B - A(i)) contains in set pairCount++
         *      - else set.add(A.get(i))
         **/
         int pairCount = 0;
         HashMap<Integer, Integer> numberAndFrequencyMap = new HashMap<Integer, Integer>();
         for(int i=0; i<A.size(); i++){
            int constitutingPart = B - A.get(i);
            if(numberAndFrequencyMap.keySet().contains(constitutingPart)) {
            	pairCount = pairCount+ numberAndFrequencyMap.get(constitutingPart);
            }
            if(numberAndFrequencyMap.get(A.get(i)) == null) {
            	numberAndFrequencyMap.put(A.get(i),1);
            }else {
            	numberAndFrequencyMap.put(A.get(i),numberAndFrequencyMap.get(A.get(i))+1 );
            }
        }
        return pairCount+(countOfZero * (countOfZero - 1)/ 2); // (countOfZero / 2): Two zeros in base number list makes a pair.
    }
}
