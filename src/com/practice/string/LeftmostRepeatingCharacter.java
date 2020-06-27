package com.practice.string;

public class LeftmostRepeatingCharacter {
	public static void main(String args[]) {

		String input = "abcdb";
		int result = leftmostRepeatingChar_OrderOfN(input);
		System.out.println("Index of leftmost repeating char is: " + result);
		
		result = leftmostRepeatingChar_OrderOfN_Optimized(input);
		System.out.println("Index of leftmost repeating char is: " + result);

	}

	private static int leftmostRepeatingChar_OrderOfN_Optimized(String input) {
		boolean[] visitedArray = new boolean[26];
		for (int i = 0; i < 26; i++) {
			visitedArray[i] = false;
		}

		int result = Integer.MAX_VALUE;
		for (int i = input.length() - 1 ; i >= 0; i--) {

			// not visited? assign the index
			if (visitedArray[input.charAt(i) - 97] == false) {
				visitedArray[input.charAt(i) - 97] = true;
			} else { // // visited? keep the index.
				result = i;
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int leftmostRepeatingChar_OrderOfN(String input) {
		int[] indexArray = new int[26];
		for (int i = 0; i < 26; i++) {
			indexArray[i] = -1;
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < input.length(); i++) {

			// not visited? assign the index
			if (indexArray[input.charAt(i) - 97] == -1) {
				indexArray[input.charAt(i) - 97] = i;
			} else { // // visited? Check the index for char, if less (meaning appeared before) update result with the index.
				if (indexArray[input.charAt(i) - 97] < i) {
					result = indexArray[input.charAt(i) - 97];
				}
			}
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	
}
