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
public class LongestSubsequenceRecursive {

	public static void main(String args[]) {
		String input = "google";
		String candiate = "gogle";

		Boolean isSubsequnce = isSubsequence(input, candiate, input.length()-1, candiate.length()-1);
		System.out.println(isSubsequnce);

	}

	private static Boolean isSubsequence(String input, String candiate, int n, int m) {
		
		if(m == 0) { // checking candidate string traversed till 0
			return true;
		}
		
		if(n == 0) { // // checking input string traversed till 0
			return false;
		}
		
		if ( input.charAt(n) == candiate.charAt(m) )
			return isSubsequence(input, candiate, n-1, m-1);	
		else 
			return isSubsequence(input, candiate, n-1, m);	
	}

	

}
