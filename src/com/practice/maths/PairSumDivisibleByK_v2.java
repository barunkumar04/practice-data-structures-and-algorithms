package com.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PairSumDivisibleByK_v2 {

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(50, 40, 60, 50,23, 77, 64, 36, 99, 1));
		int result = solution.solve(list, 10);
		System.out.println(result);

	}

}

class Solution1 {
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
         HashMap<Integer, Integer> numberAndFrequencyMap = new HashMap<Integer, Integer>();
         for(int i=0; i<A.size(); i++){
            if(A.get(i) == 0)
            	continue;
            if(numberAndFrequencyMap.get(A.get(i)) == null) {
            	numberAndFrequencyMap.put(A.get(i),1);
            }else {
            	numberAndFrequencyMap.put(A.get(i),numberAndFrequencyMap.get(A.get(i))+1 );
            }
         }
         
         int pairCount = 0;
         
         for(int i=0; i<A.size(); i++){
             int countOfPart1 = numberAndFrequencyMap.get(A.get(i)) != null? numberAndFrequencyMap.get(A.get(i)) : 0;
             int countOfPart2 = numberAndFrequencyMap.get(B - A.get(i)) != null? numberAndFrequencyMap.get(B- A.get(i)) : 0;
             
             pairCount += countOfPart1 * countOfPart2;
             
             numberAndFrequencyMap.remove(A.get(i));
             numberAndFrequencyMap.remove(B-A.get(i));
             
        }
        return pairCount+(countOfZero * (countOfZero - 1)/ 2); // (countOfZero / 2): Two zeros in base number list makes a pair.
    }
}
