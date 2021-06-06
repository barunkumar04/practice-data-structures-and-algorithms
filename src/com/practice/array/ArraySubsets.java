package com.practice.array;

/**
 * https://leetcode.com/problems/subsets/  
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class ArraySubsets {
	private static List<List<Integer>> results = null;
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3};
		subsets(nums);
		System.out.println(results);

	}
	public static List<List<Integer>> subsets(int[] nums) {
        results = new ArrayList<List<Integer>>();
        results.add(new ArrayList()); // An empty set is a subset 
        generateAllsubset(nums, 0);
        
        return results;
    }
    
    private static void generateAllsubset(int[] nums, int index){
        //base case
        if(index == nums.length)
            return;
        
        //Adding current element in results so far
        List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
        for(List<Integer> result : results){
            ArrayList<Integer> resultCandiate = new ArrayList<Integer>(result);
            resultCandiate.add(nums[index]);
            tempResult.add(resultCandiate);
        }        
        
        results.addAll(tempResult);
        
        generateAllsubset(nums, index+1);
            
    }
}
