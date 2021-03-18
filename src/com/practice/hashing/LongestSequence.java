package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSequence {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result = sol.longestConsecutive(new ArrayList<Integer>(Arrays.asList(100, 4, 5,200, 1, 3, 2)));
		System.out.println(result); 
	}

}

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int longestConsecutive(final List<Integer> A) {
		Map<Integer, Integer> elementVsSequenceLenght = new HashMap<Integer, Integer>();
		
		int left = 0;
		int right = 0;
		int maxSequenceLenght = 0;
		for (int i = 0; i < A.size(); i++) {
			left = right = 0;
			if(elementVsSequenceLenght.keySet().contains(A.get(i)-1)) {
				left = elementVsSequenceLenght.get(A.get(i)-1);
			}
			if(elementVsSequenceLenght.keySet().contains(A.get(i)+1)) {
				right = elementVsSequenceLenght.get(A.get(i)+1);
			}
			
			if(!elementVsSequenceLenght.keySet().contains(A.get(i))) {
				int seqLenght = left + 1  + right;
				elementVsSequenceLenght.put(A.get(i), seqLenght);
				if(seqLenght > maxSequenceLenght) {
					maxSequenceLenght = seqLenght;
				}
				elementVsSequenceLenght.put(A.get(i)-left, seqLenght);
				elementVsSequenceLenght.put(A.get(i)+right, seqLenght);
				
				
			}
			
		}
		
		return maxSequenceLenght;
		
	}
}