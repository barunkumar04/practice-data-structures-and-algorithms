package com.practice.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 Construct Array
Problem Description

Simba has an integer array of length A. Despite having insisted alot, He is not ready to reveal the array to his friend Expert. But now, he is ready to reveal some hints about the array and challenges Expert to find the values of his hidden array. The hints revealed are as follows:

The array is sorted by values.
All the elements in the array are distinct and positive (greater than 0).
The array contains two elements B and C such that B < C.
Difference between all adjacent (consecutive) elements are equal.
Among all the arrays satisfying the above conditions, his array has the minimum possible maximum element value.
Can you help Expert to construct such an array and surprise Simba?

**/

public class ConstructArray {

	public static void main(String[] args) {
		int lenghtOfArray = 3;
		int smallElement = 10;
		int largeElement = 39;
		System.out.println(solve(lenghtOfArray, smallElement, largeElement));

	}

	private static ArrayList<Integer> solve(int lenghtOfArray, int smallElement, int largeElement) {
		Map<Integer, ArrayList<Integer>> candidateResult = new HashMap<Integer, ArrayList<Integer>>();
		int diviser = largeElement - smallElement;

		ArrayList<Integer> diviserFactor = generateFactorList(diviser);

		ArrayList<Integer> candidateArray = null;	
		int minLastElement = Integer.MAX_VALUE;
		for (int i = 0; i < diviserFactor.size(); i++) {

			// generate left number
			int count = 0;
			candidateArray = new ArrayList<Integer>();
			int prevElement = largeElement;
			while (count < lenghtOfArray-1) {
				int element  = prevElement - diviserFactor.get(i);
				if(element<1)
					break;
				candidateArray.add(element);
				prevElement = element;
				count++;
			}
			candidateArray.add(largeElement);
			count++;
			prevElement = largeElement;
			if(candidateArray.size() < lenghtOfArray) { // need to generate more numbers
				while (count < lenghtOfArray) {
					int element  = prevElement + diviserFactor.get(i);
					candidateArray.add(element);
					prevElement = element;
					count++;
				}
			}
			
			if(candidateArray.contains(smallElement) ) {
				int lastElementOfArray = candidateArray.get(lenghtOfArray-1);
				candidateResult.put(lastElementOfArray, candidateArray);
				if(lastElementOfArray < minLastElement) {
					minLastElement = lastElementOfArray;
				}
			}
		}
		
		Collections.sort(candidateResult.get(minLastElement));
		return candidateResult.get(minLastElement);
	}

	private static ArrayList<Integer> generateFactorList(int diviser) {
		ArrayList<Integer> diviserFactor = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(diviser); i++) {
			if (diviser % i == 0) {
				if (diviser / i == i) {
					diviserFactor.add(i);
				} else {
					diviserFactor.add(i);
					diviserFactor.add(diviser / i);
				}

			}
		}

		return diviserFactor;
	}

}
