package com.practice.backtracking;


/**
 * 
 * Problem - Given a string, print all permutation which do not contains “AB” as a substring

 * 
 * @author Barun
 *
 */
public class StringPermutations {

	public static void main(String args[]) {
		String str = "ABC";
		// Assuming it is valid input
		String aPermutation = "";
		printPermutations(str, aPermutation);
	}

	private static void printPermutations(String str, String aPermutation) {
		// Base case - all chars of str has considered as permutation
		if (str.length() == 0) {
			System.out.println(aPermutation);
			return;
		}

		// Safety check - NA, valid input

		// Recursive call
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(isValidPermutation(aPermutation, ch)) {
				// Creating permutations starting with char at index i
				
				// Extract string of remaining chars
				String remainingCharString = str.substring(0, i) + str.substring(i+1);
				printPermutations(remainingCharString, aPermutation+ch);

			}
			
		}

	}

	private static boolean isValidPermutation(String aPermutation, char ch) {
		// if permutation already contains "AB"
		if(aPermutation.contains("AB")) {
			return false;
		}
		
		//if it contains "A" and next one is "B"
		if(aPermutation.length() > 0 && aPermutation.charAt(aPermutation.length()-1) == 'A' && ch == 'B') {
			return false;
		}
		
		return true;
	}

}
