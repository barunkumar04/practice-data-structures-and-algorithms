package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
Problem Description

The little girl loves the problems on array queries very much.
One day she came across a rather well-known problem: you've got an array of n elements (the elements of the array are indexed starting from 1); also, there are q queries, each one is defined by a pair of integers li, ri (1 < =li<=ri<=n).
You need to find for each query the sum of elements of the array with indexes from li to ri, inclusive.
The little girl found the problem rather boring. She decided to reorder the array elements before replying to the queries in a way that makes the sum of query replies maximum possible. Your task is to find the value of this maximum sum% 10 9 + 7

Problem Constraints
	1<=n,q,A[i]<=1e5

Input Format
	First Argument contains array of integers of size n denoting array A.
	Second Argument contains 2d array B of size q in which B[i][0] =l and B[i][1]=r

Output Format
	Return the value of this maximum sum% 10 9 + 7

Example Input
	Input-1
		A=[5,3,2]
		B=[[1,2],[2,3],[1,3]];
Input-2

A=[1]
B=[[1,1]];


Example Output
OUTPUT-1
25
OUTPUT-2

1


Example Explanation
Explanation-1
convert given array into A=[3,5,2] to gain maxium sum.
Explanation-2

Do not change the array 
 * 
 * @author Barun
 *
 */
public class LittleGirlAndMaximumSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5,3,2));
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		B.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		B.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		B.add(new ArrayList<Integer>(Arrays.asList(1,3)));
		
		solve(A,B);
	}

	public static int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		int[] indexFrequency = new int[A.size() + 1];
		/**
		 * Sample query: [[1,2],[2,3],[1,3]]
		 */
		for (ArrayList<Integer> query : B) {
			// -1, beacuse inputs are in 1 index
			indexFrequency[query.get(0) - 1] = indexFrequency[query.get(0) - 1] + 1;
			indexFrequency[query.get(1) - 1 + 1] = indexFrequency[query.get(1) - 1 + 1] - 1;
		}
		// indexFrequency - [2, 1, -1, -2]

		System.out.println("freqeuency array.");
		System.out.println(Arrays.toString(indexFrequency));

		int[] indexFrequencyPS = new int[A.size() + 1];
		// Taking prefix sum to calcualte frequency count of indexes
		indexFrequencyPS[0] = indexFrequency[0];
		for (int i = 1; i < indexFrequency.length ; i++) {
			indexFrequencyPS[i] = indexFrequencyPS[i - 1] + indexFrequency[i];
		}
		// indexFrequencyPS - [2, 3, 2, 0]
		System.out.println("Prefix sum of freqeuency array.");
		System.out.println(Arrays.toString(indexFrequencyPS));

		// Sort the input array
		Collections.sort(A, Collections.reverseOrder());
		// A: 5,3,2

		// Next, Rearranging sorted array, A, such that maximum elements to be placed on
		// indexFrequencyPS indexes, i.e. [2, 3, 2, 0]
		// Expected value of A is: 3, 5, 2 or 2, 5, 3

		// Pairing indexFrequencyPS value and index so that it can be sorted based on
		// value and index is tagged along.
		// Expected result: (3,2), (2,1), (2,3), (0,4)
		ArrayList<Pair> freqIndexPairs = new ArrayList<Pair>();
		for (int i = 0; i < indexFrequencyPS.length; i++) {
			freqIndexPairs.add(new Pair(indexFrequencyPS[i], i));
		}
		System.out.println(freqIndexPairs);
		// Sorting pairs
		Collections.sort(freqIndexPairs, Collections.reverseOrder());

		// Arranging the array
		int[] arrangedArray = new int[A.size()];
		for (int i = 0; i < freqIndexPairs.size() - 1; i++) {
			arrangedArray[freqIndexPairs.get(i).getValue()] = A.get(i);
		}

		// arrangedArray - 3, 5, 2
		System.out.println(new ArrayList(Arrays.asList(arrangedArray)));
		
		//Calculating sum for queries
		int[] arrangedArrayPS = new int[A.size()+1];
		arrangedArrayPS[0] = 0;
		int previousSum = 0;
		for(int i=0;i<arrangedArray.length;i++) {
			arrangedArrayPS[i+1] = previousSum + arrangedArray[i];
			previousSum = arrangedArrayPS[i+1];
		}
		int mod = 1000000007;
		long sum = 0;
		for (ArrayList<Integer> query : B) {
			int leftIndex = query.get(0);
			int rightIndex = query.get(1);
			sum = sum + (arrangedArrayPS[rightIndex] - arrangedArrayPS[leftIndex-1]);
		}
		
		return (int)(sum % mod);

	}
}

class Pair implements Comparable<Pair> {
	private int key;
	private int value;

	public Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public int getValue() {
		return this.value;
	}

	public int compareTo(Pair p) {
		return this.key - p.getKey();
	}

	public String toString() {
		return this.key + "-" + this.value;
	}
}
