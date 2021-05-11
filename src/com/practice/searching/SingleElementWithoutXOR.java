package com.practice.searching;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
Problem Description
	Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
	NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
	1 <= |A| <= 100000
	1 <= A[i] <= 10^9

Input Format
	The only argument given is the integer array A.

Output Format
	Return the single element that appears only once.

Example Input
	Input 1:
		A = [1, 1, 7]
	Input 2:
		A = [2, 3, 3]

Example Output
	Output 1:
		7
Output 2:
		2

Example Explanation
	Explanation 1:
 		7 appears once
	Explanation 2:
 		2 appears once
 * 
 * 
 * @author Barun
 *
 */
public class SingleElementWithoutXOR {

	public static void main(String[] args) {
		System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1,1,2))));

	}
	
	 /**
     * Observation:
     * 1. Every new number before the single element occurs in even index
     * 2. Every new number after the single element occurs in odd index
     * 
     * A:       [1,1,2,2,3,4,4]
     * Index:   [0,1,2,3,4,5,6]
     * 
     * 
     * Appraoch:
     * 1. Approach with binary search, with mid element as pivot 
     * 2. for the pivot element
     *      a. if immediate left and right of pivot element is name same as pivot, then this is the single occurring element
     *      b. if new number's index is even that means we are in left side of the single element and going futher left will not yield answer.
     *         So discard this space and find in right side of pivot element.
     *      c. if new number's index is odd that means we are in right side of the single element and going futher right will not yield answer.
     *         So discard this space and find in left side of pivot element.
     * */
    public static int solve(ArrayList<Integer> A) {
        
        int start = 0;
        int end = A.size()-1;
        
        int singleElement = binarySearchFindSingleElement(A, start, end);
        
        return singleElement;
        
    }
    
    private static int binarySearchFindSingleElement(ArrayList<Integer> A, int start, int end){
        
        //Base case
        if(start > end){
            return -1; //Searched entire array and no single element found
        }
        int mid = (start + end) / 2;
        int pivot = A.get(mid);
        //if the element is on left corner, just providing a distinct value as Integer.MIN_VALUE also avoiding OOB exception
        int leftOfPivot = Integer.MIN_VALUE;
        if( (mid-1) >= 0)
            leftOfPivot = A.get(mid-1);
        
        //if the element is on right corner, just providing a distinct value as Integer.MAX_VALUE also avoiding OOB exception    
        int rightOfPivot = Integer.MAX_VALUE;
        if((mid+1) <= end)
            rightOfPivot =A.get(mid+1);
        
        if(leftOfPivot != pivot && rightOfPivot != pivot){// this is the single occurring element
            return pivot;
        }else{ 
            // checking if we are in left side of the element
            int index = mid;
            while(index >=0 && A.get(index) == pivot) {
            	index--;
            }
            index++;
            
            if((index&1) == 0){//its even and element would be in right side of pivot
                return binarySearchFindSingleElement(A, mid+1, end);
            }else{//its odd and element would be in left side of pivot
                return binarySearchFindSingleElement(A, start, mid-1);
            }
        }
        
    }
}
