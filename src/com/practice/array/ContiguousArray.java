package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers A consisting of only 0 and 1.

Find the maximum length of a contiguous subarray with equal number of 0 and 1.



Input Format

The only argument given is the integer array A.
Output Format

Return the maximum length of a contiguous subarray with equal number of 0 and 1.
Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 1
For Example

Input 1:
    A = [1, 0, 1, 0, 1]
Output 1:
    4
    Explanation 1:
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarrays have equal number of ones and equal number of zeroes.

Input 2:
    A = [1, 1, 1, 0]
Output 2:
    2
 * 
 * @author Barun
 *
 */
public class ContiguousArray {

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1,1,0,1,0,0,0,1))));

	}

	 public static int solve(ArrayList<Integer> A) {
	        ArrayList<Integer> prefixSumArray = new ArrayList<Integer>();
	        prefixSumArray.add(0);
	        
	        int previousSum = 0;
	        
	        for(int i=0; i<A.size(); i++){
	            int curr = A.get(i) == 0 ? -1 : 1;
	            previousSum += curr;
	            prefixSumArray.add(previousSum);
	        }
	        
	        Map<Integer, Integer> elementIndexMap = new HashMap<Integer, Integer>();
	        
	        int maxLength = Integer.MIN_VALUE;
	        for(int i=0; i<prefixSumArray.size(); i++){
	            int element = prefixSumArray.get(i);
	            if(elementIndexMap.keySet().contains(element)){
	                int previousIndex = elementIndexMap.get(element);
	                int length = i - previousIndex;
	                
	                if(length > maxLength)
	                    maxLength = length;
	            }else{
	                elementIndexMap.put(element, i);
	            }  
	        }
	        
	       return maxLength == Integer.MIN_VALUE ? 0: maxLength;
	        
	        
	    }
}
