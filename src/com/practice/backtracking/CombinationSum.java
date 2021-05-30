package com.practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * 

Problem Description

Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
The same repeated number may be chosen from A unlimited number of times.
Note:
	1) All numbers (including target) will be positive integers.
	2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	3) The combinations themselves must be sorted in ascending order.
	4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
	5) The solution set must not contain duplicate combinations.

Problem Constraints
	1 <= |A| <= 20
	1 <= A[i] <= 50
	1 <= B <= 500

Input Format
	First argument is the vector A.
	Second argument is the integer B.

Output Format
	Return a vector of all combinations that sum up to B.

Example Input
	Input 1:
		A = [2, 3]
		B = 2
	Input 2:
		A = [2, 3, 6, 7]
		B = 7


Example Output
	Output 1:
		[ [2] ]
	Output 2:
		[ [2, 2, 3] , [7] ]

Example Explanation
Explanation 1:
	All possible combinations are listed.
Explanation 2:
	All possible combinations are listed.

 * 
 * 
 * @author Barun
 *
 */

public class CombinationSum {
	static ArrayList<ArrayList<Integer>> result = null;
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
		int B = 28;
		System.out.println(combinationSum(A, B));
	}


    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result  = new ArrayList<ArrayList<Integer>>(); 
        
        //Removing duplicates in input
		Set<Integer> setA = new HashSet<>(A);
		A = new ArrayList<>();
		A.addAll(setA);
		
		//Sorting so that next element is always greater than current 
		Collections.sort(A);
		
		ArrayList<Integer> candidateList = new ArrayList<Integer>();
		int index = 0;
		int sum = 0;
        isCombinationSumExist(A, index, sum, candidateList, B);
		return result;
	}

	private static void isCombinationSumExist(ArrayList<Integer> A, int index, int sum,
			ArrayList<Integer> candidateList, int target) {
			    
		if (target == sum) {
			result.add(new ArrayList<Integer>(candidateList));
			return;
		} 
		if (sum > target) {
			return;
		}
		if (index >= A.size()) {
			return;
		}
		
		//Considering current element
		candidateList.add(A.get(index));
		isCombinationSumExist(A, index, sum + A.get(index), candidateList, target);
		candidateList.remove(candidateList.size()-1); // Backtracking
		
		isCombinationSumExist(A, index+1, sum, candidateList, target); // Recursive call for next element
		
	}
}
