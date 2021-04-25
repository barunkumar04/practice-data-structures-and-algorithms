package com.practice.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSumProblem {

	public static void main(String[] args) {
		int k = 4;
		int target = 1;
		int[] nums = {-3,-1,0,2,4,5}; //-2,-1,0,0,1,2
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0; i<=(nums.length - k); i++) {
			ArrayList<Integer> candidateNumbers = new ArrayList<Integer>();
			candidateNumbers.add(nums[i]);
			/**
			 * One number is added in candidateNumbers, hence k reduced by 1
			 * New target is target - number in candidateNumbers
			 * And index start from next
			 */
			findKSum(candidateNumbers, nums, k-1, target-nums[i], i+1, result);
		}
		
		System.out.println(result);
		

	}

	private static void findKSum(ArrayList<Integer> candidateNumberList, int[] nums, int k, int target, int index,
			List<List<Integer>> result) {
		
		// Base condition - if k has reduced to 2.
		if(k==2) {
			ArrayList<ArrayList<Integer>> twoSumResult = findTwoSum(nums, target, index); // Return 
			for(ArrayList<Integer> twoSumList : twoSumResult){
				ArrayList<Integer> resultArray = new ArrayList<Integer>();
				resultArray.addAll(candidateNumberList);
				resultArray.addAll(twoSumList);
				if(!result.contains(resultArray)) {
					result.add(resultArray);
				}
	            
	            
	        }
	        return;
		}
		for(int i=index; i<=(nums.length-k); i++) {
			candidateNumberList.add(nums[i]); // Taking next element as candidate key
			/**
			 * One number is added in candidateNumbers, hence k reduced by 1
			 * New target is target - number in candidateNumbers
			 * And index start from next
			 */
			findKSum(candidateNumberList, nums, k-1, target-nums[i], i+1, result); // Recursively check, with these candidate keys there is any possible outcome
			candidateNumberList.remove(candidateNumberList.size()-1); //Remove the already processed candidate key
		}
				
	}

	private static ArrayList<ArrayList<Integer>> findTwoSum(int[] nums, int target, int index) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Set<Integer> partSum = new HashSet<Integer>();
		ArrayList<Integer> pairs = null;
		for(int i=index; i<nums.length; i++) {
			pairs = new ArrayList<Integer>();
			if(partSum.contains(target - nums[i])) {
				pairs.add(target - nums[i]);
				pairs.add(nums[i]);
			}else {
				partSum.add(nums[i]);
			}
			if(pairs.size() >0) {
				result.add(pairs);
			}
		}
		
		return result;
	}

}
