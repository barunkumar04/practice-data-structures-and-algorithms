package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LexicographicallySoredPair {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2,4,3));
		
		ArrayList<Integer>  result = lexicalSort(input);
		System.out.println(result);

	}

	private static ArrayList<Integer> lexicalSort(ArrayList<Integer>  input) {
		
		if(input.size() == 1) return input;
		
		//Sort the array
		Collections.sort(input); //2,3,4
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		// For an element at index i (where i >= 1). pair it with each elements from stating index
		for(int i=1; i<input.size(); i++) {
			for(int j=0; j<i;j++) {
				result.add(input.get(j));
				result.add(input.get(i));
			}
			
		}
		
		return result;
	}

}
