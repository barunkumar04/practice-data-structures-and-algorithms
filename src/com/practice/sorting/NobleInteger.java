package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputArray1 = new ArrayList<Integer>(Arrays.asList(4,4,4,7,8));
		int result1 = existsNobleInteger(inputArray1);
		System.out.println(result1);
		
		ArrayList<Integer> inputArray2 = new ArrayList<Integer>(Arrays.asList(3,2,4,1,0));
		int result2 = existsNobleInteger(inputArray2);
		System.out.println(result2);
	}

	private static int existsNobleInteger(ArrayList<Integer> array) {
		Collections.sort(array);
		int previousElement = array.get(array.size()-1);
		if(previousElement == 0) { 
			/**
			 * Largest element in the array is 0 and there are 0 greater elements in the array. 
			 * Hence 0 is the Nobel Integer in this condition.
			 */
			return 1;
		}
		for (int i = array.size()-2, visitedCount=1; i >=0 ; i--, visitedCount++) {
			if(array.get(i) == previousElement)
				continue;
			if(array.get(i) == visitedCount)
				return 1;	
			previousElement = array.get(i);
		}
		return -1;
	}
	
}
