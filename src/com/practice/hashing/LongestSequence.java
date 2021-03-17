package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestSequence {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result = sol.longestConsecutive(new ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2)));
		System.out.println(result); 
	}

}

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int longestConsecutive(final List<Integer> A) {
		/*
		 * 
		 * if(A.size() == 1){ return 1; }else if(A.size() == 0){ return -1; }
		 * 
		 * Set<Integer> counted = new HashSet<>(); Set<Integer> visited = new
		 * HashSet<>(); int seqCount = 0;
		 * 
		 * boolean partOfSeq = false; int maxSeqElement = Integer.MIN_VALUE; for(Integer
		 * a: A){ partOfSeq = false; if(visited.contains(a-1) &&
		 * !counted.contains(a-1)){ seqCount+=1; counted.add(a-1); partOfSeq = true; }
		 * 
		 * if(visited.contains(a+1) && !counted.contains(a+1)){ seqCount+=1;
		 * counted.add(a+1); partOfSeq = true; }
		 * 
		 * if(partOfSeq){ seqCount+=1; counted.add(a); partOfSeq = false; }
		 * 
		 * if(visited.contains(a-1) && counted.contains(a-1)) { maxSeqElement = a >
		 * maxSeqElement ? a : maxSeqElement; }
		 * 
		 * visited.add(a);
		 * 
		 * } if (counted.contains(maxSeqElement-1) && !counted.contains(maxSeqElement))
		 * seqCount++; return seqCount;
		 * 
		 */
		

        
        if(A.size() == 1){
            return 1;
        }else if(A.size() == 0){
            return -1;
        }
        
        int maxSeqElement = -1;
        HashSet<Integer> A_set= new HashSet<Integer>();
        A_set.addAll(A);
        for(Integer a: A_set){
            int seqCount = 1;
            while(true){
                if(A_set.contains(a+1)){
                    a =a+1;
                    seqCount++;
                }else{
                    break;
                }
            }
            
            if(seqCount > maxSeqElement)
                maxSeqElement = seqCount;
        }    
          
        return maxSeqElement;
    
	}
}