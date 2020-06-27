package com.practice.string;

public class LeftmostNonRepeatingCharacter {
	public static void main(String args[]) {

		String input = "abcdba";
		
		int result = leftmostRepeatingChar_OrderOfN_Optimized(input);
		System.out.println("Index of leftmost non repeating char is: " + result);

	}

	private static int leftmostRepeatingChar_OrderOfN_Optimized(String input) {
		boolean[] visitedArray = new boolean[26];
		for (int i = 0; i < 26; i++) {
			visitedArray[i] = false;
		}

		int result = Integer.MAX_VALUE;
		char resultChar = Character.MAX_VALUE;
		for (int i = input.length() - 1 ; i >= 0; i--) {

			// not visited? assign the index
			if (visitedArray[input.charAt(i) - 97] == false) {
				visitedArray[input.charAt(i) - 97] = true;
				result = i;
				resultChar = input.charAt(i);
			}else {
				if(resultChar == input.charAt(i))
					result = Integer.MAX_VALUE;
			} 
		}
		
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	
}
