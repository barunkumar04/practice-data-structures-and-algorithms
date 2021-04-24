package com.practice.interview.google;

import java.util.ArrayList;

/**
 * 
 * Problem statement
 * https://docs.google.com/document/d/1Zh_AXcTICquTwmn1-mtM0eaeEMnyooqDfK50GTfDem8/edit?usp=sharing
 * 
 * @author Barun
 *
 */
public class LongestSubsequence {

	public static void main(String args[]) {
		String input = "google";
		ArrayList<String> candiateSubsequence = new ArrayList<String>();
		candiateSubsequence.add("gogle");
		candiateSubsequence.add("go");
		candiateSubsequence.add("gel");

		String maxLengthSS = findMaxLengthSubsequence(input, candiateSubsequence);
		System.out.println(maxLengthSS);

	}

	private static String findMaxLengthSubsequence(String input, ArrayList<String> candiateSubsequence) {
		String result = null;;
		int inputStrLength = input.length() - 1;
		int maxLength = Integer.MIN_VALUE;
		for (String candidateSS : candiateSubsequence) {
			int i = 0;
			int j = 0;
			int csLength = candidateSS.length() - 1;

			while (i <= inputStrLength && j <= csLength) {
				if (input.charAt(i) == candidateSS.charAt(j)) {
					i++;
					j++;
				} else {
					i++;
				}

			}
			j--;
			if (j == csLength) { // This is a sub sequence string
				if (csLength > maxLength) {
					maxLength = csLength;
					result = candidateSS;
				}
			}

		}
		return result;

	}

}
