package com.practice.string;

public class StringPermutations {

	public static void main(String[] args) {
		String s = "ABC";
		printPermutations(s, "");
	}

	private static void printPermutations(String str, String ans) {

		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			//String with remaining characters
			String remainingCharString = str.substring(0, i) + str.substring(i+1);
			printPermutations(remainingCharString, ans + ch);
		}
		
		
	}
	

}
